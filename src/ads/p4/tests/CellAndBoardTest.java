package ads.p4.tests;

import ads.p4.juego.*;
import ads.p4.juego.excepciones.fichas.ForbiddenToken;
import ads.p4.juego.fichas.playerTokens.FixedToken;
import ads.p4.interfaces.*;

public class CellAndBoardTest {
	public static void main(String args[]) {
		Player p1 = new Player();
		Player p2 = new Player();
		IBoard board = new BoardGame(10, p1, p2);
		System.out.println(board);

		try {
			board.addToken(0, 0, new FixedToken(p1));
			System.out.println(board);
			board.addToken(0, 0, new FixedToken(p2));

		} catch (ForbiddenToken e) {

			System.out.println(e);

		}
		System.out.println(board);

	}

}
