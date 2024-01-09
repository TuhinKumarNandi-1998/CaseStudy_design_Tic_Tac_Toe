package Models;

import java.util.ArrayList;
import java.util.List;

public class Board extends BaseModel {
    private int size;
    private List<List<Cell>> boardImage;

    public Board(int size) {
        this.size = size;
        this.boardImage = new ArrayList<>();

        for(int i=0; i<size; i++) {
            boardImage.add(new ArrayList<>());
            for(int j=0; j<size; j++) {
                boardImage.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoardImage() {
        return boardImage;
    }

    public void setBoardImage(List<List<Cell>> boardImage) {
        this.boardImage = boardImage;
    }
}
