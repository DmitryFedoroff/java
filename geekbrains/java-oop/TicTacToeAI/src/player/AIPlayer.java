package player;

import model.GameField;

public class AIPlayer implements Player {
    private static final int MAX_DEPTH = 5;

    @Override
    public void makeMove(GameField field) {
        int[] result = minimax(MAX_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE, field, true);
        field.setCell(result[1], result[2], 'O');
    }

    private int[] minimax(int depth, int alpha, int beta, GameField field, boolean isMaximizingPlayer) {
        if (depth == 0 || field.checkWin('O') || field.checkWin('X')) {
            return new int[]{evaluateBoard(field), -1, -1};
        }

        int bestX = -1;
        int bestY = -1;

        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.isCellEmpty(i, j)) {
                    if (isMaximizingPlayer) {
                        field.setCell(i, j, 'O');
                        int currentScore = minimax(depth - 1, alpha, beta, field, false)[0];
                        if (currentScore > alpha) {
                            alpha = currentScore;
                            bestX = i;
                            bestY = j;
                        }
                    } else {
                        field.setCell(i, j, 'X');
                        int currentScore = minimax(depth - 1, alpha, beta, field, true)[0];
                        if (currentScore < beta) {
                            beta = currentScore;
                            bestX = i;
                            bestY = j;
                        }
                    }
                    field.setCell(i, j, ' ');
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
                if (field.getCell(i, j) == 'O') {
                    if (field.checkLine(i, j, 0, 1, 'O')) {
                        score += 10;
                    }
                    if (field.checkLine(i, j, 1, 0, 'O')) {
                        score += 10;
                    }
                    if (field.checkLine(i, j, 1, 1, 'O')) {
                        score += 10;
                    }
                    if (field.checkLine(i, j, -1, 1, 'O')) {
                        score += 10;
                    }
                } else if (field.getCell(i, j) == 'X') {
                    if (field.checkLine(i, j, 0, 1, 'X')) {
                        score -= 10;
                    }
                    if (field.checkLine(i, j, 1, 0, 'X')) {
                        score -= 10;
                    }
                    if (field.checkLine(i, j, 1, 1, 'X')) {
                        score -= 10;
                    }
                    if (field.checkLine(i, j, -1, 1, 'X')) {
                        score -= 10;
                    }
                }
            }
        }
        return score;
    }
}
