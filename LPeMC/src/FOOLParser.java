// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g 2016-05-15 19:59:40

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
		private ArrayList<HashMap<String,STentry>>  virtualTable = new ArrayList<HashMap<String,STentry>>();
		private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>();
		private int nestingLevel = -1;
		private int nestingClassLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle � symTable.get(nestingLevel)



	// $ANTLR start "prog"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:26:1: prog returns [Node ast] : (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> cl =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:27:3: (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC )
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:27:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog40);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog42); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:28:11: LET cl= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog56); 

					              nestingLevel++;
					              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					              symTable.add(hm);
					            
					pushFollow(FOLLOW_cllist_in_prog84);
					cl=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog89);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog91); 
					pushFollow(FOLLOW_exp_in_prog95);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog97); 

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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:44:1: cllist returns [ArrayList<Node> astlist] : ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )* CRPAR )* ;
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
		Node vine =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:4: ( ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )* CRPAR )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:45:6: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )* CRPAR )*
			{
			 
				     astlist = new ArrayList<Node>() ;
				     int offset      = -2;
				     int classoffset = -2;
				     CTentry extendedEntry = null;
				     CTentry ctentry       = null;
				   
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:52:5: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:52:6: CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist143); 
					cid=(Token)match(input,ID,FOLLOW_ID_in_cllist147); 

					         ClassNode Obj = new ClassNode((cid!=null?cid.getText():null));
					         astlist.add(Obj);
					         HashMap<String,STentry> hm = symTable.get(nestingLevel);
					         //HashMap<String,CTentry> hmClass = classTable.get(nestingClassLevel);                 
					         //HashMap<String,STentry> vTable = new HashMap<String,STentry>(); //ci va?
					         
					         STentry entryCl = new STentry(Obj,nestingLevel);
					         entryCl.setClassName((cid!=null?cid.getText():null));
					         ctentry = new CTentry(Obj,nestingClassLevel);
					         STentry tmp  = hm.put((cid!=null?cid.getText():null),entryCl);
					         CTentry tmp2 = classTable.put((cid!=null?cid.getText():null),ctentry);
					         
					         if (tmp != null && tmp2 != null)
					         {
					            System.out.println("Class id "+(cid!=null?cid.getText():null)+" at line "+(cid!=null?cid.getLine():0)+" already declared");
					            System.exit(0); 
					         }                
					         //creare una nuova hashmap per la symTable      
					        
					         nestingLevel++;
					         nestingClassLevel++;
					         HashMap<String,STentry> hmn = new HashMap<String,STentry>(); 
					         HashMap<String,STentry> vTable = new HashMap<String,STentry> (); //sicura sta cosa?
					         symTable.add(hmn);
					         virtualTable.add(vTable);
					      
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:80:6: ( EXTENDS cidext= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:80:7: EXTENDS cidext= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist163); 
							cidext=(Token)match(input,ID,FOLLOW_ID_in_cllist167); 

								     
							         // HashMap<String,STentry> hmSuper = classTable.get(nestingClassLevel-1);
							           
							           // verifico che la classe estesa sia gi� stata dichiarata in precedenza 
							          // while (j>=0 && entry==null){
							           extendedEntry = classTable.get((cidext!=null?cidext.getText():null));
							          // }
							                 
							           if(extendedEntry == null){
							           System.out.println("Class id "+(cidext!=null?cidext.getText():null)+" at line "+(cidext!=null?cidext.getLine():0)+" not declared");
							              System.exit(0);
							           }
							           
							           
							           ArrayList<Node> tmpField  = (ArrayList<Node>) extendedEntry.getFields().clone(); //necessario per non rischiare di copiare il riferimento all'oggetto
							           ArrayList<Node> tmpMethod = (ArrayList<Node>) extendedEntry.getMethods().clone();
							           ctentry.setFields(tmpField);
							           ctentry.setMethods(tmpMethod);
							           Obj.setSuperEntry(extendedEntry);
							           Obj.setClassEntry(ctentry);
							           FOOLlib.putSuperType((cid!=null?cid.getText():null),(cidext!=null?cidext.getText():null));
								     
							}
							break;

					}

					match(input,LPAR,FOLLOW_LPAR_in_cllist192); 

					           ArrayList<Node> ConstrPar = new ArrayList<Node>();
					           //int clParOffset = 1;
					           int fieldOffset=-1;
					       
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:111:7: (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:111:8: p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )*
							{
							p1=(Token)match(input,ID,FOLLOW_ID_in_cllist212); 
							match(input,COLON,FOLLOW_COLON_in_cllist214); 
							pushFollow(FOLLOW_basic_in_cllist218);
							t1=basic();
							state._fsp--;


								       
								        ConstrPar.add(t1);
							          FieldNode Objfield = new FieldNode((p1!=null?p1.getText():null),t1,(cid!=null?cid.getText():null));
							          Obj.addField(Objfield);
							          ctentry.setFieldOffset(fieldOffset);
							          // STentry  tempEntry = new STentry(Objfield,nestingClassLevel,t1,fieldOffset);//modificato il 14_05
							          STentry  tempEntry = new STentry(Objfield,nestingLevel,t1,fieldOffset);
							          
							          if ( hmn.put((p1!=null?p1.getText():null),tempEntry) != null  )
							          {
							             System.out.println("Parameter id "+(p1!=null?p1.getText():null)+" at line "+(p1!=null?p1.getLine():0)+" already declared");
							             System.exit(0); 
							          }
							          
							          fieldOffset--;
							          //boolean flag = false;
							          //
							//            if(extendedEntry!=null) //per controllare se c'� stato un extends
							//           {
							//            for(int i =0;i< extendedEntry.getFields().size() ;i++) //cerco se c'� stato override
							//              if(extendedEntry.getFields().get(i).equals((p1!=null?p1.getText():null))) //in caso positivo, flag = true per cui non verr� aggiunta alla ctentry 
							//                {
							//                  //remove field?
							//                }
							//           }
							         // if(!flag)         
							           //ctentry.setField(Objfield); //controlla se il campo � gi� presente, in caso positivo si sta facendo ovveriding e quindi devo sovrascrivere (questa operazione viene fatta in setField)
							          //se p1 � anche in extendedEntry.getFields non lo aggiungiamo in symbolTable
							          ctentry.setFieldAndCheck(Objfield, (p1!=null?p1.getText():null));
							         
							          //nestingLevel++; //06_05 non so se vada bene
								     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:145:7: ( COMMA pn= ID COLON tn= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:145:8: COMMA pn= ID COLON tn= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist236); 
									pn=(Token)match(input,ID,FOLLOW_ID_in_cllist240); 
									match(input,COLON,FOLLOW_COLON_in_cllist242); 
									pushFollow(FOLLOW_basic_in_cllist246);
									tn=basic();
									state._fsp--;


										        ConstrPar.add(tn);
									          FieldNode ObjfieldN = new FieldNode((pn!=null?pn.getText():null),tn,(cid!=null?cid.getText():null));
									          Obj.addField(ObjfieldN);
									          ctentry.setFieldOffset(fieldOffset--);
									          //aggiunga del parametro nell'apposita collezione tenendo conto dell'overriding dei parametri
									          // FOOLlib.addParTuple((cid!=null?cid.getText():null), (pn!=null?pn.getText():null), FOOLlib.getParamRealOffset(Obj, (pn!=null?pn.getText():null)));
									          //  if ( hmn.put((pn!=null?pn.getText():null),new STentry(ObjfieldN,nestingClassLevel,tn,fieldOffset)) != null  )modificato il 14_05
									          if ( hmn.put((pn!=null?pn.getText():null),new STentry(ObjfieldN,nestingLevel,tn,fieldOffset)) != null  )
									          {
									             System.out.println("Parameter id "+(pn!=null?pn.getText():null)+" at line "+(pn!=null?pn.getLine():0)+" already declared");
									             System.exit(0); 
									          }
									          
									          ctentry.setFieldAndCheck(Objfield, (pn!=null?pn.getText():null));//va bene? 14_05
										     
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist268); 

						        ctentry.addType( new ArrowTypeNode(ConstrPar, Obj) ); //� esatto??????????
						     
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist284); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:167:9: ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:167:10: FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? vine= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist295); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist299); 
							match(input,COLON,FOLLOW_COLON_in_cllist301); 
							pushFollow(FOLLOW_basic_in_cllist305);
							retm=basic();
							state._fsp--;

							               
								           //creazione del nodo del metodo e set a true del flag indicante che si
							             // � all'interno di un metodo di classe 
							              
							             //isInMethod = true;
							             //inserimento di ID nella symtable
							             MethodNode f = new MethodNode((mid!=null?mid.getText():null),retm);                
							             //astlist.add(f);//giusto o da commentare???
							             HashMap<String,STentry> hmclass = virtualTable.get(nestingClassLevel);                    
							             //aggiunga del parametro nell'apposita collezione tenendo conto dell'overriding dei parametri
							             //FOOLlib.addMethodTuple((mid!=null?mid.getText():null), (cid!=null?cid.getText():null), FOOLlib.getMethodRealOffset(Obj,(mid!=null?mid.getText():null)));
							             //STentry entry = new STentry(nestingClassLevel,f,classoffset++); //modificato il 14_05
							             STentry entry = new STentry(nestingLevel,f,classoffset++);
							             entry.setIsMethod();  
							             entry.setMethodName((mid!=null?mid.getText():null));           
							             if ( hmclass.put((mid!=null?mid.getText():null),entry) != null  )
							             {
							                System.out.println("Method id "+(mid!=null?mid.getText():null)+" at line "+(mid!=null?mid.getLine():0)+" already declared");
							                System.exit(0); 
							             }
							             nestingClassLevel++;
							             nestingLevel++; //06_05 non so se vada bene
							             HashMap<String,STentry> hmnc = new HashMap<String,STentry> ();
							             virtualTable.add(hmnc);
							             ctentry.setMethod(f);
							             Obj.setMethod(f);
							             symTable.add(hmnc);
							             //creare una nuova hashmap per la symTable
							             // nestingLevel++;
							             // HashMap<String,STentry> hmnc = new HashMap<String,STentry> (); //hmnc � la vTable
							             //symTable.add(hmnc);
								       
							match(input,LPAR,FOLLOW_LPAR_in_cllist325); 

								          ArrayList<Node> parTypes = new ArrayList<Node>();
							            int parOffset = 1;
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:205:9: (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:205:10: mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )*
									{
									mp1=(Token)match(input,ID,FOLLOW_ID_in_cllist349); 
									match(input,COLON,FOLLOW_COLON_in_cllist351); 
									pushFollow(FOLLOW_type_in_cllist355);
									mpt1=type();
									state._fsp--;


										          parTypes.add(mpt1);
									            ParNode fpar = new ParNode((mp1!=null?mp1.getText():null),mpt1);
									            
									            f.addPar(fpar);
									            
									              if ( hmnc.put((mp1!=null?mp1.getText():null),new STentry(fpar,nestingLevel,mpt1,parOffset++)) != null  ){
									               System.out.println("Parameter id "+(mp1!=null?mp1.getText():null)+" at line "+(mp1!=null?mp1.getLine():0)+" already declared");
									               System.exit(0);
									               }
									            
									            //nestingLevel++;
									            /*
									            if(mpt1.text.equals("ClassTypeNode")
									            {
									             //  STentry entryCl2 = new STentry(Obj,nestingLevel);
									               entryCl.setClassName((cid!=null?cid.getText():null));
									             //  ctentry = new CTentry2(Obj,nestingClassLevel);
									               STentry tmp2  = hm.put((cid!=null?cid.getText():null),entryCl);
									               CTentry tmp22 = classTable.put((cid!=null?cid.getText():null),ctentry);
									         
									         if (tmp2 != null && tmp22 != null)
									         {
									            System.out.println("Class id "+(cid!=null?cid.getText():null)+" at line "+(cid!=null?cid.getLine():0)+" already declared");
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
									            // if ( hmnc.put((mp1!=null?mp1.getText():null),new STentry(fpar,nestingLevel,mpt1,parOffset++)) != null  )
										          // if ( entry.put((mp1!=null?mp1.getText():null),new STentry(fpar,nestingLevel,mpt1,parOffset++)) != null  )
										          // {
										          //     System.out.println("Parameter id "+(mp1!=null?mp1.getText():null)+" at line "+(mp1!=null?mp1.getLine():0)+" already declared");
										          //     System.exit(0); 
										          // }
										          
									            
										       
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:251:9: ( COMMA mpn= ID COLON mptn= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:251:10: COMMA mpn= ID COLON mptn= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist377); 
											mpn=(Token)match(input,ID,FOLLOW_ID_in_cllist381); 
											match(input,COLON,FOLLOW_COLON_in_cllist383); 
											pushFollow(FOLLOW_type_in_cllist387);
											mptn=type();
											state._fsp--;


												          parTypes.add(mptn);
											            ParNode par = new ParNode((mpn!=null?mpn.getText():null),mptn);
											            f.addPar(par);
											            if ( hmnc.put((mpn!=null?mpn.getText():null),new STentry(fpar,nestingLevel,mptn,parOffset++)) != null  ){
											               System.out.println("Parameter id "+(mpn!=null?mpn.getText():null)+" at line "+(mpn!=null?mpn.getLine():0)+" already declared");
											               System.exit(0);
											               }
											               //nestingLevel++;
											            // if ( hmnc.put((mpn!=null?mpn.getText():null),new STentry(par,nestingLevel,mptn,parOffset++)) != null  )
											            // if ( entry.put((mpn!=null?mpn.getText():null),new STentry(par,nestingLevel,mptn,parOffset++)) != null  )
											            // {
											            //     System.out.println("Parameter id "+(mpn!=null?mpn.getText():null)+" at line "+(mpn!=null?mpn.getLine():0)+" already declared");
											            //     System.exit(0); 
											            // }
												       
											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist404); 

								          entry.addType( new ArrowTypeNode(parTypes , retm) );
							            ArrayList<Node> letInMethodList = new ArrayList<Node>();       
							            
							            
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:274:9: ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:274:10: LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist425); 
									int innerOs = -2; 
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:275:9: ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:275:10: VAR vid= ID COLON vt= type ASS ve= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist438); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist442); 
											match(input,COLON,FOLLOW_COLON_in_cllist444); 
											pushFollow(FOLLOW_type_in_cllist448);
											vt=type();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist450); 
											pushFollow(FOLLOW_exp_in_cllist454);
											ve=exp();
											state._fsp--;


												          VarNode v = new VarNode((vid!=null?vid.getText():null),vt,ve);
											            // letInMethodList.add(v); 
											            astlist.add(v);
											            HashMap<String,STentry> varhm = symTable.get(nestingLevel);
											            //HashMap<String,STentry> hmv = symTable.get(nestingLevel);
											            // HashMap<String,STentry> hmv = classTable.get(nestingClassLevel);
											            if ( varhm.put((vid!=null?vid.getText():null),new STentry(v,nestingLevel,vt,nestingLevel--)) != null  )
											            {
											               System.out.println("Var id "+(vid!=null?vid.getText():null)+" at line "+(vid!=null?vid.getLine():0)+" already declared");
											               System.exit(0); 
											            } 
											            // nestingLevel++;  
											          
											match(input,SEMIC,FOLLOW_SEMIC_in_cllist475); 
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist479); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist486);
							vine=exp();
							state._fsp--;


								            //chiudere scope                       
							              symTable.remove(nestingLevel--);  //� corretto? 06_05
							              virtualTable.remove(nestingClassLevel--);           
							              f.addBody(vine);
							              //aggiungo il metodo alla classe
							              Obj.addMethod(f); 
							              // isInMethod = false;
								        
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist508); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist519); 
					}
					break;

				default :
					break loop10;
				}
			}


			          //codice per l'ereditariet�
			            if(extendedEntry != null) //se � null allora non c'� stata ereditariet�
			            {
			                boolean flag = true;   //controllo che non ci sia stato overriding
			                ArrayList<Node> fieldsExt = extendedEntry.getFields();
			                ArrayList<Node> methodsExt = extendedEntry.getMethods();
			                STentry tempEntry = null;
			                int jj = nestingClassLevel;
			                
			                
			                for(int i = 0; i < fieldsExt.size(); i ++)//controllo ogni field della classe ereditata con ogni field della classe base, i simboli senza overriding vengono aggiunti in vTable
			                {
			                  flag = true; //se e' true non c'� stato overriding, false altrimenti
			                  
			                  for(int j = 0; j < ctentry.getFields().size(); j ++)
			                  { 
			                    if(( (FieldNode) fieldsExt.get(i)).getName().equals(((FieldNode) ctentry.getFields().get(j)).getName()) )
			                    {
			                        flag = false;
			                        break;
			                    }
			                  }
			                  
			                  if(flag)                 
			                  {
			                      jj = nestingClassLevel; //perch� jj viene diminuito e quindi ad ogni iterazione va resettato
			                                       
			                      while (jj>=0 && tempEntry==null)
			                      {                         
			                          tempEntry=(virtualTable.get(jj--)).get(((FieldNode)fieldsExt.get(i)).getName());                                                        
			                          //� da aggiungere il check di tipo di parametri/metodi
			                      }
			                          ctentry.addvTable(tempEntry, ((FieldNode)fieldsExt.get(i)).getName());
			                          ctentry.setField(fieldsExt.get(i));
			                                                         
			                  }
			                
			                }
			                
			                for(int i = 0; i < methodsExt.size(); i ++) //strategia analoga ai Fields
			                {       
			                  flag = true;                                                    
			                  
			                  for(int j = 0; j < ctentry.getMethods().size(); j ++)
			                  {                                               
			                    if(( (MethodNode) methodsExt.get(i)).getName().equals(((MethodNode) ctentry.getMethods().get(j)).getName()) )
			                      {
			                         flag = false;
			                         break;
			                      } 
			                                    
			                  }
			                  
			                  if(flag)
			                  {
			                      jj = nestingClassLevel;
			                      while (jj>=0 && tempEntry==null)
			                       {                         
			                           tempEntry=(virtualTable.get(jj--)).get(((MethodNode)methodsExt.get(i)).getName());                                
			                       }
			                    
			                     
			                    //� da aggiungere il check di tipo di parametri/metodi
			                    ctentry.addvTable(tempEntry, ((MethodNode)methodsExt.get(i)).getName());
			                    ctentry.setMethod(methodsExt.get(i));
			                   } 
			                } 
			                                                    
			              } 
			              //fine codice per l'ereditariet�  
			      
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:376:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* ;
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:377:2: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:377:4: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			{

				    astlist = new ArrayList<Node>() ;
				    int offset=-2;
				  
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:381:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==FUN||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:382:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:382:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:383:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist576); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist580); 
							match(input,COLON,FOLLOW_COLON_in_declist582); 
							pushFollow(FOLLOW_type_in_declist586);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist588); 
							pushFollow(FOLLOW_exp_in_declist592);
							e=exp();
							state._fsp--;


							          VarNode v = new VarNode((i!=null?i.getText():null),t,e);
							          astlist.add(v);
							          //System.out.println("type: "+t + "var "+(i!=null?i.getText():null));
							          if(t instanceof ArrowTypeNode)
							          {
							             offset-=2;
							          }
							          System.out.println("[FOOL.g] VAR    "+ v.toPrint(""));
							            
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);
							          
							          if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  ){
							             System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							             System.exit(0);
							          }
							       
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:402:8: FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist619); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist623); 
							match(input,COLON,FOLLOW_COLON_in_declist625); 
							pushFollow(FOLLOW_basic_in_declist629);
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
							       
							match(input,LPAR,FOLLOW_LPAR_in_declist647); 
							 ArrayList<Node> parTypes = new ArrayList<Node>(); int paroffset=1; 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:420:8: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:421:10: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist672); 
									match(input,COLON,FOLLOW_COLON_in_declist674); 
									pushFollow(FOLLOW_type_in_declist678);
									fty=type();
									state._fsp--;


										          parTypes.add(fty); 
										          ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
										          
										          if(fty instanceof ArrowTypeNode)
									            {
									               paroffset+=2;
									               System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" � di tipo funzionale");
									            } 
										          
										          f.addPar(fpar);
										                             
										          if ( hmn.put((fid!=null?fid.getText():null),new STentry(fpar,nestingLevel,fty,paroffset++)) != null  ){
										             System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
										             System.exit(0);
										          }
									         
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:439:10: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:440:12: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist713); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist717); 
											match(input,COLON,FOLLOW_COLON_in_declist719); 
											pushFollow(FOLLOW_type_in_declist723);
											ty=type();
											state._fsp--;


													           parTypes.add(ty); 
													           ParNode par = new ParNode((id!=null?id.getText():null),ty);
													           if(fty instanceof ArrowTypeNode)
													           {
													              paroffset+=2;
													              System.out.println("Parameter id "+(id!=null?id.getText():null)+" � di tipo funzionale:");
											               } 
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

							match(input,RPAR,FOLLOW_RPAR_in_declist768); 
							 entry.addType( new ArrowTypeNode(parTypes, t) ); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:458:8: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:458:10: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist782); 
									pushFollow(FOLLOW_declist_in_declist786);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist788); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist813);
							e=exp();
							state._fsp--;

							//chiudere scope
							          symTable.remove(nestingLevel--);
							          f.addDecBody(d, e);//abbiamo cambiato add body con addDecBody (dichiarazione dei parametri ed espressione del corpo della funzione)
							       
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist833); 
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:469:1: type returns [Node ast] : (bas= basic |art= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node bas =null;
		Node art =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:470:9: (bas= basic |art= arrow )
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:470:11: bas= basic
					{
					pushFollow(FOLLOW_basic_in_type867);
					bas=basic();
					state._fsp--;

					ast = bas;
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:471:11: art= arrow
					{
					pushFollow(FOLLOW_arrow_in_type883);
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:474:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:475:3: ( INT | BOOL |i= ID )
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:475:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic911); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:476:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic926); 
					ast =new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:477:11: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic943); 

					         int jj = nestingClassLevel;    
					         STentry classEntry = null;    
					         while (jj>=0 && classEntry==null){
					           classEntry=(symTable.get(jj--)).get((i!=null?i.getText():null));         
					         }       
					                  if(classEntry != null)
					                  {
					                    ast =new ClassTypeNode((i!=null?i.getText():null));                  
					                   }
					                  else
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:496:1: arrow returns [Node ast] : LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node funParT =null;
		Node funParTy =null;
		Node retTy =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:497:9: ( LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:497:11: LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow972); 

			            //creazione di una lista vuota per i parametri
			            ArrayList<Node> funParTypes = new ArrayList<Node>();
			          
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:502:11: (funParT= type ( COMMA funParTy= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:503:13: funParT= type ( COMMA funParTy= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1013);
					funParT=type();
					state._fsp--;


					              funParTypes.add(funParT);
					            
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:507:13: ( COMMA funParTy= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:507:14: COMMA funParTy= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1043); 
							pushFollow(FOLLOW_type_in_arrow1047);
							funParTy=type();
							state._fsp--;


							              funParTypes.add(funParTy);
							            
							}
							break;

						default :
							break loop18;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow1079); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1081); 
			pushFollow(FOLLOW_basic_in_arrow1085);
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:517:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:518:3: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:518:5: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1117);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:519:7: ( PLUS l= term | MINUS l= term | OR l= term )*
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:520:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1136); 
					pushFollow(FOLLOW_term_in_exp1140);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:521:10: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1154); 
					pushFollow(FOLLOW_term_in_exp1158);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:522:10: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1171); 
					pushFollow(FOLLOW_term_in_exp1175);
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:526:1: term returns [Node ast] : f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:527:2: (f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:527:4: f= factor ( MULT l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1209);
			f=factor();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:528:6: ( MULT l= factor | DIV l= factor | AND l= factor )*
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:529:7: MULT l= factor
					{
					match(input,MULT,FOLLOW_MULT_in_term1226); 
					pushFollow(FOLLOW_factor_in_term1230);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:530:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1242); 
					pushFollow(FOLLOW_factor_in_term1247);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:531:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1259); 
					pushFollow(FOLLOW_factor_in_term1264);
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:535:1: value returns [Node ast] : (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? );
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:536:2: (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? )
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:536:4: i= INTEGER
					{
					i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1291); 
					ast = new NatNode(Integer.parseInt((i!=null?i.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:537:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1300); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:538:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1309); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:539:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1317); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:540:5: NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1326); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1330); 

					       CTentry ctEntry=null; 
					       ctEntry=classTable.get((i!=null?i.getText():null));
					       
					       // Debug statements...
					//       List keys = new ArrayList(classTable.keySet());
					//			 for (int j = 0; j < keys.size(); j++) {
					//				    Object obj = keys.get(j);
					//				    System.out.println("[FOOL.g] classTable ["+j+"] = "+obj);
					//			 }
					//			 System.out.println("[FOOL.g] i.text = "+(i!=null?i.getText():null));
					//			 System.out.println("[FOOL.g] classTable entry = "+classTable.get((i!=null?i.getText():null)));
					//       System.out.println("[FOOL.g] entry.getType() = "+ ctEntry.getType());
					//       System.out.println("[FOOL.g] NEW \""+(i!=null?i.getText():null)+"\" -> num of Fields = "+ ctEntry.getFields().size());
					//       for(int j=0; j<ctEntry.getFields().size(); j++){
					//          System.out.println("[FOOL.g] \tfield "+j+" = "+ ((FieldNode)ctEntry.getFields().get(j)).getName());
					//       }
					//       System.out.println("[FOOL.g] NEW \""+(i!=null?i.getText():null)+"\" -> num of Methods = "+ ctEntry.getMethods().size());
					//       for(int j=0; j<ctEntry.getMethods().size(); j++){
					//          System.out.println("[FOOL.g] \tmethod "+j+" = "+ ((MethodNode)ctEntry.getMethods().get(j)).getName());
					//       }
					       // ...End debug statements
					       
					       if(ctEntry==null)
					       {
					          System.out.println("Class "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!!!!");
					          System.exit(0); 
					       }
					    
					match(input,LPAR,FOLLOW_LPAR_in_value1342); 

					       ArrayList<Node> argList = new ArrayList<Node>();
					    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:574:5: (fa= exp ( COMMA a= exp )* )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==FALSE||(LA23_0 >= ID && LA23_0 <= IF)||LA23_0==INTEGER||LA23_0==LPAR||(LA23_0 >= NEW && LA23_0 <= NULL)||LA23_0==PRINT||LA23_0==TRUE) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:574:6: fa= exp ( COMMA a= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1357);
							fa=exp();
							state._fsp--;


							       argList.add(fa);
							       //ctEntry.setField(fa);
							    
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:579:7: ( COMMA a= exp )*
							loop22:
							while (true) {
								int alt22=2;
								int LA22_0 = input.LA(1);
								if ( (LA22_0==COMMA) ) {
									alt22=1;
								}

								switch (alt22) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:579:8: COMMA a= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1372); 
									pushFollow(FOLLOW_exp_in_value1376);
									a=exp();
									state._fsp--;


										        argList.add(a);
										        // ctEntry.setField(a);
										     
									}
									break;

								default :
									break loop22;
								}
							}

							}
							break;

					}


					          //qui ci devo fare qualcosa?
					          //creo il nuovo nodo che istanzia la classe
					            //ClassCallNode c= new ClassCallNode((i!=null?i.getText():null),entry,argList,nNewClass);
					         // ast =c;
					         ast = new NewNode((i!=null?i.getText():null),ctEntry,argList);
					              
					//            se l'istanza della classe � all'interno di un metodo viene inserito il nodo relativo a tale istanza
					//            all'interno della lista contenente i nodi delle chiamate ai costruttori effettuate all'interno di metodi
					//            di classe, altrimenti viene aggiunto tale nodo alla lista contenente i nodi delle istanze effettuate
					//            fuori dai metodi di classe. Se si � in un metodo di classe viene incrementato anche il numero relativo 
					//            alle istanze effettuate all'interno di metodi di classe, altrimenti viene incrementato il contatore delle
					//            istanze create fuori da metodi di classe
					            
					//          if(!isInMethod) {
					//                nNewNotMethodClass++;
					//                callClassNodeNotInMethod.add(c);
					//            } else {
					//                nNewInMethodClass++;
					//              callClassNodeInMethod.add(c);
					//            }
					    
					match(input,RPAR,FOLLOW_RPAR_in_value1412); 
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:610:5: IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1427); 
					match(input,LPAR,FOLLOW_LPAR_in_value1429); 
					pushFollow(FOLLOW_exp_in_value1433);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1435); 
					match(input,THEN,FOLLOW_THEN_in_value1437); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1439); 
					pushFollow(FOLLOW_exp_in_value1443);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1445); 
					match(input,ELSE,FOLLOW_ELSE_in_value1455); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1457); 
					pushFollow(FOLLOW_exp_in_value1461);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1463); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:613:5: NOT LPAR x= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1479); 
					match(input,LPAR,FOLLOW_LPAR_in_value1481); 
					pushFollow(FOLLOW_exp_in_value1486);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1488); 
					ast = new NotNode(x);
					}
					break;
				case 8 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:614:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1497); 
					match(input,LPAR,FOLLOW_LPAR_in_value1499); 
					pushFollow(FOLLOW_exp_in_value1503);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1505); 
					ast = new PrintNode(e);
					}
					break;
				case 9 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:615:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1513); 
					pushFollow(FOLLOW_exp_in_value1517);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1519); 
					ast = e;
					}
					break;
				case 10 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:616:6: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1530); 
					//cercare la dichiarazione (cio� quando lo usa)
						    int j  = nestingLevel;
						    int jj = nestingClassLevel;
						    STentry entry     = null; 
						    STentry classEntry = null;
						    
						    // while (j>=0 && entry==null)
						    //  entry=(symTable.get(j--)).get((i!=null?i.getText():null));
						    for(j=0;j<symTable.size() && entry==null;j++)
						        entry=(symTable.get(j)).get((i!=null?i.getText():null));
						        
						    while (jj>=0 && classEntry==null){
					        classEntry=(virtualTable.get(jj--)).get((i!=null?i.getText():null));         
					        }
					         
						    if (entry == null ){
						       System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!");	       
						       System.exit(0);
						    }
						     	   
						    ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
						    
						    //inizia la parte OO
						    
						    String classInputName = "";
					      if(classEntry != null){
					        if(classEntry.getDecl() instanceof ParNode){
					          if( ((ParNode)classEntry.getDecl()).isParClass()){
					                    //System.out.println("SETTING " + (i!=null?i.getText():null) + " PARNODE " + initJ);
					               // classInputName =((ParNode)classEntry.getDecl()).getClassName();
					                //System.out.println("CLASS OF PAR " + classInputName + " name " + className);               
					          }
					        }
					      }
					           //System.out.println("PARSER ENTRY DECL " + entry.getDecl() + " -> "  +(i!=null?i.getText():null) + " OS " + entry.getOffset() + " CLNAME " + classInputName);
					           //System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0) + "   - j: " +j + " - nl: " + nestingLevel);
					         // System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0) + "   - j: " +j + " - nl: " + nestingLevel);
					           //if (entry==null){
					          //  System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
					              // System.exit(0); 
					         //  }    
					           //ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel-(j+1), classInputName, classFieldName,className);
					           //System.out.println("PARSER Id "+(i!=null?i.getText():null)+" ENTRY " + entry.getOffset());
					           //System.out.println(outClass);
					           
					           //
					           //ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel-(j+1), classInputName, outClass); //da reinserire
					           //         
					           //fine parte OO
					                
					                 
					    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:669:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
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
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:670:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1550); 
							 ArrayList<Node> argList = new ArrayList<Node>(); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:671:7: (fa= exp ( COMMA a= exp )* )?
							int alt25=2;
							int LA25_0 = input.LA(1);
							if ( (LA25_0==FALSE||(LA25_0 >= ID && LA25_0 <= IF)||LA25_0==INTEGER||LA25_0==LPAR||(LA25_0 >= NEW && LA25_0 <= NULL)||LA25_0==PRINT||LA25_0==TRUE) ) {
								alt25=1;
							}
							switch (alt25) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:671:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1564);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:9: ( COMMA a= exp )*
									loop24:
									while (true) {
										int alt24=2;
										int LA24_0 = input.LA(1);
										if ( (LA24_0==COMMA) ) {
											alt24=1;
										}

										switch (alt24) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:10: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1577); 
											pushFollow(FOLLOW_exp_in_value1581);
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


							        ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel-(j+1));
							      
							match(input,RPAR,FOLLOW_RPAR_in_value1613); 
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:678:8: DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1622); 
							cmid=(Token)match(input,ID,FOLLOW_ID_in_value1626); 

							       //int h = nestingLevel;
							       //int k = nestingClassLevel;
							       int h=symTable.size()-1;
							       int k=virtualTable.size()-1;
							       // System.out.println(""+(i!=null?i.getText():null));
							       STentry entryRealCl = null;
							       STentry entryM = null;
							       // String clName = ((ClassTypeNode)entry.getType()).getName();
							       //System.out.println("Class Name: "+clName);              
							     // ricerca della entry relativa alla classe dell'oggetto istanza su cui viene richiamato il metodo
							//       -ClassCallNode  ID1.ID2() 
							//        STentry dell'ID1 in campo "entry"
							//        STentry dell'ID2 in campo "methodEntry"
							//        (ID2 cercato in vTable della CTentry della classe del tipo di ID1)
							       while (h>=0 && entryRealCl==null){
							         entryRealCl=(symTable.get(h--)).get((i!=null?i.getText():null));
							         //Debug: System.out.println(">>>[FOOL.g] DOT  entryRealCl = "+ entryRealCl);
							         //System.out.println("Found 1 ciclo:" +(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0) + " j="+j + "     nl: " + nestingLevel);
							         //found=true;
							       }
							       //Debug: System.out.println("[FOOL.g] Debug: End while cycle. EntryRealCl: "+entryRealCl);
							//       if(entryRealCl==null)
							//       {
							//          System.out.println("entryRealCl alla line 682 del file FOOL.g � null");
							          //System.exit(0); 
							//       }
							       
							       //ricerca dell'entry del metodo all'interno della classe relativa ad esso trovata in precedenza
							       
							     //  k = entryRealCl.getNestingLevel() + 1;  da reinserire
							       //System.out.println("N Real Cl: " + k + " clName: " + clName + " -> " + (i!=null?i.getText():null) + " " + (i!=null?i.getLine():0));
							       while (k>=0 && entryM==null){
							         entryM = (virtualTable.get(k--)).get((cmid!=null?cmid.getText():null));
							         // Debug: System.out.println("entryM= "+ entryM);
							         //System.out.println("Found 1 ciclo:" +(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0) + " j="+j + "     nl: " + nestingLevel);
							         //found=true;
							       }
							       // Debug: System.out.println("Debug: end while cycle. entryM: "+entryM);
							       
							       if (entryM==null){
							         System.out.println("Method Call "+(cmid!=null?cmid.getText():null)+" at line "+(cmid!=null?cmid.getLine():0)+" not declared");
							         System.exit(0); 
							       }
							                 
							                                
							// commenti degli altri STentry entryCl=(symTable.get(k)).get(clName);
							//                 if(entryCl == null){
							//                  ArrayList<String> clh = FOOLlib.getClassHierarchy(clName);
							//                  for(int p = 0; p < clh.size(); p++){
							//                    int f=nestingLevel;
							//                    //System.out.println("Cur Class: " + clh.get(p));
							//                    if(FOOLlib.getMethodTuple((cmid!=null?cmid.getText():null), clh.get(p)) != null) {
							//                    while (f>=0 && entryCl==null){
							//                       entryCl=(symTable.get(f--)).get(clh.get(p));
							//                       //System.out.println("Found :" +f);
							//                       //found=true;
							//                    }
							//                    break;
							//                  }
							//                  }
							//                 }
							                 
							    
							match(input,LPAR,FOLLOW_LPAR_in_value1639); 

							        ArrayList<Node> mArgList = new ArrayList<Node>();
							     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:747:6: (cmex1= exp ( COMMA cmexn= exp )* )?
							int alt27=2;
							int LA27_0 = input.LA(1);
							if ( (LA27_0==FALSE||(LA27_0 >= ID && LA27_0 <= IF)||LA27_0==INTEGER||LA27_0==LPAR||(LA27_0 >= NEW && LA27_0 <= NULL)||LA27_0==PRINT||LA27_0==TRUE) ) {
								alt27=1;
							}
							switch (alt27) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:747:7: cmex1= exp ( COMMA cmexn= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1656);
									cmex1=exp();
									state._fsp--;


									        mArgList.add(cmex1);
									     
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:751:6: ( COMMA cmexn= exp )*
									loop26:
									while (true) {
										int alt26=2;
										int LA26_0 = input.LA(1);
										if ( (LA26_0==COMMA) ) {
											alt26=1;
										}

										switch (alt26) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:751:7: COMMA cmexn= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1671); 
											pushFollow(FOLLOW_exp_in_value1675);
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


							        
							        ast = new ClassCallNode((cmid!=null?cmid.getText():null), entryRealCl, entryM, mArgList, nestingLevel);
							     
							match(input,RPAR,FOLLOW_RPAR_in_value1708); 
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
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:765:1: factor returns [Node ast] : f= value ( EQ l= value | GR l= value | LE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:766:5: (f= value ( EQ l= value | GR l= value | LE l= value )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:766:7: f= value ( EQ l= value | GR l= value | LE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1752);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:767:5: ( EQ l= value | GR l= value | LE l= value )*
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:768:9: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1770); 
					pushFollow(FOLLOW_value_in_factor1774);
					l=value();
					state._fsp--;

					ast = new EqualNode(ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:769:9: GR l= value
					{
					match(input,GR,FOLLOW_GR_in_factor1786); 
					pushFollow(FOLLOW_value_in_factor1790);
					l=value();
					state._fsp--;

					ast = new GreaterOrEqualNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:770:9: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1803); 
					pushFollow(FOLLOW_value_in_factor1807);
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



	public static final BitSet FOLLOW_exp_in_prog40 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog56 = new BitSet(new long[]{0x0000040001100100L});
	public static final BitSet FOLLOW_cllist_in_prog84 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_prog89 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_prog91 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_prog95 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist143 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist147 = new BitSet(new long[]{0x0000000020040000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist163 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist167 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist192 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist212 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist214 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist218 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist236 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist240 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist242 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist246 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist268 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist284 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_FUN_in_cllist295 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist299 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist301 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist305 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist325 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist349 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist351 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist355 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist377 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist381 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist383 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist387 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist404 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_cllist425 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_VAR_in_cllist438 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist442 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist444 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist448 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist450 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist454 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist475 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_IN_in_cllist479 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist486 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist508 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist519 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist576 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist580 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist582 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist586 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist588 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist592 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist619 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist623 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist625 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_declist629 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist647 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_declist672 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist674 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist678 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist713 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist717 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist719 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist723 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist768 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_declist782 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_declist786 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_declist788 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist813 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist833 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_basic_in_type867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow972 = new BitSet(new long[]{0x0000004022400080L});
	public static final BitSet FOLLOW_type_in_arrow1013 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow1043 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_arrow1047 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow1079 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1081 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_arrow1085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp1117 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1136 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1140 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1154 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1158 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp1171 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1175 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term1209 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_MULT_in_term1226 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1230 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_DIV_in_term1242 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1247 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_AND_in_term1259 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1264 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_INTEGER_in_value1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1326 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1330 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1342 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1357 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1372 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1376 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1427 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1429 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1433 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1435 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1437 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1439 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1443 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1445 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_value1455 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1457 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1461 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1479 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1481 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1486 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1497 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1499 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1503 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1513 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1517 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1530 = new BitSet(new long[]{0x0000000020004002L});
	public static final BitSet FOLLOW_LPAR_in_value1550 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1564 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1577 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1581 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1622 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1626 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1639 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1656 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1671 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1675 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1752 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_EQ_in_factor1770 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1774 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_GR_in_factor1786 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1790 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_LE_in_factor1803 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1807 = new BitSet(new long[]{0x0000000008210002L});
}
