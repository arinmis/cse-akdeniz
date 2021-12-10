import java.util.*;

public class Board {
    public static final int X = 1, O = -1; // players
    public static final int EMPTY = 0; // empty cell 
    private int player;
    private int[][] board;

    // initialize board
    public Board() {
        this.board = new int[3][3]; 
        player = X;
    }
    
    // sketch given place     
    public void putMark(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2)
            throw new IllegalArgumentException("invalid place: " + x + ", " + y);
        if (this.board[x][y] != EMPTY)
            throw new IllegalArgumentException("board position occupied: " + x + ", " + y);
        this.board[x][y] = player;
        player = - player; // switch the player
    } 

    // go to initial state
    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    @Override 
    public String toString() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int value = this.board[i][j];
                if (value == X)
                    result += "X ";
                else if (value == O) 
                    result += "O ";
                else 
                    result += "- ";
            }
            if (i != board.length - 1)
                result += "\n";
        }
        return result;
    }


    // check is there any winner
    private boolean isWin(int mark) {
        return ( 
        // check rows
                (board[0][0] + board[0][1] + board[0][2] == mark * 3) ||
                (board[1][0] + board[1][1] + board[1][2] == mark * 3) ||
                (board[2][0] + board[2][1] + board[2][2] == mark * 3) ||
        // check columns 
                (board[0][0] + board[1][0] + board[2][0] == mark * 3) ||
                (board[0][1] + board[1][1] + board[2][1] == mark * 3) ||
                (board[0][2] + board[1][2] + board[2][2] == mark * 3) ||
        // check diogonals
                (board[0][0] + board[1][1] + board[2][2] == mark * 3) ||
                (board[2][0] + board[1][1] + board[0][2] == mark * 3) 
              ); 
    } 

    /* return winning player's code */
    public int winner() {
        if (isWin(X))
            return X;
        else if (isWin(O))
            return O;
        return 0;
    }

    public void print2D(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }

    // find computers move
    public void moveAI() {
        System.out.println("move is calculating");

        // print2D(backupBoard);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                // create back-up
                int[][] backupBoard = this.copy();  
                // put marks
                putMark(i, j);
                System.out.println("board:" + "\n" + this.toString() + "\n");
                // reset changes
                this.board = backupBoard;
                // same player
                player = - player;
            }
        }
    }


    // copy matrix
    private int[][] copy() {
        int [][] cloneBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                cloneBoard[i][j] = board[i][j];
            }
        }
        return cloneBoard;
    }


}
