
public class EmptyTypeNode implements Node {

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		return new EmptyTypeNode();
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
