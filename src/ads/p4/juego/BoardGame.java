package ads.p4.juego;

import ads.p4.interfaces.*;
import ads.p4.juego.excepciones.fichas.ForbiddenToken;
import ads.p4.juego.excepciones.fichas.NotNeighbourException;
import ads.p4.juego.excepciones.fichas.OutOfBoardException;
import ads.p4.juego.excepciones.fichas.OverwriteException;
import ads.p4.juego.fichas.EnhancerToken;
import ads.p4.juego.fichas.NormalToken;

import java.util.*;

public class BoardGame implements IBoard {
    ArrayList<Player> players;
    Cell[][] celdas;

    public BoardGame(int casillas, Player p1, Player p2) {
        players = new ArrayList<Player>();
        this.players.add(p1);
        this.players.add(p2);
        this.celdas = new Cell[casillas][casillas];
        for (int i = 0; i < casillas; i++) {
            for (int j = 0; j < casillas; j++) {
                this.celdas[i][j] = new Cell(i, j);
            }
        }
        // Añadimos fichas de los jugadores iniciales
        try {
            NormalToken n1 = new NormalToken(players.get(0));
            NormalToken n2 = new NormalToken(players.get(1));
            this.addToken(0, 0, n1);
            n1.getPlayer().setLastCell(this.celdas[0][0]);
            this.addToken(this.getRows() - 1, this.getColumns() - 1, n2);
            n2.getPlayer().setLastCell(this.celdas[this.getRows() - 1][this.getColumns() - 1]);
            this.randomEnhancer();
        } catch (ForbiddenToken e) {
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
        for (int i = 0; i < this.getRows(); i++) {
            for (Cell c : this.celdas[i]) {
                ret = (ret + c.toString() + " ");
            }
            ret = (ret + "\n");
        }
        return ret;
    }

    public void randomEnhancer() {
        Random rand = new Random(); // instance of random class
        int upperbound = this.getColumns();
        int row, column, count, maxTries = 10;

        for (count = 0; count < maxTries; count++) {
            row = rand.nextInt(upperbound);
            column = rand.nextInt(upperbound);
            ICell c = this.getSymmetric(this.getCell(row, column));
            // Intento de insercion de tokens sin colision
            if (c.getToken() == null && this.getCell(row, column).getToken() == null) {
                EnhancerToken en = new EnhancerToken();
                try {
                    this.addToken(row, column, en);
                    this.addToken(c.getRow(), c.getColumn(), en);
                    break;
                } catch (ForbiddenToken e) {
                }
            }
        }

    }

    public void addToken(int row, int column, IToken f) throws ForbiddenToken {
        if (row > this.getRows() || row < 0 || column < 0 || column > this.getRows()) {
            throw new OutOfBoardException(f, row, column);
        } else if ((this.celdas[row][column].getToken() != null)
                && (this.celdas[row][column].getToken().getOverriteable() != true)) {
            throw new OverwriteException(f, row, column);
        } else if (f.getPlayer() == null && this.celdas[row][column].getToken() == null) {
            this.celdas[row][column].setToken(f);
            return;
        } else if (f.getPlayer().getLastCell() == null) {
            if ((this.celdas[row][column].getToken() != null)
                    && (this.celdas[row][column].getToken().getOverriteable() == true)
                    || this.celdas[row][column].getToken() == null) {
                this.celdas[row][column].setToken(f);
                f.getPlayer().setLastCell(this.celdas[row][column]);
                f.getPlayer().addPoint();
                return;
            } else {
                throw new OverwriteException(f, row, column);
            }
        } else if (this.celdas[row][column].isNeighbor(f.getPlayer().getLastCell()) != true && f.getPlayer()
                .getLastCell() != (this.celdas[row][column])) {
            throw new NotNeighbourException(f, row, column);
        } else {
            this.celdas[row][column].setToken(f);
            f.getPlayer().setLastCell(this.celdas[row][column]);
            f.getPlayer().addPoint();
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
        return this.celdas[this.getRows() - c.getRow() - 1][this.getColumns() - c.getColumn() - 1];
    }

    public Boolean playerCanPlaceToken(Player p) {
        List<ICell> cells = this.getNeighbors(p.getLastCell().getRow(), p.getLastCell().getColumn());
        for (ICell c : cells) {
            if (c.getToken() == null || c.getToken().toString().equals("EN")) {
                return true;
            }
        }
        return false;
    }
}
