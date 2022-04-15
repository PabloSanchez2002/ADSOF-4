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
        return "Error. Invalid board. Number of rows and columns must be " + this.size
                + ". Number of wall tokens must not exceed " + (this.size
                        - (this.walls + 1))
                + "\n";
    }
}
