public class VarNode implements Node, DecNode { //Rappresenta una variabile

	private String id;
	private Node type;
	private Node exp;

	public VarNode (String i, Node t, Node v) {
		id=i;
		type=t;
		exp=v;
	}

	public String toPrint(String s) {
		return s+"Var:" + id +"\n"
				+type.toPrint(s+"  ")  
				+exp.toPrint(s+"  "); 
	}

	
	public Node typeCheck () {
		if (! (FOOLlib.isSubtype(exp.typeCheck(),type)) ){     // Controlla se exp e' effettivamente tipo o sottotipo di quello dichiarato
			System.out.println("incompatible value for variable: "+id);
			System.exit(0);
		}
		return null;
	}

	public String codeGeneration() {
		return exp.codeGeneration();
	}

	public String getName(){
		return id;
	}

	@Override
	public Node getSymType() {
		return type;
	}  
}