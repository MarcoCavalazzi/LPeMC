
public class NullNode implements Node {

	public NullNode() {
    }

    @Override
    public String toPrint(String s) {
        return s+ "NullNode";
    }

    @Override
    public Node typeCheck() {
        return new NullNode();
    }

    @Override //Giuseppe: penso che con -1 potrebbe anche andare, ma non sono sicuro.
    public String codeGeneration() {
        return "push -1" + "\n";
    }	
	

}
