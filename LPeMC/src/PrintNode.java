public class PrintNode implements Node {

	private Node val;

	public PrintNode (Node v) {
		val=v;
	}

	public String toPrint(String s) {
		return s+"Print\n" + val.toPrint(s+"  ") ;
	}

	public Node typeCheck() {
		return val.typeCheck();
	}  

	public String codeGeneration() {
		return val.codeGeneration()+
				"print\n";	// print stampa banalmente con una System.out ciò che vede sulla cima dello stack.
	}

}  