package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;
/**
 * Excepcion cuando no es vecino
 * @author Alvaro Rodríguez y Pablo Sanchez
 */
public class NotNeighbourException extends ForbiddenToken {
    /**
     * Constructor de la excepcion
     * @param token token
     * @param x fila
     * @param y columna
     */
    public NotNeighbourException(IToken token, int x, int y) {
        super(token, x, y);
    }

    /**
     * To string de la clase
     */
    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + ", " + y
                + " because: the token is not next to your last placed token\n";
    }
}
