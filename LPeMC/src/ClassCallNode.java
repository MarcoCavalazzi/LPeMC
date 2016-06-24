import java.util.ArrayList;
//Serve quando richiamiamo un metodo della classe, es nomeClasse.metodo().
public class ClassCallNode implements Node {

	private String id;
	private STentry entry; 
	private STentry methodEntry;
	private ArrayList<Node> par = new ArrayList<Node>();
	private int nl;
	
	public ClassCallNode (String i, STentry e,STentry me, ArrayList<Node> p, int n) {
		id=i;
		entry=e;
		methodEntry = me;
		par = p;
		nl = n;
	}
	
	public String toPrint(String s) {
		String str = s+"Class call " + id + " \n"+s+"  Parameters type: \n";
		for(int j=0;j < par.size();j++){
			str += s+"  "+par.get(j).toPrint(s+"  ");
		}
		return str;
	}


	public Node typeCheck() {
		ArrowTypeNode t = null;
		if( methodEntry.getType() instanceof ArrowTypeNode )	// Controlliamo che sia effettivamente un metodo, quindi di tipo ArrowTypeNode.
			t = (ArrowTypeNode) methodEntry.getType();
		else{
			System.out.println("Invocation of a non-method: "+id);
			System.exit(0);
		}
		
		if(par != null)
		{
			ArrayList<Node> p = t.getParList();	// otteniamo la lista dei tipi dei parametri formali
			if ( !(p.size() == par.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di parametri passati in input.
				System.out.println("Wrong number of parameters in the invocation of "+id);
				System.exit(0);
			}
			
			// Controlliamo che ogni parametro passato in input sia compatibile con il tipo atteso.
			for (int i=0; i< par.size(); i++)
			{			
				// ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypeNode)				
				if (!(FOOLlib.isSubtype( par.get(i).typeCheck(), p.get(i))) ) {
					System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of: "+id);
					System.exit(0);
				}
			}
		}
		
		return t.getRet();
	}
	
	
	public String codeGeneration() {
		
		String parCode = "";	
		for(int i=par.size()-1; i>=0; i--){
			parCode += par.get(i).codeGeneration();
		}
		
		String getAR = "";
		for(int i=0; i< nl - entry.getNestinglevel(); i++)
			getAR += "lw\n";
		
		// Recupera valore dell'ID1 (object pointer) dall'AR dove è dichiarato con meccanismo usuale di risalita catena statica		
		return 
				"lfp\n"+	// FP attuale. Non utilizzato in classCallNode, usato fuori.
				parCode+	
				"lfp\n"+	// Andiamo a salvare sullo Stack l'object pointer dell'oggetto in questione. Serve dopo, ne fa uso il metodo per ad esempio richiamare un altro metodo della classe che si sta richiamando dall'interno del metodo. Oppure anche per ritrovare il parametro della classe dall'interno del metodo.
				getAR+		// Trova l'indirizzo dell'AR dove è dichiarato entry e lo mette in Stack.
				"push "+entry.getOffset()+"\n"+	// troviamo l'object pointer dell'oggetto all'interno dell'AR
				"add\n"+
				"lw\n"+		// troviamo l'object pointer e lo mettiamo sullo Stack.
				"lfp\n"+	// da qui le istruzioni vanno a ritrovare l'object pointer dell'oggetto (lo rifacciamo)
				getAR+
				"push "+entry.getOffset()+"\n"+
				"add\n"+
				"lw\n"+		// Ora abbiamo l'object pointer.
				"push "+methodEntry.getOffset()+"\n"+	// gli aggiungiamo l'offset del metodo 
				"add\n"+
				"lw\n"+
				"js\n";		// e andiamo a quell'indirizzo.
	
	}
	
	public String getClassName(){
		return ((ClassNode)((ArrowTypeNode)entry.getType()).getRet()).getName();
	}

}
