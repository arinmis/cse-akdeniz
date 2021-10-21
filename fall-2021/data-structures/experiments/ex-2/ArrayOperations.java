import java.util.Arrays;

public class ArrayOperations {

  public static void main(String[] args) {
    int size = 5;
    int[] numbers = new int[size];
    for (int i = 0; i < size; i++)
      numbers[i] = i + 1;
    shiftLeft(numbers, 0);
    System.out.println(Arrays.toString(numbers));
  }

  /* reverse given arrays elements */
  public static void reverse(int[] arr) {
    for(int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
  }

  /* shift left side  one step starting starting from given index */
  public static void shiftLeft(int[] arr, int index) {
    for (int i = index; i < arr.length - 1; i++) 
      arr[i] = arr[i + 1];
  }

  /* shift right side  one step starting starting from given index */
  public static void shiftRight(int[] arr, int index) {
    for (int i = arr.length - 1; i > index; i--) 
      arr[i] = arr[i - 1];
  }

}
