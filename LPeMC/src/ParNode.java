public class ParNode implements Node, DecNode {

	private String id;
	private Node type;
	private String isClassPar = "";

	public ParNode (String i, Node t) {
		id=i;
		type=t;
	}

	public String toPrint(String s) {
		return s+"Par:" + id +"\n"
				+type.toPrint(s+"  ") ; 
	}

	public Node typeCheck () {
		return null;
	}

	public String codeGeneration() {
		return "";
	}

	@Override
	public Node getSymType() {
		return type;
	}
	//funzioni per l'OO
	public ParNode (String i, Node t,String iCP){
		id=i;
		type=t;
		isClassPar = iCP;
	}	

	public String getClassName(){
		return isClassPar;
	}	

	public boolean isParClass(){
		return !(isClassPar.equals(""));
	}

	public String getName(){
		return id;
	}
}  