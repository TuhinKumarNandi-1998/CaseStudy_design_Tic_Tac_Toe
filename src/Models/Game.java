package Models;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.*;

public class Game extends BaseModel {
    private Board board;
    private List<Player> players;
    private Player winner;
    private GameState gameState;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;

    public Game(int boardSize,
                List<Player> players,
                List<WinningStrategy> winningStrategies) {
        this.board = new Board(boardSize);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        int boardSize;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Game build() throws PlayerCountException, BotCountException, SymbolCountException {
            validate();
            System.out.println("Game is created Successfully");
            return new Game(boardSize, players, winningStrategies);
        }

        private void validate() throws PlayerCountException, BotCountException, SymbolCountException {
            playerCountValidation();

            botCountValidation();

            symbolCountValidation();
        }

        private void playerCountValidation() throws PlayerCountException {
            if (boardSize-1 != players.size()) {
                throw new PlayerCountException("Player count is invalid");
            }
        }

        private void botCountValidation() throws BotCountException {
            //Bot count has to be 1, more than 1 Bot is not allowed
            int botCount = 0;

            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }

            if(botCount > 1) {
                throw new BotCountException("Bot count is more than 1, which is not allowed");
            }
        }

        private void symbolCountValidation() throws SymbolCountException {
            //No 2 player can pick exactly same symbol
            Map<Symbol, Integer> symbolCount = new HashMap<>();

            for(Player player : players) {
                if(!symbolCount.containsKey(player.getSymbol())) {
                    symbolCount.put(player.getSymbol(), 0);
                }
                if(symbolCount.get(player.getSymbol())>1){
                    throw new SymbolCountException("No 2 player can pick same symbol");
                }
            }
        }

        public int getBoardSize() {
            return boardSize;
        }

        public Builder setBoard(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
}
