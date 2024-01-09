package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinning implements WinningStrategy{

    Map<Integer, Map<Symbol, Integer>> rowMap = new HashMap<>();
    @Override
    public boolean makeMove(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getCell().getPlayer().getSymbol();

        if(!rowMap.containsKey(row)) {
            rowMap.put(row, new HashMap<>());
        }
        Map<Symbol, Integer> rowMapCount = rowMap.get(row);
        if(!rowMapCount.containsKey(symbol)) {
            rowMapCount.put(symbol, 0);
        }
        rowMapCount.put(symbol, rowMapCount.get(symbol)+1);

        //Now check if it is the winner or not
        if(rowMapCount.get(symbol).equals(board.getSize())){
            //it is the winner
            return true;
        }
        return false;
    }
}
