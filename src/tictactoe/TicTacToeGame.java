package tictactoe;

import javax.swing.SwingUtilities;
import tictactoe.frame.GameFrame;

public class TicTacToeGame {
    /**
     * Creates a new instance of GameFrame class.
     */
    public static void start() {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}