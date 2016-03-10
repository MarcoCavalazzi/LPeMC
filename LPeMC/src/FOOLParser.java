// $ANTLR 3.5.2 C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g 2016-03-10 18:39:13

	import java.util.ArrayList;
	import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARROW", "ASS", "BOOL", 
		"CLASS", "CLPAR", "COLON", "COMMA", "CRPAR", "DIV", "DOT", "ELSE", "EQ", 
		"ERR", "EXTENDS", "FALSE", "FUN", "GR", "ID", "IF", "IN", "INT", "INTEGER", 
		"LE", "LET", "LPAR", "MINUS", "MULT", "NEW", "NOT", "NULL", "OR", "PLUS", 
		"PRINT", "RPAR", "SEMIC", "THEN", "TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOL=7;
	public static final int CLASS=8;
	public static final int CLPAR=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int CRPAR=12;
	public static final int DIV=13;
	public static final int DOT=14;
	public static final int ELSE=15;
	public static final int EQ=16;
	public static final int ERR=17;
	public static final int EXTENDS=18;
	public static final int FALSE=19;
	public static final int FUN=20;
	public static final int GR=21;
	public static final int ID=22;
	public static final int IF=23;
	public static final int IN=24;
	public static final int INT=25;
	public static final int INTEGER=26;
	public static final int LE=27;
	public static final int LET=28;
	public static final int LPAR=29;
	public static final int MINUS=30;
	public static final int MULT=31;
	public static final int NEW=32;
	public static final int NOT=33;
	public static final int NULL=34;
	public static final int OR=35;
	public static final int PLUS=36;
	public static final int PRINT=37;
	public static final int RPAR=38;
	public static final int SEMIC=39;
	public static final int THEN=40;
	public static final int TRUE=41;
	public static final int VAR=42;
	public static final int WHITESP=43;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FOOLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FOOLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g"; }


		private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno ï¿½ 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle ï¿½ symTable.get(nestingLevel)



	// $ANTLR start "prog"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:23:1: prog returns [Node ast] : (e= exp SEMIC | LET d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:24:3: (e= exp SEMIC | LET d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==INTEGER||LA1_0==LPAR||(LA1_0 >= NOT && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
				alt1=1;
			}
			else if ( (LA1_0==LET) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:24:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog42);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog44); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:25:11: LET d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog58); 

					              nestingLevel++;
					              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					              symTable.add(hm);
					            
					pushFollow(FOLLOW_declist_in_prog88);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog90); 
					pushFollow(FOLLOW_exp_in_prog94);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog96); 

					              symTable.remove(nestingLevel--);
					              ast = new LetInNode(d,e) ;
					            
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "declist"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:195:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token i=null;
		Token fid=null;
		Token id=null;
		Node t =null;
		Node e =null;
		Node fty =null;
		Node ty =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:196:2: ( ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:196:4: ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{

				    astlist = new ArrayList<Node>() ;
				    int offset=-2;
				  
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:200:5: ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==FUN||LA6_0==VAR) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:201:6: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:201:6: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==VAR) ) {
						alt5=1;
					}
					else if ( (LA5_0==FUN) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:202:8: VAR i= ID COLON t= type ASS e= exp SEMIC
							{
							match(input,VAR,FOLLOW_VAR_in_declist171); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist175); 
							match(input,COLON,FOLLOW_COLON_in_declist177); 
							pushFollow(FOLLOW_type_in_declist181);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist183); 
							pushFollow(FOLLOW_exp_in_declist187);
							e=exp();
							state._fsp--;

							match(input,SEMIC,FOLLOW_SEMIC_in_declist189); 

							          VarNode v = new VarNode((i!=null?i.getText():null),t,e);
							          astlist.add(v);
							          if(t instanceof ArrowTypeNode)
							            {
							                offset-=2;
							            }
							          
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);
							          
							          if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  ){
							            System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							            System.exit(0);
							          }
							       
							}
							break;
						case 2 :
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:219:8: FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist216); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist220); 
							match(input,COLON,FOLLOW_COLON_in_declist222); 
							pushFollow(FOLLOW_basic_in_declist226);
							t=basic();
							state._fsp--;

							  
							          //inserimento di ID nella symtable
							         FunNode f = new FunNode((i!=null?i.getText():null),t);
							         astlist.add(f);
							         HashMap<String,STentry> hm = symTable.get(nestingLevel);
							         STentry entry = new STentry(nestingLevel,offset--);
							         //STentry entry = new STentry(nestingLevel,f,offset-=2);
							         if ( hm.put((i!=null?i.getText():null),entry) != null ){
							            System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							            System.exit(0);
							         }
							         //creare una nuova hashmap per la symTable
							         nestingLevel++;
							         HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							         symTable.add(hmn);
							       
							match(input,LPAR,FOLLOW_LPAR_in_declist244); 
							 ArrayList<Node> parTypes = new ArrayList<Node>(); int paroffset=1; 
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:237:8: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==ID) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:238:10: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist269); 
									match(input,COLON,FOLLOW_COLON_in_declist271); 
									pushFollow(FOLLOW_type_in_declist275);
									fty=type();
									state._fsp--;


										          parTypes.add(fty); 
										          ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
										          
										          if(fty instanceof ArrowTypeNode)
									            {
									              paroffset+=2;
									              System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" è di tipo funzionale");
									            } 
										          
										          f.addPar(fpar);
										                             
										          if ( hmn.put((fid!=null?fid.getText():null),new STentry(fpar,nestingLevel,fty,paroffset++)) != null  ){
										             System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
										             System.exit(0);
										          }
									         
									// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:256:10: ( COMMA id= ID COLON ty= type )*
									loop2:
									while (true) {
										int alt2=2;
										int LA2_0 = input.LA(1);
										if ( (LA2_0==COMMA) ) {
											alt2=1;
										}

										switch (alt2) {
										case 1 :
											// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:257:12: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist310); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist314); 
											match(input,COLON,FOLLOW_COLON_in_declist316); 
											pushFollow(FOLLOW_type_in_declist320);
											ty=type();
											state._fsp--;


													           parTypes.add(ty); 
													           ParNode par = new ParNode((id!=null?id.getText():null),ty);
													          if(fty instanceof ArrowTypeNode)
													            {
													              paroffset+=2;
													              System.out.println("Parameter id "+(id!=null?id.getText():null)+" è di tipo funzionale:");
											                } 
													           f.addPar(par);
													           if ( hmn.put((id!=null?id.getText():null),new STentry(par,nestingLevel,ty,paroffset++)) != null  ){
													              System.out.println("Parameter id "+(id!=null?id.getText():null)+" at line "+(id!=null?id.getLine():0)+" already declared");
													              System.exit(0);
													           }
												          
											}
											break;

										default :
											break loop2;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist365); 
							 entry.addType( new ArrowTypeNode(parTypes, t) ); 
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:275:8: ( LET d= declist IN )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==LET) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:275:10: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist379); 
									pushFollow(FOLLOW_declist_in_declist383);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist385); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist410);
							e=exp();
							state._fsp--;

							//chiudere scope
							          symTable.remove(nestingLevel--);
							          f.addDecBody(d, e);//abbiamo cambiato add body con addDecBody (dichiarazione dei parametri ed espressione del corpo della funzione
							       
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist430); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astlist;
	}
	// $ANTLR end "declist"



	// $ANTLR start "type"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:286:1: type returns [Node ast] : (bas= basic |art= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node bas =null;
		Node art =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:287:9: (bas= basic |art= arrow )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BOOL||LA7_0==ID||LA7_0==INT) ) {
				alt7=1;
			}
			else if ( (LA7_0==LPAR) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:287:11: bas= basic
					{
					pushFollow(FOLLOW_basic_in_type463);
					bas=basic();
					state._fsp--;

					ast = bas;
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:288:11: art= arrow
					{
					pushFollow(FOLLOW_arrow_in_type479);
					art=arrow();
					state._fsp--;

					ast = art;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"



	// $ANTLR start "basic"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:291:1: basic returns [Node ast] : ( INT | BOOL | ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:292:3: ( INT | BOOL | ID )
			int alt8=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt8=1;
				}
				break;
			case BOOL:
				{
				alt8=2;
				}
				break;
			case ID:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:292:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic507); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:293:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic522); 
					ast =new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:294:11: ID
					{
					match(input,ID,FOLLOW_ID_in_basic537); 
					ast =new IdNode();
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "basic"



	// $ANTLR start "arrow"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:301:1: arrow returns [Node ast] : LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node funParT =null;
		Node funParTy =null;
		Node retTy =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:302:9: ( LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic )
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:302:11: LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow564); 

			            //creazione di una lista vuota per i parametri
			            ArrayList<Node> funParTypes = new ArrayList<Node>();
			          
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:307:11: (funParT= type ( COMMA funParTy= type )* )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==BOOL||LA10_0==ID||LA10_0==INT||LA10_0==LPAR) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:308:13: funParT= type ( COMMA funParTy= type )*
					{
					pushFollow(FOLLOW_type_in_arrow605);
					funParT=type();
					state._fsp--;


					              funParTypes.add(funParT);
					            
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:312:13: ( COMMA funParTy= type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==COMMA) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:312:14: COMMA funParTy= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow635); 
							pushFollow(FOLLOW_type_in_arrow639);
							funParTy=type();
							state._fsp--;


							              funParTypes.add(funParTy);
							            
							}
							break;

						default :
							break loop9;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow671); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow673); 
			pushFollow(FOLLOW_basic_in_arrow677);
			retTy=basic();
			state._fsp--;


			           //creazione del nodo della funzione High Order
			           ast = new ArrowTypeNode(funParTypes,retTy);
			          
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "arrow"



	// $ANTLR start "exp"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:322:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:323:3: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:323:5: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp709);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:324:7: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop11:
			while (true) {
				int alt11=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt11=1;
					}
					break;
				case MINUS:
					{
					alt11=2;
					}
					break;
				case OR:
					{
					alt11=3;
					}
					break;
				}
				switch (alt11) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:325:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp728); 
					pushFollow(FOLLOW_term_in_exp732);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:326:10: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp746); 
					pushFollow(FOLLOW_term_in_exp750);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:327:10: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp763); 
					pushFollow(FOLLOW_term_in_exp767);
					l=term();
					state._fsp--;

					ast = new OrNode   (ast,l);
					}
					break;

				default :
					break loop11;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:331:1: term returns [Node ast] : f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:332:2: (f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* )
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:332:4: f= factor ( MULT l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term801);
			f=factor();
			state._fsp--;

			ast = f;
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:333:6: ( MULT l= factor | DIV l= factor | AND l= factor )*
			loop12:
			while (true) {
				int alt12=4;
				switch ( input.LA(1) ) {
				case MULT:
					{
					alt12=1;
					}
					break;
				case DIV:
					{
					alt12=2;
					}
					break;
				case AND:
					{
					alt12=3;
					}
					break;
				}
				switch (alt12) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:334:7: MULT l= factor
					{
					match(input,MULT,FOLLOW_MULT_in_term818); 
					pushFollow(FOLLOW_factor_in_term822);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:335:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term834); 
					pushFollow(FOLLOW_factor_in_term839);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:336:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term851); 
					pushFollow(FOLLOW_factor_in_term856);
					l=factor();
					state._fsp--;

					ast = new AndNode (ast,l);
					}
					break;

				default :
					break loop12;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "value"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:340:1: value returns [Node ast] : (i= INTEGER | TRUE | FALSE | NULL | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token i=null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e =null;
		Node fa =null;
		Node a =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:341:2: (i= INTEGER | TRUE | FALSE | NULL | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt16=9;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt16=1;
				}
				break;
			case TRUE:
				{
				alt16=2;
				}
				break;
			case FALSE:
				{
				alt16=3;
				}
				break;
			case NULL:
				{
				alt16=4;
				}
				break;
			case IF:
				{
				alt16=5;
				}
				break;
			case NOT:
				{
				alt16=6;
				}
				break;
			case PRINT:
				{
				alt16=7;
				}
				break;
			case LPAR:
				{
				alt16=8;
				}
				break;
			case ID:
				{
				alt16=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:341:4: i= INTEGER
					{
					i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value883); 
					ast = new NatNode(Integer.parseInt((i!=null?i.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:342:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value892); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:343:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value903); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:344:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value912); 
					ast = new NullNode();
					}
					break;
				case 5 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:401:5: IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value938); 
					match(input,LPAR,FOLLOW_LPAR_in_value940); 
					pushFollow(FOLLOW_exp_in_value944);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value946); 
					match(input,THEN,FOLLOW_THEN_in_value948); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value950); 
					pushFollow(FOLLOW_exp_in_value954);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value956); 
					match(input,ELSE,FOLLOW_ELSE_in_value966); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value968); 
					pushFollow(FOLLOW_exp_in_value972);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value974); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 6 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:404:5: NOT LPAR x= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value990); 
					match(input,LPAR,FOLLOW_LPAR_in_value992); 
					pushFollow(FOLLOW_exp_in_value997);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value999); 
					ast = new NotNode(x);
					}
					break;
				case 7 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:405:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1008); 
					match(input,LPAR,FOLLOW_LPAR_in_value1010); 
					pushFollow(FOLLOW_exp_in_value1014);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1016); 
					ast = new PrintNode(e);
					}
					break;
				case 8 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:406:5: LPAR exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1024); 
					pushFollow(FOLLOW_exp_in_value1026);
					exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1028); 
					}
					break;
				case 9 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:407:6: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1038); 
					//cercare la dichiarazione
						    int j=nestingLevel;
						    STentry entry=null; 
						    while (j>=0 && entry==null)
						      entry=(symTable.get(j--)).get((i!=null?i.getText():null));
						    if (entry==null){
						       System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
						       System.exit(0);
						    } 	                  
						    ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
						    
						    //inizia la parte OO
						    /*
						    String classInputName = "";
					                 if(entry != null){
					                   if(entry.getDecl() instanceof ParNode){
					                if( ((ParNode)entry.getDecl()).isParClass()){
					                    //System.out.println("SETTING " + (i!=null?i.getText():null) + " PARNODE " + initJ);
					                classInputName =((ParNode)entry.getDecl()).getClassName();
					                //System.out.println("CLASS OF PAR " + classInputName + " name " + className);
					            }
					             }
					                 }
					                 
					                 //System.out.println("PARSER ENTRY DECL " + entry.getDecl() + " -> "  +(i!=null?i.getText():null) + " OS " + entry.getOffset() + " CLNAME " + classInputName);
					                 //System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0) + "   - j: " +j + " - nl: " + nestingLevel);
					                 if (entry==null){
					                  System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
					                    // System.exit(0); 
					                 }    
					                 //ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel-(j+1), classInputName, classFieldName,className);
					                 //System.out.println("PARSER Id "+(i!=null?i.getText():null)+" ENTRY " + entry.getOffset());
					                 //System.out.println(outClass);
					                 ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel-(j+1), classInputName, outClass);
					                 //fine parte OO
					                 */
					                 
					    
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:446:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==LPAR) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:447:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1059); 
							 ArrayList<Node> argList = new ArrayList<Node>(); 
							// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:448:7: (fa= exp ( COMMA a= exp )* )?
							int alt14=2;
							int LA14_0 = input.LA(1);
							if ( (LA14_0==FALSE||(LA14_0 >= ID && LA14_0 <= IF)||LA14_0==INTEGER||LA14_0==LPAR||(LA14_0 >= NOT && LA14_0 <= NULL)||LA14_0==PRINT||LA14_0==TRUE) ) {
								alt14=1;
							}
							switch (alt14) {
								case 1 :
									// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:448:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1073);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:449:9: ( COMMA a= exp )*
									loop13:
									while (true) {
										int alt13=2;
										int LA13_0 = input.LA(1);
										if ( (LA13_0==COMMA) ) {
											alt13=1;
										}

										switch (alt13) {
										case 1 :
											// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:449:10: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1086); 
											pushFollow(FOLLOW_exp_in_value1090);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop13;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1114); 

							        ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel-(j+1));
							      
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"



	// $ANTLR start "factor"
	// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:532:1: factor returns [Node ast] : f= value ( EQ l= value | GR l= value | LE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:533:5: (f= value ( EQ l= value | GR l= value | LE l= value )* )
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:533:7: f= value ( EQ l= value | GR l= value | LE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1199);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:534:5: ( EQ l= value | GR l= value | LE l= value )*
			loop17:
			while (true) {
				int alt17=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt17=1;
					}
					break;
				case GR:
					{
					alt17=2;
					}
					break;
				case LE:
					{
					alt17=3;
					}
					break;
				}
				switch (alt17) {
				case 1 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:535:9: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1217); 
					pushFollow(FOLLOW_value_in_factor1221);
					l=value();
					state._fsp--;

					ast = new EqualNode(ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:536:9: GR l= value
					{
					match(input,GR,FOLLOW_GR_in_factor1233); 
					pushFollow(FOLLOW_value_in_factor1237);
					l=value();
					state._fsp--;

					ast = new GreaterOrEqualNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\GG\\git\\LPeMC\\LPeMC\\FOOL.g:537:9: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1250); 
					pushFollow(FOLLOW_value_in_factor1254);
					l=value();
					state._fsp--;

					ast = new LessOrEqualNode(ast,l);
					}
					break;

				default :
					break loop17;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog42 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog58 = new BitSet(new long[]{0x0000040000100000L});
	public static final BitSet FOLLOW_declist_in_prog88 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_prog90 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_prog94 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist171 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist175 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist177 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist181 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist183 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_declist187 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist189 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist216 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist220 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist222 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_declist226 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist244 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_declist269 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist271 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist275 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist310 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist314 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist316 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist320 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist365 = new BitSet(new long[]{0x0000022634C80000L});
	public static final BitSet FOLLOW_LET_in_declist379 = new BitSet(new long[]{0x0000040000100000L});
	public static final BitSet FOLLOW_declist_in_declist383 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_declist385 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_declist410 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist430 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_basic_in_type463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow564 = new BitSet(new long[]{0x0000004022400080L});
	public static final BitSet FOLLOW_type_in_arrow605 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow635 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_arrow639 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow671 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow673 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_arrow677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp709 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp728 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_term_in_exp732 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp746 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_term_in_exp750 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp763 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_term_in_exp767 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term801 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_MULT_in_term818 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_factor_in_term822 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_DIV_in_term834 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_factor_in_term839 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_AND_in_term851 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_factor_in_term856 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_INTEGER_in_value883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value938 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value940 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value944 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value946 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value948 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value950 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value954 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value956 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_value966 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value968 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value972 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value990 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value992 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value997 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1008 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1010 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value1014 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1016 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1024 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value1026 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1038 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_LPAR_in_value1059 = new BitSet(new long[]{0x0000026624C80000L});
	public static final BitSet FOLLOW_exp_in_value1073 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1086 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_exp_in_value1090 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1199 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_EQ_in_factor1217 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_value_in_factor1221 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_GR_in_factor1233 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_value_in_factor1237 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_LE_in_factor1250 = new BitSet(new long[]{0x0000022624C80000L});
	public static final BitSet FOLLOW_value_in_factor1254 = new BitSet(new long[]{0x0000000008210002L});
}
