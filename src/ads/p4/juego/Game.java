package ads.p4.juego;

import java.io.IOException;

import ads.p4.juego.excepciones.game.InvalidGame;

public class Game {
    int turns;
    int size;
    int wallTokens;
    BoardGame bg;

    public Game(int turns, int size, int wallTokens) {
        this.turns = turns;
        this.size = size;
        this.wallTokens = wallTokens;
        bg = new BoardGame(size, p1, p2);
    }

    public void play() throws NumberFormatException, InvalidGame, IOException {
        if (this.wallTokens >= this.size - (this.size + 1)) {
            throw new InvalidGame(this.size, this.wallTokens);
        } else {
            for (int i = 0; i < this.turns; i++) {
                System.out.println("Starting turn " + i + 1);

            }
        }

    }
}
