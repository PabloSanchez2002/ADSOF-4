package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;

public class NotNeighbourException extends ForbiddenToken {
    public NotNeighbourException(IToken token, int x, int y) {
        super(token, x, y);
    }

    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + ", " + y
                + " because: the token is not next to your last placed token\n";
    }
}
