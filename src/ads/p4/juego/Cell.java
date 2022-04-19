package ads.p4.juego;

import ads.p4.interfaces.ICell;
import ads.p4.interfaces.IToken;

import java.lang.Math;

/**
 * Clase cell 
 * @author Pablo Sanchez y Alvaro Rodriguez
 */
public class Cell implements ICell {
    int row;
    int column;
    IToken token;

    /**
     * Constructor cell
     * @param row fila
     * @param column columna
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.token = null;
    }

    /**
     * Devuelve la fila
     * @return int
     */
    public int getRow() {
        return row;
    }

    /**
     * Devuelve la columna
     * @return int
     */
    public int getColumn() {
        return column;
    }

    /**
     * Devuelve el token
     * @return IToken
     */
    public IToken getToken() {
        return token;
    }

    /**
     * Cambia el token
     * @param f token
     */
    public void setToken(IToken f) {
        this.token = f;
    }

    /**
     * Comprueba si son vecinos dos celdas
     * @param c celda
     * @return boolean
     */
    public boolean isNeighbor(ICell c) {
        if ((Math.abs(this.getRow() - c.getRow()) <= 1) && (Math.abs(this.getColumn() - c.getColumn()) <= 1)) {
            return true;
        }
        return false;
    }

    /**
     * Metodo toString de la clase
     */
    @Override
    public String toString() {
        if (token == null) {
            return "--";
        }
        return token.toString();
    }

    /**
     * coordenadas en String 
     * @return String
     */
    public String cordinatesToString() {
        return (row + "," + column);
    }
}
