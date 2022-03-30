package juego.fichas;

import interfaces.*;

public abstract class Token implements IToken {
    Boolean overritable;
    int posFila;
    int posColumn;

    public Token(boolean ove) {
        this.overritable = ove;
    }

    // ===========INTERFAZ============
    public boolean canBeOverwritten() {
        return this.overritable;
    }
}
