public class Board {
    Piece[][] currentPosition;
    boolean isPlayerOneTurn;
    boolean isGameOver;

    Board() {
        currentPosition = new Piece[7][6];
        isGameOver = false;
        isPlayerOneTurn = true;
        generateBlankBoard();
    }

    private void generateBlankBoard() {
        for (int i = 0; i < currentPosition.length; i++) {
            for (int z = 0; z < currentPosition[i].length; z++) {
                currentPosition[i][z] = new Piece();
            }
        }
    }
}
