package juego.fichas;

import juego.Player;

public class MultiplierToken extends Token {
    int valor;
    Player p;

    public MultiplierToken(Player p) {
        super(true);
        this.p = p;
        this.valor = 3;
    }

    @Override
    public String toString() {
        return "M" + this.p.getId();
    }

}
