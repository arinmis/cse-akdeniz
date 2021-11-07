/**
 * An equation puzzle solver with recursive brute force
 * In puzzle, each character represents a distinct digit 
 *
 * Example puzzle: donald + gerald = robert 
 * Solution:       526485 + 197485 = 723970        
 *
 * @author Mustafa Arinmis 
 * @since  2021-10-31
 */

import java.util.*;

public class Puzzle {

    public static void main(String[] args) {
        // take input from user
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 1st input value: " );
        String input1 = input.next();
        System.out.print("Enter 2st input value: " );
        String input2 = input.next();
        System.out.print("Enter output value:    " );
        String output = input.next();

        // put comma to seperate equation elements
        String equation = input1 + "," +  input2 + "," +output;

        // check whether given inputs are valid
        checkInputs(equation);
        
        // update cli before computation
        System.out.print("\nSolution: ");
        String charSet = getCharSet(equation);
        String digits = "0123456789"; 
        ArrayList<String> squenceList = new ArrayList<>(); // put all solutions here
        // measure performance
        long startTime = System.currentTimeMillis();
        solvePuzzle(charSet.length(), "", digits, charSet, equation, squenceList);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("computed in " + elapsed + " ms");

        // when no solution 
        if (squenceList.size() == 0) {
            System.out.println("No solution has been founded :(");
        }
        else {
            // solve with first founded squence
            String solution = getSolution(squenceList.get(0), charSet, equation);
            System.out.println(solution);
            if (squenceList.size()  - 1 != 0) 
                // print out num of other solution
                System.out.println("Also there are " + (squenceList.size()  - 1) + " other solution exist");
        }
    }

    // k for desired length of the sequence 
    public static void solvePuzzle(int k, String sequence, String  digits, String charSet, String equation, ArrayList<String> squenceList) {
        for (int i = 0; i < digits.length(); i++) {
            sequence += digits.charAt(i);
            if (k == 1) {
               if (canSolve(sequence, charSet, equation)) {
                   squenceList.add(sequence);
               }
            }
            else {
                // send digits excepts current indexed one
                solvePuzzle(k - 1, sequence, digits.substring(0, i) + digits.substring(i + 1), charSet, equation, squenceList); 
            }
            sequence = sequence.substring(0, sequence.length() - 1);
        }
    } 

    // 
    public static boolean canSolve(String sequence, String charSet, String equation) {
        // clean spaces and split equation to three part
        String values[] = equation.split(",");
        int number1 = getNumber(sequence, charSet, values[0]);
        int number2 = getNumber(sequence, charSet, values[1]);
        int result = getNumber(sequence, charSet, values[2]);
        return number1 + number2 == result;
    }

    // return valid solution according to given sequence 
    public static String getSolution(String sequence, String charSet, String equation) {
        // clean spaces and split equation to three part
        equation = equation.replaceAll(" ","");
        String values[] = equation.split(",");
        int number1 = getNumber(sequence, charSet, values[0]);
        int number2 = getNumber(sequence, charSet, values[1]);
        int result = getNumber(sequence, charSet, values[2]);
        return putFrontZeros(number1, values[0].length()) + " + "  + 
               putFrontZeros(number2, values[1].length()) + " = " +
               putFrontZeros(result, values[2].length());
    }

      
    // put preceeding zeros before present the number
    public static String putFrontZeros(int number, int desiredLen) {
        String numStr = String.valueOf(number);
        for (int i = 0; i < desiredLen - numStr.length(); i++)
            numStr = "0" + numStr;
        return numStr;
    }
        


    // return real numerical digits of value
    // example: 
    // squence -> 132
    // digits  -> cat
    public static int getNumber(String squence, String charSet, String value) {
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            result += squence.charAt(charSet.indexOf(value.charAt(i)));  
        }
        return Integer.valueOf(result);
    }

    // return unique char set of equation
    // abc + bac = def -> {a, b, c, d, e, f}
    public static String getCharSet(String equation) {
        equation = equation.replaceAll(",","");
        String set = "";
        for (int i = 0; i < equation.length(); i++) {
            if (!set.contains(String.valueOf(equation.charAt(i))))
                    set += equation.charAt(i);
        }
        return set;
    } 

    // check input validity
    public static void checkInputs(String equation) {
        // check words length
        for (String word : equation.split(",")) {
            if (word.length() < 2 || word.length() > 6) 
                throw new IllegalArgumentException("Word length must be in range [2,6]: " + word);  
        }
        // check number of unique char
        String charSet = getCharSet(equation);
        if (charSet.length() > 10)
                throw new IllegalArgumentException("Too many distinct char: " +  (charSet.length()));  
    }

}
