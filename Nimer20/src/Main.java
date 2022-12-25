import java.awt.*;

public class Main {

    //                         [func: declaration]                                                                 main: [appel] end2: PRINT
    //PUSH true PUSH main GOTO [func: PUSH a LOAD PUSH a LOAD MUL PUSH a MOV PUSH a LOAD PUSH true PUSH end2 GOTO] main: [PUSH a PUSH 5 DECLARE PUSH true PUSH func GOTO] end2: PUSH a PUSH 2 DECLARE;
    // String s = "PUSH true PUSH main GOTO "+Generator.func("func","a","end2", Generator.AssignExpression("a","MUL"))+" main: "+Generator.funcall("func","a", "4", "end2")+" PRINT ";


    //PUSH true PUSH main GOTO main: PUSH a PUSH 5 DECLARE PUSH b PUSH 2 DECLARE PUSH a LOAD PUSH b LOAD EQ PUSH main GOTO

    public static void main(String[] args) {
        String s = "PUSH true PUSH main GOTO "
                    + Generator.func("funcarre","a","end2", Generator.AssignExpression("a","MUL")) //fonction carre
                    + Generator.func("func","x","end3", Generator.Increment("x")+Generator.Increment("x")) // fonction double increment
                    + Generator.DeclarationScope("main")
                    + Generator.funcall("funcarre","a", "4", "end2") +" PRINT "
                    + Generator.funcall("func","x", "1", "end3") +" PRINT "
                    + Generator.IfStatement("x", "a", "GT", "end5")
                    + Generator.DeclarationScope("end5")
                    + Generator.Increment("a")
                    + Generator.ForStatement("i", "0", "a", "LT", "end4", " PUSH i LOAD PRINT ");

        StackEmu m = new StackEmu(s);
    }
}