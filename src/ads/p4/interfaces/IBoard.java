package ads.p4.interfaces;

import java.util.*;

import ads.p4.juego.excepciones.fichas.ForbiddenToken;
/**
 * Interfaz IBoard tiene las funciones que se implementaran en board game
 * @author Alvaro Rodriguez y Pablo Sanchez
 */
public interface IBoard {
    /**
     * Devuelve la celda en la posicion row,column
     * @param row posicion x
     * @param column posicion y
     * @return ICell celda
     */
    public ICell getCell(int row, int column);
    /**
     * Devuelve el numero de filas
     * @return int
     */
    public int getRows();
/**
 * Devuelve el numero de columnas
 * @return int 
 */
    public int getColumns();
    /**
     *  To string de Board
     * @return String
     */
    public String toString();
/**
 * Añade un token a una celula 
 * @param row fila donde se introduce
 * @param column  columna donde se introduce
 * @param f token que se añade
 * @throws ForbiddenToken exception
 */
    public void addToken(int row, int column, IToken f) throws ForbiddenToken;
/**
 * Se obtienen los vecinos alrededor de una celda
 * @param row fila  
 * @param column columna
 * @return Lista con los vecinos
 */
    public List<ICell> getNeighbors(int row, int column);
/**
 * Se obtiene el simetrico de una celda 
 * @param c Celda de la que se obtiene el simetrico
 * @return Celda simetrica
 */
    public ICell getSymmetric(ICell c);
}
