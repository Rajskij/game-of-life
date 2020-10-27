package life;

public class Main {
    public static void main(String[] args) {

        int size = 80;

        GameOfLife window = new GameOfLife();
        LifeBoard board = new LifeBoard(size);
        LifeController controller = new LifeController(board, window, size);

        controller.start();
    }
}

