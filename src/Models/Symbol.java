package Models;

public class Symbol extends BaseModel {
    private char symbolChar;

    public Symbol(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }
}
