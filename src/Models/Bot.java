package Models;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, PlayerType playerType, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
