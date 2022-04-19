package ads.p4.juego.fichas.playerTokens;

import ads.p4.interfaces.ITokenPoints;
import ads.p4.juego.Player;
import ads.p4.juego.fichas.Token;

public abstract class PlayerToken extends Token implements ITokenPoints {
    int valor;
    Player p;

    public PlayerToken(boolean ove, Player p, int puntos) {
        super(ove);
        this.p = p;
        this.valor = puntos;
    }

    public Player getPlayer() {
        return p;
    }

    @Override
    public void addPoints() {
        p.addPoints(this.valor);
    }
}
