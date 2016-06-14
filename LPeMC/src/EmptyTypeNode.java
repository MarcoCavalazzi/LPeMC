
public class EmptyTypeNode implements Node {

	@Override
	public String toPrint(String indent) {
		return null;
	}

	@Override
	public Node typeCheck() {
		return new EmptyTypeNode();
	}

	@Override
	public String codeGeneration() {
		return null;
	}
}
