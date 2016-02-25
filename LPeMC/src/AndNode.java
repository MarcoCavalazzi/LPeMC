
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
		// Servir� forse un "and" alla fine per l'AND e un "or" alla fine per l'OR?
		//No, non esistono come comandi nel file SVM.g, secondo me � corretto usare mult e add 
		// con mult riesco a fare: 1*0 = 0 | 1*1 = 1 | 0*0 = 0| cio� le regole per fare l'AND logico
		//per l'OR � lo stesso ragionamento ma con add
		return left.codeGeneration()+right.codeGeneration()+"and\n";
	}

}

/*  
	  public String codeGeneration(){
	    return left.codeGeneration()+right.codeGeneration()+"add\n"; 
	  }
}

*/