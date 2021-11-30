package bitwise;

import java.util.Scanner;

/**
 * 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */
public class HW2_20190808004 {

    /**
     * Main code  that asks user for operation type, and 
     * input/inputs. After performing the operaion, it prints 
     * performed operation in binary.
     * 
     *
     * @param args Commandline arguments 
     *
     */
    public static void main(String[] args) {
        // store users inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Give the type of input? int=0, string=1, double=2");
        int inputCode = input.nextInt();
        System.out.println("Give the type of input? or=0, and=1, xor=2, copmlement=3, right shift=4, left shift=5");
        int operationCode = input.nextInt();
        String output = null; // store operation result
        // integer operations
        if (inputCode == 0) {
            // preform or 
            if (operationCode == 0) {
                System.out.print("First Integer Number: ");
                String firstInt = input.next();
                System.out.print("Second Integer Number: ");
                String secondInt = input.next();
                String result = BitwiseInteger.or(firstInt, secondInt);
                output = BitwiseInteger.toPresent(firstInt, secondInt, result, "|");
            }
            // preform and 
            else if (operationCode == 1) {
                System.out.print("First Integer Number: ");
                String firstInt = input.next();
                System.out.print("Second Integer Number: ");
                String secondInt = input.next();
                String result = BitwiseInteger.and(firstInt, secondInt);
                output = BitwiseInteger.toPresent(firstInt, secondInt, result, "&");
            }
            // preform xor 
            else if (operationCode == 2) {
                System.out.print("First Integer Number: ");
                String firstInt = input.next();
                System.out.print("Second Integer Number: ");
                String secondInt = input.next();
                String result = BitwiseInteger.xor(firstInt, secondInt);
                output = BitwiseInteger.toPresent(firstInt, secondInt, result, "^");
            }
            // preform compelement 
            else if (operationCode == 3) {
                System.out.print("Integer Number: ");
                String firstInt = input.next();
                String result = BitwiseInteger.complement(firstInt);
                output = BitwiseInteger.toPresent(firstInt, result, "~");
            }
            // perform right shift
            else if (operationCode == 4) {
                System.out.print("Integer Number: ");
                String firstInt = input.next();
                System.out.print("Shift Number: ");
                int shiftNum = input.nextInt();
                String result = BitwiseInteger.rightShift(firstInt, shiftNum);
                output = BitwiseInteger.toPresent(firstInt, result, shiftNum, ">>");
            }
            // perform left shift
            else if (operationCode == 5) {
                System.out.print("Integer Number: ");
                String firstInt = input.next();
                System.out.print("Shift Number: ");
                int shiftNum = input.nextInt();
                String result = BitwiseInteger.leftShift(firstInt, shiftNum);
                output = BitwiseInteger.toPresent(firstInt, result, shiftNum, "<<");
            }
            else {
                throw new IllegalArgumentException("Invalid integer operation: " + operationCode); 
            }
        }
        // string operations
        else if (inputCode == 1) {
            // preform or 
            if (operationCode == 0) {
                System.out.print("First String: ");
                String firstStr = input.next();
                System.out.print("Second Number: ");
                String secondStr = input.next();
                String result = BitwiseString.or(firstStr, secondStr);
                output = BitwiseString.toPresent(firstStr, secondStr, result, "|");
            }
            // preform and 
            else if (operationCode == 1) {
                System.out.print("First String: ");
                String firstStr = input.next();
                System.out.print("Second Number: ");
                String secondStr = input.next();
                String result = BitwiseString.and(firstStr, secondStr);
                output = BitwiseString.toPresent(firstStr, secondStr, result, "&");
            }
            // preform xor 
            else if (operationCode == 2) {
                System.out.print("First String: ");
                String firstStr = input.next();
                System.out.print("Second Number: ");
                String secondStr = input.next();
                String result = BitwiseString.xor(firstStr, secondStr);
                output = BitwiseString.toPresent(firstStr, secondStr, result, "^");
            }
            else {
                // throw error
                throw new IllegalArgumentException("Invalid string operation: " + operationCode); 
            }
        }
        // double operations
        else if (inputCode == 2) {
            // preform or 
            if (operationCode == 0) {
                System.out.print("First Double Number: ");
                String firstDouble = input.next();
                System.out.print("Second Double Number: ");
                String secondDouble = input.next();
                String result = BitwiseDouble.or(firstDouble, secondDouble);
                output = BitwiseDouble.toPresent(firstDouble, secondDouble, result, "|");
            }
            // preform and 
            else if (operationCode == 1) {
                System.out.print("First Double Number: ");
                String firstDouble = input.next();
                System.out.print("Second Double Number: ");
                String secondDouble = input.next();
                String result = BitwiseDouble.and(firstDouble, secondDouble);
                output = BitwiseDouble.toPresent(firstDouble, secondDouble, result, "&");
            }
            // preform xor 
            else if (operationCode == 2) {
                System.out.print("First Double Number: ");
                String firstDouble = input.next();
                System.out.print("Second Double Number: ");
                String secondDouble = input.next();
                String result = BitwiseDouble.xor(firstDouble, secondDouble);
                output = BitwiseDouble.toPresent(firstDouble, secondDouble, result, "^");
            }
            else {
                // throw error
                throw new IllegalArgumentException("Invalid String operation: " + operationCode); 
            }
        }
        else {
            // throw exception
            throw new IllegalArgumentException("Invalid input type: " + inputCode); 
        }

        // print the result 
        System.out.println(output);

    }

}

/**
 * A class with static method that supports 'or', 'and', and 'xor' operation between given two double input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */
