package life;

import javax.swing.*;
import java.awt.*;

public class LifePanel extends JPanel {

    private IndividualCell[][] cellArray;

    public LifePanel() {
        new javax.swing.JPanel();
    }

    public void initialize(int dimension) {

        this.setLayout(new GridLayout(dimension, dimension, 1, 1));
        this.cellArray = new IndividualCell[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cellArray[i][j] = new IndividualCell();
                this.add(cellArray[i][j]);
            }
        }
    }
    public void updateCellArray(boolean[][] board) {
        if (cellArray != null) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (cellArray[i][j].isAlive() != board[i][j]) {
                        cellArray[i][j].setAlive(board[i][j]);
                    }
                }
            }
            repaint();
        } else {
            initialize(board.length);
            updateCellArray(board);
        }
    }
}

