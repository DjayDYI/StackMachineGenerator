package Expressions;

import Instructions.Instructions;

public class expression extends Instructions {

    boolean both = false;
    String left;
    String right;
    String operateur;

    public expression(String left, String right, String op){
        this.left = left;
        this.right = right;
        this.operateur = op;
        if(isDigit(left)&&isDigit(right))
            both = true;
    }
    boolean isDigit(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) { // in case that a char is NOT a digit, enter to the if code block
                return false;
            }
        }
        return true;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getOperateur() {
        return operateur;
    }

    public String toString(){
        if (both){
            return "PUSH "+left+" PUSH "+right+" "+operateur+" ";
        }
        else if(isDigit(left)){
            return "PUSH "+left+" PUSH "+right+" LOAD "+operateur+" ";
        }
        else if(isDigit(right)){
            return "PUSH "+left+" LOAD PUSH "+right+" "+operateur+" ";
        }
        else{
            return "PUSH "+left+" LOAD PUSH "+right+" LOAD "+operateur+" ";
        }
    }

    public int getNumber(){
        if (both){
            return 5;
        }
        else if(isDigit(left)){
            return 6;
        }
        else if(isDigit(right)){
            return 6;
        }
        else{
            return 7;
        }
    }

    String leftExpression(expression left){
        return left.toString() + this.toString();
    }

    String rightExpression(expression right){
        return this.toString() + right.toString();
    }

}