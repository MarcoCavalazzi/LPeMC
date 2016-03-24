public class FieldNode implements Node, DecNode {

  private String id;
  private Node type;
  private String className;
  
  public FieldNode (String i, Node t, String c ) {
   id=i;
   type=t;
   className=c;
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

  public String getClassName(){
	  return className;
  }	

  public String getName(){
	  return id;
  }
					
}
