/**
 * An equation puzzle solver with recursive brute force
 * In puzzle, each character represents a distinct digit 
 *
 * Example puzzle: a + b = c 
 * Solution:       1 + 2 = 3  
 *
 * @author Mustafa Arinmis 
 * @since  2021-10-23
 */

import java.util.*;

public class SolveEquation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("enter equation: " );
        String equation = input.nextLine().replaceAll(" ","");
        // update cli before computation
        System.out.print("Solution: ");
        String charSet = getCharSet(equation);
        String digits = "0123456789"; 
        ArrayList<String> squenceList = new ArrayList<>(); // put all solutions here
        solvePuzzle(charSet.length(), "", digits, charSet, equation, squenceList);
        // when no solution 
        if (squenceList.size() == 0) {
            System.out.println("No solution has been founded: " + equation);
        }
        else {
            // solve with first founded squence
            String solution = getSolution(squenceList.get(0), charSet, equation);
            System.out.println(solution);
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
        String values[] = equation.split("\\+|\\=");
        int number1 = getNumber(sequence, charSet, values[0]);
        int number2 = getNumber(sequence, charSet, values[1]);
        int result = getNumber(sequence, charSet, values[2]);
        return number1 + number2 == result;
    }

    // return valid solution according to given sequence 
    public static String getSolution(String sequence, String charSet, String equation) {
        // clean spaces and split equation to three part
        equation = equation.replaceAll(" ","");
        String values[] = equation.split("\\+|\\=");
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
        String set = "";
        for (int i = 0; i < equation.length(); i++) {
            // skip non-numerical ones 
            if (equation.charAt(i) == '+' || equation.charAt(i) == '=')
               continue;
            if (!set.contains(String.valueOf(equation.charAt(i))))
                    set += equation.charAt(i);
        }
        return set;
    } 

}
