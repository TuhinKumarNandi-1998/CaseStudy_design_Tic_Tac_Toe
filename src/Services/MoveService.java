package Services;

import Exceptions.InvalidMoveException;
import Models.*;
import Strategies.WinningStrategies.WinningStrategy;

public class MoveService {

    public void makeMove(Game game) throws InvalidMoveException {
        Player Currentplayer = game.getPlayers().get(game.getNextPlayerIndex());

        System.out.println("Now its "+Currentplayer.getName()+"'s turn.");

        Board board = game.getBoard();
        Move move = Currentplayer.makeMove(board);
        if(validate(move, game.getBoard().getSize())) {
            throw new InvalidMoveException("Invalid Move id made");
        }


        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        //updating the status in the board
        Cell cellOfBoard = board.getBoardImage().get(row).get(col);
        cellOfBoard.setCellState(CellState.FILLED);
        cellOfBoard.setPlayer(Currentplayer);

        Move move1 = new Move(cellOfBoard);
        game.getMoves().add(move1);

        if(checkForWinner(game,move1)) {
            game.setWinner(Currentplayer);
            game.setGameState(GameState.WIN);
            return;
        }

        if(game.getMoves().size()==game.getBoard().getSize()*game.getBoard().getSize()){
            game.setGameState(GameState.DRAW);
        }

        int nextPlayerIndex = game.getNextPlayerIndex()+1;
        nextPlayerIndex %= game.getPlayers().size();
        game.setNextPlayerIndex(nextPlayerIndex);
    }

    public boolean validate(Move move, int size) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row<0 || row>=size) {
            return true;
        }
        if(col<0 || col>=size) {
            return true;
        }
        return false;
    }

    public boolean checkForWinner(Game game, Move move) {
        for(WinningStrategy winningStrategy : game.getWinningStrategies()) {
            if(winningStrategy.makeMove(game.getBoard(), move)){
                return true;
            }
        }
        return false;
    }
}
