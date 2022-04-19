package ads.p4.juego.fichas;

import ads.p4.juego.Player;

public class EnhancerToken extends Token {

    public EnhancerToken() {
        super(true);
    }

    @Override
    public String toString() {
        return "EN";
    }

    public Player getPlayer() {
        return null;
    }
}
