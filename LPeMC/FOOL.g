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
	private int nestingLevel = -1;
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
              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
              symTable.add(hm);
            }
           d=declist IN e=exp SEMIC 
            {
              symTable.remove(nestingLevel--);
              $ast = new LetInNode($d.astlist,$e.ast) ;
            }
	;

// Questa funzione è necessaria solo nel caso dell'Object Oriented, giusto? Ci sono le classi! 
// -> Dobbiamo quindi implementarla o no?
/*
cllist returns [ArrayList<Node> astlist]   // Probabilmente deve restituire una lista di CallNode
   : {
	     $astlist = new ArrayList<Node>() ;
	     int offset=-2;
	   }
	   (CLASS cid=ID 
	   {
	      ClassNode Obj = new ClassNode($cid.text);
	      $astlist.add(Obj);
                  HashMap<String,STentry> hm = symTable.get(nestingLevel);
                  STentry entryCl = new STentry(Obj,nestingLevel);
                  if ( hm.put($cid.text,entryCl) != null  )
                  {
                    System.out.println("Class id "+$cid.text+" at line "+$cid.line+" already declared");
                     System.exit(0); 
                  }
                  //creare una nuova hashmap per la symTable
                  nestingLevel++;
                  HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
                  symTable.add(hmn);
       }
       
       
	        
	     (EXTENDS cidext=ID
	     {
	        HashMap<String,STentry> hmSuper = symTable.get(nestingLevel-1);
	         int j=nestingLevel;
            STentry entry=null;
            // verifico che la classe estesa sia già stata dichiarata in precedenza 
            while (j>=0 && entry==null){
               entry=(symTable.get(j--)).get($cidext.text);
            }
                  
            if(entry == null){
            System.out.println("Class id "+$cidext.text+" at line "+$cidext.line+" not declared");
                 System.exit(0);
            }
            Obj.addSuperClass(entry.getDecl()); 
                
	     })? LPAR 
	     {
                ArrayList<Node> ConstrPar = new ArrayList<Node>();
                int clParOffset = 1;
       }
	     (p1=ID COLON t1=basic 
	     {
	        ConstrPar.add($t1.ast);
          ParNode Objpar = new ParNode($p1.text,$t1.ast,$cid.text);
          Obj.addPar(Objpar);
          FOOLlib.addParTuple($cid.text, $p1.text, FOOLlib.getParamRealOffset(Obj, $p1.text));
          if ( hmn.put($p1.text,new STentry(Objpar,nestingLevel,$t1.ast,FOOLlib.getParamRealOffset(Obj, $p1.text))) != null  )
           {
            System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared");
            System.exit(0); 
           }
	     }
	     (COMMA pn=ID COLON tn=basic
	     {
	        ConstrPar.add($tn.ast);
          ParNode Objparn = new ParNode($pn.text,$tn.ast,$cid.text);
          Obj.addPar(Objparn);
          //aggiunga del parametro nell'apposita collezione tenendo conto dell'overriding dei parametri
          FOOLlib.addParTuple($cid.text, $pn.text, FOOLlib.getParamRealOffset(Obj, $pn.text));
          if ( hmn.put($pn.text,new STentry(Objparn,nestingLevel,$tn.ast,FOOLlib.getParamRealOffset(Obj, $pn.text))) != null  )
          {
            System.out.println("Parameter id "+$pn.text+" at line "+$pn.line+" already declared");
             System.exit(0); 
          }
	     }
	     )* )? RPAR
	     {
	        entryCl.addType( new ArrowTypeNode(ConstrPar, Obj) );
	     }
	     CLPAR
	       (FUN mid=ID COLON retm=basic
	        {
	            /* creazione del nodo del metodo e set a true del flag indicante che si
              è all'interno di un metodo di classe */
              /*
              isInMethod = true;
                    //inserimento di ID nella symtable
                    FunNode f = new FunNode($mid.text,$retm.ast);
                    $astlist.add(f);
                    HashMap<String,STentry> hmc = symTable.get(nestingLevel);
                    //aggiunga del parametro nell'apposita collezione tenendo conto dell'overriding dei parametri
                    //FOOLlib.addMethodTuple($mid.text, $cid.text, FOOLlib.getMethodRealOffset(Obj,$mid.text));
                    STentry entry = new STentry(f,nestingLevel,FOOLlib.getMethodRealOffset(Obj,$mid.text));
                    if ( hmc.put($mid.text,entry) != null  )
                    {
                      System.out.println("Method id "+$mid.text+" at line "+$mid.line+" already declared");
                       System.exit(0); 
                    }
                    //creare una nuova hashmap per la symTable
                    nestingLevel++;
                    HashMap<String,STentry> hmnc = new HashMap<String,STentry> ();
                    symTable.add(hmnc);
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
            if ( hmnc.put($mp1.text,new STentry(fpar,nestingLevel,$mpt1.ast,parOffset++)) != null  )
            {
              System.out.println("Parameter id "+$mp1.text+" at line "+$mp1.line+" already declared");
               System.exit(0); 
            }
	       }
	       (COMMA mpn=ID COLON mptn=type
	       {
	          parTypes.add($mptn.ast);
            ParNode par = new ParNode($mpn.text,$mptn.ast);
            f.addPar(par);
            if ( hmnc.put($mpn.text,new STentry(par,nestingLevel,$mptn.ast,parOffset++)) != null  )
            {
              System.out.println("Parameter id "+$mpn.text+" at line "+$mpn.line+" already declared");
               System.exit(0); 
            }
	       })* )? RPAR
	       {
	          entry.addType( new ArrowTypeNode(parTypes , $retm.ast) );
            ArrayList<Node> letInMethodList = new ArrayList<Node>();
	       }
	       (LET {int innerOs = -2; }
	       (VAR vid=ID COLON vt=basic ASS ve=exp
	       {
	          VarNode v = new VarNode($vid.text,$vt.ast,$ve.ast);
            letInMethodList.add(v); 
            HashMap<String,STentry> hmv = symTable.get(nestingLevel);
            if ( hmv.put($vid.text,new STentry(v,nestingLevel,$vt.ast,innerOs--)) != null  )
            {
              System.out.println("Var id "+$vid.text+" at line "+$vid.line+" already declared");
                System.exit(0); 
              } 
          }
	        SEMIC)* IN )? vine=exp
	        {
	            //chiudere scope
              symTable.remove(nestingLevel--);
              f.addDecBody(letInMethodList,$vine.ast);
              //aggiungo il metodo alla classe
              Obj.addMethod(f);
              isInMethod = false;
	        }
	         SEMIC)* 
      CRPAR)*
   ;
     */   
