public class DivNode implements Node {

	private Node left;
	private Node right;

	// Vogliamo dividere "left" per "right".
	public DivNode (Node l, Node r) {
		left=l;
		right=r;
	}

	@Override
	public String toPrint(String s) {
		return s+"Div\n" + left.toPrint(s+"  ") + right.toPrint(s+"  ") ; 
	}

	@Override
	public Node typeCheck() {	// Controlliamo che i dividendi siano entrambi interi.
		if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
				FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
			System.out.println("Non integers in div");
			System.exit(0);
		}
		return new IntTypeNode();
	}
	
	@Override
	public String codeGeneration() {
		return this.left.codeGeneration() + this.right.codeGeneration() + "div\n";
	}

}
