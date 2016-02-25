
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
		// Sinceramente però non capisco perché usi "add" per fare un OR e non so bene cosa mettere per fare l'AND.
		// Servirà forse un "and" alla fine per l'AND e un "or" alla fine per l'OR?
		// con mult riesco a fare: 1*0 = 0 | 1*1 = 1 | 0*0 = 0| cioè le regole per fare l'AND logico
		//per l'OR è lo stesso ragionamento ma con add
		
		// Scusa se insisto. Ho capito la tua spiegazione, ma cosa dice al compilatore quando considerare il numero per intero e quando bit a bit?
		return left.codeGeneration()+right.codeGeneration()+"and\n";
	}

}
