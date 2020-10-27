package life;

public class LifeController extends Thread {

    private LifeBoard board;
    private GameOfLife window;
    private int size;

    public LifeController(LifeBoard board, GameOfLife window, int size) {
        this.board = board;
        this.window = window;
        this.size = size;
    }

    public void run() {

        int gen = 0;

        window.getLifePanel().initialize(size);

        while (true) {
            //Make a new thread for each update. See UpdateThread.java for reason.
            var t = new UpdateThread(board, window, gen);

            if (window.getPlayPauseButton().isSelected()) {
                t.start();

                //Wait for UpdateThread to finish
                try {
                    t.join();
                } catch (InterruptedException ex) {
                    System.out.println("error");
                }

                //Advance the model by 1 generation
                GenerationAlgo.updatePop(board);
                gen++;

                //Pause long enough for human vision
                try {
                    sleep(500L);
                } catch (InterruptedException ex) {
                    System.out.println("error");
                }
            } else {
                t.interrupt();
            }
            if (window.getResetButton().getModel().isPressed()) {
                gen = 0;
                board = new LifeBoard(size);
                System.out.println("reset");
                t.interrupt();
            }
        }
    }
}
