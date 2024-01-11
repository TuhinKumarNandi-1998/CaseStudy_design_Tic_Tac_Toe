package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinning implements WinningStrategy {

    private Map<Integer, Map<Symbol, Integer>> colMap = new HashMap<>();
    @Override
    public boolean makeMove(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getCell().getPlayer().getSymbol();

        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMapCount = colMap.get(col);
        if (!colMapCount.containsKey(symbol)) {
            colMapCount.put(symbol, 0);
        }
        colMapCount.put(symbol, colMapCount.get(symbol) + 1);

        if(colMapCount.get(symbol).equals(board.getSize())){
            return true;
        }
        return false;
    }

    @Override
    public void undo(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> colMapCount = colMap.get(col);
        colMapCount.put(symbol, colMapCount.get(symbol)-1);

        if(colMapCount.get(symbol)==0) {
            colMapCount.remove(symbol);
        }

        colMap.put(col, colMapCount);
    }
}
