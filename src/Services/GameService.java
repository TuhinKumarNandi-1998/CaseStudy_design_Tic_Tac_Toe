package Services;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.Player;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameService {

    public Game startGame(int boardSize,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws PlayerCountException, BotCountException, SymbolCountException {
        Game game = Game.getBuilder()
                .setBoard(boardSize)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies).build();
        return null;
    }
}
