
public class NewNode implements Node{

	private String id;
	private CTentry entry;
	
	public NewNode(String i, CTentry ct) {
		i = id;
		entry = ct;
	}
	@Override
	public String toPrint(String s) {
		return s+"Id:" + id +"\n" +  entry.toPrint(s+"  ") ;
	}

	@Override
	public Node typeCheck() {
		//return entry.getType();
	return null;
	}
	

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
