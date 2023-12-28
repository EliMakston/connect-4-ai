import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindowListener implements MouseListener{
    Board gameBoard;
    Panel panel;
    int turnNumber = 1;

    public GameWindowListener(Board gameBoard, Panel panel) {
        this.gameBoard = gameBoard;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int columnNumber = (e.getX() / 71);
        boolean validMove = false;
        if (turnNumber % 2 == 0) {
            validMove = gameBoard.makeMove(columnNumber, (byte) 0b10);
        } else {
            validMove = gameBoard.makeMove(columnNumber, (byte) 0b01);
        }
        if (validMove) {
            panel.setBoard(gameBoard);
            panel.repaint();
            byte winnerID = gameBoard.checkIfPlayerWon();
            //System.out.println(winnerID);
            if (winnerID == 0b01) {
                System.out.println("Red won");
            }
            if (winnerID == 0b10) {
                System.out.println("Yellow won");
            }
            turnNumber++;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
