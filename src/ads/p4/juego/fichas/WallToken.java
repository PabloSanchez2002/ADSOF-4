package ads.p4.juego.fichas;

import ads.p4.juego.Player;

public class WallToken extends Token {

    public WallToken() {
        super(false);
    }

    @Override
    public String toString() {
        return "WA";
    }

    public Player getPlayer() {
        return null;
    }

}
