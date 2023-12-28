import java.util.Random;

public class AI {
    Board currentPosition;
    byte playerID;
    int movesConsidered = 0;

    public AI(Board currentPosition, int i) {
        this.currentPosition = currentPosition;
        this.playerID = (byte) i;
    }

    public boolean makeMove() {
        Random rng = new Random();
        int randomColumn = rng.nextInt(7);
        boolean move = currentPosition.makeMove(randomColumn, playerID);
        return move;
    }
}

class MiniMaxAI extends AI {
    public MiniMaxAI(Board currentPosition, byte playerID) {
        super(currentPosition, playerID);
    }

    public boolean makeMove() {
        Board[] possibleMoves = currentPosition.getAllPossibleMoves(playerID);
        int bestColumn = 0;
        int bestEval = (int) Double.NEGATIVE_INFINITY;
        for (int i = 0; i < possibleMoves.length; i++) {
            int currentEval = minimax(possibleMoves[i], 999999999, false);
            possibleMoves[i].printCurrentPosition();
            if (currentEval > bestEval) {
                bestEval = currentEval;
                bestColumn = i;
            }
            movesConsidered++;
        }
        System.out.printf("There were %d moves considered\n", movesConsidered);
        movesConsidered = 0;
        boolean validMove = currentPosition.makeMove(bestColumn, playerID);
        return validMove;
    }

    private int minimax(Board currentMove, int depth, boolean maximizing) {
        if (depth == 0 || currentMove.checkIfPlayerWon() != 0b00) {
            return currentMove.checkIfPlayerWon();
        }

        if (maximizing) {
            int maxEval = (int) Double.NEGATIVE_INFINITY;
            Board[] possibleMoves = currentMove.getAllPossibleMoves((byte) 0b10);
            for (int i = 0; i < possibleMoves.length; i++) {
                int currentEval = minimax(possibleMoves[i], depth - 1, false);
                maxEval = max(currentEval, maxEval);
                movesConsidered++;
            }
            return maxEval;
        }

        if (!maximizing) {
            int minEval = (int) Double.POSITIVE_INFINITY;
            Board[] possibleMoves = currentMove.getAllPossibleMoves((byte) 0b01);
            for (int i = 0; i < possibleMoves.length; i++) {
                int currentEval = minimax(possibleMoves[i], depth - 1, true);
                minEval = min(currentEval, minEval);
                movesConsidered++;
            }
            return minEval;
        }
        
        return -1;
    }

    public int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    public int min(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        }
        return num2;
    }
}