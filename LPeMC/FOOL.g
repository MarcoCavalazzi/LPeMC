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
	private ArrayList<HashMap<String,STentry>>  virtualTable = new ArrayList<HashMap<String,STentry>>();
	private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>();
	private int nestingLevel = -1;
	private int nestingVirtualLevel=-1;
	//livello ambiente con dichiarazioni piu' esterno ï¿½ 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle ï¿½ symTable.get(nestingLevel)
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog	returns [Node ast]
	 : e=exp SEMIC {$ast = new ProgNode($e.ast);}
        | LET 
            {
              nestingLevel++;
              nestingVirtualLevel++;
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
	     int offset      = -2;
	     int classoffset = -2;	     
	     int methodOffset = 0;
	   } 
	   (CLASS cid=ID  //metto in symbol table level 0 l'ID della classe 
	   {
         ClassNode Obj = new ClassNode($cid.text);
         $astlist.add(Obj);
         CTentry extendedEntry = null;
         CTentry ctentry       = null;
         HashMap<String,STentry> hm = symTable.get(nestingLevel);
            
         STentry entryCl = new STentry(Obj,nestingLevel);
         ctentry = new CTentry(Obj,nestingVirtualLevel);
         entryCl.setClassName($cid.text);
         
         STentry tmp  = hm.put($cid.text,entryCl);
         CTentry tmp2 = classTable.put($cid.text,ctentry);
         
         if (tmp != null && tmp2 != null)
         {
            System.out.println("Class id "+$cid.text+" at line "+$cid.line+" already declared");
            System.exit(0); 
         }                

         nestingVirtualLevel++;
         HashMap<String,STentry> hmn =  new HashMap<String,STentry>(); 
         symTable.add(hmn);        

      }
	    (EXTENDS cidext=ID
	    {
	     
         // HashMap<String,STentry> hmSuper = classTable.get(nestingClassLevel-1);
           
           // verifico che la classe estesa sia già stata dichiarata in precedenza 
          // while (j>=0 && entry==null){
           extendedEntry = classTable.get($cidext.text);
          // }
                 
           if(extendedEntry == null){
           System.out.println("Class id "+$cidext.text+" at line "+$cidext.line+" not declared");
              System.exit(0);
           }
           
           
           ArrayList<Node> tmpField  = (ArrayList<Node>) extendedEntry.getFields().clone(); //necessario per non rischiare di copiare il riferimento all'oggetto
           ArrayList<Node> tmpMethod = (ArrayList<Node>) extendedEntry.getMethods().clone();
           ctentry.setFields(tmpField);
           ctentry.setMethods(tmpMethod);
           HashMap<String,STentry> tmpMap = (HashMap<String, STentry>) extendedEntry.getVirtualTable().clone();
           ctentry.setVirtualTable(tmpMap);
           Obj.setSuperEntry(extendedEntry);
           Obj.setClassEntry(ctentry);
           FOOLlib.putSuperType($cid.text,$cidext.text);
	     }
	     )? 
	     LPAR 
	     {
           ArrayList<Node> ConstrPar = new ArrayList<Node>();
           //int clParOffset = 1;
           int fieldOffset=-1; 
       }
	     (p1=ID COLON t1=basic 
	     {
	       
	         ConstrPar.add($t1.ast);
           FieldNode Objfield = new FieldNode($p1.text,$t1.ast,$cid.text);
           Obj.addField(Objfield);
           ctentry.setFieldOffset(fieldOffset);
           STentry  tempEntry = new STentry(Objfield,nestingVirtualLevel,$t1.ast,fieldOffset);
           tempEntry.setClassName($cid.text);
           if(ctentry.putvTable($p1.text,tempEntry, extendedEntry) != null)//putvTable controlla anche se c'è overriding, in caso positivo sovrascrive
           {
              System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared!");
              System.exit(0);
           }
           hmn.put($p1.text,tempEntry);
           ctentry.setField(Objfield);
           fieldOffset--;
//          if ( hmn.put($p1.text,tempEntry) != null  )
//          {
//             System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared");
//             System.exit(0); 
//          }
          
          
          //ctentry.setFieldAndCheck(Objfield, $p1.text);
          //boolean flag = false;
          //
//            if(extendedEntry!=null) //per controllare se c'è stato un extends
//           {
//            for(int i =0;i< extendedEntry.getFields().size() ;i++) //cerco se c'è stato override
//              if(extendedEntry.getFields().get(i).equals($p1.text)) //in caso positivo, flag = true per cui non verrà aggiunta alla ctentry 
//                {
//                  //remove field?
//                }
//           }
         // if(!flag)         
           //ctentry.setField(Objfield); //controlla se il campo è già presente, in caso positivo si sta facendo ovveriding e quindi devo sovrascrivere (questa operazione viene fatta in setField)
          //se p1 è anche in extendedEntry.getFields non lo aggiungiamo in symbolTable
          
         
         // nestingLevel++; //06_05 non so se vada bene
	     }
	     (COMMA pn=ID COLON tn=basic
	     {
	        ConstrPar.add($tn.ast);
          FieldNode ObjfieldN = new FieldNode($pn.text,$tn.ast,$cid.text);
          Obj.addField(ObjfieldN);
          ctentry.setFieldOffset(fieldOffset);
          STentry tmpSTentry = new STentry(ObjfieldN,nestingLevel,$tn.ast,fieldOffset);
          if ( ctentry.putvTable($pn.text,tmpSTentry,extendedEntry) != null  )
          {
             System.out.println("Parameter id "+$pn.text+" at line "+$pn.line+" already declared");
             System.exit(0); 
          }
          hmn.put($pn.text,tmpSTentry);
          fieldOffset--;
	     }
	     )* )? RPAR
	     {
	        ctentry.addType( new ArrowTypeNode(ConstrPar, Obj) ); 
	        
	     }
	     CLPAR//apri graffa
	       (FUN mid=ID COLON retm=basic
	       {               
	           //creazione del nodo del metodo e set a true del flag indicante che si
             // è all'interno di un metodo di classe 
              
             //isInMethod = true;
             //inserimento di ID nella symtable
             MethodNode f = new MethodNode($mid.text,$retm.ast); 
                      
             $astlist.add(f);//giusto o da commentare???
             // HashMap<String,STentry> hmclass = virtualTable.get(nestingClassLevel);   
             //HashMap<String,STentry> hmclass =  new HashMap<String,STentry>();
             //symTable.add(hmclass);                  
             //aggiunga del parametro nell'apposita collezione tenendo conto dell'overriding dei parametri
             //FOOLlib.addMethodTuple($mid.text, $cid.text, FOOLlib.getMethodRealOffset(Obj,$mid.text));
             //STentry entry = new STentry(nestingClassLevel,f,classoffset++); //modificato il 14_05           
            
             //STentry entry = new STentry(nestingLevel,f,classoffset++);//commentato e modificato il 16_05
             //STentry entry = new STentry(nestingLevel,f,methodOffset++);
             STentry entry = new STentry(f,nestingVirtualLevel,$retm.ast,methodOffset);
             entry.setClassName($cid.text);
             entry.setIsMethod();             
             if ( ctentry.putvTable($mid.text,entry,extendedEntry) != null  )
             {
                System.out.println("Method id "+$mid.text+" at line "+$mid.line+" already declared");
                System.exit(0); 
             }
             ctentry.setMethodOffset(methodOffset);
             hmn.put($mid.text,entry);
             methodOffset++;
            // nestingClassLevel++;
            // nestingLevel++; 
             //HashMap<String,STentry> hmnc = new HashMap<String,STentry> ();
            // virtualTable.add(hmnc);
             ctentry.setMethod(f);
             Obj.setMethod(f);
            // symTable.add(hmnc);
             //creare una nuova hashmap per la symTable
             // nestingLevel++;
             // HashMap<String,STentry> hmnc = new HashMap<String,STentry> (); //hmnc è la vTable
             //symTable.add(hmnc);
	       }
	       LPAR 
	       {
	          ArrayList<Node> parTypes = new ArrayList<Node>();
            int parOffset = 1;
	       }
	       (mp1=ID COLON mpt1=type 
	       {
	          parTypes.add($mpt1.ast);
            ParNode fpar = new ParNode($mp1.text,$mpt1.ast);
            
            f.addPar(fpar);
            STentry tmpEntryPar = new STentry(fpar,nestingVirtualLevel,$mpt1.ast,parOffset);             
            if ( ctentry.putvTable($mp1.text,tmpEntryPar,extendedEntry) != null  ){
             System.out.println("Parameter id "+$mp1.text+" at line "+$mp1.line+" already declared");
             System.exit(0);
             }
             
             hmn.put($mp1.text,tmpEntryPar);
             parOffset++;
            /*
            if(mpt1.text.equals("ClassTypeNode")
            {
             //  STentry entryCl2 = new STentry(Obj,nestingLevel);
               entryCl.setClassName($cid.text);
             //  ctentry = new CTentry2(Obj,nestingClassLevel);
               STentry tmp2  = hm.put($cid.text,entryCl);
               CTentry tmp22 = classTable.put($cid.text,ctentry);
         
         if (tmp2 != null && tmp22 != null)
         {
            System.out.println("Class id "+$cid.text+" at line "+$cid.line+" already declared");
            System.exit(0); 
         }                
         //creare una nuova hashmap per la symTable      
        
         nestingLevel++;
         nestingClassLevel++;
         HashMap<String,STentry> hmn2 = new HashMap<String,STentry>(); 
         HashMap<String,STentry> vTable2 = new HashMap<String,STentry> (); //sicura sta cosa?
         symTable.add(hmn);
         virtualTable.add(vTable);
            }
           */
            // if ( hmnc.put($mp1.text,new STentry(fpar,nestingLevel,$mpt1.ast,parOffset++)) != null  )
	          // if ( entry.put($mp1.text,new STentry(fpar,nestingLevel,$mpt1.ast,parOffset++)) != null  )
	          // {
	          //     System.out.println("Parameter id "+$mp1.text+" at line "+$mp1.line+" already declared");
	          //     System.exit(0); 
	          // }
	          
            
	       }
	       (COMMA mpn=ID COLON mptn=type
	       {
	          parTypes.add($mptn.ast);
            ParNode par = new ParNode($mpn.text,$mptn.ast);
            f.addPar(par);
            
            STentry stPar = new STentry(fpar,nestingVirtualLevel,$mptn.ast,parOffset);
            if (ctentry.putvTable($mpn.text,stPar,extendedEntry) != null ){
               System.out.println("Parameter id "+$mpn.text+" at line "+$mpn.line+" already declared");
               System.exit(0);
               }
               
            hmn.put($mpn.text,stPar);
            parOffset++;

	       })* )? RPAR
	       {
	          entry.addType( new ArrowTypeNode(parTypes , $retm.ast) );
            ArrayList<Node> letInMethodList = new ArrayList<Node>();       
            
            
	       }
	       (LET {int innerOs = 0; }
	       (VAR vid=ID COLON vt=type ASS ve=exp //se aggiungiamo var nel metodo, siamo in uno scope sintattico maggiore, per cui si crea una nuova hashmap, si aumenta il nestingVirtualLevel e poi si aggiunge a symTable
	       {
	          VarNode v = new VarNode($vid.text,$vt.ast,$ve.ast);
            // letInMethodList.add(v); 
            $astlist.add(v);
            //HashMap<String,STentry> varhm = symTable.get(nestingVirtualLevel);
            HashMap<String,STentry> varhm =  new HashMap<String,STentry>(); 
            symTable.add(varhm);
            nestingVirtualLevel++;
            if ( varhm.put($vid.text,new STentry(v,nestingVirtualLevel,$vt.ast,innerOs++)) != null  )
            {
               System.out.println("Var id "+$vid.text+" at line "+$vid.line+" already declared");
               System.exit(0); 
            }              
          }
	        SEMIC)* IN )? vine=exp
	        {
	            //chiudere scope                       
              //symTable.remove(nestingLevel--);  //è corretto? 06_05
              //virtualTable.remove(nestingClassLevel--);           
              f.addBody($vine.ast);
              //aggiungo il metodo alla classe
              Obj.addMethod(f); 
              // isInMethod = false;
              
	        }
	        SEMIC)* 
      CRPAR)*
      {
      }
   ;
        
