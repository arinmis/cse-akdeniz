import java.util.Random;
import java.util.ArrayList;

public class Hungarian {
    public static void main(String[] args) {
        ArrayList<int[]> randArrays = createRandArrays(10);
        for (int[] array : randArrays) {
            // System.out.println("Array: " +  Arrays.toString(array));
            long startTime = System.currentTimeMillis(); 
            hungarianQuickSort(array, 0, array.length - 1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.println("Time elapsed: " + timeElapsed);
            System.out.println();
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotIndex = low;
        int i = high;
        while (i != pivotIndex) { 
            if (pivotIndex < i) {
                if (arr[pivotIndex] > arr[i]) { 
                    swap(arr, pivotIndex, i);
                    int temp = pivotIndex;
                    pivotIndex = i;
                    i = temp + 1;
                }
                else {
                    i--;
                }
            }
            else if (pivotIndex > i) { 
                if (arr[pivotIndex] < arr[i]) { 
                    swap(arr, pivotIndex, i);
                    int temp = pivotIndex;
                    pivotIndex = i;
                    i = temp - 1;
                }
                else {
                    i++;
                }
            }
        }
        return i;
    }

    public static void hungarianQuickSort(int[] arr, int low, int high) {
        if (low > high) {
            return ;
        }
        int p = partition(arr, low, high);
        hungarianQuickSort(arr, low, p - 1);
        hungarianQuickSort(arr, p + 1, high);
    }


    public static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] createRandArray(int n) { 
        Random rand = new Random();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        return numbers;
    }

    public static ArrayList<int[]> createRandArrays(int n) { 
        int K = 1000;
        ArrayList<int[]> arrays = new ArrayList<int[]>();
        for (int i = 1; i < n + 1; i++) {
            arrays.add(createRandArray(i * 10 * K));
        }
        return arrays;
    }
}
