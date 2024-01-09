import Controllers.GameController;
import Exceptions.BotCountException;
import Exceptions.InvalidMoveException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Models.*;
import Services.BoardService;
import Services.GameService;
import Services.MoveService;
import Strategies.WinningStrategies.ColumnWinning;
import Strategies.WinningStrategies.DiagonalWinning;
import Strategies.WinningStrategies.RowWinning;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PlayerCountException, BotCountException, SymbolCountException, InvalidMoveException {
        int size = 3;
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Tuhin", PlayerType.HUMAN, new Symbol('X')));
        playerList.add(new Bot("Alpha_Go", PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinning());
        winningStrategies.add(new ColumnWinning());
        winningStrategies.add(new DiagonalWinning());

        GameService gameService = new GameService();
        BoardService boardService = new BoardService();

        Scanner sc = new Scanner(System.in);
        MoveService moveService = new MoveService();

        GameController gameController = new GameController(gameService, boardService, moveService);

        Game game = gameController.startGame(size, playerList, winningStrategies);

        while(gameController.getGameStatus(game).equals(GameState.IN_PROGRESS)) {
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.getGameStatus(game).equals(GameState.WIN)) {
            System.out.println("Winner is "+gameController.getWinner(game).getName());
        }

        if(gameController.getGameStatus(game).equals(GameState.DRAW)) {
            System.out.println("Game has been Drawn");
        }

    }
}