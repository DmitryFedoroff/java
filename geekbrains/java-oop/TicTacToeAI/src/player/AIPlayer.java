package player;

import model.GameField;
import model.GameSymbol;

public class AIPlayer implements Player {
    private static final int MAX_DEPTH = 5;
    private static final int AI_WIN_SCORE = 10;
    private static final int HUMAN_WIN_SCORE = -10;

    @Override
    public void makeMove(GameField field) {
        int[] result = minimax(MAX_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE, field, true);
        field.setCell(result[1], result[2], GameSymbol.O);
    }

    private int[] minimax(int depth, int alpha, int beta, GameField field, boolean isMaximizingPlayer) {
        if (depth == 0 || field.checkWin(GameSymbol.O) || field.checkWin(GameSymbol.X)) {
            return new int[]{evaluateBoard(field), -1, -1};
        }

        int bestX = -1;
        int bestY = -1;

        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.isCellEmpty(i, j)) {
                    if (isMaximizingPlayer) {
                        field.setCell(i, j, GameSymbol.O);
                        int currentScore = minimax(depth - 1, alpha, beta, field, false)[0];
                        if (currentScore > alpha) {
                            alpha = currentScore;
                            bestX = i;
                            bestY = j;
                        }
                    } else {
                        field.setCell(i, j, GameSymbol.X);
                        int currentScore = minimax(depth - 1, alpha, beta, field, true)[0];
                        if (currentScore < beta) {
                            beta = currentScore;
                            bestX = i;
                            bestY = j;
                        }
                    }
                    field.setCell(i, j, GameSymbol.EMPTY);
                    if (alpha >= beta) {
                        break;
                    }
                }
            }
        }
        return isMaximizingPlayer ? new int[]{alpha, bestX, bestY} : new int[]{beta, bestX, bestY};
    }

    private int evaluateBoard(GameField field) {
        int score = 0;

        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.getCell(i, j) == GameSymbol.O) {
                    if (field.checkLine(i, j, 0, 1, GameSymbol.O)) {
                        score += AI_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, 1, 0, GameSymbol.O)) {
                        score += AI_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, 1, 1, GameSymbol.O)) {
                        score += AI_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, -1, 1, GameSymbol.O)) {
                        score += AI_WIN_SCORE;
                    }
                } else if (field.getCell(i, j) == GameSymbol.X) {
                    if (field.checkLine(i, j, 0, 1, GameSymbol.X)) {
                        score += HUMAN_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, 1, 0, GameSymbol.X)) {
                        score += HUMAN_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, 1, 1, GameSymbol.X)) {
                        score += HUMAN_WIN_SCORE;
                    }
                    if (field.checkLine(i, j, -1, 1, GameSymbol.X)) {
                        score += HUMAN_WIN_SCORE;
                    }
                }
            }
        }
        return score;
    }
}
