import java.util.ArrayList;

public class ClassNode implements Node{
	private Node sc;
	private String name;
	private ArrayList<Node> dec = new ArrayList<Node>();
	private ArrayList<Node> params = new ArrayList<Node>();
	
	public ClassNode(String id){
		name = id;
	}

	public String getName() {
		return name;
	}

	public String toPrint(String s) {
		String ret = s+"Class "+name+"\n" + s + "   " + (params.size() > 0 ? " parameters:" : "") + " \n";
	    for(int j=0;j < params.size();j++){
	      ret += s+params.get(j).toPrint(s+" ")+"\n";
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
		return null;
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
	
	public void addPar(Node param){
		params.add(param);
	}
	
	public ArrayList<Node> getPar(){
		return params;
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
	
	public String codeGeneration() {
		return getMethodCodeGen();
	}
}
