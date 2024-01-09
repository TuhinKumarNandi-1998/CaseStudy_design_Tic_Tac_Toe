package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    public boolean makeMove(Board board, Move move);
}
