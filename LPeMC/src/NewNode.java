import java.util.ArrayList;
import java.util.logging.Logger;

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
		 ArrowTypeNode t=null;
	     if (entry.getType() instanceof ArrowTypeNode) 
	    	 t=(ArrowTypeNode) entry.getType(); 
	     else {
	       System.out.println("Invocation of a non-function "+id);
	       System.exit(0);
	     }
	     
	   //parlist sono i figli del CallNode
	     ArrayList<Node> p = t.getParList();	// otteniamo la lista dei tipi dei parametri formali
	     if ( !(entry.getFields().size() == parlist.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di parametri passati in input.
	       System.out.println("Wrong number of parameters in the invocation of "+id+" and parlist size is: "+parlist.size());
	       System.exit(0);
	     }  
	     // ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypNode)
	     for (int i=0; i<parlist.size(); i++) 
	     { 
	    	 //System.out.println("\ntype of parlist: "+parlist.get(i).typeCheck() + " of:"+id);
	         //System.out.println("\nentry type:"+entry.getFields().get(i).typeCheck()+ " of:"+id);
	     if (
	    	    !(FOOLlib.isSubtype(parlist.get(i).typeCheck(),( entry.getFields().get(i).typeCheck())) ) 
	    	   //nei parametri il nodo a deve essere supertipo perchè applichiamo la controvarianza
	    	 ) {
	    	// System.out.println("\ntype of parlist: "+parlist.get(i).typeCheck() + " of:"+id);
	        // System.out.println("\nentry type:"+entry.getFields().get(i).typeCheck()+ " of:"+id);
	    	 System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of: "+id+"  The parameter is: "+parlist.get(i));
	    	 System.exit(0);
	     } 
	     }
	     return t.getRet().typeCheck();
	    // return t.getRet(); prima era così ma secondo me (Giuseppe) è corretto con .typeCheck() ma non sono sicuro
	}
	

	@Override
	public String codeGeneration() {
		String parCode = "";
		String methodLabel = "";
		//Logger LOGGER = Logger.getLogger("InfoLogging");
//		for(int i = 0; i < parlist.size(); i++)
//		{
//			parCode += parlist.get(i).codeGeneration()+"\n";
//			//LOGGER.info("sono dentro parlist");
//			parCode +=  "lhp\n"+ //codice per aggiornare l'heap, in pratica mettiamo l'hp nello stack, tramite sw andiamo nell'indirizzo di memoria di hp e, facendo un'ulteriore pop dallo stack, aggiungiamo quest'ultimo valore nel suddetto indirizzo dell' heap
//						"sw\n" +
//						"push 1\n"+ 
//						"lhp\n"+ //carico l'heap pointer corrente
//						"add\n"+
//						"shp\n";
//			
//		}
		
		for(int i = 0; i < entry.allMethods.size(); i++)
		{
			
			methodLabel += "push "+((MethodNode)entry.allMethods.get(i)).getLabel()+"\n";		
		   // +"shp\n";
			//System.out.println("label method "+i+": "+((MethodNode)entry.allMethods.get(i)).getLabel());
			methodLabel += "lhp\n"+
							"sw\n" +
							"push 1\n"+ 
							"lhp\n"+ //carico l'heap pointer corrente
							"add\n"+
							"shp\n"	;
		}
		
		//FOOLlib.objectPointerMap.put(id, entry.allMethods.size());
		//FOOLlib.objectPointer = entry.allMethods.size();
		
		return 	
				//"lhp\n" +
				//"sw\n" +
				"lhp\n" +
				"srv\n"+ //mi salvo in rv l'heap pointer corrent
				//"lhp\n"+
				"push 1\n"+ //pusha 1, carica l'heap, li somma (per avere la prossima posizione libera nello heap)
				"lhp\n"+ //carico l'heap pointer corrente
				"add\n"+ //sposto l'heap pointer di 1
				"shp\n"+ //lo salva, e lo usa per poi andare ad inserire il risultato della code generation del primo parametro, poi stesso procedimento per il secondo e così via		
				makeParCode()+
			//	"lhp\n"+ //carico sulla cima dello stack hp, esattamente prima dei metodi poichè ci servirà per gestire l'object pointer
				//"srv\n"+
				makeMethodCode()+				
				"lrv\n"+ //metto sull stack il valroe rv, cioè l'heap pointer iniziale
				"lhp\n"+ //salvo tale valore nell'indirizzo di memoria di rappresentato dal valore di hp
				"sw\n" + 
				"lhp\n"+ //pusho sullo stack il valore di op, facendo la diff tra hp e numero di metodi
				"push -"+entry.allMethods.size()+
				"add\n";
						
				
//		//"lhp\n" +	
//		parCode+			
//		methodLabel+
//		"push "+(entry.allMethods.size() -1)+"\n"+
//		"shp\n";
//		//labelSHP;	
//		//"shp\n"; //? non ho capito come gestire l'object pointer ):   ma dov'è? abbiamo lo stack pointer e l'object? 
		
		
	}
	
	private String makeParCode()
	{
		String code = "";
		for(int i = 0; i < parlist.size(); i++)
		{
			code += parlist.get(i).codeGeneration()+"\n";
			
			code += "lhp\n"+ //codice per aggiornare l'heap, in pratica mettiamo l'hp nello stack, tramite sw andiamo nell'indirizzo di memoria di hp e, facendo un'ulteriore pop dallo stack, aggiungiamo quest'ultimo valore nel suddetto indirizzo dell' heap
					"sw\n" +
					"push 1\n"+ 
					"lhp\n"+ //carico l'heap pointer corrente
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
		   // +"shp\n";
			//System.out.println("label method "+i+": "+((MethodNode)entry.allMethods.get(i)).getLabel());
			mLabel += "lhp\n"+
							"sw\n" +
							"push 1\n"+ 
							"lhp\n"+ //carico l'heap pointer corrente
							"add\n"+
							"shp\n"	;
		}
		return mLabel;
	}

}