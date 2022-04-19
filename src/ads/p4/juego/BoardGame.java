package ads.p4.juego;

import ads.p4.interfaces.*;
import ads.p4.juego.excepciones.fichas.ForbiddenToken;
import ads.p4.juego.excepciones.fichas.NotNeighbourException;
import ads.p4.juego.excepciones.fichas.OutOfBoardException;
import ads.p4.juego.excepciones.fichas.OverwriteException;
import ads.p4.juego.fichas.EnhancerToken;
import ads.p4.juego.fichas.WallToken;
import ads.p4.juego.fichas.playerTokens.FixedToken;
import ads.p4.juego.fichas.playerTokens.MultiplierToken;
import ads.p4.juego.fichas.playerTokens.NormalToken;
import ads.p4.juego.fichas.playerTokens.PlayerToken;

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
            n1.addPoints();
            this.addToken(this.getRows() - 1, this.getColumns() - 1, n2);
            n2.getPlayer().setLastCell(this.celdas[this.getRows() - 1][this.getColumns() - 1]);
            n2.addPoints();
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

    public void randomWall() {
        Random rand = new Random(); // instance of random class
        int upperbound = this.getColumns();
        int row, column, count, maxTries = 10;

        for (count = 0; count < maxTries; count++) {
            row = rand.nextInt(upperbound);
            column = rand.nextInt(upperbound);
            ICell c = this.getSymmetric(this.getCell(row, column));
            // Intento de insercion de tokens sin colision
            if (c.getToken() == null && this.getCell(row, column).getToken() == null) {
                WallToken en = new WallToken();
                try {
                    this.addToken(row, column, en);
                    this.addToken(c.getRow(), c.getColumn(), en);
                    break;
                } catch (ForbiddenToken e) {
                }
            }
        }
    }

    public void clearWalls() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getRows(); j++) {
                if (this.celdas[i][j].getToken() != null
                        && this.celdas[i][j].getToken().getClass().equals(WallToken.class)) {
                    this.celdas[i][j].setToken(null);
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
            this.setToken(row, column, f);
            return;
        } else if (f.getPlayer().getLastCell() == null) {
            if ((this.celdas[row][column].getToken() != null)
                    && (this.celdas[row][column].getToken().getOverriteable() == true)
                    || this.celdas[row][column].getToken() == null) {
                this.setToken(row, column, f);
                return;
            } else {
                throw new OverwriteException(f, row, column);
            }
        } else if (this.celdas[row][column].isNeighbor(f.getPlayer().getLastCell()) != true && f.getPlayer()
                .getLastCell() != (this.celdas[row][column])) {
            throw new NotNeighbourException(f, row, column);
        } else {
            this.setToken(row, column, (PlayerToken) f);
            return;
        }
    }

    public void setToken(int row, int colum, PlayerToken f) {
        IToken last = this.celdas[row][colum].getToken();
        this.celdas[row][colum].setToken(f);
        f.getPlayer().setLastCell(this.celdas[row][colum]);
        f.addPoints();
        this.checkEnhancer(this.celdas[row][colum], last);
    }

    public void setToken(int row, int colum, IToken f) {
        this.celdas[row][colum].setToken(f);
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

    public IToken newPlayerToken(Player p) {
        Random rand = new Random();
        int upperbound = 100;
        int prob = rand.nextInt(upperbound);
        if (prob < 70) {
            return new NormalToken(p);

        } else if (prob >= 70 && prob < 90) {
            return new FixedToken(p);

        } else {
            return new MultiplierToken(p);

        }
    }

    public Boolean playerCanPlaceToken(Player p) {
        List<ICell> cells = this.getNeighbors(p.getLastCell().getRow(), p.getLastCell().getColumn());
        for (ICell c : cells) {
            if ((c.getToken() == null || c.getToken().toString().equals("EN"))
                    || (c.getToken() != null && c.getToken().getPlayer().equals(p))) {
                return true;
            }
        }
        return false;
    }

    public void checkEnhancer(ICell cell, IToken last) {
        if (cell.getToken().getClass().equals(EnhancerToken.class)) {
            this.randomEffect(cell);
        }
    }

    public void randomEffect(ICell cell) {
        Random rand = new Random();
        int upperbound = 2;
        int effect = rand.nextInt(upperbound);

        if (effect == 0) {
            // 1) Añadir fichas normales del jugador en toda la columna.
            for (int i = 0; i < this.getRows(); i++) {
                try {
                    this.addToken(i, cell.getColumn(), new NormalToken(cell.getToken().getPlayer()));
                } catch (ForbiddenToken e) {
                }
            }
        } else if (effect == 1) {
            // 1) Añadir fichas normales del jugador en toda la fila.
            for (int i = 0; i < this.getColumns(); i++) {
                try {
                    this.addToken(cell.getRow(), i, new NormalToken(cell.getToken().getPlayer()));
                } catch (ForbiddenToken e) {
                }
            }
        } else {
            // 3) Añadir fichas normales en todas las celdas vecinas de la ficha
            List<ICell> cells = this.getNeighbors(cell.getRow(), cell.getColumn());
            for (ICell c : cells) {
                try {
                    this.addToken(c.getRow(), c.getColumn(), new NormalToken(cell.getToken().getPlayer()));
                } catch (ForbiddenToken e) {
                }
            }
        }
    }
}
