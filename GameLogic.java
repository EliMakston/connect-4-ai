public class GameLogic {
    static GameWindowListener gwl;
    static Window frame;
    public static void main(String[] args) {
        Board gameBoard = new Board();
        AI ai = new MiniMaxAI(gameBoard, (byte) 0b10);
        frame = new Window("Connect 4");
        gwl = new GameWindowListener(gameBoard, frame.panel, ai);
        frame.panel.addMouseListener(gwl);
    }
}
