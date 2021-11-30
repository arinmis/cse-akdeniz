package bitwise;
/**
 * A class with static method that supports string  'or', 'and', and 'xor' operation between given two input.
 * This class also include formatter methods to make operation printable format
 * to console. 
 *
 * @author Mustafa Arinmis 
 * @since  2021-11-28
 *
 */
public class BitwiseString {

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

