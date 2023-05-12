import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SiftedInsertion {

    public static void main(String[] args) {

        int n = (int)Math.pow(2, 16);
        int[] randArray = createArray(n);
        for (int i = 1; i <= 15; i++) { 
            int k = i * n /  16; 
            long startTime = System.currentTimeMillis();
            insertionSort(rightRotate(randArray, k));
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.println("Time elapsed: " + timeElapsed);
        }
    }

    public static void insertionSort(int A[]) {
        for (int i = 1; i < A.length; i++) {
            int j = i - 1;
            int x = A[i];
            while (j > -1 && A[j] > x) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = x;
        }
    }

    public static int[] rightRotate(int A[], int k){
        ArrayList<Integer> numberList = toArrayList((A));
        for (int i = 0; i < k; i++ ) { 
            int removed = numberList.remove(numberList.size() - 1);
            numberList.add(0, removed);
        }
        return convertIntegers(numberList);
    }


    public static ArrayList<Integer> toArrayList(int[] nums) { 
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int num : nums)
        {
            intList.add(num);
        }
        return intList;
    }

    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static int[] createArray(int n) { 
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; 
        }
        return numbers;
    }


}

