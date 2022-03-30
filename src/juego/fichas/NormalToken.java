package juego.fichas;

import juego.Player;

public class NormalToken extends Token {
    int valor;
    Player p;

    public NormalToken(Player p) {
        super(true);
        this.p = p;
        this.valor = 1;
    }

    @Override
    public String toString() {
        return "N" + this.p.getId();
    }

}
