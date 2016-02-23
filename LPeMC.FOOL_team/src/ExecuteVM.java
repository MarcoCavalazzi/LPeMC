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
    
    public ExecuteVM(int[] code) {
      this.code = code;
    }
    
    public void cpu() {
      while ( true ) {
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
    
    private int pop() {
      return memory[sp++];
    }
    
    private void push(int v) {
      memory[--sp] = v;
    }
    
}