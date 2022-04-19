package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;
/**
 * MultiplierToken token multiplicador pertenece a un jugador
 * @author Alvaro Rodriguez y Pablo Sanchez
 */
public class MultiplierToken extends PlayerToken {

    /**
     * Constructor de la clase 
     * @param p jugador al que pertenece
     */
    public MultiplierToken(Player p) {
        super(true, p, 3);
    }

    /**
     * toString de la clase 
     */
    @Override
    public String toString() {
        return "M" + this.getPlayer().getId();
    }

}
