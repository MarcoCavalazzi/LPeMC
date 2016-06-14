
public class GreaterOrEqualNode implements Node {

	private Node left;
	private Node right;

	public GreaterOrEqualNode(Node l, Node r) {
		left = l;
		right = r;
	}


	@Override
	public String toPrint(String s) {
		return s+"GreaterOrEqual\n"+ 
				left.toPrint(s+"  ")+   
				right.toPrint(s+"  "); 
	}

	@Override
	public Node typeCheck() {
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		if (! ( FOOLlib.isSubtype(l,r) || FOOLlib.isSubtype(r,l) ) ) {
			System.out.println("Incompatible types in equal");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	// E' uguale al LessOrEqualNode. Cambia solo l'ordine degli elementi nello stack.
	@Override
	public String codeGeneration() {
		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return  right.codeGeneration()+
				left.codeGeneration()+
				"bless "+l1+"\n"+
				"push 0\n"+
				"b "+l2+"\n"+
				l1+":\n"+
				"push 1\n"+
				l2+":\n";
	}


}
