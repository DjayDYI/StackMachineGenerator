package Instructions;

import Expressions.expression;

public class IfStatement extends Instructions {

    BlocStatement iftrue;
    BlocStatement elseFalse;
    BlocStatement label;
    CondStatement cond;

    public IfStatement(String label, expression expr, BlocStatement iftrue, BlocStatement ifalse){
        this.label = new BlocStatement(label);
        this.cond  = new CondStatement(expr);
        this.iftrue = iftrue;
        this.elseFalse = ifalse;
    }

    public IfStatement(String label, expression expr){
        this.label = new BlocStatement(label);
        this.cond  = new CondStatement(expr);
        this.iftrue = new BlocStatement(label+"_if");
        this.elseFalse = new BlocStatement(label+"_else");
    }

    @Override
    public String toString() {
        return label.toString() +  cond.toString() + "PUSH "+(elseFalse.getNumber()+6) +" JMP " + elseFalse.toString()  + " PUSH true PUSH " + iftrue.getNumber() + " JMP " + iftrue.toString();
    }

    public int getNumber() {
        return label.getNumber() +  cond.getNumber() + 3 + (elseFalse.getNumber()) +6 + iftrue.getNumber();
    }

    public BlocStatement getIftrue(){
        return iftrue;
    }

    public BlocStatement getElseFalse() {
        return elseFalse;
    }

    static IfStatement create(String nameLabel, expression cond){
        BlocStatement bif = new BlocStatement(nameLabel+"_if");
        BlocStatement belse = new BlocStatement(nameLabel+"_else");
        IfStatement iff = new IfStatement(nameLabel,cond,bif, belse);
        return iff;
    }

    static IfStatement create(String nameLabel, String left, String right, String op){
        BlocStatement bif = new BlocStatement(nameLabel+"_if");
        BlocStatement belse = new BlocStatement(nameLabel+"_else");
        IfStatement iff = new IfStatement(nameLabel,new expression(left, right, op),bif, belse);
        return iff;
    }

}
