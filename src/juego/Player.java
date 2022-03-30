package juego;

public class Player {
    private static int count = 0;
    int id;

    public Player() {
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

}
