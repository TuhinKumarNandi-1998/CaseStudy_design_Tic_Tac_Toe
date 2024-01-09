package Controllers;

import Exceptions.BotCountException;
import Exceptions.InvalidMoveException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.GameState;
import Models.Move;
import Models.Player;
import Services.BoardService;
import Services.GameService;
import Services.MoveService;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    private GameService gameService;
    private BoardService boardService;
    private MoveService moveService;

    public GameController(GameService gameService, BoardService boardService, MoveService moveService) {
        this.gameService = gameService;
        this.boardService = boardService;
        this.moveService = moveService;
    }

    public Game startGame(int boardSize,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws PlayerCountException, BotCountException, SymbolCountException {

        Game game = gameService.startGame(boardSize, players, winningStrategies);

        return game;
    }

    public GameState getGameStatus(Game game) {
        return game.getGameState();
    }

    public void displayBoard(Game game) {
        boardService.displayBoard(game);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        moveService.makeMove(game);
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
