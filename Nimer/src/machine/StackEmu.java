package machine;

import java.util.HashMap;
import java.util.Map;


/* Utilisation for loop
     PUSH x PUSH 1 DECLARE      var x = 0
     PUSH Label :               label:
     PUSH x LOAD PUSH 1 ADD
     PUSH x MOV                 x = x+1
     PUSH 5 PUSH x LOAD
     LT PUSH Label GOTO         if x < 5 label:
*
    if else
    " PUSH deb : PUSH 1 PUSH 2 LT PUSH 11 JMP PUSH 4 PUSH 1 SUB PRINT PUSH true PUSH 3 JMP PUSH 10 PRINT PUSH EndIf :"
*

*/
public class StackEmu {

    Map<String, String> tableSymbol = new HashMap<>();
    String[] pile = new String[255];
    String[] program = null;
    int size = 0;
    int pc = 0;

    boolean running = true;
    public StackEmu(String program){
        this.program = program.split(" ");
        this.run();
    }

    void run(){
        while (running && pc < program.length){
            String instr = program[pc++];
            switch (instr) {
                case "PUSH": push();break;
                case "POP": pop();break;
                case "ADD": add();break;
                case "SUB": sub();break;
                case "MUL": mul();break;
                case "DIV": div();break;
                case "MOD": mod();break;
                case "LT": lower();break;
                case "GT": greater();break;
                case "LEQ": lower_equals();break;
                case "GEQ": greater_equals();break;
                case "EQ": equals();break;
                case "NOT": not();break;
                case "NEQ": not_equals();break;
                case "DECLARE": declare();break;
                case "MOV": mov();break;
                case "LOAD": load();break;
                case "GOTO": branch();break;
                case "JMP": jump();break;
                case ":": Label();break;
                case "HALT": halt();break;
                case "PRINT": print();break;
            }
        }
    }

    void print(){
        String opLeft = pop();
        System.out.println(opLeft);
    }
    void halt(){
        System.out.println("Machine halting");
        running = false;
    }
    void push(){
        pile[size++] = program[pc];
    }

    String pop(){
        String op = pile[size-1];
        pile[size--] = "NULL";
        return op;
    }

    void declare(){
        String opValue = pop();
        String opName = pop();
        tableSymbol.put(opName,opValue);
    }

    void load(){
        String opName = pop();
        pile[size++] = tableSymbol.get(opName);;
    }

    void mov(){
        String opName = pop();
        String opValue = pop();
        tableSymbol.remove(opName);
        tableSymbol.put(opName,opValue);
    }

    void add() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        int res = opLeft + opRight;
        pile[size++] = String.valueOf(res);
    }

    void sub() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        int res = opLeft - opRight;
        pile[size++] = String.valueOf(res);
    }
    void mul() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        int res = opLeft * opRight;
        pile[size++] = String.valueOf(res);
    }
    void div() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        int res = opLeft / opRight;
        pile[size++] = String.valueOf(res);
    }
    void mod() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        int res = opLeft % opRight;
        pile[size++] = String.valueOf(res);
    }

    void equals() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        if(opLeft == opRight)
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }

    void lower() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        if(opLeft < opRight)
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }

    void greater() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        if(opLeft > opRight)
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }

    void greater_equals() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        if(opLeft >= opRight)
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }
    void lower_equals() {
        int opLeft = Integer.parseInt(pop());
        int opRight = Integer.parseInt(pop());
        if(opLeft >= opRight)
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }

    void not() {
        String opLeft = pop();
        if(opLeft.equals("false"))
            pile[size++] = String.valueOf("true");
        else
            pile[size++] = String.valueOf("false");
    }

    void not_equals() {
        equals();
        not();
    }

    void branch(){
        String opLabel = pop();
        String opCond = pop();
        if(opCond.equals("true"))
        {
            pc = Integer.parseInt(tableSymbol.get(opLabel));
        }
    }

    void jump(){
        int unit = Integer.parseInt(pop());
        String opCond = pop();
        if(opCond.equals("true")) {
            pc = pc + unit;
        }
    }

    void Label(){
        String opLabel = pop();
        tableSymbol.put(opLabel,String.valueOf(pc));
    }

}