package Instructions;


import Expressions.expression;

import java.beans.Expression;

public class CondStatement extends Instructions
{
    String left;
    String right;
    String op;
    public CondStatement(String left, String right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public CondStatement(expression expr) {
        this.left = expr.getLeft();
        this.right = expr.getRight();
        this.op = expr.getOperateur();
    }

    @Override
    public String toString() {
        return new expression(left,right,op).toString();
    }

    public int getNumber(){
        return new expression(left,right,op).getNumber();
    }
}