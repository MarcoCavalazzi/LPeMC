import java.util.ArrayList;
import java.util.List;

public class ArrowTypeNode implements Node {

	private ArrayList<Node> parlist; 
	private Node ret;

	public ArrowTypeNode (ArrayList<Node> p, Node r) {
		parlist=p;
		ret=r;
	}


	public ArrowTypeNode()
	{
		//costruttore vuoto temporaneo
	}
	public String toPrint(String s) { //
		String parlstr="";
		for (Node par:parlist)
			parlstr+=par.toPrint(s+"  ");
		return s+"ArrowType\n" + parlstr + ret.toPrint(s+"  ->") ; 
	}

	public Node getRet () { //
		return ret;
	}

	public ArrayList<Node> getPar () { //
		return parlist;
	}

	public ArrayList<Node> getParList () { //
		return parlist;
	}

	//vedi callnode
	public Node typeCheck () {
		/*
	  ArrowTypeNode t = (ArrowTypeNode) ret;
	  ArrayList<Node> p = t.getParList();
	  //Giuseppe:non credo sia corretto questo punto ma non saprei come farlo.
	  if (this.parlist.size() != p.size()) {
		    System.out
			    .println("ArrowTypes Typecheck Error: Wrong Number of Parameters!");
		    System.exit(0);
		} else {
		    for (int i = 0; i < parlist.size(); i++) {
			if (!FOOLlib.isSubtype(parlist.get(i), p.get(i))) {
			    System.out
				    .println("ArrowTypes Typecheck Error: Wrong Type of Parameters!");
			    System.exit(0);
			}
		    }
		}
		// Restituisco il valore del parametro di ritorno
		return t.getRet();
		 */

		return new ArrowTypeNode(parlist,ret);
	}

	public String codeGeneration() {
		return "";
	}






}  