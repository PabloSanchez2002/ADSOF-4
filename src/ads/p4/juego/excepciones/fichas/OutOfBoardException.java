package ads.p4.juego.excepciones.fichas;

import ads.p4.interfaces.IToken;

public class OutOfBoardException extends ForbiddenToken {
    public OutOfBoardException(IToken token, int x, int y) {
        super(token, x, y);
    }

    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + ", " + y
                + " because: the location is out of the board\n";
    }
}
