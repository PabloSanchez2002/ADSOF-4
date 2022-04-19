package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;
/**
 * Token normal pertenece a jugador
 * @author Pablo Sanchez y Alvaro Rodriguez
 */
public class NormalToken extends PlayerToken {
    int valor;
    Player p;

    /**
     * Constructor del token
     * @param p jugador
     */
    public NormalToken(Player p) {
        super(true, p, 1);
    }

    /**
     * toString de la clase 
     */
    @Override
    public String toString() {
        return "N" + this.getPlayer().getId();
    }

}
