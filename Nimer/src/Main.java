import Expressions.expression;
import Instructions.*;
import machine.StackEmu;

public class Main {


    public static void main(String[] args) {
        //Print odd numbers until 50
        ForStatement stmt = new ForStatement("myfor", new expression("imyfor", "50", "GT"));
        DeclarationVariableStatement declare = new DeclarationVariableStatement("k", "2");
        ArithmeticStatement arithstmt = new ArithmeticStatement("k","imyfor","MOD");
        IfStatement ifstmt = new IfStatement("myIf", new expression("k","0","EQ"));
        IfStatement ifstmtZero = new IfStatement("zero", new expression("imyfor","0","NEQ"));
        PrintStatement printstmt = new PrintStatement("imyfor");
        ifstmtZero.getIftrue().appendInstructions(declare);
        ifstmtZero.getIftrue().appendInstructions(arithstmt);
        ifstmtZero.getIftrue().appendInstructions(ifstmt);
        ifstmt.getElseFalse().appendInstructions(printstmt);
        stmt.getInstr().appendInstructions(ifstmtZero);


        Main m = new Main();
        m.init(stmt.toString());
    }
    public void init(String s) {
        StackEmu machine = new StackEmu(s);
    }


}