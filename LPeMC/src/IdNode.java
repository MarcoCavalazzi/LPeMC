public class IdNode implements Node {

	private String id;
	private STentry entry = null;
	private CTentry ctentry = null;
	private int nl;
	
	// Costruttore
	public IdNode (String i, STentry st, int n) {
		id=i;
		entry=st;
		nl=n;	// il nesting level ci farà capire, atraverso la differenza, se l'ID trovato si riferisce ad una variabile locale o globale.
	}
	// Costruttore
	public IdNode (String i, CTentry ct, int n) {
		id=i;
		ctentry=ct;
		nl=n;
	}
	// Costruttore
	public IdNode ()
	{
	}
	
	public String getName(){
		return id;
	}
	
	public String toPrint(String s) {
		if(entry!= null) //id generico	
			return s+"Id:" + id +" at nestlev "+ nl +"\n" + entry.toPrint(s+"  ") ;  
		else //id di classe
			return s+"Class Id:"+id+"at nestlev"+nl+"\n" + ctentry.toPrint(s+"  ");
	}
	
	
	public Node typeCheck () {

		if( entry == null ){
			System.out.println("Id "+id+" is a class");//si può verificare anche sia id di classe anche controllando il tipo di entry, se è null è di classe
			System.exit(0);								//ma abbiamo semplicemente gestito questo caso con il fatto che al costruttore possiamo passare una stentry o una ctentry in base al fatto che sia id di classe o generico
		}
		if( entry.getIsMethod() ){
			System.out.println("Id "+id+" is a method");
			System.exit(0);
		}

		return entry.getType();
	}
	
	
	public String codeGeneration() {

		String getAR="";

		for (int i=0;i<nl-entry.getNestinglevel(); i++ )
			getAR+="lw\n";	

		if(!(entry.getType() instanceof ArrowTypeNode)){
			return 
					"lfp\n"+
					getAR+
					"push "+entry.getOffset()+"\n"+
					"add\n"+
					"lw\n";			

		}
		else {
			return 
					"lfp\n"+
					getAR+
					"push "+entry.getOffset()+"\n"+
					"add\n"+
					"lw\n"+
					"lfp\n"+
					"push "+entry.getOffset()+"\n"+
					"push 1\n"+
					"sub\n"+
					"add\n"+
					"lw\n";
		}
	}

}