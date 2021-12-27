import java.io.*;
import java.util.*;

public class HW3_20190808004_2 {

    public static void main(String[] args) {
        // read tree nodes and x
        ArrayList<int[]> nums = readFile(args[0]);
        int[] treeValues = nums.get(0);
        // value x
        int pathSum = nums.get(1)[0]; 
        System.out.println(Arrays.toString(treeValues));
        System.out.println("value x: " + pathSum);
    }

    /* read string from file */
    public static ArrayList<int[]> readFile(String path) {
        ArrayList<int[]> result = new ArrayList<>(2);
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                result.add(getNumbers(line)); // convert line to int array
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not foud: " + path);
            e.printStackTrace();
        }
        return result;
    }

    /* convert spaced line string to number array */
    public static int[] getNumbers(String line) {
        String[] asStr = line.split(" ");
        int[] numbers = new int[asStr.length];
        for (int i = 0; i < asStr.length; i++) {
            numbers[i] = Integer.valueOf(asStr[i]);
        }
        return numbers;
    }

}
