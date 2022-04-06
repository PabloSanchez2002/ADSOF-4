package ads.p4.interfaces;

import ads.p4.juego.Player;

public interface IToken {
    public String toString();

    public boolean canBeOverwritten();

    public boolean getOverriteable();

    public Player getPlayer();
}
