package ads.p4.juego;

import ads.p4.interfaces.IToken;

public class Player {
    private static int count = 0;
    int id;
    Cell lastCell;
    int points = 0;

    public Player() {
        count++;
        id = count;
    }

    public Cell getLastCell() {
        return this.lastCell;
    }

    public void setLastCell(Cell f) {
        this.lastCell = f;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

}
