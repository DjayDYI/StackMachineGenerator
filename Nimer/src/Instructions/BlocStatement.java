package Instructions;

import java.util.ArrayList;
import java.util.List;

public class BlocStatement extends Instructions{

    String label;
    List<Instructions> instructions = new ArrayList<>();
    Instructions next;
    
    public BlocStatement(String name){
        label = name;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("PUSH " + label + " : ");
        for(Instructions instr : instructions)
            s.append(instr.toString());
        return s.toString();
    }

    public int getNumber(){
        int number  = 3;
        for(Instructions instr : instructions)
            number += instr.getNumber();

        if(next != null)
            number += next.getNumber();

        return number;
    }
    
     public void branch(BlocStatement b){
        next = new ControlFlowStatement(b.label);
    }

    public void appendInstructions(Instructions instr) {
        instructions.add(instr);
    }


}