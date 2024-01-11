package Models;

import Services.MoveService;

import java.util.Scanner;

public class Player extends BaseModel {
    private String name;
    private PlayerType playerType;
    private Symbol symbol;

    private Scanner sc = new Scanner(System.in);

    public Player(String name, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public Move makeMove(Board board) {
        int row = sc.nextInt();
        int col = sc.nextInt();

        return new Move(new Cell(row, col), this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
