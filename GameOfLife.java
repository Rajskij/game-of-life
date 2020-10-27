package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private JPanel statePanel;
    private JPanel topButtonPanel;
    private JPanel bottomPanel;
    private LifePanel lifePanel;

    private JToggleButton playPauseButton;
    private JButton resetButton;
    private JTextField sizeOfCellPanel;
    private JLabel aliveLabel;
    private JLabel generationLabel;

    public GameOfLife() {
        super("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        statePanel = new JPanel();
        statePanel.setName("State Panel");
        statePanel.setLayout(new BorderLayout());
        add(statePanel, BorderLayout.WEST);

        topButtonPanel = new JPanel();
        topButtonPanel.setName("Top button panel");
        topButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        statePanel.add(topButtonPanel, BorderLayout.NORTH);

        playPauseButton = new JToggleButton("Play/Pause");
        playPauseButton.setName("PlayToggleButton");

        resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");

        topButtonPanel.add(playPauseButton);
        topButtonPanel.add(resetButton);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        statePanel.add(bottomPanel, BorderLayout.CENTER);

        bottomPanel.add(Box.createVerticalStrut(10));

        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("Generation #0");
        generationLabel.setFont(generationLabel.getFont().deriveFont(14f));
        bottomPanel.add(generationLabel);

        bottomPanel.add(Box.createVerticalStrut(10));

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("Alive: 0");
        aliveLabel.setFont(aliveLabel.getFont().deriveFont(14f));
        bottomPanel.add(aliveLabel);

        bottomPanel.add(Box.createHorizontalStrut(10));

        lifePanel = new LifePanel();
        lifePanel.setName("Life Board Panel");
        lifePanel.setBackground(Color.LIGHT_GRAY);
        add(lifePanel,BorderLayout.CENTER);

        setVisible(true);
    }
    //methods to pass field references to the controller
    public LifePanel getLifePanel() {return lifePanel;}
    public JLabel getGenLabel() {return generationLabel;}
    public JLabel getAliveLabel() {return aliveLabel;}
    public JToggleButton getPlayPauseButton() {return playPauseButton;}
    public JButton getResetButton() {return resetButton;}
}
