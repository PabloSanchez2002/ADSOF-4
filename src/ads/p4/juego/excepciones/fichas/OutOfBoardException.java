package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;
/**
 * OutofBoard excepcion, cuando se intenta introducir una ficha fuera del tablero
 * @author ALvaro Rodriguez y Pablo Sanchez
 */
public class OutOfBoardException extends ForbiddenToken {
    /**
     * Constructor de la clase
     * @param token token
     * @param x fila
     * @param y columna
     */
    public OutOfBoardException(IToken token, int x, int y) {
        super(token, x, y);
    }

    /**
     * To string de la clase
     */
    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + ", " + y
                + " because: the location is out of the board\n";
    }
}
