public class IfNode implements Node {

	private Node cond;
	private Node th;
	private Node el;

	public IfNode (Node c, Node t, Node e) {
		cond=c;
		th=t;
		el=e;
	}

	public String toPrint(String s) {
		return s+"If\n" + cond.toPrint(s+"  ") + 
				"    Then\n" + th.toPrint(s+"  ") + 
				"    Else\n" + el.toPrint(s+"  "); 
	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(new BoolTypeNode(), cond.typeCheck()))) {	// metodo che controlerà che il primo elemento sie di un tipo che è uguale al secondo oppure è un suo sottotipo. 
			// Quindi accetterà: BOOL E BOOL, INT e INT, BOOL e INT.
			System.out.println("non boolean condition in if");
			System.exit(0);
		}
		Node t = th.typeCheck();
		Node e = el.typeCheck();
		if (FOOLlib.isSubtype(t,e)) 
			return e;
		if (FOOLlib.isSubtype(e,t))
			return t;
		System.out.println("Incompatible types in then else branches");
		System.exit(0);
		return null;
	}

	public String codeGeneration() {
		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return cond.codeGeneration()+
				"push 1\n"+
				"beq "+l1+"\n"+
				el.codeGeneration()+
				"b "+l2+"\n"+
				l1+":\n"+
				th.codeGeneration()+
				l2+":\n";
	}
}  