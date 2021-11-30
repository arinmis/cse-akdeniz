/**
 * 
 *
 * @author Mustafa Arinmis 
 * @since  2021-10-31
 *
 */

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        //System.out.println(board);
        board.moveAI();
        //System.out.println("winner: " + board.winner());
    }

}

