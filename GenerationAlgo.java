package life;

public class GenerationAlgo {

    public static void updatePop(LifeBoard b) {

        //gets the current state of the Model
        boolean[][] current = b.getBoard();

        //creates a new 2D array to hold the next generation
        int size = current.length;
        boolean[][] next = new boolean[size][size];

        //nested loop iterates over all cells in 2D array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                //counts neighbors of each cell
                int count = countNeighbors(current, i, j);

                //Conway's Game of Life rules
                if (!current[i][j] && count == 3) {
                    next[i][j] = true;
                } else if (current[i][j] && (count == 2 || count ==3)) {
                    next[i][j] = true;
                } else {
                    next[i][j] = false;
                }
            }
        }

        //updates the Model with the next generation
        b.setBoard(next);
    }

    private static int countNeighbors(boolean[][] board, int row, int col) {
        int count = 0;
        int size = board.length;

        //Nested loops looks at 3x3 block of cells, centered on the coords passed to the method.
        for(int i = row - 1; i <= row + 1; i++) {
            for (int j = col -1; j <= col + 1; j++) {

                //Skips the middle cell; a cell can't be its own neighbor.
                if(i==row && j==col){
                    continue;
                }

                //Uses modular arithmetic to handle cells at the edges of the array
                if (board[(i + size) % size][(j + size) % size]) {
                    count++;
                }
            }
        }
        return count;
    }
}
