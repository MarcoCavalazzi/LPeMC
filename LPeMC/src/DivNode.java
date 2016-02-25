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
	public Node typeCheck() {
		if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
	            FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
	      System.out.println("Non integers in div");
	      System.exit(0);
	    }
	    return new IntTypeNode();
	}
	
	// Marco: Come facciamo a dire al compilatore di fare la divisione in linguaggio "assembly"? C'è direttamente il comando div
	// Ottimo. E... come fa a capire di fare la divisione leggendo DIV?
	//E' già stato implementato nel file SVM.g e ExecuteVM.java
	@Override
	public String codeGeneration() {
		return this.left.codeGeneration() + this.right.codeGeneration() + "div\n";
	}

}
