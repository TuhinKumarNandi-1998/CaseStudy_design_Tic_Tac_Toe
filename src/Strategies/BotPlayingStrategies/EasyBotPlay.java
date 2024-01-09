package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Cell;
import Models.CellState;
import Models.Move;

import java.util.List;

public class EasyBotPlay implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {

        for(List<Cell> row : board.getBoardImage()) {
            for(Cell cell : row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell);
                }
            }
        }
        return null;
    }
}
