
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
		// Marco: questa � la linea di codice che ho trovato in OrNode.java.
		// Sinceramente per� non capisco perch� usi "add" per fare un OR e non so bene cosa mettere per fare l'AND. 
		// con and riesco a fare: 1*0 = 0 | 1*1 = 1 | 0*0 = 0| cio� le regole per fare l'AND logico
		return left.codeGeneration()+right.codeGeneration()+"mult\n";
	}

}

/*  
	  public String codeGeneration(){
	    return left.codeGeneration()+right.codeGeneration()+"add\n"; 
	  }
}

*/