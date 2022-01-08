import java.util.*;

public class TicTacToe {

    public static final int X = 1, O = -1, EMPTY = 0;
    private int[][] board = new int[3][3];
    private int player;

    // contructer
    public TicTacToe() {
        this.player = this.X;
    }

    public void putMark(int i, int j) {
        // check is slot empty 
        if (!(this.board[i][j] == this.EMPTY))
            throw new IllegalArgumentException("place was occupied");
        // check given index are valid
        if ( i < 0 || i > this.board.length || j < 0 || j > this.board.length)
            throw new IllegalArgumentException("invalid board place"); 

        board[i][j] = this.player;
        // change player
        this.player = -this.player;
    }

    // return wheter the game end or not 
    public boolean isWin(int player) {
        // final point to end game
        int total = 3 * player;
        // check column 
        for (int i = 0; i < this.board.length; i++) {
            int sum = board[0][i] + board[1][i] + board[2][i];
            if ( total == sum)
                return true;
        }
        // check row 
        for (int i = 0; i < this.board[0].length; i++) {
            int sum = board[i][0] + board[i][1] + board[i][2];
            if (total == sum)
                return true;
        }
        // check diogonal 
        if (total ==  board[0][0] + board[1][1] + board[2][2])
            return true;
        // check other diogonal 
        if (total ==  board[0][2] + board[1][1] + board[2][0])
            return true;
        // no win
        return false;
    }

    // return winner if exist
    // else return 0
    public int winner() {
        if (isWin(this.X))
            return this.X;
        else if (isWin(this.O)) 
            return this.O;
        return 0;
    }

    // reset game
    public void clearBoard() {
        for (int i = 0; i < this.board.length; i++ ) {
            for (int j = 0; j < this.board[0].length; j++ ) {
                board[i][j] = this.EMPTY;
            }
        }
    }

    @Override 
    public String toString() { 
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.board.length; i++ ) {
            for (int j = 0; j < this.board[0].length; j++ ) {
                if (board[i][j] == this.X)
                    str.append("X");
                else if (board[i][j] == this.O)
                    str.append("O");
                else 
                    str.append(" ");
                // baord ui
                if (j < 2)
                    str.append("|");
            }
            // baord ui
            if (i < 2)
                str.append("\n....\n");
        }
        return str.toString();
    }

    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        game.putMark(0,0);
        game.putMark(1,2);
        game.putMark(0,1);
        game.putMark(1,1);
        game.putMark(0,2);
        System.out.println(game);
    }

}

