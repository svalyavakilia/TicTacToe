package tictactoe.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;

public class MainMenuPanel extends JPanel {
    /**
     * Starts a new game.
     */
    private final JButton play;

    {
        play = new JButton();
    }

    public MainMenuPanel() {
        setPreferredSize(new Dimension(300, 300));
        setLayout(null);
        setBackground(new Color(232, 222, 47));

        play.setSize(new Dimension(200, 80));
        play.setLocation(new Point(50, 110));
        play.setText("Play!");
        play.setFont(new Font(MONOSPACED, BOLD, 25));
        play.setBackground(new Color(181, 230, 29));
        play.addActionListener(listener -> switchToGamePanel());
        play.setFocusable(false);

        add(play);
    }

    /**
     * This method switches JFrame's content pane to a new
     * GamePanel.
     *
     * @author svalyavakilia
     */
    private void switchToGamePanel() {
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.setContentPane(new GamePanel());
        window.pack();
    }
}