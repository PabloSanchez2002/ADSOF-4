package ads.p4.juego.fichas.playerTokens;

import ads.p4.juego.Player;

public class MultiplierToken extends PlayerToken {

    public MultiplierToken(Player p) {
        super(true, p, 3);
    }

    @Override
    public String toString() {
        return "M" + this.getPlayer().getId();
    }

}
