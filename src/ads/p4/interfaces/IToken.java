package ads.p4.interfaces;

import ads.p4.juego.Player;
/**
 * Interfaz Itoken implementada por Token
 * @author Alvaro Rodriguez y Pablo Sanchez
 */
public interface IToken {
    /**
     * To string de Itoken
     * @return String
     */
    public String toString();
    /**
     * Comprueba si un token se puede sobreescribir 
     * @return boolean 
     */
    public boolean canBeOverwritten();
    /**
     * Devuelve el campo sobreescribible
     * @return boolean
     */

    public boolean getOverriteable();
    /**
     * Devuelve el jugador del token
     * @return Player
     */

    public Player getPlayer();
}
