import java.util.ArrayList;

public class MethodNode implements Node, DecNode {

	private String id;
	private Node type; 
	private ArrayList<Node> parlist = new ArrayList<Node>(); 
	private Node body;
	private String label;

	public MethodNode (String i, Node t) {
		id=i;
		type=t;
	}    

	public void addBody(Node b){
		body=b;
	}
	
	public void addPar (Node p) {
		parlist.add(p);
	} 
	
	public void addParBody(ArrayList<Node> p, Node b){
		parlist = p;
		body    = b;			  
	}
	 

	public String toPrint(String s) {
		String parlstr="";
		if (parlist!=null)
			for (Node par:parlist)
				parlstr+=par.toPrint(s+"  ");

		return s+"Method:" + id +"\n"
		+type.toPrint(s+"  ")
		+parlstr
		+body.toPrint(s+"  ") ; 
	}


	public String codeGeneration() {	 

		String popPar = "";
		if(parlist!=null)
			for(Node par:parlist) 
				popPar += "pop\n";

		if(parlist != null)	
		{
			for(int i=0; i < parlist.size();i++)
			{
				if(((DecNode)parlist.get(i)).getSymType() instanceof ArrowTypeNode)
				{
					popPar += "pop\n" ;
				}
			}
		}
		FOOLlib.putCode(
				"\n"+label+":\n"+
						"cfp\n" + //setta $fp. Copy stack pointer into frame pointer.
						"lra\n" + // load from ra sullo stack
						body.codeGeneration()+ //body della funzione
						"srv\n" + //salvo il risultato in un registro 			 
						"sra\n" + //salvo il return address
						"pop\n" + //pop dell'AL
						popPar  + //pop dei parametri che ho in parlist
						"sfp\n" + //ripristino l'$fp al control link (CL). Store top into frame pointer. 
						"lrv\n" +
						"lra\n" +
						"js\n"    //js salta all'indirizzo che è in cima allo stack
				);
		
		return "";
	}

	public Node typeCheck () {
		if (parlist!=null) 
			for (Node dec:parlist)
				dec.typeCheck();
		if ( !(FOOLlib.isSubtype(body.typeCheck(),type)) ){
			System.out.println("Wrong return type for function "+id);
			System.exit(0);
		}  
		return null;
	}

	@Override
	public Node getSymType() {
		return type;
	}

	//Funzioni per l'OO

	public String getName() {
		return id;
	}

	public void setLabel(String l){
		label = l;
	}

	public String getLabel()
	{
		return label;
	}
}
