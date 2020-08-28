package tictactoe.frame;

import javax.swing.JFrame;
import tictactoe.panel.MainMenuPanel;

public class GameFrame extends JFrame {
    public GameFrame() {
        setContentPane(new MainMenuPanel());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tic-tac-toe");
        setVisible(true);
    }
}