package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinning implements WinningStrategy {

    Map<Symbol, Integer> leftDia = new HashMap<>();
    Map<Symbol, Integer> rightDia = new HashMap<>();
    @Override
    public boolean makeMove(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        //left diagonal
        if(row==col) {
            if(!leftDia.containsKey(symbol)){
                leftDia.put(symbol, 0);
            }
            leftDia.put(symbol, leftDia.get(symbol)+1);

            if(leftDia.get(symbol).equals(board.getSize())){
                return true;
            }
        }

        //right diagonal
        if(row+col == board.getSize()-1) {
            if(!rightDia.containsKey(symbol)) {
                rightDia.put(symbol, 0);
            }
            rightDia.put(symbol, rightDia.get(symbol)+1);

            if(rightDia.get(symbol).equals(board.getSize())){
                return true;
            }
        }
        return false;
    }
}
