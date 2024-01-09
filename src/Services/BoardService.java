package Services;

import Models.Board;
import Models.Cell;
import Models.CellState;
import Models.Game;

import java.util.List;

public class BoardService {

    public void displayBoard(Game game) {
        Board board = game.getBoard();

        for(List<Cell> cellList : board.getBoardImage()) {
            for(Cell cell : cellList) {
                if(cell.getPlayer()!=null) {
                    System.out.print("| "+cell.getPlayer().getSymbol().getSymbolChar()+" |");
                }
                else {
                    System.out.print("| - |");
                }
            }
            System.out.println();
        }
    }
}
