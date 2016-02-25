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
	      System.out.println("Non integers in sum");
	      System.exit(0);
	    }
	    return new IntTypeNode();
	}
	
	// Marco: Come facciamo a dire al compilatore di fare la divisione in linguaggio "assembly"?
	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
