package ads.p4.juego;
/**
 *Clase jugador
 * @author Alvaro Rodriguez y Pablo Sanchez 
 */
public class Player {
    private static int count = 0;
    int id;
    Cell lastCell;
    int points = 0;

    /**
     * Constructor de la clase
     * 
     */
    public Player() {
        count++;
        id = count;
    }

    /**
     * Devuelve la ultima celda 
     * @return Celda
     */
    public Cell getLastCell() {
        return this.lastCell;
    }

    /**
     * Cambia la ultima celda visitada
     * @param f celda
     */
    public void setLastCell(Cell f) {
        this.lastCell = f;
    }

    /**
     * Devuelve el id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve los puntos
     * @return int 
     */
    public int getPoints() {
        return points;
    }

    /**
     * Añade puntos
     * @param n numero de puntos
     */
    public void addPoints(int n) {
        this.points += n;
    }

}
