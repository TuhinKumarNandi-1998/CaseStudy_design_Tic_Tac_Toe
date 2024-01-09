package Models;

import Strategies.BotPlayingStrategies.BotPlayingStrategy;
import Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

import java.util.Map;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, PlayerType playerType, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getTheBotPlayingStrategy(botDifficultyLevel);
    }

    public Move makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
