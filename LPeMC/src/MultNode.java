public class MultNode implements Node {

	private Node left;
	private Node right;

	public MultNode (Node l, Node r) {
		left=l;
		right=r;
	}

	public String toPrint(String s) {
		return s+"Mult\n" + left.toPrint(s+"  ")  
		+ right.toPrint(s+"  ") ; 
	}

	public Node typeCheck() {
		if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
				FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
			System.out.println("Non integers in multiplication");
			System.exit(0);
		}
		return new IntTypeNode();
	}  

	public String codeGeneration() {
		// aggiungiamo un'istruzione che dir� di fare push sullo stack del valore (e andiamo a capo). Notazione polacca!
		// non possiamo gi� calcolare il risultato e pushare quello sullo stack perch� potremmo avere anche due espressioni (non solo due numeri banali).
		return left.codeGeneration()+
				right.codeGeneration()+
				"mult\n";
	}

}  