package Instructions;

public class ControlFlowStatement extends Instructions{
    String label;
    ControlFlowStatement(String name) {
        this.label=name ;
    }

    @Override
    public String toString() {
        return " PUSH "+label+" GOTO ";
    }

    public int getNumber(){
        return 3;
    }

}
