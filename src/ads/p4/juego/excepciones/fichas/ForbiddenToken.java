package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;
/**
 * Excepcion ForbiddenToken
 * 
 * @author Alvaro Rodríguez y Pablo Sanchez
 */
public class ForbiddenToken extends Exception {
    IToken token;
    int x, y;

    /**
     * Constructor de ForbiddenTorken
     * @param token token 
     * @param x fila
     * @param y columna
     */
    public ForbiddenToken(IToken token, int x, int y) {
        this.token = token;
        this.x = x;
        this.y = y;
    }

    /**
     * to string de la excepcion
     */
    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + "," + y + "\n";
    }
}
