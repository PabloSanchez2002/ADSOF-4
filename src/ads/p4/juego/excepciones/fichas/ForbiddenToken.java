package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;

public class ForbiddenToken extends Exception {
    IToken token;
    int x, y;

    public ForbiddenToken(IToken token, int x, int y) {
        this.token = token;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + "," + y + "\n";
    }
}
