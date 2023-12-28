public class GameLogic {
    static GameWindowListener gwl;
    static Window frame;
    public static void main(String[] args) {
        Board gameBoard = new Board();
        frame = new Window("Connect 4");
        gwl = new GameWindowListener(gameBoard, frame.panel);
        frame.panel.addMouseListener(gwl);
    }
}
