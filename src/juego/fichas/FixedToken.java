package juego.fichas;

import juego.Player;

public class FixedToken extends Token {
    int valor;
    Player p;

    public FixedToken(Player p) {
        super(false);
        this.p = p;
        this.valor = 1;
    }

    @Override
    public String toString() {
        return "F" + this.p.getId();
    }

}
