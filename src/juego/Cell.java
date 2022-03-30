package juego;

import interfaces.ICell;
import interfaces.IToken;
import juego.fichas.Token;

import java.lang.Math;

public class Cell implements ICell {
    int row;
    int column;
    IToken token;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
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
}
