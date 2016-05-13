import java.util.ArrayList;

public class ClassNode implements Node{
	private Node sc;
	private String name;
	private ArrayList<Node> dec = new ArrayList<Node>();
	private ArrayList<Node> fields = new ArrayList<Node>();
	private ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
	private CTentry classEntry;
	private CTentry superEntry;
	
	public ClassNode(String id){
		name = id;
	}

	public String getName() {
		return name;
	}

	public void setSuperEntry(CTentry sE)
	{
		superEntry = sE;
	}
	
	public void setClassEntry(CTentry cE)
	{
		classEntry = cE;
	}
	
	
	public String toPrint(String s) {
		String ret = s+"Class "+name+"\n" + s + "   " + (fields.size() > 0 ? " parameters:" : "") + " \n";
	    for(int j=0;j < fields.size();j++){
	      ret += s+fields.get(j).toPrint(s+" ")+"\n";
	    }

	    if(sc != null && (sc instanceof ClassNode)){
	    	ret += s+"superclass: "+(((ClassNode)sc).getName())+"\n";
	    }
	    
	    int i;
	    if (dec != null ){
		      ret += s+"body:\n";
		    for(i=0;i < dec.size();i++){
		      ret += s+dec.get(i).toPrint(s+" ")+"\n";
		    }
	    }
	    return ret;
	}

	public Node typeCheck() {
		/*
		ArrayList<Node> uniq = FOOLlib.getTotalDecMethodsAndFields(this);
		ArrayList<Node> pt = new ArrayList<Node>();
		for(Node n : uniq) {
			if(n instanceof FunNode) {
				((FunNode)n).typeCheck();
			} else if (n instanceof ParNode) {
			      pt.add(((ParNode)n).typeCheck());
			}
		}
		
	    return new ArrowTypeNode (pt, this);
	    */
		
		if(superEntry != null)//cioè se c'è ereditarietà
		{
			// ***** MARCO: secondo me qui c'è un problema. Invece di controllare tutti i tipi del child con tutti i tipi dei parametri del parent
			// dovremmo usare una variabile boolean flag che viene resettata dentro il primo ciclo (for(i...)) e che diventa true se c'è un riscontro (isSubtype restituisce True) nel secondo ciclo (for(j...)). 
			// Una volta fuori dal secondo ciclo ci sarebbe un controllo if(flag == false){ System.exit(0); }
			/*for(int i = 0; i < classEntry.allFields.size(); i++)
			{
				for(int j = 0; j < superEntry.allFields.size(); j++)
				{
					if(!FOOLlib.isSubtype(((FieldNode)classEntry.allFields.get(i)).getSymType(), 
							((FieldNode)superEntry.allFields.get(j)).getSymType()))
					{
						System.out.println("Wrong field type in field "+ 
								((FieldNode)superEntry.allFields.get(j)).getName() +" for class "+ name);
						System.exit(0);
					}
				}
			}
			*/
			/* 
			 * Checking the type of the fields in the child class to see if they match the parent class' fields' types.
			 */
			boolean flag = false;
			int i = 0;
			int j = 0;
			while( i < classEntry.allFields.size() )
			{
				while( j < superEntry.allFields.size() )
				{
					if( FOOLlib.isSubtype(((FieldNode)classEntry.allFields.get(i)).getSymType(), 
						((FieldNode)superEntry.allFields.get(j)).getSymType()) ){
						flag = true;
						break;
					}
					
					j++;
				}
				
				if(!flag)	// If no match has been found... 
				{
					System.out.println("Wrong field type in field "+ 
							((FieldNode)superEntry.allFields.get(j)).getName() +" for class "+ name);
					System.exit(0);
				}
				
				i++;
			}
			
			/*
			 * Checking the types of the methods and their parameters with the parent class' methods.
			 */
			i=0;
			flag=false;
			while( i < classEntry.allMethods.size() )
			{
				j=0;
				while( j < superEntry.allMethods.size() )
				{
//					System.out.println("class SymType:"+((MethodNode)classEntry.allMethods.get(i)).getSymType()
//							+" for class "+name);
//					System.out.println("super SymType:"+((MethodNode)superEntry.allMethods.get(j)).getSymType()
//							+" for class "+name);
					if( FOOLlib.isSubtype(((MethodNode)classEntry.allMethods.get(i)).getSymType(), 
							((MethodNode)superEntry.allMethods.get(j)).getSymType()) )
					{
						flag = true;
						break;
					}
					
					j++;
				}
				
				if(!flag){
					System.out.println("class method name:"+((MethodNode)classEntry.allMethods.get(i)).getName()
							+" for class "+name);
					System.out.println("super method name:"+((MethodNode)superEntry.allMethods.get(j)).getName()
							+" for class "+name);
					
					System.out.println("Wrong method type in method "+ 
							((MethodNode)superEntry.allMethods.get(j)).getName()+" for class: "+name);
					System.exit(0);
				}
				
				i++;
			}
		}
		
		//return new ClassTypeNode();
		return new ClassTypeNode(name); //non siamo sicuri.
	}
	
	public ParNode getBodyParamByName(String name) {
		/*
		for(ClassNode n = this; n != null; n=(ClassNode)n.getSuperClass()) {
			for(int i = 0; i < n.getPar().size(); i++){
				if(n.getPar().get(i) instanceof ParNode) {
					if(((ParNode)n.getPar().get(i)).getName().equals(name)) {
						return ((ParNode)n.getPar().get(i));
					}
				}
			}
		}*/
		return null;
	}
	
