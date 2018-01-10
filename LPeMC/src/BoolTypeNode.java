public class BoolTypeNode implements Node {

	public BoolTypeNode () {
	}

	public String toPrint(String s) {
		return s+"BoolType\n";  
	}
	
	public Node typeCheck(){	// non utilizzato
		return null;
	}

	public String codeGeneration() {
		return "";
	}

}  