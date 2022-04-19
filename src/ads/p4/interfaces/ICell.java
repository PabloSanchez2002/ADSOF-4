package ads.p4.interfaces;
/**
 * Interfaz implementada por celll
 * @author Alvaro Rodriguez y Pablo Sanchez
 */
public interface ICell {
    /**
     * Obtiene la fila de la celda
     * @return int
     */
    public int getRow();
/**
 * Obtiene la columna de la celda
 * @return int
 */
    public int getColumn();
/**
 * Obtiene la fila de la celda
 * @return int
 */
    public IToken getToken();
/**
 * Pone un token en la celda 
 * @param f token que se añade
 */
    public void setToken(IToken f);
/**
 * Comprueba si dos celdas son vecinas
 * @param c Celda a comparar
 * @return boolean
 */
    public boolean isNeighbor(ICell c);
}
