package life;

public class UpdateThread extends Thread {
    private LifeBoard board;
    private GameOfLife window;
    private int gen;

    public UpdateThread(LifeBoard board, GameOfLife window, int gen) {
        this.board = board;
        this.window = window;
        this.gen = gen;
    }

    @Override
    public void run() {
        //updates generation label
        window.getGenLabel().setText("Generation #" + gen);
        window.getGenLabel().repaint();
        //updates alive label
        window.getAliveLabel().setText("Alive: " + board.countLiving());
        window.getAliveLabel().repaint();
        //calls update method of LifePanel
        window.getLifePanel().updateCellArray(board.getBoard());
    }
}
