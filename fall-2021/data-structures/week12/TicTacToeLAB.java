import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author :Omer Aslan
 * @since :26.11.2021
 */
public class TicTacToeLAB {

    public static double fitness(Board board) {
        return (double) board.countO / (board.countX + board.countO);
    }

    public static void main(String[] Args) throws IllegalAccessException {
        double temp;
        Board best;
        Board game1 = new Board();
        game1.printBoard();
        do {
            System.out.println("round1: " + game1.round);
            game1.getPlayerMove();
            // game1.putMark(1, 1);
            // game1.printBoard();
            game1.calculateComputerMove();

            // assign temp value
            if (game1.round % 2 == 0)
                temp = Double.NEGATIVE_INFINITY;
            else
                temp = Double.POSITIVE_INFINITY;


            best = null;
            for (Board child : game1.children) {
                double ratio = fitness(child);// (double)child.countO / (child.countX + child.countO);
                System.out.println(ratio);
                if (game1.round % 2 == 0) {
                    if (ratio > temp) {
                        temp = ratio;
                        best = child;
                    }
                }
                else {
                    if (ratio < temp) {
                        temp = ratio;
                        best = child;
                    }
                }
            }
            System.out.println();
            best.printBoard();
            game1 = best;
        } while (game1.winner() == 0 && game1.children.size() > 0);

    }
}

class Board {
    public static final int X = 1, O = -1, EMPTY = 0;
    private int[][] boardArray = new int[3][3];
    private int player; // if player=1 X will play else if =-1 O will play
    public ArrayList<Board> children;
    public Board parent;
    public int countX = 0, countO = 0;
    public int round;

    Board() {
        children = new ArrayList<>(9);
        clearBoard();
        round = 0;
    }

    public void moveFromUser(int i, int j) {
        this.boardArray[i][j] = X;
    }

    public void clearBoard() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                boardArray[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void printBoard() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                if (boardArray[i][j] == 1)
                    System.out.print("X  ");
                else if (boardArray[i][j] == -1)
                    System.out.print("O  ");
                else
                    System.out.print(".  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isWin(int a) {
        if (boardArray[0][0] + boardArray[0][1] + boardArray[0][2] == 3 * a) {
            return true;
        } else if (boardArray[1][0] + boardArray[1][1] + boardArray[1][2] == 3 * a) {
            return true;
        } else if (boardArray[2][0] + boardArray[2][1] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[0][0] + boardArray[1][0] + boardArray[2][0] == 3 * a) {
            return true;
        } else if (boardArray[0][1] + boardArray[1][1] + boardArray[2][1] == 3 * a) {
            return true;
        } else if (boardArray[0][2] + boardArray[1][2] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[0][0] + boardArray[1][1] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[2][0] + boardArray[1][1] + boardArray[0][2] == 3 * a) {
            return true;
        } else
            return false;
    }

    public void putMark(int i, int j) throws IllegalAccessException {
        if (i < 0 || i > 2 || j < 0 || j > 2)
            throw new IllegalAccessException("Invalid Board position");
        if (boardArray[i][j] != EMPTY)
            throw new IllegalAccessException("Board position occupied");
        boardArray[i][j] = player;
        player = -player;
        this.round++;
    }

    public void getPlayerMove() throws IllegalAccessException {
        int i, j;
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Please enter i = ");
            i = s.nextInt();
            System.out.print("Please enter j = ");
            j = s.nextInt();
        } while (i < 0 || i > 2 || j < 0 || j > 2 || (boardArray[i][j] != EMPTY));

        putMark(i, j);
    }

    public void printTree() {
        if (this.winner() != 0)
            this.printBoard();
        for (Board child : this.children) {
            child.printTree();
        }
    }

    public void calculateComputerMove() {
        this.children.clear();
        // System.out.println("Calculating the Computer's Move...");
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                if (boardArray[i][j] == EMPTY) {
                    Board tic = this.cloneBoard();
                    tic.parent = this;
                    try {
                        tic.putMark(i, j);
                        this.children.add(tic);
                        int winner = tic.winner();
                        if (winner == EMPTY) {
                            tic.calculateComputerMove();
                        } else {
                            if (winner == X) {// X
                                this.countX++;
                            } else if (winner == O) {
                                this.countO++;
                            }

                            Board temp = tic;
                            while (temp.parent != null) {
                                temp = temp.parent;
                                if (winner == X) {// X
                                    temp.countX++;
                                } else {
                                    temp.countO++;
                                }
                            }
                        }
                    } catch (IllegalAccessException iae) {
                    }
                    // tic.printBoard();
                }
            }
        }
    }

    public int winner() {
        if (isWin(X))
            return (X);
        else if (isWin(O))
            return (O);
        else
            return (0);
    }

    public Board cloneBoard() {
        Board newBoard = new Board();
        for (int i = 0; i < this.boardArray.length; i++) {
            for (int j = 0; j < this.boardArray[0].length; j++) {
                newBoard.boardArray[i][j] = this.boardArray[i][j];
            }
        }
        newBoard.player = this.player;
        return newBoard;
    }
}
