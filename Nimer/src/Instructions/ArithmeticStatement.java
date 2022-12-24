package Instructions;

import Expressions.expression;

public class ArithmeticStatement extends Instructions {
    String var;
    String val;
    String op;
    public ArithmeticStatement(String var, String val, String op){
        this.var = var;
        this.val = val;
        this.op = op;
    }
    public String toString(){
        if(isDigit(val))
            return "PUSH "+var+" LOAD PUSH "+val+" "+op+" PUSH "+var+" MOV ";
        else
            return "PUSH "+var+" LOAD PUSH "+val+" LOAD "+op+" PUSH "+var+" MOV ";

    }


    public int getNumber(){
        if(isDigit(val))
            return 9;
        else
            return 10;
    }
    boolean isDigit(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) { // in case that a char is NOT a digit, enter to the if code block
                return false;
            }
        }
        return true;
    }


}
