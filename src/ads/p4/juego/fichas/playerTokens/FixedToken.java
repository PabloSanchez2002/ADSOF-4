package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;

/**
 * Clase FixedToken tipo de token perteneciente a un jugador
 * @author Alvaro Rodríguez y Pablo Sanchez 
 */
public class FixedToken extends PlayerToken {

    /**
     * Constructor de la clase FixedToken
     * @param p jugador al que pertenece
     */
    public FixedToken(Player p) {
        super(false, p, 1);
    }

    /**
     * To string de la clase FixedToken
     */
    @Override
    public String toString() {
        return "F" + this.getPlayer().getId();
    }

}
