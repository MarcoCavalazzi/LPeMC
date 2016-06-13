public class EqualNode implements Node {

	private Node left;
	private Node right;

	public EqualNode (Node l, Node r) {
		left=l;
		right=r;
	}

	public String toPrint(String s) {
		return s+"Equal\n" + left.toPrint(s+"  ")   
		+ right.toPrint(s+"  ") ; 
	}

	public Node typeCheck() {
		
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		// Su tipi funzionali typechecking comunque fallisce, 
		// altrimenti fallisce solo se lowestCommonAncestor ritorna null
		//Node leftLCA = FOOLlib.lowestCommonAncestor(l,r);
		Node rightLCA = FOOLlib.lowestCommonAncestor(r,l);
		
		if (  rightLCA == null ||  l instanceof ArrowTypeNode  ||  r instanceof ArrowTypeNode )    	   
		{
			System.out.println("Incompatible types in equal");
			System.exit(0);
		}
		return new BoolTypeNode();

	}  

	public String codeGeneration() {

		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return  left.codeGeneration()+
				right.codeGeneration()+
				"beq "+l1+"\n"+
				"push 0\n"+
				"b "+l2+"\n"+
				l1+":\n"+
				"push 1\n"+
				l2+":\n";
	}

}  