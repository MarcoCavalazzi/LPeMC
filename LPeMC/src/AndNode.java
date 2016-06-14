
public class AndNode implements Node {
	private Node left;
	private Node right;

	public AndNode(Node l, Node r){
		left=l;
		right=r;
	}

	@Override
	public String toPrint(String s) {
		return s+ "AndNode\n"+left.toPrint(s)+" "+right.toPrint(s)+" ";
	}

	@Override
	public Node typeCheck() {
		// Type checking. Se ci sono due sottotipi di BOOL va avanti, altrimenti si ferma.
		if (! (FOOLlib.isSubtype(left,new BoolTypeNode()))  &&  (FOOLlib.isSubtype(right,new BoolTypeNode())) ){
			System.out.println("Non BOOL in AND operation");
			System.exit(0);
		}

		return new BoolTypeNode();
	}

	/* Questo metodo restituisce il risultato della moltiplicazione tra i due elementi in input. Restituisce:
	 * 1 per True
	 * 0 per False.  */
	@Override
	public String codeGeneration() {
		return left.codeGeneration()+right.codeGeneration()+"mult\n";
	}

}
