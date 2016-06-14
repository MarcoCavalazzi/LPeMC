grammar FOOL;

@header{
	import java.util.ArrayList;
	import java.util.HashMap;
}

@lexer::members {
  int lexicalErrors=0;
}
 
@members{
	private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
	private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>();
	private int nestingLevel = -1; // ***** non facciamo prima a togliere questo e togliere anche il "nestingLevel++" in prog LET IN ??
	//livello ambiente con dichiarazioni piu' esterno Ë 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle symTable.get(nestingLevel)
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog	returns [Node ast]
	 : e=exp SEMIC { $ast = new ProgNode($e.ast); }
        | LET 
            {
              nestingLevel++;
              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
              symTable.add(hm);
            }
         cl=cllist  d=declist IN e=exp SEMIC 
            {
              symTable.remove(nestingLevel--);
              $ast = new LetInNode($d.astlist,$cl.astlist,$e.ast) ;
            }
	;


cllist returns [ArrayList<Node> astlist]  
   : { 
	     $astlist = new ArrayList<Node>() ;	     
	   } 
	   (CLASS cid=ID  //metto in symbol table level 0 l'ID della classe 
	   {
         ClassNode classItem = new ClassNode($cid.text);               
         $astlist.add(classItem);
         // Initializing local variables
         CTentry extendedEntry = null;
         CTentry ctentry       = null;
         HashMap<String,STentry> hm = symTable.get(nestingLevel);// Recuperiamo l'hashmap del nesting level in cui ci troviamo.
         // Creiamo la entry per l'hashmap
         STentry entryCl = new STentry(classItem,nestingLevel);
         entryCl.setClassName($cid.text);
         entryCl.setType(null);
         nestingLevel++;// Incrementiamo il nesting level (perch√© siamo dentro la classe ora)
         ctentry = new CTentry(classItem,nestingLevel);// A questo punto possiamo definire la CTentry
         
         STentry tmp  = hm.put($cid.text,entryCl);// "put()" ritorna diverso da null solo se c'era qualcosa di gi√† definito con quella keyword nella HM.
         CTentry tmp2 = classTable.put($cid.text,ctentry);
         
         if (tmp != null && tmp2 != null)
         {
            System.out.println("Class id "+$cid.text+" at line "+$cid.line+" already declared");
            System.exit(0); 
         }                
         
         HashMap<String,STentry> classLevelSymTable =  new HashMap<String,STentry>(); // creaiamo una nuova HM per gli elementi definiti nella classe
         symTable.add(classLevelSymTable);  // aggiungiamo tale HM in 'symtable'      
         ctentry.setVirtualTable(classLevelSymTable);// salviamo tale HM come virtual table della classe (copia del puntatore).
      }
	    (EXTENDS cidext=ID
	    {
           extendedEntry = classTable.get($cidext.text);
           
           if(extendedEntry == null){
           System.out.println("Class id "+$cidext.text+" at line "+$cidext.line+" not declared");
              System.exit(0);
           }
           
           ArrayList<Node> tmpFields = (ArrayList<Node>) extendedEntry.getFields().clone(); //.clone() √® necessario per non rischiare di copiare il riferimento all'oggetto
           ArrayList<Node> tmpMethods = (ArrayList<Node>) extendedEntry.getMethods().clone();
           ctentry.setFields(tmpFields);
           ctentry.setMethods(tmpMethods);
           HashMap<String,STentry> tmpMap = (HashMap<String, STentry>) extendedEntry.getVirtualTable().clone();// Prendiamo la virtual table della classe parent e la copiamo nella virtual table della classe figlia.
           
           symTable.get(nestingLevel).putAll(tmpMap); //merge tra tmpMap e la virtualTable della classe che estende
           ctentry.setMethodOffset(extendedEntry.getMethodOffset());
           ctentry.setFieldOffset(extendedEntry.getFieldOffset());
           classItem.setSuperEntry(extendedEntry);
           classItem.setClassEntry(ctentry);
           FOOLlib.putSuperType($cid.text,$cidext.text);//Memorizziamo il nome della classe e della relativa super classe in FOOLlib.
           
	     }
	     )? 
	     LPAR 
	     {
           ArrayList<Node> constrPar = new ArrayList<Node>(); // lista dei field della classe
       }
	     (p1=ID COLON t1=basic 
	     {
	         // Aggiungiamo il field alla lista
	         constrPar.add($t1.ast);
	         // Aggiungiamo il field alla classe, necessario poi per la code generation.
           FieldNode objField = new FieldNode($p1.text,$t1.ast,$cid.text);
           classItem.addField(objField);
           // Aggiungiamo il field alla virtual table della ctentry della classe
           STentry tempEntry = new STentry(objField,nestingLevel,$t1.ast,ctentry.getFieldOffset());
           tempEntry.setClassName($cid.text);
           STentry tmpField = ctentry.getVirtualTable().put($p1.text,tempEntry); //restituisce una STentry se gi‡ presente in vTable
           if(tmpField != null)
           {
              if(ctentry.checkLocals(tmpField.getOffset())){ //se Ë true vuol dire che sto ridefinendo un field/method nella classe
                System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared!");
                System.exit(0);
              }// else: Ë overriding
           }
           
           // Check anche su allFields e gestione della lista stessa ('allFields')
           if(ctentry.setFieldAndCheck(objField,$p1.text))
               tempEntry.setOffset(ctentry.getFieldOffset());//controlla in allFields se c'Ë gi‡ come campo, in caso positivo sovrascrive (overriding)    
           
           ctentry.addLocals(ctentry.getFieldOffset()); // Aggiungo l'offset del field in caso non sia stato ancora dichiarato
           ctentry.decFieldOffset();  // Decrementiamo il fieldOffset per il prossimo field
	     }
	     (COMMA pn=ID COLON tn=basic
	     {
	         // Aggiungiamo il field alla lista
           constrPar.add($tn.ast);
           // Aggiungiamo il field alla classe
           FieldNode objFieldN = new FieldNode($pn.text,$tn.ast,$cid.text);
           classItem.addField(objFieldN);      
           // Aggiungiamo il field alla virtual table della ctentry della classe
           STentry tmpSTentry = new STentry(objFieldN,nestingLevel,$tn.ast,ctentry.getFieldOffset());
           STentry tmpFieldN = ctentry.getVirtualTable().put($pn.text,tmpSTentry);
           if ( tmpFieldN  != null  )
           {
              if(ctentry.checkLocals(tmpFieldN.getOffset())){
                 System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared!");
                 System.exit(0);
              }           
           }         
           
           // Check anche su allFields e gestione della lista stessa ('allFields')
           if(ctentry.setFieldAndCheck(objFieldN,$pn.text))
              tmpSTentry.setOffset(ctentry.getFieldOffset());
           tmpSTentry.setOffset( ctentry.getFieldOffset() );//controlla in allFields se c'√® gi√† come campo, in caso positivo sovrascrive (overriding)
           //******** doppio setOffset() ?? - fine richiesta spiegazione
           ctentry.addLocals(ctentry.getFieldOffset()); // Aggiungo l'offset del field in caso non sia stato ancora dichiarato
           ctentry.decFieldOffset();  // Decrementiamo il fieldOffset per il prossimo field
	     }
	     )* )? RPAR
	     {
	        ctentry.addType( new ArrowTypeNode(constrPar, classItem) ); // adding the type to the ctentry
	     }
	     CLPAR//apri graffa
	       (FUN mid=ID COLON retm=basic    // definizione di un metodo della classe. Esempio-> fun method:int ()
	       {
             // Definizione del metodo
             MethodNode mNode = new MethodNode($mid.text,$retm.ast);
             STentry entry = new STentry(mNode,nestingLevel,$retm.ast,ctentry.getMethodOffset());
             entry.setClassName($cid.text);
             entry.setIsMethod();  // Specifichiamo che si tratta di un metodo
             STentry tmpMethod = ctentry.getVirtualTable().put($mid.text,entry);  // Ritorna un valore diverso da 'null' solo se va a sovrascrivere un valore che aveva la stessa key.
             if (tmpMethod != null)
             {
                if(ctentry.checkLocals(tmpMethod.getOffset())){ // Se il metodo Ë stato gi‡ definito nella classe in questione...
                  System.out.println("Method id "+$mid.text+" at line "+$mid.line+" already declared!");
                  System.exit(0);
                }
                else
                    ctentry.addLocals(tmpMethod.getOffset()); // Il metodo Ë stato sovrascritto (override).
             } 
             else
                ctentry.addLocals(ctentry.getMethodOffset()); // Aggiungiamo semplicemente il nuovo offset tra quelli memorizzati in 'locals'. 
             
             if( ctentry.setMethodAndCheck(mNode,$mid.text) ) // Se c'Ë stato un override
                entry.setOffset(ctentry.getMethodOffset());   // Memorizziamo l'offset del metodo  
             
             ctentry.incMethodOffset();     // Incrementiamo l'offset per il prossimo metodo    
             
             classItem.setMethod(mNode);    // Settiamo il metodo nella classe
             nestingLevel++;                // Aumentiamo il nesting level, stiamo entrando nel metodo.
             HashMap<String,STentry> hmMethod = new HashMap<String,STentry>();  // Definizione della HashMap del metodo in symtable.
             symTable.add(hmMethod);
	       }
	       LPAR
	       {
	          ArrayList<Node> parTypes = new ArrayList<Node>();  // parametri in input per il metodo
            int parOffset = 1;
	       }
	       (mp1=ID COLON mpt1=type 
	       {
	           // Leggiamo il primo parametro in input del metodo
	           parTypes.add($mpt1.ast);
             ParNode fpar = new ParNode($mp1.text,$mpt1.ast);
             mNode.addPar(fpar);  // Aggiungiamo il parametro alla struttura dati del metodo
             
             STentry tmpEntryPar = new STentry(fpar,nestingLevel,$mpt1.ast,parOffset);             
             if ( hmMethod.put($mp1.text,tmpEntryPar) != null  ){  // Aggiungiamo il parametro alla symbol table
                System.out.println("Parameter id "+$mp1.text+" at line "+$mp1.line+" already declared");
                System.exit(0);
             }
             
             parOffset++;   // Incrementiamo l'offset per il prossimo parametro
	       }
	       (COMMA mpn=ID COLON mptn=type
	       {
	           // Leggiamo dal secondo parametro in poi in input del metodo
	           parTypes.add($mptn.ast);
             ParNode par = new ParNode($mpn.text,$mptn.ast);
             mNode.addPar(par);  // Aggiungiamo il parametro alla struttura dati del metodo
             
             STentry stPar = new STentry(fpar,nestingLevel,$mptn.ast,parOffset);
             if (hmMethod.put($mpn.text,stPar) != null ){  // Aggiungiamo il parametro alla symbol table
                System.out.println("Parameter id "+$mpn.text+" at line "+$mpn.line+" already declared");
                System.exit(0);
             }
               
             parOffset++;   // Incrementiamo l'offset per il prossimo parametro

	       })* )? RPAR   // Fine parametri del metodo
	       {
	           entry.addType( new ArrowTypeNode(parTypes , $retm.ast) );
             ArrayList<Node> letInMethodList = new ArrayList<Node>();       
	       }
	       (LET 
	       {
	           int innerOffset = 0; 
	           nestingLevel++;
	       }
	       (VAR vid=ID COLON vt=type ASS ve=exp // Se aggiungiamo var nel metodo, siamo in uno scope sintattico maggiore (per via del LET), per cui si crea una nuova hashmap, si aumenta il nestingLevel e poi si aggiunge a symTable
	       {
	           VarNode v = new VarNode($vid.text,$vt.ast,$ve.ast);
             $astlist.add(v);
             
             HashMap<String,STentry> varhm =  new HashMap<String,STentry>(); 
             symTable.add(varhm);
             if ( varhm.put($vid.text,new STentry(v,nestingLevel,$vt.ast,innerOffset++)) != null  )
             {
                 System.out.println("Var id "+$vid.text+" at line "+$vid.line+" already declared");
                 System.exit(0);
             }
          }
	        SEMIC)* IN 
	        {
	          // *********** Giuseppe, dici che possiamo togliere queste parentesi vuote?
	        }
	        )? varE=exp //varExp
	        {
	            // Chiudiamo lo scope, decrementando anche il nesting level di riferimento.
              symTable.remove(nestingLevel--);           
              mNode.addBody($varE.ast);     // Aggiungiamo la var al metodo ****** corretto?
              classItem.addMethod(mNode);   // Aggiungiamo il metodo alla classe
	        }
	        SEMIC)* 
      CRPAR
      {
        symTable.remove(nestingLevel--);  // Chiudiamo lo scope.
      }
      )*
      
   ;
        
declist	returns [ArrayList<Node> astlist]
	: {
	    $astlist = new ArrayList<Node>() ;
	    int offset=-2;   // ******* Giuseppe, perchÈ partiamo da -2? 
	  }
    ( // Possiamo trovarci a dichiarare VAR o FUNzioni
     (
       VAR i=ID COLON t=type ASS e=exp
       {
          // Leggiamo l'input, creiamo la struttura dati della Var e l'aggiungiamo alla lista 'astlist'.
          VarNode v = new VarNode($i.text,$t.ast,$e.ast);
          $astlist.add(v);
          if($t.ast instanceof ArrowTypeNode) // Se Ë di tipo funzionale usiamo un offset doppio per considerare ********** il puntatore e il valore???
          {
             offset--;
          }
          
          System.out.println("VAR    "+ v.toPrint(""));
          
          // Recuperiamo l'HashMap del livello attuale e vi aggiungiamo la VAR.
          HashMap<String,STentry> hm = symTable.get(nestingLevel);
          STentry varEntry = new STentry(nestingLevel,$t.ast,offset--);
          if ( hm.put($i.text,varEntry) != null  ){
             System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
             System.exit(0);
          }
       }
       |
       FUN i=ID COLON t=basic
       {
          // Creazione del FunNode e aggiunta in astlist
          FunNode f = new FunNode($i.text,$t.ast);
          $astlist.add(f);
          // Recuperiamo l'HashMap del livello attuale e vi aggiungiamo la FUN.
          HashMap<String,STentry> hm = symTable.get(nestingLevel);
          STentry entry = new STentry(nestingLevel,offset);
          offset = offset - 2;  // ****** come mai -2? Non dovrebbe essere +2?
          if ( hm.put($i.text,entry) != null ){
             System.out.println("FUN id "+$i.text+" at line "+$i.line+" already declared");
             System.exit(0);
          }
          // Creiamo una nuova HashMap per la symTable per gestire il livello di nesting interno alla funzione.
          nestingLevel++;   // andiamo "dentro" alla funzione.
          HashMap<String,STentry> hmn = new HashMap<String,STentry> (); // HashMap che gestisce il contenuto della funzione.
          symTable.add(hmn);
       }
       LPAR
       {
          ArrayList<Node> parTypes = new ArrayList<Node>();
          int paroffset = 1;
       }
       (
         fid=ID COLON fty=type
         {
            // Gestione del parametro in input alla FUN
	          parTypes.add($fty.ast);
	          ParNode fpar = new ParNode($fid.text,$fty.ast);
	          
	          if($fty.ast instanceof ArrowTypeNode )  // Se di tipo funzionale
               paroffset++;
            
	          f.addPar(fpar);    // Aggiunta del parametro alla funzione
	          
	          if ( hmn.put($fid.text,new STentry(fpar,nestingLevel,$fty.ast,paroffset++)) != null  ){
	             System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
	             System.exit(0);
	          }
         }
         (
	          COMMA id=ID COLON ty=type  // parametri di input dal secondo in poi.
	          {
	             // Gestione degli altri parametri in input alla FUN (come per il primo parametro).
		           parTypes.add($ty.ast); 
		           ParNode par = new ParNode($id.text,$ty.ast);
		           if($ty.ast instanceof ArrowTypeNode)
		              paroffset++;
               
		           f.addPar(par);
		           if ( hmn.put($id.text,new STentry(par,nestingLevel,$ty.ast,paroffset++)) != null  ){
		              System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
		              System.exit(0);
		           }
	          }
         )*
       )?
       RPAR { entry.addType( new ArrowTypeNode(parTypes, $t.ast) ); } 
       ( LET d=declist IN )?
       e=exp
       {//chiudere scope
          symTable.remove(nestingLevel--);
          f.addDecBody($d.astlist, $e.ast);//abbiamo cambiato add body con addDecBody (dichiarazione dei parametri ed espressione del corpo della funzione)
       } 
      ) SEMIC
     )*
	;
 
type  returns [Node ast]
        : bas=basic {$ast= $bas.ast;}
        | art=arrow {$ast= $art.ast;}
    ; 

basic returns [Node ast]
  :       INT  {$ast=new IntTypeNode();}
        | BOOL {$ast=new BoolTypeNode();} 
        | i=ID {
		         int nl = nestingLevel;
		         STentry classEntry = null;    
		         while (nl>=0 && classEntry==null){
		            classEntry=(symTable.get(nl--)).get($i.text);         
		         }
		                
		         if(classEntry != null)
		            $ast=new ClassTypeNode($i.text);
		         else
		            $ast=new IdNode();
          }
	;	

/*type: basic | arrow;
basic: INT | BOOL | ID ;
arrow: LPAR (type(COMMA type)*)? RPAR ARROW basic;
*/
arrow returns [Node ast]
        : LPAR 
          {
            //creazione di una lista vuota per i parametri
            ArrayList<Node> funParTypes = new ArrayList<Node>();
          }
          (
            funParT=type 
            {
              funParTypes.add($funParT.ast);
            }
            (COMMA funParTy=type 
            {
              funParTypes.add($funParTy.ast);
            }
          )*)? RPAR ARROW retTy=basic
          {
           //creazione del nodo della funzione High Order
           $ast = new ArrowTypeNode(funParTypes,$retTy.ast);
          }
    ;
exp	returns [Node ast]
 	: f=term {$ast= $f.ast;}
 	    (
	 	    PLUS l=term  {$ast = new PlusNode ($ast,$l.ast);}
	 	    | MINUS l=term {$ast = new MinusNode($ast,$l.ast);}
	 	    | OR l=term    {$ast = new OrNode   ($ast,$l.ast);}
 	    )*
 	;
 	
term returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    (
		    MULT l=factor {$ast= new MultNode ($ast,$l.ast);}
		    | DIV  l=factor {$ast= new DivNode ($ast,$l.ast);}
		    | AND  l=factor {$ast= new AndNode ($ast,$l.ast);}
	    )*
	;

value	returns [Node ast]
	: i=INTEGER {$ast= new NatNode(Integer.parseInt($i.text));}  
	| TRUE  {$ast = new BoolNode(true);}
  | FALSE {$ast = new BoolNode(false);}
  | NULL  {$ast = new EmptyNode();}
  | NEW i=ID
    {
       CTentry ctEntry=null; 
       ctEntry=classTable.get($i.text);
       
       if(ctEntry==null)
       {
          System.out.println("Class "+$i.text+" at line "+$i.line+" not declared!!!!");
          System.exit(0); 
       }
    }
    LPAR
    {
       ArrayList<Node> argList = new ArrayList<Node>();
    }
    (fa=exp
    {
       argList.add($fa.ast);
    }
	     (COMMA a=exp
	     {
	        argList.add($a.ast);
	     }
	     )* 
	  )?
    {
         $ast = new NewNode($i.text,ctEntry,argList);     
    }
    RPAR
        
  | IF LPAR x=exp RPAR THEN CLPAR y=exp CRPAR 
       ELSE CLPAR z=exp CRPAR 
    {$ast= new IfNode($x.ast,$y.ast,$z.ast);}   
  | NOT LPAR  x=exp RPAR  {$ast = new NotNode($x.ast);}
  | PRINT LPAR e=exp RPAR {$ast = new PrintNode($e.ast);}
  | LPAR e=exp RPAR {$ast = $e.ast;}
  |  i=ID
    {//cercare la dichiarazione (cio√® quando lo usa)
	    int j  = nestingLevel;
	    STentry entry     = null; 
	    CTentry classEntry = null;
	    classEntry = classTable.get($i.text);
	        	     
	    if(classEntry==null)    
	    {
         while (j>=0 && entry==null)
         entry=(symTable.get(j--)).get($i.text);
      }
      
	    if (entry == null && classEntry == null){
	       System.out.println("Id "+$i.text+" at line "+$i.line+" not declared!!");	       
	       System.exit(0);
	    }
	     	 
	    if( classEntry != null )	        
	       $ast = new IdNode($i.text,classEntry,nestingLevel);//per distinguere i nome di classe e id generico
	    else
	       $ast = new IdNode($i.text,entry,nestingLevel);
	    
                 
    }
    (
      LPAR { ArrayList<Node> argList = new ArrayList<Node>(); } 
      (fa=exp {argList.add($fa.ast);}
        (COMMA a=exp {argList.add($a.ast);})*
      )?
      {
      
        if( classEntry != null) 
        {
            System.out.println("Call of class Id "+$i.text);
            System.exit(0);
        }
        else
            $ast=new CallNode($i.text,entry,argList,nestingLevel);

      }    
     RPAR
    |  DOT cmid=ID
    {
       CTentry ctentryClass = null;
       STentry entryM = null;
       if(entry != null) 
         ctentryClass = classTable.get(((ClassTypeNode)entry.getType()).getName());
       else
       {  
          System.out.println("Not object invocation, check: "+$i.text);
          System.exit(0);
       }    
     // ricerca della entry relativa alla classe dell'oggetto istanza su cui viene richiamato il metodo
//       -ClassCallNode  ID1.ID2() 
//        STentry dell'ID1 in campo "entry"
//        STentry dell'ID2 in campo "methodEntry"
//        (ID2 cercato in vTable della CTentry della classe del tipo di ID1)      
       //ricerca dell'entry del metodo all'interno della classe relativa ad esso trovata in precedenza

       entryM = ctentryClass.getVirtualTable().get($cmid.text);
       
       if (entryM==null){
         System.out.println("Method Call "+$cmid.text+" at line "+$cmid.line+" not declared");
         System.exit(0); 
       }        
  
    }
     LPAR
     {
        ArrayList<Node> mArgList = new ArrayList<Node>();
     }
     (cmex1=exp
     {
        mArgList.add($cmex1.ast);
     }
     (COMMA cmexn=exp
     {
        mArgList.add($cmexn.ast);
     }
     )* )? 
     {
        $ast = new ClassCallNode($cmid.text, entry,entryM, mArgList, nestingLevel, ctentryClass);
     }
     RPAR    
     )? 
     
 	;	 

factor returns [Node ast]
    : f = value {$ast = $f.ast;}
    (
        EQ l=value {$ast = new EqualNode($ast,$l.ast);}
      | GR l=value {$ast = new GreaterOrEqualNode($ast,$l.ast);}
      | LE l=value {$ast = new LessOrEqualNode($ast,$l.ast);}
    )*
  ; 

 	
/*------------------------------------------------------------------
 * GRAMMAR RULES
 *------------------------------------------------------------------*/
/*
**prog  : expr SEMIC                        
        | LET cllist declist IN expr SEMIC
        ;

cllist  : (CLASS ID (EXTENDS ID)? LPAR (ID COLON basic (COMMA ID COLON basic)* )? RPAR    
              CLPAR
                 (FUN ID COLON basic LPAR (ID COLON type (COMMA ID COLON type)* )? RPAR
              (LET (VAR ID COLON basic ASS expr SEMIC)* IN )? expr 
            SEMIC)*                
              CRPAR)*
        ; 

**declist : (
            (   VAR ID COLON type ASS expr
              | FUN ID COLON basic LPAR (ID COLON type (COMMA ID COLON type)* )? RPAR (LET declist IN)? expr 
            ) SEMIC 
          )*
        ;

**expr  : term 
          (   PLUS term  
            | MINUS term 
            | OR t2=term
          ) * 
        ;  

**term  : factor 
      (   MULT factor 
        | DIV  factor 
        | AND  factor 
      )*
    ;
    
**factor  : value 
      (   EQ value 
      | GR value 
      | LE value 
    )*
  ;     
    
**value : 
    INTEGER 
  | TRUE      
  | FALSE       
  | NULL      
  | NEW ID LPAR (expr (COMMA expr)* )? RPAR         
  | IF expr THEN CLPAR expr CRPAR ELSE CLPAR expr CRPAR     
  | NOT LPAR expr RPAR 
  | PRINT LPAR expr RPAR      
  | LPAR expr RPAR  
  | ID ( LPAR (expr (COMMA expr)* )? RPAR 
       | DOT ID LPAR (expr (COMMA expr)* )? RPAR )?    
        ; 
               
**type    :  basic | arrow 
        ;

**basic   : INT               
        | BOOL              
  | ID                        
  ;  
    
**arrow   : LPAR (type (COMMA type)* )? RPAR ARROW basic 
  ;           	
 	*/
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV   : '/' ;
LPAR  : '(' ;
RPAR  : ')' ;
CLPAR : '{' ;
CRPAR : '}' ;
SEMIC   : ';' ;
COLON   : ':' ; 
COMMA : ',' ;
DOT : '.' ;
OR  : '||';
AND : '&&';
NOT : 'not' ;
GR  : '>=' ;
LE  : '<=' ;
EQ  : '==' ;  
ASS : '=' ;
TRUE  : 'true' ;
FALSE : 'false' ;
IF  : 'if' ;
THEN  : 'then';
ELSE  : 'else' ;
PRINT : 'print' ;
LET     : 'let' ; 
IN      : 'in' ;  
VAR     : 'var' ;
FUN : 'fun' ; 
CLASS : 'class' ; 
EXTENDS : 'extends' ; 
NEW   : 'new' ; 
NULL    : 'null' ;    
INT : 'int' ;
BOOL  : 'bool' ;
ARROW   : '->' ;  
INTEGER : (('1'..'9')('0'..'9')*) | '0' ; 
ID    : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
WHITESP : ( '\t' | ' ' | '\r' | '\n' )+    { $channel=HIDDEN; } ;
 
ERR   	 : . { System.out.println("Invalid char: "+$text); lexicalErrors++; $channel=HIDDEN; } ; 

