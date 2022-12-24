package Instructions;

import Expressions.expression;

public class DeclarationVariableStatement extends Instructions {
    String name;
    String value = "NULL";

    public DeclarationVariableStatement(String name) {
        this.name = name;
    }

    public DeclarationVariableStatement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) { // in case that a char is NOT a digit, enter to the if code block
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (isDigit(value)) {
            return "PUSH " + name + " PUSH " + value + " DECLARE ";
        } else {
            return "PUSH " + name + " PUSH " + value + " LOAD DECLARE ";
        }
    }

    public int getNumber() {
        if (isDigit(value)) {
            return 5;
        }
        return 6;
    }
}