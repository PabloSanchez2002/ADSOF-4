package ads.p4.juego;

import ads.p4.interfaces.*;
import ads.p4.juego.excepciones.*;

import java.util.*;

public class BoardGame implements IBoard {
    ArrayList<Player> players;
    Cell[][] celdas;

    public BoardGame(int casillas, Player p1, Player p2) {
        players = new ArrayList<Player>();
        this.players.add(p1);
        this.players.add(p2);
        this.celdas = new Cell[casillas][casillas];
        for (int i = 0; i < this.getRows() - 1; i++) {
            for (int j = 0; j < this.getColumns() - 1; j++) {
                this.celdas[i][j] = new Cell(i, j);
            }
        }
    }

    public ICell getCell(int row, int column) {
        return this.celdas[row][column];
    }

    public int getRows() {
        return this.celdas.length;
    }

    public int getColumns() {
        return this.celdas[0].length;
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < this.getRows() - 1; i++) {
            for (Cell c : this.celdas[i]) {
                ret.concat(c.toString() + " ");
            }
            ret.concat("\n");
        }
        return ret;
    }

    public void addToken(int row, int column, IToken f) throws ForbiddenToken {
        if (this.celdas[row][column].getToken().getOverriteable() == true) {
            throw new OverwriteException(f, row, column);
        } else if (row > this.getRows() || row < 0 || column < 0 || column > this.getRows()) {
            throw new OutOfBoardException(f, row, column);
        } else if (f.getPlayer().getLastCell() == null) {
            this.celdas[row][column].setToken(f);
            f.getPlayer().setLastCell(this.celdas[row][column]);
            return;
        } else if (this.celdas[row][column].isNeighbor(f.getPlayer().getLastCell()) != true) {
            throw new NotNeighbourException(f, row, column);
        } else {
            this.celdas[row][column].setToken(f);
            f.getPlayer().setLastCell(this.celdas[row][column]);
            return;
        }
    }

    public List<ICell> getNeighbors(int row, int column) {
        List<ICell> neightbours = new ArrayList<ICell>();
        Cell c = this.celdas[row][column];
        for (int i = 0; i < this.getRows(); i++) {
            for (Cell cel : this.celdas[i]) {
                if (c.isNeighbor(cel) == true) {
                    neightbours.add(cel);
                }

            }
        }
        return neightbours;
    }

    public ICell getSymmetric(ICell c) {
        return this.celdas[this.getRows() - c.getRow()][this.getColumns() - c.getColumn()];
    }
}
