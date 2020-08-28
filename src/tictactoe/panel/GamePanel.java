package tictactoe.panel;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static java.awt.Color.WHITE;

public class GamePanel extends JPanel {
    /**
     * This image represents 'X'.
     */
    private static final ImageIcon X;

    /**
     * This image represents 'O'.
     */
    private static final ImageIcon O;

    static {
        X = new ImageIcon("resources\\x.png");
        O = new ImageIcon("resources\\o.png");
    }

    /**
     * Array which contains information about the moves.
     */
    private final char[] xo;

    /**
     * This variable decides what image to set or if it is a draw.
     */
    private int decider;

    /**
     * This variable represents current game's status.
     */
    private boolean gameHasNotFinished;

    {
        xo = new char[] {'░', '░', '░',
                         '░', '░', '░',
                         '░', '░', '░'};

        decider = 0;

        gameHasNotFinished = true;

        final JButton[] buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setName(String.valueOf(i));
            buttons[i].addActionListener(listener -> {
                final JButton source = (JButton) listener.getSource();

                final int sourceId = Integer.parseInt(source.getName());

                if (decider % 2 == 0) {
                    source.setIcon(X);
                    source.setDisabledIcon(X);
                    xo[sourceId] = 'x';
                } else {
                    source.setIcon(O);
                    source.setDisabledIcon(O);
                    xo[sourceId] = 'o';
                }

                source.setEnabled(false);

                ++decider;

                if (decider >= 5) {
                    checkRows();
                    if (gameHasNotFinished) checkColumns();
                    if (gameHasNotFinished) checkDiagonals();
                }

                if (decider == 9 && gameHasNotFinished) {
                    switchToEndGamePanel("Draw!");
                }
            });
            buttons[i].setBackground(WHITE);
            buttons[i].setFocusable(false);
            add(buttons[i]);
        }
    }

    public GamePanel() {
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(3, 3, 0, 0));
    }

    /**
     * This method calls another method with two different arguments
     * to check if someone has three 'X' or three 'O' in a row.
     *
     * @author svalyavakilia
     */
    private void checkRows() {
        checkRows('x');
        checkRows('o');
    }

    /**
     * This method checks if someone has three 'X' or three 'O' in a row.
     *
     * @author svalyavakilia
     */
    private void checkRows(final char symbol) {
        if (xo[0] == symbol && xo[1] == symbol && xo[2] == symbol
            ||
            xo[3] == symbol && xo[4] == symbol && xo[5] == symbol
            ||
            xo[6] == symbol && xo[7] == symbol && xo[8] == symbol) {
            gameHasNotFinished = false;

            switchToEndGamePanel((symbol == 'x') ? "X won!" : "O won!");
        }
    }

    /**
     * This method calls another method with two different arguments
     * to check if someone has three 'X' or three 'O' in a column.
     *
     * @author svalyavakilia
     */
    private void checkColumns() {
        checkColumns('x');
        checkColumns('o');
    }

    /**
     * This method checks if someone has three 'X' or three 'O' in a column.
     *
     * @author svalyavakilia
     */
    private void checkColumns(final char symbol) {
        if (xo[0] == symbol && xo[3] == symbol && xo[6] == symbol
            ||
            xo[1] == symbol && xo[4] == symbol && xo[7] == symbol
            ||
            xo[2] == symbol && xo[5] == symbol && xo[8] == symbol) {
            gameHasNotFinished = false;

            switchToEndGamePanel((symbol == 'x') ? "X won!" : "O won!");
        }
    }

    /**
     * This method calls another method with two different arguments
     * to check if someone has three 'X' or three 'O' in a diagonal.
     *
     * @author svalyavakilia
     */
    private void checkDiagonals() {
        checkDiagonals('x');
        checkDiagonals('o');
    }

    /**
     * This method checks if someone has three 'X' or three 'O' in a diagonal.
     *
     * @author svalyavakilia
     */
    private void checkDiagonals(final char symbol) {
        if (xo[0] == symbol && xo[4] == symbol && xo[8] == symbol
            ||
            xo[2] == symbol && xo[4] == symbol && xo[6] == symbol) {
            gameHasNotFinished = false;

            switchToEndGamePanel((symbol == 'x') ? "X won!" : "O won!");
        }
    }

    /**
     * This method switches JFrame's content pane to a new
     * EndGamePanel.
     *
     * @param result Contains the information on who has won the game
     *               or if it has ended in a draw.
     *
     * @author svalyavakilia
     */
    private void switchToEndGamePanel(final String result) {
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.setContentPane(new EndGamePanel(result));
        window.pack();
    }
}