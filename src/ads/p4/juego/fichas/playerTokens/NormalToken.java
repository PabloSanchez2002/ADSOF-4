package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;

public class NormalToken extends PlayerToken {
    int valor;
    Player p;

    public NormalToken(Player p) {
        super(true, p, 1);
    }

    @Override
    public String toString() {
        return "N" + this.getPlayer().getId();
    }

}