	public FunNode getBodyFunctionByName(String name) {
		/*
		for(ClassNode n = this; n != null; n=(ClassNode)n.getSuperClass()) {
			for(int i = 0; i < n.getBody().size(); i++){
				if(n.getBody().get(i) instanceof FunNode) {
					if(((FunNode)n.getBody().get(i)).getName().equals(name)) {
						return ((FunNode)n.getBody().get(i));
					}
				}
			}
		}*/
		return null;
	}

	public FunNode getOnlyThisBodyFunctionByName(String name) {
	/*		for(int i = 0; i < dec.size(); i++){
			if(dec.get(i) instanceof FunNode) {
				if(((FunNode)dec.get(i)).getName().equals(name)) {
					return ((FunNode)dec.get(i));
				}
			}
		}*/
		return null;
	}

	public void addSuperClass(Node superClass){
		/*FOOLlib.addClassHierarchy(((ClassNode)superClass).getName(), this.name);
		sc = superClass;*/
	}

	public Node getSuperClass() {
		return sc;
	}
	
	public void addField(Node f){
		fields.add(f);
	}
	
	public ArrayList<Node> getPar(){
		return fields;
	}

	public ArrayList<Node> getBody(){
		return dec;
	}
	
	public void addMethod(Node method){
		dec.add(method);
	}
	
	public String getMethodCodeGen(){
		// prelievo di tutti i metodi e parametri della classe e delle superclassi considerando l'override
		/*
		ArrayList<Node> uniq = FOOLlib.getTotalDecMethodsAndFields(this);
		String decCode = "";
		//System.out.println("Generazione ClassNode " + name + " size: " + uniq.size());

		/*
		 * prelievo del nome composto di tale classe e relativa variabile all'interno della struttura per indicizzare le classi;
		 * set del nome composto di questa classe e relativa size in modo da indicizzarla nell'heap nel caso in cui venga costruito correttamente il nome composto
		 */
		/*
		String constrName = FOOLlib.getVarNameForClass(false);
		FOOLlib.setLastVarNameForClass(constrName);
		if(constrName != null){
			FOOLlib.putClassIndex(constrName, uniq.size()+1);
		}

		//System.out.println("Class " + name + " size " + (uniq.size() + 1));
		for(int i = 0; i < uniq.size() ; i++) {
			if(uniq.get(i) instanceof FunNode) {
				if (dec.contains(uniq.get(i))){
					/*
					 * se il metodo appartiene alla classe corrente, allora viene recuperato dall'apposita lista,
					 * viene impostato il suo flag indicando quindi che esso appartiene ad una classe; infine viene
					 * effettuata la generazione di codice andando a memorizzare la label associata a tale metodo e 
					 * poi spostandoci alla prossima locazione di memoria nell'heap
					 */
		/*
					FOOLlib.setFunClassName(name);
					FunNode f = ((FunNode)uniq.get(i));
					f.setClassMethodFlag(true);
					decCode += f.codeGeneration()+
							   "lhp\n"+
							   "sw\n"+
							   "push 1\n"+ 
							   "lhp\n"+ //carico l'heap pointer corrente
						 	   "add\n"+
							   "shp\n";//incremento l'heap pointer
				} else {
					/*
					 * se il metodo appartiene ad una delle superclassi
					 * si va a ricercare a quale classe appartiene
					 */
		
		/*
					String label = ""; 
					FunNode f = ((FunNode)uniq.get(i));
					for(ClassNode n = (ClassNode)sc; n != null; n=(ClassNode)n.getSuperClass()){
						if(n.getBody().contains(f)){
							label = ((ClassNode)n).getName();
							break;
						}
					}
					/*
					 * se la classe contenente tale metodo non è istanziata, si va ad effettuare la code
					 * generation della funzione (poichè non è possibile che sia stata effettuata in precedenza);
					 * se invece essa è istanziata, si va a caricare la label relativa a tale metodo, caricata in
					 * precedenza
					 */
		/*
					String osMeth;
					if (!FOOLlib.isInstancedClass(label)){
						osMeth = f.codeGeneration();
					} else {
						String funFreshLbl = FOOLlib.getFunctionLabel(label,f.getName());
						if(funFreshLbl == null) {
							FOOLlib.setFunClassName(label);
							osMeth = f.codeGeneration();
						} else {
							osMeth = "push " + funFreshLbl + "\n";
						}
					}
					/*
					 * si concatena la generazione di codice del metodo al codice necessario 
					 * per memorizzare tale funzione ed infine 
					 * per effettuare lo spostamento alla prossima locazione di memoria libera
					 */
		/*
					decCode += osMeth +
							   "lhp\n"+
							   "sw\n"+
							   "push 1\n"+ 
							   "lhp\n"+ //carico l'heap pointer corrente
						 	   "add\n"+
							   "shp\n";//incremento l'heap pointer
				}
			}
		}
		
		return decCode;
		*/
		return null;
		 
	}
	
	public void setMethod(MethodNode Node)
	{
		methods.add(Node);
	}
	

	
	
	public String codeGeneration() {
		
		//String methodCode="";
		//String methodLabel = "";
		
		for (MethodNode method:methods)
		{
			method.setLabel(FOOLlib.freshFunLabel());
			method.codeGeneration();
		}	
		
		
	//	FOOLlib.putCode(
	//	"\n"+methodLabel+":\n"+
	//	methodCode);
		
		return "";

	}
}
