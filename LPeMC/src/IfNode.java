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
		//La condizione deve essere un booleano
		if (!(FOOLlib.isSubtype(new BoolTypeNode(), cond.typeCheck()))) {	// metodo che controllerà che il primo elemento sia di un tipo che è uguale al secondo oppure è un suo sottotipo. 
			// Quindi accetterà: BOOL E BOOL, INT e INT, BOOL e INT.
			System.out.println("non boolean condition in if");
			System.exit(0);
		}
		
		Node t = th.typeCheck();
		Node e = el.typeCheck();
		/* Chiama lowestCommonAncestor sui tipi delle espressioni del then e dell'else:
		 * se ritorna null typechecking fallisce, altrimenti restituisce il tipo tornato. */
		Node ret = FOOLlib.lowestCommonAncestor(t,e);
		if ( ret != null) 
			return ret;
		ret = FOOLlib.lowestCommonAncestor(e,t);
		if (ret != null)
			return ret;
		
		return null;
	}
	
	public String codeGeneration() {
		String l1=FOOLlib.freshLabel();
		String l2=FOOLlib.freshLabel();
		return cond.codeGeneration()+
				"push 1\n"+
				"beq "+l1+"\n"+     	// Se la condizione è vera salta ad "l1" per eseguire lo "then".
				el.codeGeneration()+	// Mentre se è falsa esegue il codice dell'else...
				"b "+l2+"\n"+			// ...e salta a l2 per proseguire.
				l1+":\n"+
				th.codeGeneration()+
				l2+":\n";
	}
}  