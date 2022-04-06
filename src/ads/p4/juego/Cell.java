package ads.p4.juego;

import ads.p4.interfaces.ICell;
import ads.p4.interfaces.IToken;
import ads.p4.juego.fichas.Token;

import java.lang.Math;

public class Cell implements ICell {
    int row;
    int column;
    IToken token;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.token = null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public IToken getToken() {
        return token;
    }

    public void setToken(IToken f) {
        this.token = f;
    }

    public boolean isNeighbor(ICell c) {
        if ((Math.abs(this.getRow() - c.getRow()) <= 1) && (Math.abs(this.getColumn() - c.getColumn()) <= 1)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (token == null) {
            return "--";
        }
        return token.toString();
    }
}
