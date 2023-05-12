import java.util.*;

public class Program {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 1;
        // initial numbers
        System.out.println(Arrays.toString(numbers));
        // two times left shift 
        shiftLeft(numbers, 0);
        shiftLeft(numbers, 0);
        // final arrangment
        System.out.println(Arrays.toString(numbers));
    }

    public static void shiftLeft(int[] array, int fromIndex) {
        int temp = array[0];
        for (int i = fromIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;  
    }
}
