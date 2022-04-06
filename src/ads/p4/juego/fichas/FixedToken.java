package ads.p4.juego.fichas;

import ads.p4.juego.Player;

public class FixedToken extends Token {
    int valor;
    Player p;

    public FixedToken(Player p) {
        super(false);
        this.p = p;
        this.valor = 1;
    }

    public Player getPlayer() {
        return p;
    }

    @Override
    public String toString() {
        return "F" + this.p.getId();
    }

}
