package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;

/** 
 * OverWrite exception cuando no se puede sobrescribir una ficha   
 */
public class OverwriteException extends ForbiddenToken {
    /**
     * Constructor de la clase
     * @param token token
     * @param x fila
     * @param y columna
     */
    public OverwriteException(IToken token, int x, int y) {
        super(token, x, y);
    }

    /**
     * To string de la clase
     */
    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + ", " + y
                + " because: the cell contains a token that cannot be overwritten";
    }
}