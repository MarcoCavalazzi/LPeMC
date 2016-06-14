import java.util.ArrayList;

public class CallNode implements Node {

	private String id;
	private STentry entry; 
	private ArrayList<Node> parlist; 
	private int nl;
	
	// Contructor
	public CallNode (String i, STentry e, ArrayList<Node> p, int n) {
		id=i;
		entry=e;
		parlist = p;
		nl =n;
	}
	
	public String toPrint(String s) {  // Stampa a video del contenuto del CallNode
		String parlstr="";
		for (Node par:parlist)
			parlstr+=par.toPrint(s+"  ");		
		return s+"Call:" + id +" at nestlev "+ nl +"\n" 
		+entry.toPrint(s+"  ")
		+parlstr;        
	}
	
	public Node typeCheck () {  // Check dei tipi
		// Controlliamo che l'entry sia effettivamente un ArrowTypNode
		ArrowTypeNode t=null;
		if (entry.getType() instanceof ArrowTypeNode) 
			t = (ArrowTypeNode) entry.getType(); 
		else {
			System.out.println("Invocation of a non-function "+id);
			System.exit(0);
		}
		// Controlliamo ci sia il giusto numero di parametri in input.
		ArrayList<Node> p = t.getParList();		// otteniamo la lista dei tipi dei parametri formali
		if ( !(p.size() == parlist.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di parametri passati in input.
			System.out.println("Wrong number of parameters in the invocation of "+id);
			System.exit(0);
		}
		// Controlliamo che ogni parametro passato in input sia compatibile con il tipo atteso.
		for (int i=0; i<parlist.size(); i++)
			if ( !(FOOLlib.isSubtype( (parlist.get(i)).typeCheck(), p.get(i) )) ) {
				System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id+"  The parameter is: "+parlist.get(i));
				System.exit(0);
			}
		
		return t.getRet();
	}
	
	public String codeGeneration(){
		// fp al frame del chiamante e poi i parametri in ordine inverso
		// -> ciclo di creazione di una stringa
		String parCode = "";
		for(int i=parlist.size()-1; i>=0; i--){
			parCode += parlist.get(i).codeGeneration();
		}

		String getAR = "";
		for(int i=0; i<nl-entry.getNestinglevel(); i++){
			getAR += "lw\n";
		}

		return    
				"lfp\n"+	
				parCode+
				"lfp\n"+	
				getAR+		
				"push "+entry.getOffset()+"\n"+
				"add\n"+
				"lw\n"+
				"lfp\n"+	  			
				getAR+
				"push "+entry.getOffset()+"\n"+
				"push 1\n"+
				"sub\n"+
				"add\n"+
				"lw\n"+		
				"js\n";
	}

}  