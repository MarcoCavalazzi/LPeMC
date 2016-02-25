
public class AndNode implements Node {
	private Node left;
	private Node right;
	
	public AndNode(Node l, Node r){
		left=l;
		right=r;
	}
	
	@Override
	public String toPrint(String s) {
		return s+ "OrNode["+left.toPrint(s)+","+right.toPrint(s)+"]";
	}

	@Override
	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(left,new BoolTypeNode()))  ||  (FOOLlib.isSubtype(right,new BoolTypeNode()))){
		    System.exit(0);
		}
		
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		// Marco: questa è la linea di codice che ho trovato in OrNode.java.
		// Sinceramente però non capisco perché usi "add" per fare un OR e non so bnee cosa mettere per fare l'AND.
		return left.codeGeneration()+right.codeGeneration()+"add\n";
	}

}

/*  
	  public String codeGeneration(){
	    return left.codeGeneration()+right.codeGeneration()+"add\n"; 
	  }
}

*/