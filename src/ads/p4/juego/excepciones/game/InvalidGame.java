package ads.p4.juego.excepciones.game;
/**
 * Excepcion InvalidGame 
 * @author Pablo Sanchez y Alvaro Rodriguez
 */
public class InvalidGame extends Exception {
    int size;
    int walls;

    /**
     * Constructor de la clase
     * @param size tamaño
     * @param walls murallas
     */
    public InvalidGame(int size, int walls) {
        this.size = size;
        this.walls = walls;
    }

    /**
     * To string de la clase
     */
    @Override
    public String toString() {
        return "Error. Invalid board. Number of rows and columns must be " + this.size
                + ". Number of wall tokens must not exceed " + (this.size
                        - (this.walls + 1))
                + "\n";
    }
}