declist	returns [ArrayList<Node> astlist]
	: {
	    $astlist = new ArrayList<Node>() ;
	    int offset=-2;
	  }
    (
     (
       VAR i=ID COLON t=type ASS e=exp SEMIC
       {
          VarNode v = new VarNode($i.text,$t.ast,$e.ast);
          $astlist.add(v);
          if($t.ast instanceof ArrowTypeNode)
            {
                offset-=2;
            }
          
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
          f.addDecBody($d.astlist, $e.ast);//abbiamo cambiato add body con addDecBody (dichiarazione dei parametri ed espressione del corpo della funzione
       } 
      ) SEMIC
     )+
	;

type  returns [Node ast]
        : bas=basic {$ast= $bas.ast;}
        | art=arrow {$ast= $art.ast;}
    ; 

basic returns [Node ast]
  :       INT  {$ast=new IntTypeNode();}
        | BOOL {$ast=new BoolTypeNode();} 
        | ID {$ast=new IdNode();}
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
  | NULL  {$ast = new NullNode();}
 /* | NEW i=ID
    {
 //incremento il contatore delle istanze(identificatore univoco)
      nNewClass++;
      int j=nestingLevel;
      STentry entry=null; 
      //cercare la dichiarazione
      while (j>=0 && entry==null){
        entry=(symTable.get(j--)).get($i.text);
      }
      
      if (entry==null)
       { 
          System.out.println("Type "+$i.text+" at line "+$i.line+" not declared");
          System.exit(0); 
       }               
       
      //memorizzo la nuova istanza della classe nell'apposita lista
      FOOLlib.setInstanceClass($i.text);
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
        )* )? 
        {
          //creo il nuovo nodo che istanzia la classe
          CallClassNode c= new CallClassNode($i.text,entry,argList,nNewClass);
          $ast=c;
          /*
            se l'istanza della classe è all'interno di un metodo viene inserito il nodo relativo a tale istanza
            all'interno della lista contenente i nodi delle chiamate ai costruttori effettuate all'interno di metodi
            di classe, altrimenti viene aggiunto tale nodo alla lista contenente i nodi delle istanze effettuate
            fuori dai metodi di classe. Se si è in un metodo di classe viene incrementato anche il numero relativo 
            alle istanze effettuate all'interno di metodi di classe, altrimenti viene incrementato il contatore delle
            istanze create fuori da metodi di classe
            */
            /*
          if(!isInMethod) {
                nNewNotMethodClass++;
                callClassNodeNotInMethod.add(c);
            } else {
                nNewInMethodClass++;
                callClassNodeInMethod.add(c);
            }
        }
        RPAR
        */
  | IF LPAR x=exp RPAR THEN CLPAR y=exp CRPAR 
       ELSE CLPAR z=exp CRPAR 
    {$ast= new IfNode($x.ast,$y.ast,$z.ast);}   
  | NOT LPAR  x=exp RPAR  {$ast = new NotNode($x.ast);}
  | PRINT LPAR e=exp RPAR {$ast= new PrintNode($e.ast);}
  | LPAR exp RPAR 
  |  i=ID 
    {//cercare la dichiarazione
	    int j=nestingLevel;
	    STentry entry=null; 
	    while (j>=0 && entry==null)
	      entry=(symTable.get(j--)).get($i.text);
	    if (entry==null){
	       System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
	       System.exit(0);
	    } 	                  
	    $ast = new IdNode($i.text,entry,nestingLevel);
	    
	    //inizia la parte OO
	    /*
	    String classInputName = "";
                 if(entry != null){
                   if(entry.getDecl() instanceof ParNode){
                if( ((ParNode)entry.getDecl()).isParClass()){
                    //System.out.println("SETTING " + $i.text + " PARNODE " + initJ);
                classInputName =((ParNode)entry.getDecl()).getClassName();
                //System.out.println("CLASS OF PAR " + classInputName + " name " + className);
            }
             }
                 }
                 
                 //System.out.println("PARSER ENTRY DECL " + entry.getDecl() + " -> "  +$i.text + " OS " + entry.getOffset() + " CLNAME " + classInputName);
                 //System.out.println("Id "+$i.text+" at line "+$i.line + "   - j: " +j + " - nl: " + nestingLevel);
                 if (entry==null){
                  System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
                    // System.exit(0); 
                 }    
                 //$ast= new IdNode($i.text,entry,nestingLevel-(j+1), classInputName, classFieldName,className);
                 //System.out.println("PARSER Id "+$i.text+" ENTRY " + entry.getOffset());
                 //System.out.println(outClass);
                 $ast= new IdNode($i.text,entry,nestingLevel-(j+1), classInputName, outClass);
                 //fine parte OO
                 */
                 
    }
    (
      LPAR { ArrayList<Node> argList = new ArrayList<Node>(); } 
      (fa=exp {argList.add($fa.ast);}
        (COMMA a=exp {argList.add($a.ast);})
        *)? 
      RPAR    
      {
        $ast=new CallNode($i.text,entry,argList,nestingLevel-(j+1));
      }    
      
    /*  
    |  DOT cmid=ID
    {
      int k=nestingLevel;
                 int h=nestingLevel;
                 STentry entryM=null;
                 STentry entryRealCl = null;
                 
                 String clName = ((ClassTypeNode)entry.getType()).getName();
                 //System.out.println("Class Name: "+clName);
                 
                 /*
                 ricerca della entry relativa alla classe dell'oggetto istanza su cui viene richiamato il metodo
                 */
                 /*
                 while (h>=0 && entryRealCl==null){
                  entryRealCl=(symTable.get(h--)).get(clName);
                  //System.out.println("Found 1 ciclo:" +$i.text+" at line "+$i.line + " j="+j + "     nl: " + nestingLevel);
                  //found=true;
                 }
                 
                 /*
                 ricerca dell'entry del metodo all'interno della classe relativa ad esso trovata in precedenza
                 
                 k = entryRealCl.getNestingLevel() + 1;
                 //System.out.println("N Real Cl: " + k + " clName: " + clName + " -> " + $i.text + " " + $i.line);
                 while (k>=0 && entryM==null){
                  entryM=(symTable.get(k--)).get($cmid.text);
                  //System.out.println("Found 1 ciclo:" +$i.text+" at line "+$i.line + " j="+j + "     nl: " + nestingLevel);
                  //found=true;
                 }
                 if (entryM==null){
                  System.out.println("Method Call "+$cmid.text+" at line "+$cmid.line+" not declared");
                    System.exit(0); 
                 }
                 
                 /*                
                 STentry entryCl=(symTable.get(k)).get(clName);
                 if(entryCl == null){
                  ArrayList<String> clh = FOOLlib.getClassHierarchy(clName);
                  for(int p = 0; p < clh.size(); p++){
                    int f=nestingLevel;
                    //System.out.println("Cur Class: " + clh.get(p));
                    if(FOOLlib.getMethodTuple($cmid.text, clh.get(p)) != null) {
                    while (f>=0 && entryCl==null){
                       entryCl=(symTable.get(f--)).get(clh.get(p));
                       //System.out.println("Found :" +f);
                       //found=true;
                    }
                    break;
                  }
                  }
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
        $ast=new CallMethodNode($cmid.text, entryM, entryRealCl, mArgList, $i.text);
     }
     
     */
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

