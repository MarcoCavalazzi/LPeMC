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
		if ( (!( FOOLlib.isSubtype(l,r) || FOOLlib.isSubtype(r,l)))  ||  l instanceof ArrowTypeNode  ||  r instanceof ArrowTypeNode )    	   
		{
			System.out.println("Incompatible types in equal");
			System.exit(0);
		}
		return new BoolTypeNode();
	}  

	public String codeGeneration() {
		/*Node l = left.typeCheck();
	Node r = right.typeCheck();   
	if((l instanceof ClassTypeNode && r instanceof ClassTypeNode) || 
			(l instanceof EmptyTypeNode && r instanceof ClassTypeNode) ||
			(l instanceof ClassTypeNode && r instanceof EmptyTypeNode ))
	{
		int lPointer = FOOLlib.objectPointerMap.get(((IdNode) left).getName());	
		int rPointer = FOOLlib.objectPointerMap.get(((IdNode) right).getName());	
		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return lPointer+
			   rPointer+
			   "beq "+l1+"\n"+
			   "push 0\n"+
			   "b "+l2+"\n"+
			   l1+":\n"+
			   "push 1\n"+
			   l2+":\n";
	}*/
		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return left.codeGeneration()+
				right.codeGeneration()+
				"beq "+l1+"\n"+
				"push 0\n"+
				"b "+l2+"\n"+
				l1+":\n"+
				"push 1\n"+
				l2+":\n";
	}

}  