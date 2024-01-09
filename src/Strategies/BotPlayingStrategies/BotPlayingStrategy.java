package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    public void makeMove(Board board, Move move);
}
