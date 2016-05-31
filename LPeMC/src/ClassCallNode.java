import java.util.ArrayList;

public class ClassCallNode implements Node {

	private String id;
	private STentry entry; 
	private STentry methodEntry;
	private CTentry ctentry;
	private ArrayList<Node> par = new ArrayList<Node>();
	private int nl;


	public ClassCallNode (String i, STentry e,STentry me, ArrayList<Node> p, int n, CTentry c) {
		id=i;
		entry=e;
		methodEntry = me;
		par = p;
		nl = n;
		ctentry = c;
	}
	public String toPrint(String s) {

		String str = s+"CALL CLASS " + id + " \n"+s+"  Parameters type: \n";
		for(int j=0;j < par.size();j++){
			str += s+"   "+par.get(j).toPrint(s+" ");
		}
		return str;
	}


	public Node typeCheck() {
		/*
		 ArrowTypeNode classAtn = (ArrowTypeNode)((ClassNode)((ArrowTypeNode)entry.getType()).getRet()).typeCheck();
		  if(classAtn.getPar().size() != par.size()) {
			  System.out.println("Wrong parameter's number for constructor of " + id);
		}

		for(int i = 0; i < par.size(); i++) {
			  Node curP = par.get(i);
			  if (!(FOOLlib.isSubtype(curP.typeCheck(), classAtn.getPar().get(i).typeCheck()))){
			        System.out.println("Wrong type for constructor of " + id);
			        //System.exit(0); 
			  }
		  }
		  return new ClassTypeNode(((ClassNode)classAtn.getRet()).getName());
		 */
		ArrowTypeNode t=null;
		if (methodEntry.getType() instanceof ArrowTypeNode) 
			t=(ArrowTypeNode) methodEntry.getType(); 
		else {
			System.out.println("Invocation of a non-method: "+id);
			System.exit(0);
		}
		if(par != null)
		{
			ArrayList<Node> p = t.getParList();	// otteniamo la lista dei tipi dei parametri formali
			if ( !(p.size() == par.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di parametri passati in input.
				System.out.println("Wrong number of parameters in the invocation of "+id);
				System.exit(0);
			}
			// ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypeNode)
			for (int i=0; i< par.size(); i++)
			{
				if ( !( FOOLlib.isSubtype( p.get(i), (par.get(i)).typeCheck()) ) ){ 
					// !(FOOLlib.isSubtype((p.get(i)),(parlist.get(i)).typeCheck())) //nei parametri il nodo a deve essere supertipo perchè applichiamo la controvarianza
					System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of: "+id+"().  Type required: "+ p.get(i) +". Type passed: "+ (par.get(i)).typeCheck());
					// ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypNode)
					for (int i1=0; i1< par.size(); i1++) 
						if (
								!(FOOLlib.isSubtype( p.get(i1), par.get(i1).typeCheck() ) ) 
								// !(FOOLlib.isSubtype((p.get(i)),(parlist.get(i)).typeCheck())) //nei parametri il nodo a deve essere supertipo perchè applichiamo la controvarianza
								) {
							System.out.println("Wrong type for "+(i1+1)+"-th parameter in the invocation of: "+id);
							System.exit(0);
						}
				}
			}
		}
		return t.getRet();
	}


	public String codeGeneration() {

		int offsetNewInn=0;
		String parCode = "";	// codice per la prima parte dell'activation record (vedi file "progettiamo il nostro layout" nell'esercitazione 12_04).
		for(int i=par.size()-1; i>=0; i--){
			parCode += par.get(i).codeGeneration();
		}

		String getAR2 = "";
		for(int i=0; i< nl - methodEntry.getNestinglevel(); i++){ 
			getAR2 += "lw\n";
		}
		
		String getAR = "";
		for(int i=0; i< nl - entry.getNestinglevel(); i++){ 
			getAR += "lw\n";
		}
//		for(int i =0; i < ctentry.getFields().size();i++) non serve
//			if(((FieldNode)ctentry.getFields().get(i)).getSymType() instanceof ClassTypeNode)
//			{
//				//offsetNewInn++;
//			}

		/**		   
		 * recupera valore dell'ID1 (object pointer) dall'AR dove è dichiarato 
			 con meccanismo usuale di risalita catena statica
		 */
		return 
				"lfp\n"+		// CL
				parCode+	// parametri
				"lfp\n"+
				//"CLASSCALLNODE\n"+
				getAR+
				"push "+entry.getOffset()+"\n"+
				"add\n"+
				"lw\n"+
				//ora ho in cima allo stack l'obj pointer 
				"lfp\n"+
				getAR+
				"push "+entry.getOffset()+"\n"+
				"add\n"+
				"lw\n"+	
				
				"push "+methodEntry.getOffset()+"\n"+		  		
				"add\n"+
				"lw\n"+
				"js\n";

	}

	public String getClassName(){
		return ((ClassNode)((ArrowTypeNode)entry.getType()).getRet()).getName();

	}


}
