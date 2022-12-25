public class Generator {

    static String func(String name, String par, String blocReturn, String instr){
        return name+": "+instr+" PUSH "+par+" LOAD PUSH true PUSH "+ blocReturn +" GOTO ";
    }

    static String funcall(String name, String par, String val, String blocReturn){
        return DeclarationVariable(par,val)+" PUSH true PUSH "+name+" GOTO "+blocReturn+": ";
    }

    static String AssignExpression(String var, String op){
        return "PUSH "+var+" LOAD PUSH "+var+" LOAD "+op+" PUSH "+var+" MOV ";
    }

    static String AssignNumeric(String var, String val, String op){
        return "PUSH "+var+" LOAD PUSH "+val+" "+op+" PUSH "+var+" MOV ";
    }

    static String AssignVariable(String var, String var2, String op){
        return "PUSH "+var+" LOAD PUSH "+var2+" LOAD "+op+" PUSH "+var+" MOV ";
    }

    static String Increment(String var){
        return "PUSH "+var+" LOAD PUSH 1 ADD PUSH "+var+" MOV ";
    }

    static String DeclarationVariable(String var, String val){
        return "PUSH "+var+" PUSH "+val+" DECLARE";
    }

    static String DeclarationScope(String scope){
        return " "+scope+": ";
    }

    static String IfStatement(String var, String var2, String op, String gotoLabel){
        String s = "PUSH "+var;

        if(isNumeric(var))
            s+=" PUSH ";
        else
            s+= " LOAD PUSH ";

        s+= var2;

        if(!isNumeric(var))
            s+=" LOAD ";

        s+=op+" PUSH "+gotoLabel+" GOTO ";

        return s;
    }

    static String ForStatement(String var,String val, String var2, String op, String gotoLabel, String instr){
        return DeclarationVariable(var, val)+" PUSH "+gotoLabel+" :"+ instr + Increment(var)+IfStatement(var2,var, op, gotoLabel);
    }

    // var 2 : true or false
    static String dowhileStatement(String var, String var2, String op, String gotoLabel, String instr){
        return DeclarationVariable(var, "true")+" PUSH "+gotoLabel+" :"+ instr +IfStatement(var, var2, op, gotoLabel);
    }

    static String repeatStatement(String var, String gotoLabel, String instr){
        return ForStatement("rep_i","0",var,"LT",gotoLabel,instr);
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

}
