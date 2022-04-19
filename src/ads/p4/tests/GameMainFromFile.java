package ads.p4.tests;

import java.io.IOException;

import org.junit.runner.RunWith;

import ads.p4.juego.Game;
import ads.p4.juego.GameLoader;
import ads.p4.juego.excepciones.game.InvalidGame;

public class GameMainFromFile {
	public static void main(String args[]) throws NumberFormatException, InvalidGame, IOException {

		Game g = GameLoader.load(args[0]);
		if (g != null)
			g.play();

	}

}
