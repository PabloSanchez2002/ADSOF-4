package ads.p4.juego.fichas;

import ads.p4.juego.Player;

public class MultiplierToken extends Token {
    int valor;
    Player p;

    public MultiplierToken(Player p) {
        super(true);
        this.p = p;
        this.valor = 3;
    }

    public Player getPlayer() {
        return p;
    }

    @Override
    public String toString() {
        return "M" + this.p.getId();
    }

}
