package ads.p4.juego.excepciones.game;

public class InvalidGame extends Exception {
    int size;
    int walls;

    public InvalidGame(int size, int walls) {
        this.size = size;
        this.walls = walls;
    }

    @Override
    public String toString() {
        return "Error. the token " + token + " can not be placed in position " + x + "," + y + "\n";
    }
}
