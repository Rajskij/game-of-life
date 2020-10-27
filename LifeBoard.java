package life;

import java.util.Random;

public class LifeBoard {

    private boolean[][] board;
    private Random rand;

    public LifeBoard(int size) {
        board = new boolean[size][size];
        rand = new Random();
        initializeBoard();
    }

    //initializes the life universe cells randomly
    private void initializeBoard() {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = rand.nextBoolean();
            }
        }
    }

    //returns current state of the life universe
    public boolean[][] getBoard() {
        return board;
    }

    //Setter used by GenerationAlgo.java
    public void setBoard(boolean[][] b) {
        board = b;
    }

    //returns number of living cells
    public int countLiving() {
        int count = 0;
        for(boolean[] b : board) {
            for (boolean c : b) {
                if (c) {
                    count++;
                }
            }
        }
        return count;
    }
}