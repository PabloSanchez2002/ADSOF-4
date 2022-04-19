package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;

public class FixedToken extends PlayerToken {

    public FixedToken(Player p) {
        super(false, p, 1);
    }

    @Override
    public String toString() {
        return "F" + this.getPlayer().getId();
    }

}
