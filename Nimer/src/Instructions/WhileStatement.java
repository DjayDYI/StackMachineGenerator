package Instructions;

import Expressions.expression;

public class WhileStatement extends Instructions {

    BlocStatement name;
    BlocStatement instr;

    public WhileStatement(String nameLabel, expression cond){
        this.name = new BlocStatement(nameLabel);
        this.instr = new BlocStatement(nameLabel+"while");
        this.name.appendInstructions(this.instr);
        this.name.appendInstructions(cond);
        this.name.branch(this.name);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public int getNumber(){
        return name.getNumber();
    }

}
