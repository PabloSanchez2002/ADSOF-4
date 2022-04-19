package ads.p4.juego.fichas;

import ads.p4.juego.Player;

/**
 * Clase walltoken
 * @author Alvaro Rodriguez y Pablo Sanchez
 */
public class WallToken extends Token {

    /**
     * Constructor de la clase
     */
    public WallToken() {
        super(false);
    }

    /**
     * toString de la clase
     */
    @Override
    public String toString() {
        return "WA";
    }

    /**
     * Devuelve null ya que las murallas no tienen jugador
     */
    public Player getPlayer() {
        return null;
    }

}
