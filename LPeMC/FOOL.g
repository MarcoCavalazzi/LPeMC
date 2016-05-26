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
	private int nestingLevel = -1;
	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle symTable.get(nestingLevel)
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
         System.out.println("La STentry di class "+$cid.text+" ha nl = "+nestingLevel);   
         STentry entryCl = new STentry(Obj,nestingLevel);
         nestingLevel++;
         ctentry = new CTentry(Obj,nestingLevel);
         entryCl.setClassName($cid.text);
         
         STentry tmp  = hm.put($cid.text,entryCl);
         CTentry tmp2 = classTable.put($cid.text,ctentry);
         
         if (tmp != null && tmp2 != null)
         {
            System.out.println("Class id "+$cid.text+" at line "+$cid.line+" already declared");
            System.exit(0); 
         }                
         
         HashMap<String,STentry> classLevelSymTable =  new HashMap<String,STentry>(); 
         symTable.add(classLevelSymTable);        
         ctentry.setVirtualTable(classLevelSymTable);
      }
	    (EXTENDS cidext=ID
	    {
	     
           // HashMap<String,STentry> hmSuper = classTable.get(nestingClassLevel-1);           
           // verifico che la classe estesa sia già stata dichiarata in precedenza          
           extendedEntry = classTable.get($cidext.text);
         
                 
           if(extendedEntry == null){
           System.out.println("Class id "+$cidext.text+" at line "+$cidext.line+" not declared");
              System.exit(0);
           }
           
           
           ArrayList<Node> tmpField  = (ArrayList<Node>) extendedEntry.getFields().clone(); //necessario per non rischiare di copiare il riferimento all'oggetto
           ArrayList<Node> tmpMethod = (ArrayList<Node>) extendedEntry.getMethods().clone();
           ctentry.setFields(tmpField);
           ctentry.setMethods(tmpMethod);
           HashMap<String,STentry> tmpMap = (HashMap<String, STentry>) extendedEntry.getVirtualTable().clone();
           //ctentry.setVirtualTable(tmpMap);
           
  //         symTable.putAll(tmp);
//           HashMap<String,STentry> vTableExtendedEntry = extendedEntry.getVirtualTable();
//           HashMap<String,STentry> tempSymTable = symTable.get(nestingLevel);
//           vTableExtendedEntry.forEach( STentry s ){
//              tempSymTable.put(s);
//           }
           //ctentry.getVirtualTable().putAll(tempMap);
//           for(int i=0; i<tmpMap.size(); i++){
//              symTable.get(nestingLevel).put(tmpMap.get(i).getKey(), tmpMap.get(i).getValue());
////                ctentry.putvTable(tmpMap.get(i));
//           }
           symTable.get(nestingLevel).putAll(tmpMap);
           Obj.setSuperEntry(extendedEntry);
           Obj.setClassEntry(ctentry);
           FOOLlib.putSuperType($cid.text,$cidext.text);
           //nestingVirtualLevel = extendedEntry.getNestinglevel();
           //hmn = symTable.get(extendedEntry.getNestinglevel());
	     }
	     )? 
	     LPAR 
	     {
           ArrayList<Node> ConstrPar = new ArrayList<Node>();
           int fieldOffset=-1; 
       }
	     (p1=ID COLON t1=basic 
	     {
	       
	         ConstrPar.add($t1.ast);
           FieldNode objField = new FieldNode($p1.text,$t1.ast,$cid.text);
           Obj.addField(objField);
           ctentry.setFieldOffset(fieldOffset);
           STentry  tempEntry = new STentry(objField,nestingLevel,$t1.ast,fieldOffset);
           tempEntry.setClassName($cid.text);
           if(ctentry.putvTable($p1.text,tempEntry, extendedEntry) != null)//putvTable controlla anche se c'è overriding, in caso positivo sovrascrive
           {
              System.out.println("Parameter id "+$p1.text+" at line "+$p1.line+" already declared!");
              System.exit(0);
           }         
           ctentry.setFieldAndCheck(objField,$p1.text);//controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)
           fieldOffset--;
	     }
	     (COMMA pn=ID COLON tn=basic
	     {
	        ConstrPar.add($tn.ast);
          FieldNode objFieldN = new FieldNode($pn.text,$tn.ast,$cid.text);
          Obj.addField(objFieldN);
          ctentry.setFieldOffset(fieldOffset);
          STentry tmpSTentry = new STentry(objFieldN,nestingLevel,$tn.ast,fieldOffset);
          System.out.println("La entry "+$pn.text+" ha nl = "+nestingLevel);
          if ( ctentry.putvTable($pn.text,tmpSTentry,extendedEntry) != null  )
          {
             System.out.println("Parameter id "+$pn.text+" at line "+$pn.line+" already declared");
             System.exit(0); 
          }         
          ctentry.setFieldAndCheck(objFieldN,$pn.text);
          fieldOffset--;
	     }
	     )* )? RPAR
	     {
	        ctentry.addType( new ArrowTypeNode(ConstrPar, Obj) ); 
	        
	     }
	     CLPAR//apri graffa
	       (FUN mid=ID COLON retm=basic
	       { 
             MethodNode mNode = new MethodNode($mid.text,$retm.ast); 
                      
             //$astlist.add(f);//giusto o da commentare???
             
             STentry entry = new STentry(mNode,nestingLevel,$retm.ast,methodOffset);
             entry.setClassName($cid.text);
             entry.setIsMethod();             
             if ( ctentry.putvTable($mid.text,entry,extendedEntry) != null  )
             {
                System.out.println("Method id "+$mid.text+" at line "+$mid.line+" already declared");
                System.exit(0); 
             }
             ctentry.setMethodOffset(methodOffset);  //            
             methodOffset++;
             ctentry.setMethodAndCheck(mNode,$mid.text);
             Obj.setMethod(mNode);

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
            
            mNode.addPar(fpar);
            STentry tmpEntryPar = new STentry(fpar,nestingLevel,$mpt1.ast,parOffset);             
            
            if ( ctentry.putvTable($mp1.text,tmpEntryPar,extendedEntry) != null  ){
             System.out.println("Parameter id "+$mp1.text+" at line "+$mp1.line+" already declared");
             System.exit(0);
             }
             
             parOffset++;
	          
            
	       }
	       (COMMA mpn=ID COLON mptn=type
	       {
	          parTypes.add($mptn.ast);
            ParNode par = new ParNode($mpn.text,$mptn.ast);
            mNode.addPar(par);
            System.out.println("La entry "+$mpn.text+" ha nl = "+nestingLevel);
            STentry stPar = new STentry(fpar,nestingLevel,$mptn.ast,parOffset);
            if (ctentry.putvTable($mpn.text,stPar,extendedEntry) != null ){
               System.out.println("Parameter id "+$mpn.text+" at line "+$mpn.line+" already declared");
               System.exit(0);
               }
               
            parOffset++;

	       })* )? RPAR
	       {
	          entry.addType( new ArrowTypeNode(parTypes , $retm.ast) );
            ArrayList<Node> letInMethodList = new ArrayList<Node>();       
            
            
	       }
	       (LET 
	       {
	           int innerOs = 0; 
	           nestingLevel++;
	       }
	       (VAR vid=ID COLON vt=type ASS ve=exp //se aggiungiamo var nel metodo, siamo in uno scope sintattico maggiore, per cui si crea una nuova hashmap, si aumenta il nestingLevel e poi si aggiunge a symTable
	       {
	          VarNode v = new VarNode($vid.text,$vt.ast,$ve.ast);
           // letInMethodList.add(v); 
            $astlist.add(v);
            HashMap<String,STentry> varhm =  new HashMap<String,STentry>(); 
            symTable.add(varhm);
            
            if ( varhm.put($vid.text,new STentry(v,nestingLevel,$vt.ast,innerOs++)) != null  )
            {
               System.out.println("Var id "+$vid.text+" at line "+$vid.line+" already declared");
               System.exit(0); 
            } 
                         
          }
	        SEMIC)* IN 
	        {
	          symTable.remove(nestingLevel--);
	        }
	        )? varE=exp //varExp
	        {
	            //chiudere scope                       
                         
              mNode.addBody($varE.ast);
              //aggiungo il metodo alla classe
              Obj.addMethod(mNode); 
              
	        }
	        SEMIC)* 
      CRPAR
      {
        symTable.remove(nestingLevel--);  
      }
      )*
      
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
          //System.out.println("Var id "+$i.text+" at line "+$i.line+" ha nesting = "+nestingLevel);
          STentry varEntry = new STentry(nestingLevel,$t.ast,offset--);
          if ( hm.put($i.text,varEntry) != null  ){
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
         int jj = nestingLevel;    
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
        // ctEntry.setNewOffset(newOffset);
         $ast = new NewNode($i.text,ctEntry,argList);
        // newOffset++;
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
         while (j>=0 && entry==null)
         entry=(symTable.get(j--)).get($i.text);
      }
      
	    if (entry == null && classEntry == null){
	       System.out.println("Id "+$i.text+" at line "+$i.line+" not declared!!");	       
	       System.exit(0);
	    }
	     	 
	    if( classEntry != null )	        
	        $ast = new IdNode($i.text,classEntry,nestingLevel);
	    else
	        $ast = new IdNode($i.text,entry,nestingLevel);
	    
                 
    }
    (
      LPAR { ArrayList<Node> argList = new ArrayList<Node>(); } 
      (fa=exp {argList.add($fa.ast);}
        (COMMA a=exp {argList.add($a.ast);})*
      )?
      {
      
        System.out.println("nl - (j+1) = "+(nestingLevel-(j+1))+" nl = "+nestingLevel+" j = "+j);
        if( classEntry != null) 
         $ast=new CallNode($i.text,entry,argList,nestingLevel-(j+1));
        else 
        $ast=new CallNode($i.text,entry,argList,nestingLevel-(j+1));//è esatto? quasi sicuramente no!
      }    
     RPAR
    |  DOT cmid=ID
    {
       
       STentry entryM = null;

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
        System.out.println("CCN: nl - (j+1) = "+(nestingLevel-(j+1))+" nl = "+nestingLevel+" j = "+j);
        $ast = new ClassCallNode($cmid.text, entry,entryM, mArgList, nestingLevel-(j+1));
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

