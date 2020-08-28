package tictactoe.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;
import static javax.swing.SwingConstants.CENTER;

public class EndGamePanel extends JPanel {
    /**
     * Shows the result of the game.
     */
    private final JLabel result;

    /**
     * Starts a new game.
     */
    private final JButton replay;

    /**
     * Exits the application.
     */
    private final JButton exit;

    {
        result = new JLabel();
        replay = new JButton();
        exit = new JButton();
    }

    public EndGamePanel(final String result) {
        setPreferredSize(new Dimension(300, 300));
        setLayout(null);
        setBackground(new Color(232, 222, 47));

        final Font endGamePanelFont = new Font(MONOSPACED, BOLD, 25);

        this.result.setSize(new Dimension(100, 40));
        this.result.setLocation(100, 20);
        this.result.setText(result);
        this.result.setFont(endGamePanelFont);
        this.result.setHorizontalAlignment(CENTER);
        this.result.setBorder(BorderFactory.createDashedBorder(BLACK, 10, 5));

        replay.setSize(new Dimension(200, 80));
        replay.setLocation(50, 90);
        replay.setText("Replay!");
        replay.setFont(endGamePanelFont);
        replay.setBackground(new Color(181, 230, 29));
        replay.addActionListener(listener -> switchToGamePanel());
        replay.setFocusable(false);

        exit.setSize(new Dimension(200, 80));
        exit.setLocation(50, 200);
        exit.setText("Exit!");
        exit.setFont(endGamePanelFont);
        exit.setBackground(new Color(181, 230, 29));
        exit.addActionListener(listener -> System.exit(0));
        exit.setFocusable(false);

        add(this.result);
        add(replay);
        add(exit);
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