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
	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
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
    
declist	returns [ArrayList<Node> astlist]
	: {
	    $astlist= new ArrayList<Node>() ;
	    int offset=-2;
	  }
    (
       VAR i=ID COLON t=type ASS e=exp SEMIC
       {
          VarNode v = new VarNode($i.text,$t.ast,$e.ast);
          $astlist.add(v);
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
	           f.addPar(fpar);
	           if ( hmn.put($fid.text,new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ){
	              System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
	              System.exit(0);
	           }
           }
           (
             COMMA id=ID COLON ty=type
             {
	             parTypes.add($ty.ast); 
	             ParNode par = new ParNode($id.text,$ty.ast);
	             f.addPar(par);
	             if ( hmn.put($id.text,new STentry(nestingLevel,$ty.ast,paroffset++)) != null  ){
	                System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
	                System.exit(0);
	             }
             }
           )*
         )? 
         RPAR { entry.addType( new ArrowTypeNode(parTypes, $t.ast) ); } 
         ( LET d=declist IN {f.addDec($d.astlist);} )? e=exp
         {//chiudere scope
	          symTable.remove(nestingLevel--);
	          f.addBody($e.ast);
         } SEMIC
     )+
	;

type	returns [Node ast]
  :       b=basic | ARROW {$ast=new ArrowTypeNode();}
  ;

basic returns [Node ast]
  :       INT  {$ast=new IntTypeNode();}
        | BOOL {$ast=new BoolTypeNode();} 
        | ID {$ast=new IdNode();}
	;	

/*type: basic | arrow;
basic: INT | BOOL | ID ;*/
arrow returns [ArrowTypeNode ast]: 
LPAR (type(COMMA type)*)? RPAR ARROW basic;
	 
exp	returns [Node ast]
 	: f=term {$ast= $f.ast;}
 	    (
 	    PLUS l=term {$ast= new PlusNode ($ast,$l.ast);}
 	    MINUS l=term {$ast= new MinusNode ($ast,$l.ast);}
 	    OR l=term {$ast= new OrNode ($ast,$l.ast);}
 	    )*
 	;
 	
term returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    (
	    MULT l=factor {$ast= new MultNode ($ast,$l.ast);}
	    DIV l=factor {$ast= new DivNode ($ast,$l.ast);}
	    AND l=factor {$ast= new AndNode ($ast,$l.ast);}
	    )*
	;

value	returns [Node ast]
	: i=INTEGER {$ast= new NatNode(Integer.parseInt($i.text));}  
	| TRUE 
    {$ast= new BoolNode(true);}  
  | FALSE
    {$ast= new BoolNode(false);} 
  | NULL {$ast = new NullNode(null);}     
  //| NEW ID LPAR (expr (COMMA expr)* )? RPAR         
  | IF x=exp THEN CLPAR y=exp CRPAR 
       ELSE CLPAR z=exp CRPAR 
    {$ast= new IfNode($x.ast,$y.ast,$z.ast);}   
  | NOT LPAR  x=exp RPAR  
  {$ast = new NotNode($x.ast);}
    
  | PRINT LPAR e=exp RPAR 
    {$ast= new PrintNode($e.ast);}
        
  |  i=ID 
    {//cercare la dichiarazione
    int j=nestingLevel;
    STentry entry=null; 
    while (j>=0 && entry==null)
      entry=(symTable.get(j--)).get($i.text);
    if (entry==null)
      {System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
       System.exit(0);}               
    $ast= new IdNode($i.text,entry,nestingLevel);}  
    ( LPAR {ArrayList<Node> argList = new ArrayList<Node>();} 
      (fa=exp {argList.add($fa.ast);}
        (COMMA a=exp {argList.add($a.ast);})* 
      )?       
      RPAR {$ast=new CallNode($i.text,entry,argList,nestingLevel);}
    )?  
   // |  DOT ID LPAR (expr (COMMA expr)* )? RPAR )?    
 	;	 

factor returns [Node ast]
       : f = value {$ast = $f.ast;}
      ( EQ  l=value {$ast = new EqualNode($ast,$l.ast);}
      | GR l=value {$ast = new GreaterOrEqualNode($ast,$l.ast);}
      | LE l=value {$ast = new LessOrEqualNode($ast,$l.ast);}
    )*
  ; 

/*


arrow: LPAR (type(COMMA type)*)? RPAR ARROW basic;
*/
 	
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
    
value : 
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
               
type    :  basic | arrow 
        ;

basic   : INT               
        | BOOL              
  | ID                        
  ;  
    
arrow   : LPAR (type (COMMA type)* )? RPAR ARROW basic 
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

