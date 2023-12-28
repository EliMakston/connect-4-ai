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

    public boolean makeMove(int columnNumber, byte playerID) {
        for (int i = 0; i < currentPosition[columnNumber].length; i++) {
            if (currentPosition[columnNumber][i].ID == 0b00) {
                currentPosition[columnNumber][i].ID = playerID;
                return true;
            }
        }
        return false;
    }

    public void printCurrentPosition() {
        for (int i = 0; i < currentPosition.length; i++) {
            for (int z = 0; z < currentPosition[i].length; z++) {
                System.out.print(currentPosition[i][z].ID);
            }
            System.out.print("\n");
        }
    }

    public byte checkIfPlayerWon() {
        int i = 0;
        while (i < currentPosition.length) {
            for (int z = 0; z < currentPosition[i].length; z++) {
                if ((i + 3 < currentPosition.length - 1)) {
                    if (currentPosition[i][z].ID == currentPosition[i + 1][z].ID && currentPosition[i][z].ID == currentPosition[i + 2][z].ID && currentPosition[i][z].ID == currentPosition[i + 3][z].ID) {
                        if (!(currentPosition[i][z].ID == 0b00)) {
                            return currentPosition[i][z].ID;
                        }
                    }
                }
                if (!(z + 3 > currentPosition[i].length - 1)) {
                    if (currentPosition[i][z].ID == currentPosition[i][z + 1].ID && currentPosition[i][z].ID == currentPosition[i][z + 2].ID && currentPosition[i][z].ID == currentPosition[i][z + 3].ID) {
                        if (!(currentPosition[i][z].ID == 0b00)) {
                            return currentPosition[i][z].ID;
                        }
                    }
                    if ((i + 3 < currentPosition.length - 1)) {
                        if (currentPosition[i][z].ID == currentPosition[i + 1][z + 1].ID && currentPosition[i][z].ID == currentPosition[i + 2][z + 2].ID && currentPosition[i][z].ID == currentPosition[i + 3][z + 3].ID) {
                            if (!(currentPosition[i][z].ID == 0b00)) {
                                    return currentPosition[i][z].ID;
                                }
                        }
                    }
                }
                if (!((z - 3) < 0)) {
                    if ((i + 3 < currentPosition.length - 1)) {
                        if (currentPosition[i][z].ID == currentPosition[i + 1][z - 1].ID && currentPosition[i][z].ID == currentPosition[i + 2][z - 2].ID && currentPosition[i][z].ID == currentPosition[i + 3][z - 3].ID) {
                            if (!(currentPosition[i][z].ID == 0b00)) {
                                return currentPosition[i][z].ID;
                            }
                        }
                    }
                }
            }
            i++;
        }
        return 0b00;
    }
}
