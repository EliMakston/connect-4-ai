import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Panel extends JPanel {
    Board gameBoard = new Board();

    Panel() {
        this.setPreferredSize(new Dimension(500, 500));
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        drawBoard(g2D);
    }

    public void drawBoard(Graphics2D g2D) {
        g2D.setColor(Color.GRAY);
        g2D.fillRect(0, 0, 500, 500);
        g2D.setColor(Color.white);
        int leftgap = 7;
        int topgap = 25;
        for (int i = 0; i < gameBoard.currentPosition.length; i++) {
            int x = (leftgap * (2*i + 1)) + (i * 57);
            for (int z = 0; z < gameBoard.currentPosition[i].length; z++) {
                int y = 430 - (z * topgap) - (z * 57);
                g2D.setColor(Color.WHITE);
                if (gameBoard.currentPosition[i][z].ID == 0b01) {
                    g2D.setColor(Color.RED);
                }
                if (gameBoard.currentPosition[i][z].ID == 0b10) {
                    g2D.setColor(Color.YELLOW);
                }
                g2D.fillOval(x, y, 57, 57);
            }
            //g2D.fillOval(x, 435, 57, 57);
        }
    }

    public void setBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
}
