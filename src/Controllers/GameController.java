package Controllers;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.Player;
import Services.GameService;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public Game startGame(int boardSize,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws PlayerCountException, BotCountException, SymbolCountException {

        Game game = gameService.startGame(boardSize, players, winningStrategies);

        return game;
    }
}