declist	returns [ArrayList<Node> astlist]
	: {
	    $astlist = new ArrayList<Node>() ;
	    int offset=-2;
	  }
    (
     (
       VAR i=ID COLON t=type ASS e=exp
       {
          VarNode v = new VarNode($i.text,$t.ast,$e.ast);
          $astlist.add(v);
          //System.out.println("type: "+$t.ast + "var "+$i.text);
          if($t.ast instanceof ArrowTypeNode)
          {
             offset-=2;
          }
          System.out.println("[FOOL.g] VAR    "+ v.toPrint(""));
            
          HashMap<String,STentry> hm = symTable.get(nestingLevel);
          
          if ( hm.put($i.text,new STentry(nestingLevel,$t.ast,offset--)) != null  ){
             System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
             System.exit(0);
          }
       }
       |
       FUN i=ID COLON t=basic
       {  
          //inserimento di ID nella symtable
          FunNode f = new FunNode($i.text,$t.ast);
          $astlist.add(f);
          HashMap<String,STentry> hm = symTable.get(nestingLevel);
          STentry entry = new STentry(nestingLevel,offset--);
          //STentry entry = new STentry(nestingLevel,f,offset-=2);
          if ( hm.put($i.text,entry) != null ){
             System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
             System.exit(0);
          }
          //creare una nuova hashmap per la symTable
          nestingLevel++;
          HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
          symTable.add(hmn);
       }
       LPAR { ArrayList<Node> parTypes = new ArrayList<Node>(); int paroffset=1; } 
       (
         fid=ID COLON fty=type
         {
	          parTypes.add($fty.ast); 
	          ParNode fpar = new ParNode($fid.text,$fty.ast);
	          
	          if($fty.ast instanceof ArrowTypeNode)
            {
               paroffset+=2;
               System.out.println("Parameter id "+$fid.text+" è di tipo funzionale");
            } 
	          
	          f.addPar(fpar);
	                             
	          if ( hmn.put($fid.text,new STentry(fpar,nestingLevel,$fty.ast,paroffset++)) != null  ){
	             System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
	             System.exit(0);
	          }
         }
         (
	          COMMA id=ID COLON ty=type
	          {
		           parTypes.add($ty.ast); 
		           ParNode par = new ParNode($id.text,$ty.ast);
		           if($fty.ast instanceof ArrowTypeNode)
		           {
		              paroffset+=2;
		              System.out.println("Parameter id "+$id.text+" è di tipo funzionale:");
               } 
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
          //{f.addDec($d.astlist);} 
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
        | i=ID   {
         int jj = nestingVirtualLevel;    
         STentry classEntry = null;    
         while (jj>=0 && classEntry==null){
           classEntry=(symTable.get(jj--)).get($i.text);         
         }       
                  if(classEntry != null)
                  {
                    $ast=new ClassTypeNode($i.text);                  
                   }
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
       //ctEntry.setField($fa.ast);
    }
	     (COMMA a=exp
	     {
	        argList.add($a.ast);
	        // ctEntry.setField($a.ast);
	     }
	     )* 
	  )?
    {
            //ClassCallNode c= new ClassCallNode($i.text,entry,argList,nNewClass);
         // $ast=c;
         $ast = new NewNode($i.text,ctEntry,argList);
              
//     
    }
    RPAR
        
  | IF LPAR x=exp RPAR THEN CLPAR y=exp CRPAR 
       ELSE CLPAR z=exp CRPAR 
    {$ast= new IfNode($x.ast,$y.ast,$z.ast);}   
  | NOT LPAR  x=exp RPAR  {$ast = new NotNode($x.ast);}
  | PRINT LPAR e=exp RPAR {$ast = new PrintNode($e.ast);}
  | LPAR e=exp RPAR {$ast = $e.ast;}
  |  i=ID
    {//cercare la dichiarazione (cioè quando lo usa)
	    int j  = nestingLevel;
	    int jj = nestingVirtualLevel;
	    STentry entry     = null; 
	    CTentry classEntry = null;
	    classEntry = classTable.get($i.text);
	        
	  //   while (j>=0 && entry==null)
	 //     entry=(symTable.get(j--)).get($i.text);
//	    for(j=0;j<symTable.size() && entry==null;j++)
//	       entry=(symTable.get(j)).get($i.text);
//	     
	    if(classEntry==null)    
	    {
         while (jj>=0 && entry==null)
         entry=(symTable.get(jj--)).get($i.text);
      }
      
	    if (entry == null && classEntry == null){
	       System.out.println("Id "+$i.text+" at line "+$i.line+" not declared!");	       
	       System.exit(0);
	    }
	     	 
	    if( classEntry != null )	        
	        $ast = new IdNode($i.text,classEntry,nestingLevel);
	    else
	        $ast = new IdNode($i.text,entry,nestingVirtualLevel);
	    
                 
    }
    (
      LPAR { ArrayList<Node> argList = new ArrayList<Node>(); } 
      (fa=exp {argList.add($fa.ast);}
        (COMMA a=exp {argList.add($a.ast);})*
      )?
      {
        $ast=new CallNode($i.text,entry,argList,nestingLevel-(j+1));//è esatto? quasi sicuramente no!
      }    
     RPAR
    |  DOT cmid=ID
    {
       
       STentry entryM = null;
       jj = nestingVirtualLevel;
      
         
       CTentry ctentryClass = classTable.get(((ClassTypeNode)entry.getType()).getName());      
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
        
        $ast = new ClassCallNode($cmid.text, entry,entryM, mArgList, nestingVirtualLevel);
     }
     RPAR    
     )? 
     
 	;	 

factor returns [Node ast]
    : f = value {$ast = $f.ast;}
    (
        EQ l=value {$ast = new EqualNode($ast,$l.ast);}
      | GR l=value {$ast = new GreaterOrEqualNode($ast,$l.ast);} //GreaterOrEqualNode svolto
      | LE l=value {$ast = new LessOrEqualNode($ast,$l.ast);} //LessOrEqualNode svolto
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

