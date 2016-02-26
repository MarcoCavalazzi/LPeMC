// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g 2016-02-26 14:23:11

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g"; }


		private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle � symTable.get(nestingLevel)



	// $ANTLR start "prog"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:23:1: prog returns [Node ast] : (e= exp SEMIC | LET d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:24:3: (e= exp SEMIC | LET d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==INTEGER||(LA1_0 >= NOT && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:24:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog42);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog44); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:25:11: LET d= declist IN e= exp SEMIC
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



	// $ANTLR start "cllist"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:40:1: cllist returns [ArrayList<Node> astlist] : ( CLASS i= ID ( EXTENDS ID )? LPAR ( ID COLON basic ( COMMA ID COLON basic )* )? RPAR CLPAR ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token i=null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:41:4: ( ( CLASS i= ID ( EXTENDS ID )? LPAR ( ID COLON basic ( COMMA ID COLON basic )* )? RPAR CLPAR ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )* CRPAR )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:41:6: ( CLASS i= ID ( EXTENDS ID )? LPAR ( ID COLON basic ( COMMA ID COLON basic )* )? RPAR CLPAR ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )* CRPAR )*
			{

				     astlist = new ArrayList<Node>() ;
				     int offset=-2;
				   
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:5: ( CLASS i= ID ( EXTENDS ID )? LPAR ( ID COLON basic ( COMMA ID COLON basic )* )? RPAR CLPAR ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:6: CLASS i= ID ( EXTENDS ID )? LPAR ( ID COLON basic ( COMMA ID COLON basic )* )? RPAR CLPAR ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist140); 
					i=(Token)match(input,ID,FOLLOW_ID_in_cllist144); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:17: ( EXTENDS ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:18: EXTENDS ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist147); 
							match(input,ID,FOLLOW_ID_in_cllist149); 
							}
							break;

					}

					match(input,LPAR,FOLLOW_LPAR_in_cllist153); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:36: ( ID COLON basic ( COMMA ID COLON basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:37: ID COLON basic ( COMMA ID COLON basic )*
							{
							match(input,ID,FOLLOW_ID_in_cllist156); 
							match(input,COLON,FOLLOW_COLON_in_cllist158); 
							pushFollow(FOLLOW_basic_in_cllist160);
							basic();
							state._fsp--;

							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:52: ( COMMA ID COLON basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:53: COMMA ID COLON basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist163); 
									match(input,ID,FOLLOW_ID_in_cllist165); 
									match(input,COLON,FOLLOW_COLON_in_cllist167); 
									pushFollow(FOLLOW_basic_in_cllist169);
									basic();
									state._fsp--;

									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist176); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist184); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:9: ( FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:10: FUN ID COLON basic LPAR ( ID COLON type ( COMMA ID COLON type )* )? RPAR ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )? exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist195); 
							match(input,ID,FOLLOW_ID_in_cllist197); 
							match(input,COLON,FOLLOW_COLON_in_cllist199); 
							pushFollow(FOLLOW_basic_in_cllist201);
							basic();
							state._fsp--;

							match(input,LPAR,FOLLOW_LPAR_in_cllist203); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:34: ( ID COLON type ( COMMA ID COLON type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:35: ID COLON type ( COMMA ID COLON type )*
									{
									match(input,ID,FOLLOW_ID_in_cllist206); 
									match(input,COLON,FOLLOW_COLON_in_cllist208); 
									pushFollow(FOLLOW_type_in_cllist210);
									type();
									state._fsp--;

									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:49: ( COMMA ID COLON type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:50: COMMA ID COLON type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist213); 
											match(input,ID,FOLLOW_ID_in_cllist215); 
											match(input,COLON,FOLLOW_COLON_in_cllist217); 
											pushFollow(FOLLOW_type_in_cllist219);
											type();
											state._fsp--;

											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist226); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:48:9: ( LET ( VAR ID COLON basic ASS exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:48:10: LET ( VAR ID COLON basic ASS exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist237); 
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:48:14: ( VAR ID COLON basic ASS exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:48:15: VAR ID COLON basic ASS exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist240); 
											match(input,ID,FOLLOW_ID_in_cllist242); 
											match(input,COLON,FOLLOW_COLON_in_cllist244); 
											pushFollow(FOLLOW_basic_in_cllist246);
											basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist248); 
											pushFollow(FOLLOW_exp_in_cllist250);
											exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist252); 
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist256); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist261);
							exp();
							state._fsp--;

							match(input,SEMIC,FOLLOW_SEMIC_in_cllist263); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist274); 
					}
					break;

				default :
					break loop10;
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
		return astlist;
	}
	// $ANTLR end "cllist"



	// $ANTLR start "declist"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:52:1: declist returns [ArrayList<Node> astlist] : ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp SEMIC )+ ;
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:53:2: ( ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp SEMIC )+ )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:53:4: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp SEMIC )+
			{

				    astlist = new ArrayList<Node>() ;
				    int offset=-2;
				  
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:57:5: ( VAR i= ID COLON t= type ASS e= exp SEMIC | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp SEMIC )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=3;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==VAR) ) {
					alt14=1;
				}
				else if ( (LA14_0==FUN) ) {
					alt14=2;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:58:8: VAR i= ID COLON t= type ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist316); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist320); 
					match(input,COLON,FOLLOW_COLON_in_declist322); 
					pushFollow(FOLLOW_type_in_declist326);
					t=type();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist328); 
					pushFollow(FOLLOW_exp_in_declist332);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist334); 

					          VarNode v = new VarNode((i!=null?i.getText():null),t,e);
					          astlist.add(v);
					          HashMap<String,STentry> hm = symTable.get(nestingLevel);
					          if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  ){
					            System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
					            System.exit(0);
					          }
					       
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:69:8: FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist361); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist365); 
					match(input,COLON,FOLLOW_COLON_in_declist367); 
					pushFollow(FOLLOW_basic_in_declist371);
					t=basic();
					state._fsp--;

					  
					          //inserimento di ID nella symtable
					         FunNode f = new FunNode((i!=null?i.getText():null),t);
					         astlist.add(f);
					         HashMap<String,STentry> hm = symTable.get(nestingLevel);
					         STentry entry = new STentry(nestingLevel,offset--);
					         if ( hm.put((i!=null?i.getText():null),entry) != null ){
					            System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
					            System.exit(0);
					         }
					         //creare una nuova hashmap per la symTable
					         nestingLevel++;
					         HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
					         symTable.add(hmn);
					       
					match(input,LPAR,FOLLOW_LPAR_in_declist389); 
					 ArrayList<Node> parTypes = new ArrayList<Node>(); int paroffset=1; 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:86:8: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==ID) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:87:10: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
							{
							fid=(Token)match(input,ID,FOLLOW_ID_in_declist414); 
							match(input,COLON,FOLLOW_COLON_in_declist416); 
							pushFollow(FOLLOW_type_in_declist420);
							fty=type();
							state._fsp--;


								          parTypes.add(fty); 
								          ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
								          f.addPar(fpar);
								          if ( hmn.put((fid!=null?fid.getText():null),new STentry(nestingLevel,fty,paroffset++)) != null  ){
								             System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
								             System.exit(0);
								          }
							         
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:97:10: ( COMMA id= ID COLON ty= type )*
							loop11:
							while (true) {
								int alt11=2;
								int LA11_0 = input.LA(1);
								if ( (LA11_0==COMMA) ) {
									alt11=1;
								}

								switch (alt11) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:98:12: COMMA id= ID COLON ty= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist455); 
									id=(Token)match(input,ID,FOLLOW_ID_in_declist459); 
									match(input,COLON,FOLLOW_COLON_in_declist461); 
									pushFollow(FOLLOW_type_in_declist465);
									ty=type();
									state._fsp--;


											           parTypes.add(ty); 
											           ParNode par = new ParNode((id!=null?id.getText():null),ty);
											           f.addPar(par);
											           if ( hmn.put((id!=null?id.getText():null),new STentry(nestingLevel,ty,paroffset++)) != null  ){
											              System.out.println("Parameter id "+(id!=null?id.getText():null)+" at line "+(id!=null?id.getLine():0)+" already declared");
											              System.exit(0);
											           }
										          
									}
									break;

								default :
									break loop11;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_declist510); 
					 entry.addType( new ArrowTypeNode(parTypes, t) ); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:111:8: ( LET d= declist IN )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==LET) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:112:11: LET d= declist IN
							{
							match(input,LET,FOLLOW_LET_in_declist534); 
							pushFollow(FOLLOW_declist_in_declist538);
							d=declist();
							state._fsp--;

							match(input,IN,FOLLOW_IN_in_declist540); 
							f.addDec(d);
							}
							break;

					}

					pushFollow(FOLLOW_exp_in_declist564);
					e=exp();
					state._fsp--;

					//chiudere scope
					          symTable.remove(nestingLevel--);
					          f.addBody(e);
					       
					match(input,SEMIC,FOLLOW_SEMIC_in_declist575); 
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:122:1: type returns [Node ast] : (b= basic | ARROW );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node b =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:123:3: (b= basic | ARROW )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BOOL||LA15_0==ID||LA15_0==INT) ) {
				alt15=1;
			}
			else if ( (LA15_0==ARROW) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:123:11: b= basic
					{
					pushFollow(FOLLOW_basic_in_type607);
					b=basic();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:123:21: ARROW
					{
					match(input,ARROW,FOLLOW_ARROW_in_type611); 
					ast =new ArrowTypeNode();
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:126:1: basic returns [Node ast] : ( INT | BOOL | ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:127:3: ( INT | BOOL | ID )
			int alt16=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt16=1;
				}
				break;
			case BOOL:
				{
				alt16=2;
				}
				break;
			case ID:
				{
				alt16=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:127:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic636); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:128:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic651); 
					ast =new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:129:11: ID
					{
					match(input,ID,FOLLOW_ID_in_basic666); 
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:136:1: arrow returns [ArrowTypeNode ast] : LPAR ( type ( COMMA type )* )? RPAR ARROW basic ;
	public final ArrowTypeNode arrow() throws RecognitionException {
		ArrowTypeNode ast = null;


		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:136:34: ( LPAR ( type ( COMMA type )* )? RPAR ARROW basic )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:137:3: LPAR ( type ( COMMA type )* )? RPAR ARROW basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow687); 
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:137:8: ( type ( COMMA type )* )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==ARROW||LA18_0==BOOL||LA18_0==ID||LA18_0==INT) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:137:10: type ( COMMA type )*
					{
					pushFollow(FOLLOW_type_in_arrow691);
					type();
					state._fsp--;

					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:137:14: ( COMMA type )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==COMMA) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:137:15: COMMA type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow693); 
							pushFollow(FOLLOW_type_in_arrow695);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop17;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow702); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow704); 
			pushFollow(FOLLOW_basic_in_arrow706);
			basic();
			state._fsp--;

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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:139:1: exp returns [Node ast] : f= term ( PLUS l= term MINUS l= term OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:140:3: (f= term ( PLUS l= term MINUS l= term OR l= term )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:140:5: f= term ( PLUS l= term MINUS l= term OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp724);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:141:7: ( PLUS l= term MINUS l= term OR l= term )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==PLUS) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:142:8: PLUS l= term MINUS l= term OR l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp743); 
					pushFollow(FOLLOW_term_in_exp747);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					match(input,MINUS,FOLLOW_MINUS_in_exp759); 
					pushFollow(FOLLOW_term_in_exp763);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					match(input,OR,FOLLOW_OR_in_exp774); 
					pushFollow(FOLLOW_term_in_exp778);
					l=term();
					state._fsp--;

					ast = new OrNode   (ast,l);
					}
					break;

				default :
					break loop19;
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:148:1: term returns [Node ast] : f= factor ( MULT l= factor DIV l= factor AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:149:2: (f= factor ( MULT l= factor DIV l= factor AND l= factor )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:149:4: f= factor ( MULT l= factor DIV l= factor AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term812);
			f=factor();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:150:6: ( MULT l= factor DIV l= factor AND l= factor )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==MULT) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:151:7: MULT l= factor DIV l= factor AND l= factor
					{
					match(input,MULT,FOLLOW_MULT_in_term829); 
					pushFollow(FOLLOW_factor_in_term833);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					match(input,DIV,FOLLOW_DIV_in_term843); 
					pushFollow(FOLLOW_factor_in_term848);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					match(input,AND,FOLLOW_AND_in_term858); 
					pushFollow(FOLLOW_factor_in_term863);
					l=factor();
					state._fsp--;

					ast = new AndNode (ast,l);
					}
					break;

				default :
					break loop20;
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:157:1: value returns [Node ast] : (i= INTEGER | TRUE | FALSE | NULL | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:158:2: (i= INTEGER | TRUE | FALSE | NULL | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt24=8;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt24=1;
				}
				break;
			case TRUE:
				{
				alt24=2;
				}
				break;
			case FALSE:
				{
				alt24=3;
				}
				break;
			case NULL:
				{
				alt24=4;
				}
				break;
			case IF:
				{
				alt24=5;
				}
				break;
			case NOT:
				{
				alt24=6;
				}
				break;
			case PRINT:
				{
				alt24=7;
				}
				break;
			case ID:
				{
				alt24=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:158:4: i= INTEGER
					{
					i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value890); 
					ast = new NatNode(Integer.parseInt((i!=null?i.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:159:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value899); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:160:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value910); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:161:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value919); 
					ast = new NullNode();
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:163:5: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value931); 
					pushFollow(FOLLOW_exp_in_value935);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value937); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value939); 
					pushFollow(FOLLOW_exp_in_value943);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value945); 
					match(input,ELSE,FOLLOW_ELSE_in_value955); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value957); 
					pushFollow(FOLLOW_exp_in_value961);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value963); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:166:5: NOT LPAR x= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value979); 
					match(input,LPAR,FOLLOW_LPAR_in_value981); 
					pushFollow(FOLLOW_exp_in_value986);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value988); 
					ast = new NotNode(x);
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:167:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value997); 
					match(input,LPAR,FOLLOW_LPAR_in_value999); 
					pushFollow(FOLLOW_exp_in_value1003);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1005); 
					ast = new PrintNode(e);
					}
					break;
				case 8 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:168:6: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1016); 
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
					    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:180:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==LPAR) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:181:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1037); 
							 ArrayList<Node> argList = new ArrayList<Node>(); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:182:7: (fa= exp ( COMMA a= exp )* )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==FALSE||(LA22_0 >= ID && LA22_0 <= IF)||LA22_0==INTEGER||(LA22_0 >= NOT && LA22_0 <= NULL)||LA22_0==PRINT||LA22_0==TRUE) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:182:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1051);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:183:9: ( COMMA a= exp )*
									loop21:
									while (true) {
										int alt21=2;
										int LA21_0 = input.LA(1);
										if ( (LA21_0==COMMA) ) {
											alt21=1;
										}

										switch (alt21) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:183:10: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1064); 
											pushFollow(FOLLOW_exp_in_value1068);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop21;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1097); 
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
	// $ANTLR end "value"



	// $ANTLR start "factor"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:190:1: factor returns [Node ast] : f= value ( EQ l= value | GR l= value | LE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:191:5: (f= value ( EQ l= value | GR l= value | LE l= value )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:191:7: f= value ( EQ l= value | GR l= value | LE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1137);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:192:5: ( EQ l= value | GR l= value | LE l= value )*
			loop25:
			while (true) {
				int alt25=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt25=1;
					}
					break;
				case GR:
					{
					alt25=2;
					}
					break;
				case LE:
					{
					alt25=3;
					}
					break;
				}
				switch (alt25) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:193:9: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1155); 
					pushFollow(FOLLOW_value_in_factor1159);
					l=value();
					state._fsp--;

					ast = new EqualNode(ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:194:9: GR l= value
					{
					match(input,GR,FOLLOW_GR_in_factor1171); 
					pushFollow(FOLLOW_value_in_factor1175);
					l=value();
					state._fsp--;

					ast = new GreaterOrEqualNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:195:9: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1188); 
					pushFollow(FOLLOW_value_in_factor1192);
					l=value();
					state._fsp--;

					ast = new LessOrEqualNode(ast,l);
					}
					break;

				default :
					break loop25;
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
	public static final BitSet FOLLOW_IN_in_prog90 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_prog94 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist140 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist144 = new BitSet(new long[]{0x0000000020040000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist147 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist149 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist153 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist156 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist158 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist160 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist163 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist165 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist167 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist169 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist176 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist184 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_FUN_in_cllist195 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist197 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist199 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist201 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist203 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist206 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist208 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_cllist210 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist213 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist215 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist217 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_cllist219 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist226 = new BitSet(new long[]{0x0000022614C80000L});
	public static final BitSet FOLLOW_LET_in_cllist237 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_VAR_in_cllist240 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist242 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist244 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist246 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist248 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_cllist250 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist252 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_IN_in_cllist256 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_cllist261 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist263 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist274 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist316 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist320 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist322 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_declist326 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist328 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_declist332 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist334 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_FUN_in_declist361 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist365 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist367 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_declist371 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist389 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_declist414 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist416 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_declist420 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist455 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist459 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist461 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_declist465 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist510 = new BitSet(new long[]{0x0000022614C80000L});
	public static final BitSet FOLLOW_LET_in_declist534 = new BitSet(new long[]{0x0000040000100000L});
	public static final BitSet FOLLOW_declist_in_declist538 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_declist540 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_declist564 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist575 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_basic_in_type607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARROW_in_type611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow687 = new BitSet(new long[]{0x00000040024000A0L});
	public static final BitSet FOLLOW_type_in_arrow691 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow693 = new BitSet(new long[]{0x00000000024000A0L});
	public static final BitSet FOLLOW_type_in_arrow695 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow702 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow704 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_arrow706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp724 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_PLUS_in_exp743 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_term_in_exp747 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_MINUS_in_exp759 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_term_in_exp763 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_OR_in_exp774 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_term_in_exp778 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_factor_in_term812 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_MULT_in_term829 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_factor_in_term833 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DIV_in_term843 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_factor_in_term848 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AND_in_term858 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_factor_in_term863 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_INTEGER_in_value890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value931 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value935 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value937 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value939 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value943 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value945 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_value955 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value957 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value961 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value979 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value981 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value986 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value997 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value999 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value1003 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1016 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_LPAR_in_value1037 = new BitSet(new long[]{0x0000026604C80000L});
	public static final BitSet FOLLOW_exp_in_value1051 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1064 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_exp_in_value1068 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1137 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_EQ_in_factor1155 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_value_in_factor1159 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_GR_in_factor1171 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_value_in_factor1175 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_LE_in_factor1188 = new BitSet(new long[]{0x0000022604C80000L});
	public static final BitSet FOLLOW_value_in_factor1192 = new BitSet(new long[]{0x0000000008210002L});
}
