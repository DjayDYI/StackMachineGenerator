package Instructions;

public class Increment extends Instructions{

    String var;

    public Increment(String var){
        this.var = var;
    }
    public String toString(){
        return "PUSH "+var+" LOAD PUSH 1 ADD PUSH "+var+" MOV ";
    }

    public int getNumber(){
        return 9;
    }

}
