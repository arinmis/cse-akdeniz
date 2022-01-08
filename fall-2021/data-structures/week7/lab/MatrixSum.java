/**
 * Write a recursive algorithm to compute
 * the sum of all elements in an nxn(2D)
 * arrays of integer.
 *
 * @author Mustafa Arinmis
 * @since 06.11.2021
 */
public class MatrixSum {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1}, {1, 1}};  
        int total = sum(matrix, 0, 0, 0);
        System.out.println(total);
    }

    // find sum of the elements of the given 2D array
    public static int sum(int[][] matrix, int i, int j, int total) {
        // add current index to sum
        total += matrix[i][j];
        // base case
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return total;
        // go to next row, first column
        if (j == matrix[0].length - 1) { 
            // pass to next row and start at first column
            return sum(matrix, i + 1, 0, total); 
        }
        return  sum(matrix, i, j + 1, total);
    }

}
