
public class NotNode implements Node {

	private final Node exp;

	public NotNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String s) {
		return s+"NotNode\n"
				+" "+this.exp.toPrint(s)
				+" ";	// gli spazi extra sono stati aggiunti per indentare meglio il risultato.
	}

	@Override
	public Node typeCheck() {
		if ( ( FOOLlib.isSubtype(exp,new BoolTypeNode()) )) {
			System.out.println("Incompatible types in not");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		String lab1 = FOOLlib.freshLabel(); //il label per il not
		String lab2 = FOOLlib.freshLabel();	//label per il true
		return this.exp.codeGeneration() //cima allo stack, valore di exp.codeGeneration, push 1 e confronto con beq questi 2 ultimi valori,  
				+ "push 1" 		+ "\n"   //se la condizione è verificata vado nel label lab1 e poi metto push 0, altrimenti vado in lab2 pushando 1
				+ "beq " + lab1	+ "\n"	 
				+ "push 1" 		+ "\n"
				+ "b " + lab2 	+ "\n"
				+ lab1 + ":"	+ "\n"
				+ "push 0" 		+ "\n"
				+ lab2 + ":"	+ "\n";
	}

}
