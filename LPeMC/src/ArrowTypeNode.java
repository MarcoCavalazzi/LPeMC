import java.util.ArrayList;

public class ArrowTypeNode implements Node {

	private ArrayList<Node> parlist; 
	private Node ret;
	
	public ArrowTypeNode()
	{
		//costruttore vuoto di base
	}
	
	public ArrowTypeNode (ArrayList<Node> p, Node r) {
		parlist=p;
		ret=r;
	}
	
	public String toPrint(String s) {
		String parlstr="";
		for (Node par:parlist)
			parlstr+=par.toPrint(s+"  ");
		return s+"ArrowType\n" + parlstr + ret.toPrint(s+"  ->") ; 
	}

	public Node getRet () {
		return ret;
	}

	public ArrayList<Node> getPar () {
		return parlist;
	}

	public ArrayList<Node> getParList () {
		return parlist;
	}

	public Node typeCheck () {
		return new ArrowTypeNode(parlist,ret);
	}

	public String codeGeneration() {
		return "";
	}

	public void addParListElem(Node node) {	// This function adds a parameter to the function.
		parlist.add(node);
	}
	
	public void setRet(Node lowestRes) {	// This function sets the return node of the function.
		ret = lowestRes;
	}






}  