package ads.p4.juego.fichas;

import ads.p4.juego.Player;
/**
 * Token Enhancer no pertenece al jugador
 * @author Pablo Sanchez y ALvaro Rodriguez
 */
public class EnhancerToken extends Token {

    /**
     * Constructor de la clase
     */
    public EnhancerToken() {
        super(true);
    }

    /** 
     * to String de la clase
     */
    @Override
    public String toString() {
        return "EN";
    }

    /**
     * Se obtiene el jugador que es null porque no pertenece a uno
     */
    public Player getPlayer() {
        return null;
    }
}
