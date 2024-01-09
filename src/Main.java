import Controllers.GameController;
import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Models.*;
import Services.GameService;
import Strategies.WinningStrategies.ColumnWinning;
import Strategies.WinningStrategies.DiagonalWinning;
import Strategies.WinningStrategies.RowWinning;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PlayerCountException, BotCountException, SymbolCountException {
        int size = 3;
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Tuhin", PlayerType.HUMAN, new Symbol('X')));
        playerList.add(new Bot("Alpha_Go", PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinning());
        winningStrategies.add(new ColumnWinning());
        winningStrategies.add(new DiagonalWinning());

        GameService gameService = new GameService();

        GameController gameController = new GameController(gameService);

        Game game = gameController.startGame(size, playerList, winningStrategies);

    }
}