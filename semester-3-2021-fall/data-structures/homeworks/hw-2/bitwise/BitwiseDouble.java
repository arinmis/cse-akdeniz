package bitwise;

/**
 * A class with static method that supports 'or', 'and', and 'xor' operation between given two double input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */
public class BitwiseDouble {

   /**
    * Fixed operation bar for 64 bit double 
    */
    private static final String BAR = "------------------------------------------------------------------------";

   /**
    * Returns result of 'or' operation  of given 
    * two double parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of or operation
    */
    public static String or(String firstNum, String secondNum) {
        long num1 = Double.doubleToRawLongBits(Double.valueOf(firstNum));
        long num2 = Double.doubleToRawLongBits(Double.valueOf(secondNum));
        return String.valueOf(num1 | num2);
    }    


   /**
    * Returns result of 'and' operation of given 
    * two double parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of and operation
    */
    public static String and(String firstNum, String secondNum) {
        long num1 = Double.doubleToRawLongBits(Double.valueOf(firstNum));
        long num2 = Double.doubleToRawLongBits(Double.valueOf(secondNum));
        return String.valueOf(num1 & num2);
    }    


   /**
    * Returns result of 'xor' operation  of given 
    * two double parameters 
    * @param firstNum  first input number 
    * @param secondNum second input number 
    * @return result of xor operation
    */
    public static String xor(String firstNum, String secondNum) {
        long num1 = Double.doubleToRawLongBits(Double.valueOf(firstNum));
        long num2 = Double.doubleToRawLongBits(Double.valueOf(secondNum));
        return String.valueOf(num1 ^ num2);
    }    


   /**
    * Returns whole operation in presentable format 
    * @param input1 operation's input  
    * @param input2 operation's input  
    * @param rawOutput raw result of operation 
    * @param opSymbol Symbol that represent operation 
    * @return String which shows entire operation 
    *
    */
    public static String toPresent(String input1, String input2, String rawOutput, String opSymbol) {
        long rawInput1 = Double.doubleToRawLongBits(Double.valueOf(input1));
        long rawInput2 = Double.doubleToRawLongBits(Double.valueOf(input2));
        String inputStr1 = byteSpace(binaryString(String.valueOf(rawInput1)));   
        String inputStr2 = byteSpace(binaryString(String.valueOf(rawInput2)));   
        String outputStr = byteSpace(binaryString(String.valueOf(rawOutput)));   
        return inputStr1 + " " + opSymbol + "\n" + 
               inputStr2 + "\n" +  
               BAR + "\n" + 
               outputStr;
    } 

   /**
    * Convert given number to 64-bit length binary 
    * string with leading zeros
    * @param number 
    * @return binary string with leading zeros
    */
    private static String binaryString(String str) {
        long number = Long.valueOf(str);
        String binaryStr = String.valueOf(Long.toBinaryString(number));
        while(binaryStr.length() < 64) 
            binaryStr = "0" + binaryStr;
        return binaryStr;
    }

   /**
    * Put space between each byte 
    * @param number 64 bit binary string  
    * @return byte spaced version of given string 
    */
    private static String byteSpace(String str) {
        if (str.length() != 64)
            throw new IllegalArgumentException("not a 64 bit");
        String result = "";
        for (int i = 0; i < str.length(); i += 8)
            result += str.substring(i, i + 8) + " ";
        return result.trim();
    }

}

