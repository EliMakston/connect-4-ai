public class GameLogic {
    static GameWindowListener gwl;
    static Window frame;
    public static void main(String[] args) {
        gwl = new GameWindowListener();
        frame = new Window("Connect 4");
        frame.panel.addMouseListener(gwl);
    }
}
