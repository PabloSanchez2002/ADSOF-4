package ads.p4.juego.fichas;

import ads.p4.interfaces.*;
/**
 * Clase abstracta token 
 * @author Pablo Sanchez y Alvaro Rodriguez
 */
public abstract class Token implements IToken {
    Boolean overritable;

    /**
     * Constructor de la clase
     * @param ove sobreescribible
     */
    public Token(boolean ove) {
        this.overritable = ove;
    }

    /**
     * devuelve si puede ser sobreescribible
     * @return boolean
     */
    public boolean canBeOverwritten() {
        return this.overritable;
    }

    /**
     * devuelve si puede ser sobreescribible
     * @return boolean
     */
    public boolean getOverriteable() {
        return this.overritable;
    }

    /**
     * to string de la clase token
     */
    @Override
    public String toString() {
        return "--";

    }
}
