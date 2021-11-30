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

