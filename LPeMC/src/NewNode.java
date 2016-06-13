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
		return s+"NewNode: "+ id +"\n\t" 
		+entry.toPrint(s+"  ")
		+parlstr;
	}

	@Override
	public Node typeCheck() {
		
		if (!(entry.getType() instanceof ArrowTypeNode)) 
		{
			System.out.println("Invocation of a non-function "+id);
			System.exit(0);
		}

		if ( !(entry.getFields().size() == parlist.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di parametri passati in input.
			System.out.println("Wrong number of parameters in the instantiation  of "+id+" and parlist size is: "+parlist.size());
			System.exit(0);
		}  
		// ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypNode)
		for (int i=0; i<parlist.size(); i++) 
		{ 

			if (!(FOOLlib.isSubtype(parlist.get(i).typeCheck(), entry.getFields().get(i).typeCheck())) ) {
				
				System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of: "+id+"  The parameter is: "+parlist.get(i));
				System.exit(0);
			} 
		}
		return entry.getDec().typeCheck();
	}


	@Override
	public String codeGeneration() {

		if(entry.vTable.size() == 0) //classe vuota
		{
			return  	
					"lhp\n"+ //così facendo l'obj pointer che sarà sullo stack punterà allo spazio vuoto che creiamo 
					"lhp\n"+ //carico l'heap pointer corrente e faccio un salto di 1 creando uno spazio vuoto
					"push 1\n"+ 
					"add\n"+
					"shp\n";
					
		}
		
		return 	
				makeParCode()+	
				"lhp\n"+		
				makeMethodCode();								


	}

	private String makeParCode()
	{
		String code = "";
		for(int i = parlist.size()-1; i >= 0; i--)
		{
			code += parlist.get(i).codeGeneration();			
			code +=
					"lhp\n"+ //codice per aggiornare l'heap, in pratica mettiamo l'hp nello stack, tramite sw andiamo nell'indirizzo di memoria di hp e, facendo un'ulteriore pop dallo stack, aggiungiamo quest'ultimo valore nel suddetto indirizzo dell' heap
					"sw\n" +					
					"lhp\n"+ //carico l'heap pointer corrente
					"push 1\n"+ 
					"add\n"+
					"shp\n";
		

		}
		return code;
	}


	private String makeMethodCode()
	{
		String mLabel="";
		for(int i = 0; i < entry.allMethods.size(); i++)
		{

			mLabel += "push "+((MethodNode)entry.allMethods.get(i)).getLabel()+"\n";		

			mLabel += 
					"lhp\n"+
					"sw\n" +
					"lhp\n"+ //carico l'heap pointer corrente	
					"push 1\n"+								 					 
					"add\n"+
					"shp\n";
		}
		return mLabel;
	}

}