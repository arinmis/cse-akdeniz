package bitwise;
/**
 * A class with static method that supports 'or', 'and', 'xor', 'complement', 'right shift', and 'left shift' operation between given two integer input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */


public class BitwiseInteger {

    
    /**
    * Fixed operation bar for 32 bit integer 
    */
    private static final String BAR = "------------------------------------";

    /**
    * Return result of 'or' operation  of given 
    * two integer parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of or operation
    */
    public static String or(String firstNum, String secondNum) {
        int result = Integer.valueOf(firstNum) | Integer.valueOf(secondNum);
        return String.valueOf(result);
    }    

    /**
    * Return result of 'and' operation  of given 
    * two integer parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of and operation
    */
    public static String and(String firstNum, String secondNum) {
        int result = Integer.valueOf(firstNum) & Integer.valueOf(secondNum);
        return String.valueOf(result);
    }    

    /**
    * Return result of 'xor' operation  of given 
    * two integer parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of xor operation
    */
    public static String xor(String firstNum, String secondNum) {
        int result = Integer.valueOf(firstNum) ^ Integer.valueOf(secondNum);
        return String.valueOf(result);
    }    

    /**
    * Return complement of given input 
    * @param number input number 
    * @return result of complement operation 
    */
    public static String complement(String number) {
        int result = ~ Integer.valueOf(number);
        return String.valueOf(result);
    }    

    /**
    * Return 'right shift' operation result of given number, 
    * given amount of times
    * @param number input number 
    * @param amount right shift amount 
    * @return result of right shift operation 
    */
    public static String rightShift(String number, int amount) {
        int result = Integer.valueOf(number) >> amount;
        return String.valueOf(result);
    }    


    /**
    * Return 'left shift' operation result of given number, 
    * given amount of times
    * @param number input number 
    * @param amount left shift amount 
    * @return result of left shift operation 
    */
    public static String leftShift(String number, int amount) {
        int result = Integer.valueOf(number) << amount;
        return String.valueOf(result);
    }    

    /**
    * Return whole operation in presentable format 
    * @param input1 operation's input  
    * @param output result of operation 
    * @param opSymbol Symbol that represent operation 
    * @return String which shows entire operation 
    */
    public static String toPresent(String input1, String output, String opSymbol) {
        String inputStr1 = byteSpace(binaryString(input1));   
        String outputStr = byteSpace(binaryString(output));   
        return  opSymbol + inputStr1 + " = " + outputStr +  " = " + output;
    } 

    /**
    * Return whole operation in presentable format 
    * @param input1 operation's input  
    * @param output result of operation 
    * @param shiftAmount amount that shift operation is performed 
    * @param opSymbol Symbol that represent operation 
    * @return String which shows entire operation 
    */
    public static String toPresent(String input1,  String output, int shiftAmount, String opSymbol) {
        String outputStr = byteSpace(binaryString(output));   
        return input1 + " " + opSymbol + " " + shiftAmount + " = " +
               outputStr + " = " + output;
    } 

    /**
    * Return whole operation in presentable format 
    * @param input1 operation's input  
    * @param input2 operation's input  
    * @param output result of operation 
    * @param opSymbol Symbol that represent operation 
    * @return String which shows entire operation 
    */
    public static String toPresent(String input1, String input2, String output, String opSymbol) {
        String inputStr1 = byteSpace(binaryString(input1));   
        String inputStr2 = byteSpace(binaryString(input2));   
        String outputStr = byteSpace(binaryString(output));   
        return inputStr1 + " " + opSymbol + "\n" + 
               inputStr2 + "\n" +  
               BAR + "\n" + 
               outputStr + " = " + output;
    } 


    /**
    * Add zores until length of given binary string become 32 
    * @param number operation's input  
    * @return given integer in binary with leading zeros
    */
    private static String binaryString(String str) {
        int number = Integer.valueOf(str);
        String binaryStr = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(number)).replace(' ', '0');
        return binaryStr;
    } /**
    * Put space between each byte 
    * @param number 32 bit binary string  
    * @return byte spaced version of given string 
    */
    private static String byteSpace(String str) {
        if (str.length() != 32)
            throw new IllegalArgumentException("not a 32 bit");
        String result = "";
        for (int i = 0; i < str.length(); i += 8)
            result += str.substring(i, i + 8) + " ";
        return result.trim();
    }
      
}

