package ads.p4.interfaces;

import java.util.*;
import ads.p4.juego.excepciones.ForbiddenToken;

public interface IBoard {
    public ICell getCell(int row, int column);

    public int getRows();

    public int getColumns();

    public String toString();

    public void addToken(int row, int column, IToken f) throws ForbiddenToken;

    public List<ICell> getNeighbors(int row, int column);

    public ICell getSymmetric(ICell c);
}
