
public class NotNode implements Node {

	private final Node exp;
	
	
	public NotNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public String toPrint(String s) {
        return s+"NotNode"
                + "[" + this.exp.toPrint(s)
                + "]";
    }

    @Override
    public Node typeCheck() {
    	
        if (! ( FOOLlib.isSubtype(exp,new BoolTypeNode()) )) {
          System.out.println("Incompatible types in not");
          System.exit(0);
        }
        return new BoolTypeNode();
    }

    @Override// Marco: scusa, ma te la capisci la spiegazione del prof di questo metodo (nei commenti)? 	
    //I commenti li ho scritti io per cercare di far capire il ragionamento fatto ma sono stato poco chiaro evidentemente,
    //in pratica per ogni valore che mi arriva lo confronto con 1(true) se 
    public String codeGeneration() {
        String lab1 = FOOLlib.freshLabel(); //il label per il not
        String lab2 = FOOLlib.freshLabel();	//label per il true
        return this.exp.codeGeneration()
                + "push 1" 		+ "\n"   //se per esempio ho 3, cioè false, ecco cosa succede: ho 3 sullo stack, metto anche 1, 
                + "beq" + lab1 	+ "\n"	 //se 3 è == 1, metto 1 sullo stack cioè true, cioè il not di 3(False), altrimenti metto 0 (push 0)
                + "push 1" 		+ "\n"
                + "b " + lab2 	+ "\n"
                + lab1 + ":"	+ "\n"
                + "push 0" 		+ "\n"
                + lab2 + ":"	+ "\n";
    }




}