class BitwiseDouble {

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

/**
 * A class with static method that supports 'or', 'and', 'xor', 'complement', 'right shift', and 'left shift' operation between given two integer input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */


class BitwiseInteger {

    
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

/**
 * A class with static method that supports string  'or', 'and', and 'xor' operation between given two input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */
class BitwiseString {

   /**
    * Returns result of 'or' operation  of given 
    * two string character by character with corresponding ASCII codes 
    * @param firstStr first input string 
    * @param secondStr second input string 
    * @return result of or operation
    */
    public static String or(String firstStr, String secondStr) {
        // determine long and short strings
        String longStr = firstStr;
        String shortStr = secondStr;
        if (firstStr.length() < secondStr.length()) {
            longStr = secondStr;
            shortStr = firstStr;
        }
        String resultStart = longStr.substring(0, longStr.length() - shortStr.length());
        // perform or operation char by char
        String resultEnd = "";
        for (int i = 0; i < shortStr.length(); i++) {
            int chr1 = (int)longStr.charAt(longStr.length() - i - 1);
            int chr2 = (int)shortStr.charAt(shortStr.length() - i - 1);
            String charInt = BitwiseInteger.or(String.valueOf(chr1), String.valueOf(chr2));
            resultEnd += (char)(int)Integer.valueOf(charInt);
        }
        return resultStart + resultEnd; 
    }    

   /**
    * Returns result of 'and' operation  of given 
    * two string character by character with corresponding ASCII codes 
    * @param firstStr first input string 
    * @param secondStr second input string 
    * @return result of and operation
    */
    public static String and(String firstStr, String secondStr) {
        // determine long and shandt strings
        String longStr = firstStr;
        String shortStr = secondStr;
        if (firstStr.length() < secondStr.length()) {
            longStr = secondStr;
            shortStr = firstStr;
        }
        // fill with 0 char
        String resultStart = "";
        for (int i = 0; i < longStr.length() - shortStr.length(); i++)
            resultStart += (char)0;
        // perform and operation char by char
        String resultEnd = "";
        for (int i = 0; i < shortStr.length(); i++) {
            int chr1 = (int)longStr.charAt(longStr.length() - i - 1);
            int chr2 = (int)shortStr.charAt(shortStr.length() - i - 1);
            String charInt = BitwiseInteger.and(String.valueOf(chr1), String.valueOf(chr2));
            resultEnd += (char)(int)Integer.valueOf(charInt);
        }
        System.out.println(resultStart);
        return resultStart + resultEnd; 
    }    

   /**
    * Returns result of 'xor' operation  of given 
    * two string character by character with corresponding ASCII codes 
    * @param firstStr  first input string 
    * @param secondStr second input string 
    * @return result of and operation
    */
    public static String xor(String firstStr, String secondStr) {
        // determine long and short strings
        String longStr = firstStr;
        String shortStr = secondStr;
        if (firstStr.length() < secondStr.length()) {
            longStr = secondStr;
            shortStr = firstStr;
        }
        // copy first part, since xor'ing with 0 outputs same result 
        String resultStart = longStr.substring(0, longStr.length() - shortStr.length());
        // perform or operation char by char
        String resultEnd = "";
        for (int i = 0; i < shortStr.length(); i++) {
            int chr1 = (int)longStr.charAt(longStr.length() - i - 1);
            int chr2 = (int)shortStr.charAt(shortStr.length() - i - 1);
            String charInt = BitwiseInteger.xor(String.valueOf(chr1), String.valueOf(chr2));
            resultEnd += (char)(int)Integer.valueOf(charInt);
        }
        return resultStart + resultEnd; 
    }    

   /**
    * Returns whole operation in presentable format 
    * @param input1 operation's input  
    * @param input2 operation's input  
    * @param output result of operation 
    * @param opSymbol Symbol that represent operation 
    * @return String which shows entire operation 
    *
    */
    public static String toPresent(String input1, String input2, String output, String opSymbol) {
        int maxLen = Math.max(input1.length(), input2.length());
        String inputStr1 = byteSpace(binaryString(input1, maxLen));   
        String inputStr2 = byteSpace(binaryString(input2, maxLen));   
        String outputStr = byteSpace(binaryString(output, maxLen));   
        return inputStr1 + " " + opSymbol + "\n" + 
               inputStr2 + "\n" +  
               createBar(maxLen) + "\n" + 
               outputStr + " = " + output;
    } 

    /**
     * Convert String to binary with leading zeros bytes
     * string with leading zeros
     * @param str input string to be binary with leading zeros   
     * @param byteAmount desired byte length for given string 
     * @return binary string with leading zeros
     */
    public static String binaryString(String str, int byteAmount) {
        String result = "";
        // convert existing chars to binary
        for (int i = 0; i < str.length(); i++) 
            result += byteString((int)str.charAt(i));
        // put leadings zero bytes if needed
        for (int i = 0; i < byteAmount- str.length(); i++) 
            result = "00000000" + result;
        return result;
    }

    /**
     * Convert String to binary with leading zeros bytes
     * string with leading zeros
     * @param number decimal number  
     * @return binary corresponce of given decimal number with leading zeros, exactly one byte length 
     */
    public static String byteString(int number) {
        String binaryByte = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');
        return binaryByte;
    }

   /**
    * Put space between each byte 
    * @param str arbitary length of string 
    * @return byte spaced version of given string 
    */
    private static String byteSpace(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 8)
            result += str.substring(i, i + 8) + " ";
        return result.trim();
    }

   /**
    * Put space between each byte 
    * @param byteAmount length of the custom bar measured in byte 
    * @return custom bar in desired length 
    */
    private static String createBar(int byteAmount) {
        System.out.println("bar amount: " + byteAmount);
        String subBar = "---------";
        String bar = "";
        for (int i = 0; i < byteAmount; i++)
           bar += subBar; 
        return bar;
    }
    
}

