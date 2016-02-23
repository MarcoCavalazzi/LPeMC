// $ANTLR 3.5.2 C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g 2015-12-11 15:21:40

import java.util.ArrayList;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASS", "BOOL", "CLPAR", "COLON", 
		"COMMA", "COMMENT", "CRPAR", "ELSE", "EQ", "ERR", "FALSE", "FUN", "ID", 
		"IF", "IN", "INT", "LET", "LPAR", "NAT", "PLUS", "PRINT", "RPAR", "SEMIC", 
		"THEN", "TIMES", "TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ASS=4;
	public static final int BOOL=5;
	public static final int CLPAR=6;
	public static final int COLON=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int CRPAR=10;
	public static final int ELSE=11;
	public static final int EQ=12;
	public static final int ERR=13;
	public static final int FALSE=14;
	public static final int FUN=15;
	public static final int ID=16;
	public static final int IF=17;
	public static final int IN=18;
	public static final int INT=19;
	public static final int LET=20;
	public static final int LPAR=21;
	public static final int NAT=22;
	public static final int PLUS=23;
	public static final int PRINT=24;
	public static final int RPAR=25;
	public static final int SEMIC=26;
	public static final int THEN=27;
	public static final int TIMES=28;
	public static final int TRUE=29;
	public static final int VAR=30;
	public static final int WHITESP=31;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g"; }


	private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
	private int nestingLevel = -1;
	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
	


	// $ANTLR start "prog"
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:23:1: prog returns [Node ast] : (e= exp SEMIC | LET d= dec IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:24:2: (e= exp SEMIC | LET d= dec IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||(LA1_0 >= LPAR && LA1_0 <= NAT)||LA1_0==PRINT||LA1_0==TRUE) ) {
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
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:24:10: e= exp SEMIC
					{
						pushFollow(FOLLOW_exp_in_prog47);
						e=exp();
						state._fsp--;
	
						match(input,SEMIC,FOLLOW_SEMIC_in_prog49); 
						ast = new ProgNode(e);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:26:11: LET d= dec IN e= exp SEMIC
					{
						match(input,LET,FOLLOW_LET_in_prog76); 
						nestingLevel++;
						HashMap<String,STentry> hm = new HashMap<String,STentry> ();
						symTable.add(hm); // Mettiamo la nuova hashmap nel fronte della tabella
						            
						pushFollow(FOLLOW_dec_in_prog105);
						d=dec();
						state._fsp--;
	
						match(input,IN,FOLLOW_IN_in_prog107); 
						pushFollow(FOLLOW_exp_in_prog111);
						e=exp();
						state._fsp--;
	
						match(input,SEMIC,FOLLOW_SEMIC_in_prog113); 
						symTable.remove(nestingLevel--); // tolgo quel livello dalla tabella e decremento il nesting level.
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



	// $ANTLR start "dec"
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:36:1: dec returns [ArrayList<Node> astlist] : ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp SEMIC )+ ;
	public final ArrayList<Node> dec() throws RecognitionException {
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
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:37:2: ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp SEMIC )+ )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:37:4: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp SEMIC )+
			{
			astlist = new ArrayList<Node>() ;
				   int offset=-2;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:39:10: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp SEMIC )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==VAR) ) {
					alt5=1;
				}
				else if ( (LA5_0==FUN) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:40:13: VAR i= ID COLON t= type ASS e= exp SEMIC
					{
						match(input,VAR,FOLLOW_VAR_in_dec169); 
						i=(Token)match(input,ID,FOLLOW_ID_in_dec173); 
						match(input,COLON,FOLLOW_COLON_in_dec175); 
						pushFollow(FOLLOW_type_in_dec179);
						t=type();
						state._fsp--;
	
						match(input,ASS,FOLLOW_ASS_in_dec181); 
						pushFollow(FOLLOW_exp_in_dec185);
						e=exp();
						state._fsp--;
	
						match(input,SEMIC,FOLLOW_SEMIC_in_dec187); 
						VarNode v = new VarNode((i!=null?i.getText():null),t,e);
						astlist.add(v);
						// Mettiamo prima di entrare nello scope con i suoi parametri il codice per modificare il nesting level.
						HashMap<String,STentry> hm = symTable.get(nestingLevel);
						// Controlliamo che non ci sia già. Se non c'è lo aggiungiamo.
				        if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  )
						{
				        	// Se la put() ritorna 'null' vuol dire che prima non c'era nulla. Altrimenti ritorna l'elemento che c'era prima associato a quella stringa.
					        // Nell'ultimo caso dobbiamo dare un "errore di doppia dichiarazione".
					        System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
						    System.exit(0);
					    }
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:49:13: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp SEMIC
					{
						match(input,FUN,FOLLOW_FUN_in_dec232); 
						i=(Token)match(input,ID,FOLLOW_ID_in_dec236); 
						match(input,COLON,FOLLOW_COLON_in_dec238); 
						pushFollow(FOLLOW_type_in_dec242);
						t=type();
						state._fsp--;
	
						//inserimento di ID nella symtable
		                FunNode f = new FunNode((i!=null?i.getText():null),t);
		                astlist.add(f);  // passaggio per riferimento. I Java tutti i passaggi sono per riferimento (dice il prof.).
		                
		                // entriamo in un nuovo SCOPE prima delle dischiarazione dei parametri
		                // Mettiamo prima di entrare nello scope con i suoi parametri il codice per modificare il nesting level.
		                HashMap<String,STentry> hm = symTable.get(nestingLevel);
		                STentry entry = new STentry(nestingLevel,offset--);
		                // Controlliamo che non ci sia già. Se non c'è lo aggiungiamo.
		                if ( hm.put((i!=null?i.getText():null),entry) != null )
		                {
		                	// Se la put() ritorna 'null' vuol dire che prima non c'era nulla. Altrimenti ritorna l'elemento che c'era prima associato a quella stringa.
							// Nell'ultimo caso dobbiamo dare un "errore di doppia dichiarazione".
							System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
		                	System.exit(0);
		                }
		                
		                //creare una nuova hashmap per la symTable
		                nestingLevel++;
		                HashMap<String,STentry> hmn = new HashMap<String,STentry> ();  // "Hash Map new", giusto per differenziarla dall'altra.
		                symTable.add(hmn); // Mettiamo la nuova hashmap nel fronte della tabella
		              
						match(input,LPAR,FOLLOW_LPAR_in_dec274); 
						ArrayList<Node> parTypes = new ArrayList<Node>();
						                    int paroffset=1;
						// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:65:17: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==ID) ) {
							alt3=1;
						}
						switch (alt3) {
							case 1 :
								// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:65:18: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
								{
									fid=(Token)match(input,ID,FOLLOW_ID_in_dec298); 
									match(input,COLON,FOLLOW_COLON_in_dec300); 
									pushFollow(FOLLOW_type_in_dec304);
									fty=type();
									state._fsp--;
		
									// creo il ParNode 
							        // lo attacco al FunNode invocando addPar
							        // aggiungo una STentry alla hashmap hmn
									parTypes.add(fty); 
									ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
									f.addPar(fpar);
									if ( hmn.put((fid!=null?fid.getText():null),new STentry(nestingLevel,fty,paroffset++)) != null  )
				                    {
										System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
										System.exit(0);
									}
									                  
									// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:74:19: ( COMMA id= ID COLON ty= type )*
									loop2:
									while (true) {
										int alt2=2;
										int LA2_0 = input.LA(1);
										if ( (LA2_0==COMMA) ) {
											alt2=1;
										}
		
										switch (alt2) {
											case 1 :
												// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:74:20: COMMA id= ID COLON ty= type
												{
													match(input,COMMA,FOLLOW_COMMA_in_dec345); 
													id=(Token)match(input,ID,FOLLOW_ID_in_dec349); 
													match(input,COLON,FOLLOW_COLON_in_dec351); 
													pushFollow(FOLLOW_type_in_dec355);
													ty=type();
													state._fsp--;
				
													// creo il ParNode 
											        // lo attacco al FunNode invocando addPar
											        // aggiungo una STentry alla hashmap hmn
									          
								                    parTypes.add(ty); 
								                    ParNode par = new ParNode((id!=null?id.getText():null),ty);
								                    f.addPar(par);
								                    if ( hmn.put((id!=null?id.getText():null),new STentry(nestingLevel,ty,paroffset++)) != null  )
								                    {
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
	
						match(input,RPAR,FOLLOW_RPAR_in_dec434); 
						entry.addType( new ArrowTypeNode(parTypes, t) );
						// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:86:15: ( LET d= dec IN )?
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==LET) ) {
							alt4=1;
						}
						switch (alt4) {
							case 1 :
								// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:86:16: LET d= dec IN
								{
								match(input,LET,FOLLOW_LET_in_dec454); 
								pushFollow(FOLLOW_dec_in_dec458);
								d=dec();
								state._fsp--;
	
								match(input,IN,FOLLOW_IN_in_dec460); 
								f.addDec(d);
								}
								break;
	
						}
	
						pushFollow(FOLLOW_exp_in_dec468);
						e=exp();
						state._fsp--;
	
						//chiudere scope
			            symTable.remove(nestingLevel--); // tolgo quel livello dalla tabella e decremento il nesting level.
			            f.addBody(e);
						              
						match(input,SEMIC,FOLLOW_SEMIC_in_dec486); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
	// $ANTLR end "dec"



	// $ANTLR start "type"
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:94:1: type returns [Node ast] : ( INT | BOOL );
	public final Node type() throws RecognitionException {
		Node ast = null;


		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:95:3: ( INT | BOOL )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==INT) ) {
				alt6=1;
			}
			else if ( (LA6_0==BOOL) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:95:11: INT
					{
					match(input,INT,FOLLOW_INT_in_type522); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:96:11: BOOL
					{
						match(input,BOOL,FOLLOW_BOOL_in_type537); 
						ast = new BoolTypeNode();
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



	// $ANTLR start "exp"
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:99:1: exp returns [Node ast] : f= term ( PLUS l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:100:3: (f= term ( PLUS l= term )* )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:100:5: f= term ( PLUS l= term )*
			{
			pushFollow(FOLLOW_term_in_exp561);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:101:7: ( PLUS l= term )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==PLUS) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:101:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp572); 
					pushFollow(FOLLOW_term_in_exp576);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;

				default :
					break loop7;
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
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:106:1: term returns [Node ast] : f= value ( TIMES l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:107:2: (f= value ( TIMES l= value )* )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:107:4: f= value ( TIMES l= value )*
			{
			pushFollow(FOLLOW_value_in_term615);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:108:6: ( TIMES l= value )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TIMES) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:108:7: TIMES l= value
					{
					match(input,TIMES,FOLLOW_TIMES_in_term625); 
					pushFollow(FOLLOW_value_in_term629);
					l=value();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;

				default :
					break loop8;
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
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:113:1: value returns [Node ast] : f= fatt ( EQ l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:114:2: (f= fatt ( EQ l= fatt )* )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:114:4: f= fatt ( EQ l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value664);
			f=fatt();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:115:6: ( EQ l= fatt )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==EQ) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:115:7: EQ l= fatt
					{
					match(input,EQ,FOLLOW_EQ_in_value674); 
					pushFollow(FOLLOW_fatt_in_value678);
					l=fatt();
					state._fsp--;

					ast = new EqualNode (ast,l);
					}
					break;

				default :
					break loop9;
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
	// $ANTLR end "value"



	// $ANTLR start "fatt"
	// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:120:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
	public final Node fatt() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node fa =null;
		Node a =null;

		try {
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:121:2: (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt13=7;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt13=1;
				}
				break;
			case TRUE:
				{
				alt13=2;
				}
				break;
			case FALSE:
				{
				alt13=3;
				}
				break;
			case LPAR:
				{
				alt13=4;
				}
				break;
			case IF:
				{
				alt13=5;
				}
				break;
			case PRINT:
				{
				alt13=6;
				}
				break;
			case ID:
				{
				alt13=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:121:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt719); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:123:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt734); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:125:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt747); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:127:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt759); 
					pushFollow(FOLLOW_exp_in_fatt763);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt765); 
					ast = e;
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:129:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt777); 
					pushFollow(FOLLOW_exp_in_fatt781);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt783); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt785); 
					pushFollow(FOLLOW_exp_in_fatt789);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt791); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt799); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt801); 
					pushFollow(FOLLOW_exp_in_fatt805);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt807); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:132:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt820); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt822); 
					pushFollow(FOLLOW_exp_in_fatt826);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt828); 
					ast = new PrintNode(e);
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:134:4: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt841); 
					//cercare la dichiarazione
					    int j=nestingLevel; // nestingLevel è il fronte. poi scendiamo fintanto che j è >=0, finché non troviamo quello che cerchiamo
					    STentry entry=null;  // Se all'uscita dal ciclo è ancora null non abbiamo trovato.
					    while (j>=0 && entry==null){
					    	// Vediamo se a questa iterazione c'è qualcosa associato a questo (i!=null?i.getText():null)
					    	entry=(symTable.get(j--)).get((i!=null?i.getText():null));
					    }
					    // Se entry è ancora uguale a null allora abbiamousato una var ancora non dichiarata.
					    if (entry==null)
					    {
					    	System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
					        System.exit(0);
					    }
					    
					    // Troviamo in base all'identificatore
						ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:144:4: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==LPAR) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:144:6: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt856); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:145:6: (fa= exp ( COMMA a= exp )* )?
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( (LA11_0==FALSE||(LA11_0 >= ID && LA11_0 <= IF)||(LA11_0 >= LPAR && LA11_0 <= NAT)||LA11_0==PRINT||LA11_0==TRUE) ) {
								alt11=1;
							}
							switch (alt11) {
								case 1 :
									// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:145:7: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt869);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:146:8: ( COMMA a= exp )*
									loop10:
									while (true) {
										int alt10=2;
										int LA10_0 = input.LA(1);
										if ( (LA10_0==COMMA) ) {
											alt10=1;
										}

										switch (alt10) {
										case 1 :
											// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:146:9: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt881); 
											pushFollow(FOLLOW_exp_in_fatt885);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop10;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt911); 
							ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
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
	// $ANTLR end "fatt"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog47 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog76 = new BitSet(new long[]{0x0000000040008000L});
	public static final BitSet FOLLOW_dec_in_prog105 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_IN_in_prog107 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_prog111 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_dec169 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec173 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec175 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec179 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASS_in_dec181 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_dec185 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_dec187 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_FUN_in_dec232 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec236 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec238 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec242 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_dec274 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_ID_in_dec298 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec300 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec304 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_COMMA_in_dec345 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec349 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec351 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec355 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_RPAR_in_dec434 = new BitSet(new long[]{0x0000000021734000L});
	public static final BitSet FOLLOW_LET_in_dec454 = new BitSet(new long[]{0x0000000040008000L});
	public static final BitSet FOLLOW_dec_in_dec458 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_IN_in_dec460 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_dec468 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_dec486 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_INT_in_type522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp561 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_PLUS_in_exp572 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_term_in_exp576 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_value_in_term615 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_TIMES_in_term625 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_value_in_term629 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_fatt_in_value664 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_EQ_in_value674 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_fatt_in_value678 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_NAT_in_fatt719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt759 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt763 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt777 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt781 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_THEN_in_fatt783 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLPAR_in_fatt785 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt789 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_fatt791 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ELSE_in_fatt799 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLPAR_in_fatt801 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt805 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_fatt807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt820 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_fatt822 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt826 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt841 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_LPAR_in_fatt856 = new BitSet(new long[]{0x0000000023634000L});
	public static final BitSet FOLLOW_exp_in_fatt869 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_COMMA_in_fatt881 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_fatt885 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_RPAR_in_fatt911 = new BitSet(new long[]{0x0000000000000002L});
}
