package ads.p4.juego.excepciones;

import ads.p4.interfaces.IToken;

public class OverwriteException extends ForbiddenToken {
    public OverwriteException(IToken token, int x, int y) {
        super(token, x, y);
    }

    @Override
    public String toString() {
        return "Error. the token" + token + " can not be placed in position " + x + ", " + y
                + " because: the cell contains a token that cannot be overwritten";
    }
}