public class VarNode implements Node, DecNode {

  private String id;
  private Node type;
  private Node exp;
  
  public VarNode (String i, Node t, Node v) {
    id=i;
    type=t;
    exp=v;
  }
  
  public String toPrint(String s) {
	return s+"Var:" + id +"\n"
	  	   +type.toPrint(s+"  ")  
           +exp.toPrint(s+"  "); 
  }
  
  //valore di ritorno non utilizzato
  public Node typeCheck () {
    if (! (FOOLlib.isSubtype(type,exp.typeCheck())) ){      
      System.out.println("incompatible value for variable: "+id);
      System.exit(0);
    }     
    return null;
  }
  
  public String codeGeneration() {
	return exp.codeGeneration();
  }

@Override
public Node getSymType() {
	
	return type;
}
    
}  