package Strategies.BotPlayingStrategies;

import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getTheBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlay();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlay();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlay();
        }
        return new EasyBotPlay();
    }
}
