package life;

import javax.swing.*;
import java.awt.*;

/*
 * Class to represent the individual cells in the Game of Life window.
 * It's a JPanel with a black background, visible if alive and invisible if dead.
 */

public class IndividualCell extends JPanel {

    private boolean alive;

    public IndividualCell() {
        super();
        setVisible(false);
        setBackground(Color.BLACK);
    }

    public IndividualCell(boolean alive) {
        super();
        setAlive(alive);
    }

    //sets living/dead status of cell
    public void setAlive(boolean alive) {
        this.alive = alive;
        setVisible(this.alive);
    }

    //returns living/dead status of cell
    public boolean isAlive() {return alive;}

}