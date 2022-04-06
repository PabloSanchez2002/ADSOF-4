package ads.p4.juego.fichas;

import ads.p4.juego.Player;

public class NormalToken extends Token {
    int valor;
    Player p;

    public NormalToken(Player p) {
        super(true);
        this.p = p;
        this.valor = 1;
    }

    public Player getPlayer() {
        return p;
    }

    @Override
    public String toString() {
        return "N" + this.p.getId();
    }

}
