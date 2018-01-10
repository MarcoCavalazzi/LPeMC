// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g 2016-06-27 18:38:30

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
		private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle symTable.get(nestingLevel)
		boolean debuggingModeOn=false; // variabile che determina se stampare le print di debug o meno durante l'esecuzione. (false = non stampare)



	// $ANTLR start "prog"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:25:1: prog returns [Node ast] : (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> cl =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:26:3: (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==INTEGER||LA1_0==LPAR||(LA1_0 >= NEW && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:26:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog41);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog43); 
					 ast = new ProgNode(e); 
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:27:11: LET cl= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog57); 

					              nestingLevel++;
					              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					              symTable.add(hm);
					            
					pushFollow(FOLLOW_cllist_in_prog85);
					cl=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog90);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog92); 
					pushFollow(FOLLOW_exp_in_prog96);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog98); 

					              symTable.remove(nestingLevel--);
					              ast = new LetInNode(d,cl,e) ;
					            
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:41:1: cllist returns [ArrayList<Node> astlist] : ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token cid=null;
		Token cidext=null;
		Token p1=null;
		Token pn=null;
		Token mid=null;
		Token mp1=null;
		Token mpn=null;
		Token vid=null;
		Node t1 =null;
		Node tn =null;
		Node retm =null;
		Node mpt1 =null;
		Node mptn =null;
		Node vt =null;
		Node ve =null;
		Node varE =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:42:4: ( ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:42:6: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )*
			{

				     astlist = new ArrayList<Node>();
				   
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:5: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:6: CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist138); 
					cid=(Token)match(input,ID,FOLLOW_ID_in_cllist142); 

					         ClassNode classItem = new ClassNode((cid!=null?cid.getText():null));
					         astlist.add(classItem);
					         // Initializing local variables
					         CTentry extendedEntry = null;
					         CTentry ctentry       = null;
					         HashMap<String,STentry> hm = symTable.get(nestingLevel);// Recuperiamo l'hashmap del nesting level in cui ci troviamo.
					         // Creiamo la entry per l'hashmap
					         STentry entryCl = new STentry(classItem,nestingLevel);
					         entryCl.setClassName((cid!=null?cid.getText():null));
					         entryCl.setType(null);
					         nestingLevel++;// Incrementiamo il nesting level (perchÃ© siamo dentro la classe ora)
					         ctentry = new CTentry(classItem,nestingLevel);// A questo punto possiamo definire la CTentry
					         
					         STentry tmp  = hm.put((cid!=null?cid.getText():null),entryCl);// "put()" ritorna diverso da null solo se c'era qualcosa di giÃ  definito con quella keyword nella HM.
					         CTentry tmp2 = classTable.put((cid!=null?cid.getText():null),ctentry);
					         
					         if (tmp != null && tmp2 != null)
					         {
					            System.out.println("Class id "+(cid!=null?cid.getText():null)+" at line "+(cid!=null?cid.getLine():0)+" already declared");
					            System.exit(0); 
					         }                
					         
					         HashMap<String,STentry> classLevelSymTable =  new HashMap<String,STentry>(); // creaiamo una nuova HM per gli elementi definiti nella classe
					         symTable.add(classLevelSymTable);  // aggiungiamo tale HM in 'symtable'      
					         ctentry.setVirtualTable(classLevelSymTable);// salviamo tale HM come virtual table della classe (copia del puntatore).
					      
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:73:6: ( EXTENDS cidext= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:73:7: EXTENDS cidext= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist158); 
							cidext=(Token)match(input,ID,FOLLOW_ID_in_cllist162); 

							           extendedEntry = classTable.get((cidext!=null?cidext.getText():null));
							           
							           if(extendedEntry == null){
							           System.out.println("Class id "+(cidext!=null?cidext.getText():null)+" at line "+(cidext!=null?cidext.getLine():0)+" not declared");
							              System.exit(0);
							           }
							           
							           ArrayList<Node> tmpFields = (ArrayList<Node>) extendedEntry.getFields().clone(); //.clone() Ã¨ necessario per non rischiare di copiare il riferimento all'oggetto
							           ArrayList<Node> tmpMethods = (ArrayList<Node>) extendedEntry.getMethods().clone();
							           ctentry.setFields(tmpFields);
							           ctentry.setMethods(tmpMethods);
							           HashMap<String,STentry> tmpMap = (HashMap<String, STentry>) extendedEntry.getVirtualTable().clone();// Prendiamo la virtual table della classe parent e la copiamo nella virtual table della classe figlia.
							           
							           symTable.get(nestingLevel).putAll(tmpMap); //merge tra tmpMap e la virtualTable della classe che estende
							           ctentry.setMethodOffset(extendedEntry.getMethodOffset());
							           ctentry.setFieldOffset(extendedEntry.getFieldOffset());
							           classItem.setSuperEntry(extendedEntry);
							           classItem.setClassEntry(ctentry);
							           FOOLlib.putSuperType((cid!=null?cid.getText():null),(cidext!=null?cidext.getText():null));//Memorizziamo il nome della classe e della relativa super classe in FOOLlib.
							           
								     
							}
							break;

					}

					match(input,LPAR,FOLLOW_LPAR_in_cllist187); 

					           ArrayList<Node> constrPar = new ArrayList<Node>(); // lista dei field della classe
					       
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:101:7: (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:101:8: p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )*
							{
							p1=(Token)match(input,ID,FOLLOW_ID_in_cllist207); 
							match(input,COLON,FOLLOW_COLON_in_cllist209); 
							pushFollow(FOLLOW_basic_in_cllist213);
							t1=basic();
							state._fsp--;


								         // Aggiungiamo il field alla lista
								         constrPar.add(t1);
								         // Aggiungiamo il field alla classe, necessario poi per la code generation.
							           FieldNode objField = new FieldNode((p1!=null?p1.getText():null),t1,(cid!=null?cid.getText():null));
							           classItem.addField(objField);
							           // Aggiungiamo il field alla virtual table della ctentry della classe
							           STentry tempEntry = new STentry(objField,nestingLevel,t1,ctentry.getFieldOffset());
							           tempEntry.setClassName((cid!=null?cid.getText():null));
							           STentry tmpField = ctentry.getVirtualTable().put((p1!=null?p1.getText():null),tempEntry); //restituisce una STentry se già presente in vTable
							           if(tmpField != null)
							           {
							              if(ctentry.checkLocals(tmpField.getOffset())){ //se è true vuol dire che sto ridefinendo un field/method nella classe
							                System.out.println("Parameter id "+(p1!=null?p1.getText():null)+" at line "+(p1!=null?p1.getLine():0)+" already declared!");
							                System.exit(0);
							              }// else: è overriding
							           }
							           
							           // Check anche su allFields e gestione della lista stessa ('allFields')
							           if(ctentry.setFieldAndCheck(objField,(p1!=null?p1.getText():null)))
							               tempEntry.setOffset( tmpField.getOffset() );//controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)    
							           
							           ctentry.addLocals(ctentry.getFieldOffset()); // Aggiungo l'offset del field in caso non sia stato ancora dichiarato
							           ctentry.decFieldOffset();  // Decrementiamo il fieldOffset per il prossimo field
								     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:127:7: ( COMMA pn= ID COLON tn= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:127:8: COMMA pn= ID COLON tn= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist231); 
									pn=(Token)match(input,ID,FOLLOW_ID_in_cllist235); 
									match(input,COLON,FOLLOW_COLON_in_cllist237); 
									pushFollow(FOLLOW_basic_in_cllist241);
									tn=basic();
									state._fsp--;


										         // Aggiungiamo il field alla lista
									           constrPar.add(tn);
									           // Aggiungiamo il field alla classe
									           FieldNode objFieldN = new FieldNode((pn!=null?pn.getText():null),tn,(cid!=null?cid.getText():null));
									           classItem.addField(objFieldN);
									           // Aggiungiamo il field alla virtual table della ctentry della classe
									           STentry tmpSTentry = new STentry(objFieldN,nestingLevel,tn,ctentry.getFieldOffset());
									           STentry tmpFieldN = ctentry.getVirtualTable().put((pn!=null?pn.getText():null),tmpSTentry);
									           if ( tmpFieldN  != null  )
									           {
									              if(ctentry.checkLocals(tmpFieldN.getOffset())){
									                 System.out.println("Parameter id "+(p1!=null?p1.getText():null)+" at line "+(p1!=null?p1.getLine():0)+" already declared!");
									                 System.exit(0);
									              }
									           }
									           
									           // Check anche su allFields e gestione della lista stessa ('allFields')
									           if(ctentry.setFieldAndCheck(objFieldN,(pn!=null?pn.getText():null))) //controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)
									              tmpSTentry.setOffset( tmpFieldN.getOffset() );
									           
									           ctentry.addLocals( ctentry.getFieldOffset() ); // Aggiungo l'offset del field in caso non sia stato ancora dichiarato
									           ctentry.decFieldOffset();  // Decrementiamo il fieldOffset per il prossimo field
										     
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist263); 

						        ctentry.addType( new ArrowTypeNode(constrPar, classItem) ); // adding the type to the ctentry
						     
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist279); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:157:9: ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:157:10: FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist290); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist294); 
							match(input,COLON,FOLLOW_COLON_in_cllist296); 
							pushFollow(FOLLOW_basic_in_cllist300);
							retm=basic();
							state._fsp--;


							             // Definizione del metodo
							             MethodNode mNode = new MethodNode((mid!=null?mid.getText():null),retm);
							             STentry entry = new STentry(mNode,nestingLevel,retm,ctentry.getMethodOffset());
							             entry.setClassName((cid!=null?cid.getText():null));
							             entry.setIsMethod();  // Specifichiamo che si tratta di un metodo
							             STentry tmpMethod = ctentry.getVirtualTable().put((mid!=null?mid.getText():null),entry);  // Ritorna un valore diverso da 'null' solo se va a sovrascrivere un valore che aveva la stessa key.
							             if (tmpMethod != null)
							             {
							                if(ctentry.checkLocals(tmpMethod.getOffset())){ // Se il metodo è stato già definito nella classe in questione...
							                  System.out.println("Method id "+(mid!=null?mid.getText():null)+" at line "+(mid!=null?mid.getLine():0)+" already declared!");
							                  System.exit(0);
							                }
							                else
							                    ctentry.addLocals(tmpMethod.getOffset()); // Il metodo è stato sovrascritto (override).
							             } 
							             else
							                ctentry.addLocals(ctentry.getMethodOffset()); // Aggiungiamo semplicemente il nuovo offset tra quelli memorizzati in 'locals'. 
							             
							             if( ctentry.setMethodAndCheck(mNode,(mid!=null?mid.getText():null)) ) // Se c'è stato un override
							                entry.setOffset( tmpMethod.getOffset() );   // Memorizziamo l'offset del metodo  
							             
							             ctentry.incMethodOffset();     // Incrementiamo l'offset per il prossimo metodo    
							             
							             classItem.setMethod(mNode);    // Settiamo il metodo nella classe
							             nestingLevel++;                // Aumentiamo il nesting level, stiamo entrando nel metodo.
							             HashMap<String,STentry> hmMethod = new HashMap<String,STentry>();  // Definizione della HashMap del metodo in symtable.
							             symTable.add(hmMethod);
								       
							match(input,LPAR,FOLLOW_LPAR_in_cllist324); 

								          ArrayList<Node> parTypes = new ArrayList<Node>();  // parametri in input per il metodo
							            int parOffset = 1;
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:192:9: (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:192:10: mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )*
									{
									mp1=(Token)match(input,ID,FOLLOW_ID_in_cllist347); 
									match(input,COLON,FOLLOW_COLON_in_cllist349); 
									pushFollow(FOLLOW_type_in_cllist353);
									mpt1=type();
									state._fsp--;


										           // Leggiamo il primo parametro in input del metodo
										           parTypes.add(mpt1);
									             ParNode fpar = new ParNode((mp1!=null?mp1.getText():null),mpt1);
									             mNode.addPar(fpar);  // Aggiungiamo il parametro alla struttura dati del metodo
									             
									             STentry tmpEntryPar = new STentry(fpar,nestingLevel,mpt1,parOffset);             
									             if ( hmMethod.put((mp1!=null?mp1.getText():null),tmpEntryPar) != null  ){  // Aggiungiamo il parametro alla symbol table
									                System.out.println("Parameter id "+(mp1!=null?mp1.getText():null)+" at line "+(mp1!=null?mp1.getLine():0)+" already declared");
									                System.exit(0);
									             }
									             
									             parOffset++;   // Incrementiamo l'offset per il prossimo parametro
										       
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:207:9: ( COMMA mpn= ID COLON mptn= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:207:10: COMMA mpn= ID COLON mptn= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist375); 
											mpn=(Token)match(input,ID,FOLLOW_ID_in_cllist379); 
											match(input,COLON,FOLLOW_COLON_in_cllist381); 
											pushFollow(FOLLOW_type_in_cllist385);
											mptn=type();
											state._fsp--;


												           // Leggiamo dal secondo parametro in poi in input del metodo
												           parTypes.add(mptn);
											             ParNode par = new ParNode((mpn!=null?mpn.getText():null),mptn);
											             mNode.addPar(par);  // Aggiungiamo il parametro alla struttura dati del metodo
											             
											             STentry stPar = new STentry(fpar,nestingLevel,mptn,parOffset);
											             if (hmMethod.put((mpn!=null?mpn.getText():null),stPar) != null ){  // Aggiungiamo il parametro alla symbol table
											                System.out.println("Parameter id "+(mpn!=null?mpn.getText():null)+" at line "+(mpn!=null?mpn.getLine():0)+" already declared");
											                System.exit(0);
											             }
											               
											             parOffset++;   // Incrementiamo l'offset per il prossimo parametro

												       
											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist402); 

								           entry.addType( new ArrowTypeNode(parTypes , retm) );
							             ArrayList<Node> letInMethodList = new ArrayList<Node>();       
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:227:9: ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:227:10: LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist426); 

										           int innerOffset = 0;
										           nestingLevel++;
										           HashMap<String,STentry> varhm = new HashMap<String,STentry>();
										       
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:233:9: ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:233:10: VAR vid= ID COLON vt= type ASS ve= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist448); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist452); 
											match(input,COLON,FOLLOW_COLON_in_cllist454); 
											pushFollow(FOLLOW_type_in_cllist458);
											vt=type();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist460); 
											pushFollow(FOLLOW_exp_in_cllist464);
											ve=exp();
											state._fsp--;


												           VarNode v = new VarNode((vid!=null?vid.getText():null),vt,ve);
											             astlist.add(v);
											             
											             symTable.add(varhm);
											             if ( varhm.put((vid!=null?vid.getText():null),new STentry(v,nestingLevel,vt,innerOffset++)) != null  )
											             {
											                 System.out.println("Var id "+(vid!=null?vid.getText():null)+" at line "+(vid!=null?vid.getLine():0)+" already declared");
											                 System.exit(0);
											             }
											          
											match(input,SEMIC,FOLLOW_SEMIC_in_cllist486); 
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist490); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist497);
							varE=exp();
							state._fsp--;


								            // Chiudiamo lo scope, decrementando anche il nesting level di riferimento.
							              symTable.remove(nestingLevel--);           
							              mNode.addBody(varE);     // Aggiungiamo la var al metodo
							              classItem.addMethod(mNode);   // Aggiungiamo il metodo alla classe
								        
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist520); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist531); 

					        symTable.remove(nestingLevel--);  // Chiudiamo lo scope.
					      
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:261:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* ;
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:262:2: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:262:4: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			{

				    astlist = new ArrayList<Node>() ;
				    int offset = -2;   // Partiamo da -2 perché il nostro stack parte da 9998 anziché da 10000.
				  
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:266:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==FUN||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:267:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:267:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==VAR) ) {
						alt14=1;
					}
					else if ( (LA14_0==FUN) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:268:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist603); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist607); 
							match(input,COLON,FOLLOW_COLON_in_declist609); 
							pushFollow(FOLLOW_type_in_declist613);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist615); 
							pushFollow(FOLLOW_exp_in_declist619);
							e=exp();
							state._fsp--;


							          // Leggiamo l'input, creiamo la struttura dati della Var e l'aggiungiamo alla lista 'astlist'.
							          VarNode v = new VarNode((i!=null?i.getText():null),t,e);
							          astlist.add(v);
							          if(t instanceof ArrowTypeNode) // Se è di tipo funzionale usiamo un offset doppio. Ci consente di memorizzare sia l'indirizzo della funzione sia l'FP (frame pointer) a questo AR (Activation Record).
							          {
							             offset--;
							          }
							          
							          if(debuggingModeOn){
							              System.out.println("VAR    "+ v.toPrint(""));
							          }
							          
							          // Recuperiamo l'HashMap del livello attuale e vi aggiungiamo la VAR.
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);
							          STentry varEntry = new STentry(nestingLevel,t,offset--);
							          if ( hm.put((i!=null?i.getText():null),varEntry) != null  ){
							             System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							             System.exit(0);
							          }
							       
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:291:8: FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist646); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist650); 
							match(input,COLON,FOLLOW_COLON_in_declist652); 
							pushFollow(FOLLOW_basic_in_declist656);
							t=basic();
							state._fsp--;


							          // Creazione del FunNode e aggiunta in astlist
							          FunNode f = new FunNode((i!=null?i.getText():null),t);
							          astlist.add(f);
							          // Recuperiamo l'HashMap del livello attuale e vi aggiungiamo la FUN.
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);
							          STentry entry = new STentry(nestingLevel,offset);
							          offset = offset - 2;  // perché è funzionale
							          if ( hm.put((i!=null?i.getText():null),entry) != null ){
							             System.out.println("FUN id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							             System.exit(0);
							          }
							          // Creiamo una nuova HashMap per la symTable per gestire il livello di nesting interno alla funzione.
							          nestingLevel++;   // andiamo "dentro" alla funzione.
							          HashMap<String,STentry> hmn = new HashMap<String,STentry> (); // HashMap che gestisce il contenuto della funzione.
							          symTable.add(hmn);
							       
							match(input,LPAR,FOLLOW_LPAR_in_declist674); 

							          ArrayList<Node> parTypes = new ArrayList<Node>();
							          int paroffset = 1;
							       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:314:8: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:315:10: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist705); 
									match(input,COLON,FOLLOW_COLON_in_declist707); 
									pushFollow(FOLLOW_type_in_declist711);
									fty=type();
									state._fsp--;


									            // Gestione del parametro in input alla FUN
										          parTypes.add(fty);
										          ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
										          
										          if(fty instanceof ArrowTypeNode )  // Se di tipo funzionale
									               paroffset++;
									            
										          f.addPar(fpar);    // Aggiunta del parametro alla funzione
										          
										          if ( hmn.put((fid!=null?fid.getText():null),new STentry(fpar,nestingLevel,fty,paroffset++)) != null  ){
										             System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
										             System.exit(0);
										          }
									         
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:331:10: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:332:12: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist746); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist750); 
											match(input,COLON,FOLLOW_COLON_in_declist752); 
											pushFollow(FOLLOW_type_in_declist756);
											ty=type();
											state._fsp--;


												             // Gestione degli altri parametri in input alla FUN (come per il primo parametro).
													           parTypes.add(ty); 
													           ParNode par = new ParNode((id!=null?id.getText():null),ty);
													           if(ty instanceof ArrowTypeNode)
													              paroffset++;
											               
													           f.addPar(par);
													           if ( hmn.put((id!=null?id.getText():null),new STentry(par,nestingLevel,ty,paroffset++)) != null  ){
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

							match(input,RPAR,FOLLOW_RPAR_in_declist802); 
							 entry.addType( new ArrowTypeNode(parTypes, t) ); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:349:8: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:349:10: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist816); 
									pushFollow(FOLLOW_declist_in_declist820);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist822); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist836);
							e=exp();
							state._fsp--;


							          // Chiudiamo lo scope
							          symTable.remove(nestingLevel--);
							          f.addDecBody(d, e);
							       
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist855); 
					}
					break;

				default :
					break loop15;
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
	// $ANTLR end "declist"



	// $ANTLR start "type"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:360:1: type returns [Node ast] : (bas= basic |art= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node bas =null;
		Node art =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:361:9: (bas= basic |art= arrow )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BOOL||LA16_0==ID||LA16_0==INT) ) {
				alt16=1;
			}
			else if ( (LA16_0==LPAR) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:361:11: bas= basic
					{
					pushFollow(FOLLOW_basic_in_type889);
					bas=basic();
					state._fsp--;

					ast = bas;
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:362:11: art= arrow
					{
					pushFollow(FOLLOW_arrow_in_type905);
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:365:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:366:9: ( INT | BOOL |i= ID )
			int alt17=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt17=1;
				}
				break;
			case BOOL:
				{
				alt17=2;
				}
				break;
			case ID:
				{
				alt17=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:366:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic930); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:367:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic945); 
					ast =new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:368:11: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic961); 

							         int nl = nestingLevel;
							         STentry classEntry = null;
							         // Check per vedere se l'ID è di tipo classe.
							         while (nl>=0 && classEntry==null){
							            classEntry = (symTable.get(nl--)).get((i!=null?i.getText():null));
							         }
							         
							         if(classEntry != null)
							            ast = new ClassTypeNode((i!=null?i.getText():null));
							         else
							            ast = new IdNode();
					          
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:383:1: arrow returns [Node ast] : LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node funParT =null;
		Node funParTy =null;
		Node retTy =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:384:9: ( LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:384:11: LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow985); 

			            // Creazione di una lista vuota per i parametri
			            ArrayList<Node> funParTypes = new ArrayList<Node>();
			          
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:389:11: (funParT= type ( COMMA funParTy= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:390:13: funParT= type ( COMMA funParTy= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1026);
					funParT=type();
					state._fsp--;


					              funParTypes.add(funParT);    // Aggiunta parametro
					            
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:394:13: ( COMMA funParTy= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:394:14: COMMA funParTy= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1056); 
							pushFollow(FOLLOW_type_in_arrow1060);
							funParTy=type();
							state._fsp--;


							              funParTypes.add(funParTy);   // Aggiunta parametro (dal secondo in poi)
							            
							}
							break;

						default :
							break loop18;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow1092); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1094); 
			pushFollow(FOLLOW_basic_in_arrow1098);
			retTy=basic();
			state._fsp--;


				           // Creazione del nodo della funzione Higher-Order
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:405:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:406:5: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:406:7: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1137);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:407:7: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop20:
			while (true) {
				int alt20=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt20=1;
					}
					break;
				case MINUS:
					{
					alt20=2;
					}
					break;
				case OR:
					{
					alt20=3;
					}
					break;
				}
				switch (alt20) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:408:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1156); 
					pushFollow(FOLLOW_term_in_exp1160);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:409:10: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1174); 
					pushFollow(FOLLOW_term_in_exp1178);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:410:10: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1191); 
					pushFollow(FOLLOW_term_in_exp1195);
					l=term();
					state._fsp--;

					ast = new OrNode   (ast,l);
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
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:414:1: term returns [Node ast] : f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:415:4: (f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:415:6: f= factor ( MULT l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1233);
			f=factor();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:416:6: ( MULT l= factor | DIV l= factor | AND l= factor )*
			loop21:
			while (true) {
				int alt21=4;
				switch ( input.LA(1) ) {
				case MULT:
					{
					alt21=1;
					}
					break;
				case DIV:
					{
					alt21=2;
					}
					break;
				case AND:
					{
					alt21=3;
					}
					break;
				}
				switch (alt21) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:417:7: MULT l= factor
					{
					match(input,MULT,FOLLOW_MULT_in_term1250); 
					pushFollow(FOLLOW_factor_in_term1254);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:418:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1266); 
					pushFollow(FOLLOW_factor_in_term1271);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:419:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1283); 
					pushFollow(FOLLOW_factor_in_term1288);
					l=factor();
					state._fsp--;

					ast = new AndNode (ast,l);
					}
					break;

				default :
					break loop21;
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:423:1: value returns [Node ast] : (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token i=null;
		Token cmid=null;
		Node fa =null;
		Node a =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e =null;
		Node cmex1 =null;
		Node cmexn =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:424:3: (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? )
			int alt29=10;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt29=1;
				}
				break;
			case TRUE:
				{
				alt29=2;
				}
				break;
			case FALSE:
				{
				alt29=3;
				}
				break;
			case NULL:
				{
				alt29=4;
				}
				break;
			case NEW:
				{
				alt29=5;
				}
				break;
			case IF:
				{
				alt29=6;
				}
				break;
			case NOT:
				{
				alt29=7;
				}
				break;
			case PRINT:
				{
				alt29=8;
				}
				break;
			case LPAR:
				{
				alt29=9;
				}
				break;
			case ID:
				{
				alt29=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:424:5: i= INTEGER
					{
					i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1318); 
					ast = new NatNode(Integer.parseInt((i!=null?i.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:425:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1326); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:426:6: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1336); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:427:6: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1345); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:428:6: NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1355); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1359); 

						       CTentry ctEntry=null; 
						       ctEntry=classTable.get((i!=null?i.getText():null));  // Troviamo la classe di riferimento
						       
						       if(ctEntry==null) // Se la classe scritta dall'utente non esiste...
						       {
						          System.out.println("Class "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!!");
						          System.exit(0); 
						       }
						    
					match(input,LPAR,FOLLOW_LPAR_in_value1373); 

						       ArrayList<Node> argList = new ArrayList<Node>();  // I parametri della classe
						    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:443:6: (fa= exp ( COMMA a= exp )* )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==FALSE||(LA23_0 >= ID && LA23_0 <= IF)||LA23_0==INTEGER||LA23_0==LPAR||(LA23_0 >= NEW && LA23_0 <= NULL)||LA23_0==PRINT||LA23_0==TRUE) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:444:8: fa= exp ( COMMA a= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1398);
							fa=exp();
							state._fsp--;


									       argList.add(fa);
									    
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:448:6: ( COMMA a= exp )*
							loop22:
							while (true) {
								int alt22=2;
								int LA22_0 = input.LA(1);
								if ( (LA22_0==COMMA) ) {
									alt22=1;
								}

								switch (alt22) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:448:7: COMMA a= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1418); 
									pushFollow(FOLLOW_exp_in_value1422);
									a=exp();
									state._fsp--;


										         argList.add(a);
										      
									}
									break;

								default :
									break loop22;
								}
							}

							}
							break;

					}


						       ast = new NewNode((i!=null?i.getText():null),ctEntry,argList);
						    
					match(input,RPAR,FOLLOW_RPAR_in_value1464); 
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:459:6: IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1477); 
					match(input,LPAR,FOLLOW_LPAR_in_value1479); 
					pushFollow(FOLLOW_exp_in_value1483);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1485); 
					match(input,THEN,FOLLOW_THEN_in_value1496); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1498); 
					pushFollow(FOLLOW_exp_in_value1502);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1504); 
					match(input,ELSE,FOLLOW_ELSE_in_value1515); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1517); 
					pushFollow(FOLLOW_exp_in_value1521);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1523); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:463:6: NOT LPAR x= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1541); 
					match(input,LPAR,FOLLOW_LPAR_in_value1545); 
					pushFollow(FOLLOW_exp_in_value1549);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1551); 
					ast = new NotNode(x);
					}
					break;
				case 8 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:464:6: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1561); 
					match(input,LPAR,FOLLOW_LPAR_in_value1563); 
					pushFollow(FOLLOW_exp_in_value1567);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1569); 
					ast = new PrintNode(e);
					}
					break;
				case 9 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:465:6: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1578); 
					pushFollow(FOLLOW_exp_in_value1582);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1584); 
					ast = e;
					}
					break;
				case 10 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:466:6: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1595); 

						      // Cerchiamo la dichiarazione (cioe' quando lo usa)
							    int nl = nestingLevel;
							    STentry entry      = null;
							    CTentry classEntry = null;
							    
							    // Cerchiamo tra le classi
							    classEntry = classTable.get((i!=null?i.getText():null));
							    if(classEntry==null)  // se non è tra le classi...
							    {
							       // Cerchiamo se è definito in Symbol Table nei nesting level dall'attuale a quelli più esterni.
						         while (nl>=0 && entry==null)
						            entry=(symTable.get(nl--)).get((i!=null?i.getText():null));
						      }
						      
							    if (entry == null && classEntry == null){   // Se non è stato trovato da nessuna parte...
							       System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!!");
							       System.exit(0);
							    }
							    
							    // Definiamo l'IdNode
							    if( classEntry != null )
							       ast = new IdNode((i!=null?i.getText():null),classEntry,nestingLevel); // Usiamo questo approccio (con tipi diversi in input) per distinguere i nome di classe e id generico
							    else
							       ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
							  
							  
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:494:6: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
					int alt28=3;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==LPAR) ) {
						alt28=1;
					}
					else if ( (LA28_0==DOT) ) {
						alt28=2;
					}
					switch (alt28) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:495:8: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1618); 
							 ArrayList<Node> argList = new ArrayList<Node>(); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:496:8: (fa= exp ( COMMA a= exp )* )?
							int alt25=2;
							int LA25_0 = input.LA(1);
							if ( (LA25_0==FALSE||(LA25_0 >= ID && LA25_0 <= IF)||LA25_0==INTEGER||LA25_0==LPAR||(LA25_0 >= NEW && LA25_0 <= NULL)||LA25_0==PRINT||LA25_0==TRUE) ) {
								alt25=1;
							}
							switch (alt25) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:497:10: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1642);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:498:10: ( COMMA a= exp )*
									loop24:
									while (true) {
										int alt24=2;
										int LA24_0 = input.LA(1);
										if ( (LA24_0==COMMA) ) {
											alt24=1;
										}

										switch (alt24) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:498:12: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1657); 
											pushFollow(FOLLOW_exp_in_value1661);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop24;
										}
									}

									}
									break;

							}


								        if( classEntry != null)
								        {
								            System.out.println("Call of class Id "+(i!=null?i.getText():null));
								            System.exit(0);
								        }
								        else
								            ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
								        
								      
							match(input,RPAR,FOLLOW_RPAR_in_value1694); 
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:512:7: DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1711); 
							cmid=(Token)match(input,ID,FOLLOW_ID_in_value1715); 

								       CTentry ctentryClass = null;
								       STentry entryM = null;
								       
								       if(entry != null && entry.getType() instanceof ClassTypeNode ) // Controlla che non stiamo facendo nomeClasse.qualcosa perché è vietato. Controlla, in più, che ci sia effettivamente un'entry dichiarata con questo nome attraverso il controllo della symTable.
								          ctentryClass = classTable.get(((ClassTypeNode)entry.getType()).getName());  // Ricerca della entry relativa alla classe dell'oggetto istanza su cui viene richiamato il metodo
								       else
								       {  
								          System.out.println("Not object invocation, check: "+(i!=null?i.getText():null));
								          System.exit(0);
								       }    
								       
								       // Ricerca dell'entry del metodo all'interno della classe relativa ad esso trovata in precedenza
								       entryM = ctentryClass.getVirtualTable().get((cmid!=null?cmid.getText():null));
								       
								       if (entryM == null){  // Se il metodo richiamato non esiste...
								         System.out.println("Method Call "+(cmid!=null?cmid.getText():null)+" at line "+(cmid!=null?cmid.getLine():0)+" not declared");
								         System.exit(0);
								       }
								     
							match(input,LPAR,FOLLOW_LPAR_in_value1731); 

								        ArrayList<Node> mArgList = new ArrayList<Node>();
								     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:537:7: (cmex1= exp ( COMMA cmexn= exp )* )?
							int alt27=2;
							int LA27_0 = input.LA(1);
							if ( (LA27_0==FALSE||(LA27_0 >= ID && LA27_0 <= IF)||LA27_0==INTEGER||LA27_0==LPAR||(LA27_0 >= NEW && LA27_0 <= NULL)||LA27_0==PRINT||LA27_0==TRUE) ) {
								alt27=1;
							}
							switch (alt27) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:538:9: cmex1= exp ( COMMA cmexn= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1759);
									cmex1=exp();
									state._fsp--;


											        mArgList.add(cmex1);
											     
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:542:8: ( COMMA cmexn= exp )*
									loop26:
									while (true) {
										int alt26=2;
										int LA26_0 = input.LA(1);
										if ( (LA26_0==COMMA) ) {
											alt26=1;
										}

										switch (alt26) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:542:9: COMMA cmexn= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1781); 
											pushFollow(FOLLOW_exp_in_value1785);
											cmexn=exp();
											state._fsp--;


													        mArgList.add(cmexn);
													     
											}
											break;

										default :
											break loop26;
										}
									}

									}
									break;

							}


								        ast = new ClassCallNode((cmid!=null?cmid.getText():null), entry, entryM, mArgList, nestingLevel);
								     
							match(input,RPAR,FOLLOW_RPAR_in_value1833); 
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:555:1: factor returns [Node ast] : f= value ( EQ l= value | GR l= value | LE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:556:5: (f= value ( EQ l= value | GR l= value | LE l= value )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:556:7: f= value ( EQ l= value | GR l= value | LE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1869);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:557:5: ( EQ l= value | GR l= value | LE l= value )*
			loop30:
			while (true) {
				int alt30=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt30=1;
					}
					break;
				case GR:
					{
					alt30=2;
					}
					break;
				case LE:
					{
					alt30=3;
					}
					break;
				}
				switch (alt30) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:558:9: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1887); 
					pushFollow(FOLLOW_value_in_factor1891);
					l=value();
					state._fsp--;

					ast = new EqualNode(ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:559:9: GR l= value
					{
					match(input,GR,FOLLOW_GR_in_factor1903); 
					pushFollow(FOLLOW_value_in_factor1907);
					l=value();
					state._fsp--;

					ast = new GreaterOrEqualNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:560:9: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1919); 
					pushFollow(FOLLOW_value_in_factor1923);
					l=value();
					state._fsp--;

					ast = new LessOrEqualNode(ast,l);
					}
					break;

				default :
					break loop30;
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



	public static final BitSet FOLLOW_exp_in_prog41 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog43 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog57 = new BitSet(new long[]{0x0000040001100100L});
	public static final BitSet FOLLOW_cllist_in_prog85 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_prog90 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_prog92 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_prog96 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist138 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist142 = new BitSet(new long[]{0x0000000020040000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist158 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist162 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist187 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist207 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist209 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist213 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist231 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist235 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist237 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist241 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist263 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist279 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_FUN_in_cllist290 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist294 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist296 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist300 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist324 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist347 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist349 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist353 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist375 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist379 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist381 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist385 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist402 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_cllist426 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_VAR_in_cllist448 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist452 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist454 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist458 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist460 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist464 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist486 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_IN_in_cllist490 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist497 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist520 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist531 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist603 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist607 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist609 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist613 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist615 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist619 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist646 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist650 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist652 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_declist656 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist674 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_declist705 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist707 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist711 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist746 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist750 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist752 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist756 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist802 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_declist816 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_declist820 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_declist822 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist836 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist855 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_basic_in_type889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow985 = new BitSet(new long[]{0x0000004022400080L});
	public static final BitSet FOLLOW_type_in_arrow1026 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow1056 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_arrow1060 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow1092 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1094 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_arrow1098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp1137 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1156 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1160 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1174 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1178 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp1191 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1195 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term1233 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_MULT_in_term1250 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1254 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_DIV_in_term1266 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1271 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_AND_in_term1283 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1288 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_INTEGER_in_value1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1355 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1359 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1373 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1398 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1418 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1422 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1477 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1479 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1483 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1485 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1496 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1498 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1502 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1504 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_value1515 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1517 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1521 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1541 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1545 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1549 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1561 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1563 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1567 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1578 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1582 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1595 = new BitSet(new long[]{0x0000000020004002L});
	public static final BitSet FOLLOW_LPAR_in_value1618 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1642 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1657 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1661 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1711 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1715 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1731 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1759 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1781 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1785 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1869 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_EQ_in_factor1887 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1891 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_GR_in_factor1903 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1907 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_LE_in_factor1919 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1923 = new BitSet(new long[]{0x0000000008210002L});
}
