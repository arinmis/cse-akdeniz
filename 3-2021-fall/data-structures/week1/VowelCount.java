import java.util.*;

/* 
 * write a program that counts number
 * of vowel in given string
 *
 */

public class VowelCount{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("enter string to count vowel: "); 
            System.out.println("Number of vowel: " + countVowel(input.next())); 
        }
    }

    public static int countVowel(String str) {
        int count = 0;
        for (char chr : str.toCharArray()) {
            if(chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u' )
                count++;
        }
        return count;
    }

}
