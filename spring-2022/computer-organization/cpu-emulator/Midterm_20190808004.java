/*
 *
 *  @author Mustafa Arinmis
 *  @since  24.05.2022
 *
 * */

import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Arrays; 
import java.io.File;  
import java.io.FileNotFoundException; 

public class  Midterm_20190808004 {
    static int F = 0;
    static int PC = 0;
    static int AC = 0;
    static int[] M = new int[256];
    static ArrayList<String> instructions = new ArrayList<>();

    public static void main(String[] args) {
        loadInstructions(args[0]);
        // machine cycle: fetch-decode-execute 
        while (true) {
            Instruction instruction =  fetchAndDecode();
            execute(instruction);
        }
    }

    /* load instructions from program file */
    public static void loadInstructions(String filePath) {
        try {
          File myObj = new File(filePath);
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String instruction  = myReader.nextLine();
            String instructionWithoutIndex =  instruction.substring(instruction.indexOf(" ") + 1);
            instructions.add(instructionWithoutIndex);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println(filePath + " does not found");
          System.exit(0);
        }
    }

    /* fetch and decode given string instruction */
    public static Instruction fetchAndDecode() {
        String[] opcodeAndOperand = instructions.get(PC).split(" ");  
        Instruction instruction = null;
        if (opcodeAndOperand.length == 1) {
            instruction = new Instruction(opcodeAndOperand[0]);
        }
        else {
            instruction = new Instruction(opcodeAndOperand[0], Integer.parseInt(opcodeAndOperand[1]));
        }
        PC++; // increment to fetch next instruction in the next cycle
        return instruction;
    }

    /* execute given instruction */
    public static void execute(Instruction instruction) {
        switch(instruction.opcode) {
          case "START":
              break;
          case "LOAD": 
            AC = instruction.operand;
            break;
          case "LOADM":
              AC =  M[instruction.operand];
              break;
          case "STORE":
            M[instruction.operand] = AC;
            break;
          case "CMPM":
            F = AC > M[instruction.operand] ? 
                1 : AC < M[instruction.operand] ? 
                -1 : 0;  
            break;
          case "CJMP":
              if (F > 0) PC = instruction.operand;
              break;
          case "ADD":
              AC =  AC + instruction.operand;
              break;
          case "ADDM":
              AC =  AC + M[instruction.operand];
              break;
          case "SUB":
              AC =  AC - instruction.operand;
              break;
          case "SUBM": 
              AC =  AC - M[instruction.operand];
              break;
          case "MUL":
              AC =  AC *  instruction.operand;
              break;
          case "MULM":
              AC =  AC * M[instruction.operand];
              break;
          case "DISP":
              System.out.println(AC);
              break;
          case "JMP":
              PC = instruction.operand;
              break;
          case "HALT":
              System.exit(0);
              break;
          default:
              System.out.println("Runtime error: " + instruction.opcode + " does not in instruction set");
              System.exit(0);
        }
    }

}

class Instruction {
    public String opcode;
    public int operand = -1; 

    // instruction with one operand
    public Instruction(String opcode, int operand) { 
        this.opcode =  opcode;
        this.operand = operand;
    }

    // instruction without operand
    public Instruction(String opcode) { 
        this.opcode =  opcode;
    }
}


