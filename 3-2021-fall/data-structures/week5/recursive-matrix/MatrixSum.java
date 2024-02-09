import java.util.*;

public class MatrixSum {

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1}, {1, 1}};
        int[][] matrix2 = {{2, 2}, {2, 2}};
        int n = matrix1.length;
        int[][] result = new int[n][n];
        sum(matrix1, matrix2, result, 0, 0);
        System.out.println(Arrays.deepToString(result));
    }

    /* perform matrix sum given two matrix */ 
    public static void sum(int[][] m1, int[][] m2, int[][] result, int i, int j) {
        result[i][j] = m1[i][j] + m2[i][j];
        // prevent out of bound
        if (i == m1.length - 1 && j == m1[0].length - 1)
            return;
        // go to next row
        if (j == m1[0].length - 1)  
            sum(m1, m2, result, i + 1, 0); 
        else 
            sum(m1, m2, result, i, j + 1); // go to next column
    }



}
