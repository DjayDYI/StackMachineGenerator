package Instructions;

import Expressions.expression;

public class AssignStatement extends Instructions
{
    String name;
    expression value;
    String op;
    AssignStatement(String name, expression value, String op) {
        this.name = name;
        this.value = value;
        this.op = op;
    }

    @Override
    public String toString() {
        return "PUSH "+name+" LOAD "+value.toString()+" PUSH "+name+" MOV ";
    }

    public int getNumber() {
        return 6 + value.getNumber();
    }
}