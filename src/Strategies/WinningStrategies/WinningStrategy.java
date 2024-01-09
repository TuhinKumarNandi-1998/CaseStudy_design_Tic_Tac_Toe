package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    public void makeMove(Board board, Move move);
}
