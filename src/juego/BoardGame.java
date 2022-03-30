package juego;

import interfaces.*;
import java.util.*;

public class BoardGame implements IBoard {
    ArrayList<Player> players;
    Cell[][] celdas;

    public BoardGame(int casillas, Player p1, Player p2) {
        this.players.add(p1);
        this.players.add(p2);
        this.celdas = new Cell[casillas][casillas];
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

    public String toString();

    public void addToken(int row, int column, IToken f) throws ForbiddenToken;

    public List<ICell> getNeighbors(int row, int column);

    public ICell getSymmetric(ICell c);
}
