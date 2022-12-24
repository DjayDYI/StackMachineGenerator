package Instructions;

public class PrintStatement extends Instructions {
    String left;
    public PrintStatement(String left) {
        this.left = left;
    }

    @Override
    public String toString() {
            return "PUSH "+ left +" LOAD PRINT ";
    }

    public int getNumber(){
        return 4;
    }
}
