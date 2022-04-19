package ads.p4.juego.fichas;

import ads.p4.interfaces.*;

public abstract class Token implements IToken {
    Boolean overritable;

    public Token(boolean ove) {
        this.overritable = ove;
    }

    // ===========INTERFAZ============
    public boolean canBeOverwritten() {
        return this.overritable;
    }

    public boolean getOverriteable() {
        return this.overritable;
    }

    @Override
    public String toString() {
        return "--";

    }
}
