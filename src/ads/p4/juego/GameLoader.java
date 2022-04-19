package ads.p4.juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * Clase gameLoader 
 * @author Pablo Sanchez y ALvaro Rodriguez
 */
public class GameLoader {

    /**
     * clase para cargar el juego 
     * @param file fichero del que se lee
     * @return el juego
     */
    public static Game load(String file) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int data[] = { 0, 0, 0 };
        int i = 0;
        try {
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                data[i] = Integer.parseInt(linea);
                i++;
            }
            return new Game(data[1], data[0], data[2]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
