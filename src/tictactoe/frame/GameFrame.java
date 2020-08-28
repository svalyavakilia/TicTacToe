package tictactoe.frame;

import javax.swing.JFrame;
import tictactoe.panel.GamePanel;

public class GameFrame extends JFrame {
    public GameFrame() {
        setContentPane(new GamePanel());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tic-tac-toe");
        setVisible(true);
    }
}