package ads.p4.juego.fichas.playerTokens;

import ads.p4.interfaces.ITokenPoints;
import ads.p4.juego.Player;
import ads.p4.juego.fichas.Token;
/**
 * Clase player token de las que heredan las clases de jugador
 * @author Pablo Sanchez y Alvaro Rodriguez
 */
public abstract class PlayerToken extends Token implements ITokenPoints {
    int valor;
    Player p;

    /**
     * Constructor del la clase abstracta
     * @param ove sobreescribible
     * @param p jugador
     * @param puntos puntos
     */
    public PlayerToken(boolean ove, Player p, int puntos) {
        super(ove);
        this.p = p;
        this.valor = puntos;
    }

    /**
     * Se obtiene el jugador
     * @return Player 
     */
    public Player getPlayer() {
        return p;
    }

    /**
     * Añadir puntos
     */
    @Override
    public void addPoints() {
        p.addPoints(this.valor);
    }
}
