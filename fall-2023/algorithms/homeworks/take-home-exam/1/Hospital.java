import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;



public class Hospital {
    public static void main(String[] args) {
        ArrayList<int[]> randArrays = createRandArrays(10);
        for (int[] patients : randArrays) {
            // System.out.println("Array: " +  Arrays.toString(array));
            long startTime = System.currentTimeMillis(); 
            int missingPatient = findMissingPatient(patients, 0, patients.length - 1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.println("missing patient: " + missingPatient);
            System.out.print("Time elapsed:" +  timeElapsed + "\n");
            System.out.println();
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = high;
        int i = low;
        for (int j = low; j < pivot; j++) { 
            if (arr[j] < arr[pivot]) {
                swap(arr, j, i); 
                i++;
            }
        }
        swap(arr, i, pivot);
        return i;
    }

    public static int findMissingPatient(int[] arr, int low, int high) {
        if (low > high) {
            return low + 1;
        }
        int p = partition(arr, low, high);
        // missing on the low
        if (arr[p] - p !=  1) {
            return findMissingPatient(arr, low, p - 1);
        }
        return findMissingPatient(arr, p + 1, high);
    }


    public static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] createRandArray(int n) { 
        Random rand = new Random();
        ArrayList<Integer> seqNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqNums.add(i + 1);
        }
        // remove random element
        seqNums.remove(rand.nextInt(seqNums.size()));
        int[] seqArray = toIntArray(seqNums);
        shuffleArray(seqArray);
        return seqArray;
    }

    public static ArrayList<int[]> createRandArrays(int n) { 
        int K = 1000;
        ArrayList<int[]> arrays = new ArrayList<int[]>();
        for (int i = 1; i < n + 1; i++) {
            arrays.add(createRandArray(i * 10 * K));
        }
        return arrays;
    }

     public static int[] toIntArray(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }


  public static void shuffleArray(int[] array) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      swap(array, index, i);
    }
  }
}
