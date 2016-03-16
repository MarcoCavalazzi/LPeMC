import com.sun.org.apache.bcel.internal.generic.Instruction;

public class ExecuteVM {
    
    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;
    
    private int[] code;
    private int[] memory = new int[MEMSIZE];
    
    private int ip = 0;
    private int ra;
    private int rv;
    private int sp = MEMSIZE;
    private int fp = MEMSIZE;
    private int hp = 0;
    
    private int k=1;
    
    public ExecuteVM(int[] code) {
    	// Codice di Debug che visualizza il codice del programma in linguaggio macchina.
        System.out.println("Generated code:");
        System.out.println("----------------------");
        for(int i=0; i<code.length; i++){
        	if(code[i] != 25){// 25 = PUSH
        		if(code[i]==0)
        			break;	// This control avoids to associate <invalid> strings to values that belong to the PUSH commands.
        		System.out.println(code[i] +"\t"+ SVMParser.tokenNames[code[i]].toString());
        	}else{
        		System.out.println(code[i] +"\t"+ SVMParser.tokenNames[code[i]].toString());
        		System.out.println(code[++i]);
        	}
        }
        System.out.println("\nWe will now display the instructions of the code step by step. Together we display the state of the Stack (as \"stack pointer: stack value\").\nOnly the part of the Stack that contains useful values will be printed.");
        // After this, in the Console, we will show the stack and the state of the pointers for every step of the code during its execution.
        
        // Constructor
        this.code = code;
    }
    
    public void cpu() {
      while ( true ) {
          dumpInstruction();	// Debug statement.
          
        int bytecode = code[ip++]; // fetch
        int arg1,arg2;
        switch ( bytecode ) {
          case SVMParser.PUSH:
            push( code[ip++] );
            break;
          case SVMParser.POP:
            pop();
            break;
          case SVMParser.ADD :
            arg2=pop();
            arg1=pop();
            push(arg1 + arg2);
            break;
          case SVMParser.MULT :
            arg2=pop();
            arg1=pop();
            push(arg1 * arg2);
            break;
          case SVMParser.DIV :
            arg2=pop();
            arg1=pop();
            push(arg1 / arg2);
            break;
          case SVMParser.SUB :
            arg2=pop();
            arg1=pop();
            push(arg1 - arg2);
            break;
          case SVMParser.STOREW :
            int address = pop();
            memory[address] = pop();    
            break;
          case SVMParser.LOADW :
            push(memory[pop()]);
            break;
          case SVMParser.BRANCH :
            address = code[ip];
            ip = address;
            break;
          case SVMParser.BRANCHEQ :
            address = code[ip++];
            arg2=pop();
            arg1=pop();
            if (arg1 == arg2) ip = address;
            break;
          case SVMParser.BRANCHLESS :
            address = code[ip++];
            arg2=pop();
            arg1=pop();
            if (arg1 <= arg2) ip = address;
            break;
          case SVMParser.BRANCHGR: 
              address = code[ip++];
              arg2=pop();
              arg1=pop();
              if (arg1 >= arg2) ip = address;
              break;
            
          case SVMParser.JS :
            address = pop();
            ra = ip;
            ip = address;
            break;
         case SVMParser.STORERA :
            ra=pop();
            break;
         case SVMParser.LOADRA :
            push(ra);
            break;
         case SVMParser.STORERV :
            rv=pop();
            break;
         case SVMParser.LOADRV :
            push(rv);
            break;
         case SVMParser.LOADFP :
            push(fp);
            break;
         case SVMParser.STOREFP :
            fp=pop();
            break;
         case SVMParser.COPYFP :
            fp=sp;
            break;
         case SVMParser.STOREHP :
            hp=pop();
            break;
         case SVMParser.LOADHP :
            push(hp);
            break;
         case SVMParser.PRINT :
            System.out.println((sp<MEMSIZE)?memory[sp]:"Empty stack!");
            break;
         case SVMParser.HALT :
            return;
        }
        
      }
    } 
    
    private void dumpInstruction(){
    	System.out.println("----------------------------");
        System.out.print("- INSTRUCTION: "+ k++ + " - ");
        String command = SVMParser.tokenNames[code[ip]];
        if(command != "PUSH"){
        	System.out.println(command);
        }else{
        	System.out.print(command);
        	int tempIp = ip+1;
        	System.out.println(" "+code[tempIp]);
        }
        System.out.println("  * SP: "+ sp);
        System.out.println("  * IP: "+ ip);
        dumpStack();
    }
    
    
    private void dumpStack(){
      System.out.println("--------------");
      for(int i=memory.length-1; i>=sp; i--){
          System.out.println(i+": "+memory[i]);
      }
    }
    
    private int pop() {
      return memory[sp++];
    }
    
    private void push(int v) {
      memory[--sp] = v;
    }
    
}