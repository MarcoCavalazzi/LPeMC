import java.util.ArrayList;

public class NewNode implements Node{

	private String id;
	private CTentry entry;
	private ArrayList<Node> parlist; 
	public NewNode(String i, CTentry ct, ArrayList<Node> p ) {
		id = i;
		entry = ct;
		parlist = p;
	}
	@Override
	public String toPrint(String s) {
		String parlstr="";
		for (Node par:parlist)
		  parlstr+=par.toPrint(s+"  ");		
		return s+"NewNode:" + id +" at nestlev " +"\n" 
	           +entry.toPrint(s+"  ")
	           +parlstr;
	}

	@Override
	public Node typeCheck() {
		return entry.getType();	
	}
	

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return "";
	}

}
