package Instructions;

import Expressions.expression;

public class ForStatement extends Instructions {

    String label;
    BlocStatement instr;
    CondStatement cond;

    public ForStatement(String label, BlocStatement instructions, expression expr){
        this.label = label;
        this.instr = instructions;
        this.cond  = new CondStatement(expr);
    }

    public ForStatement(String label, expression expr){
        this.label = label;
        this.instr = new BlocStatement(label+"_instructions");
        this.cond  = new CondStatement(expr);
    }

    public BlocStatement getInstr() {
        return instr;
    }

    @Override
    public String toString() {
        return new DeclarationVariableStatement("i"+label, "0").toString() + new BlocStatement(label).toString() + instr.toString() + new Increment("i"+label).toString() + cond.toString() + new ControlFlowStatement(label).toString();
    }

    public int getNumber(){
       return new DeclarationVariableStatement("i"+label, "0").getNumber() + new BlocStatement(label).getNumber() + instr.getNumber() + new Increment("i"+label).getNumber() + cond.getNumber() + new ControlFlowStatement(label).getNumber();
    }


}
