package ads.p4.juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ads.p4.juego.excepciones.fichas.ForbiddenToken;
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
    }

    public void play() throws NumberFormatException, InvalidGame, IOException {
        if (this.wallTokens >= this.size - (this.wallTokens + 1)) {
            throw new InvalidGame(this.size, this.wallTokens);
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Inicializamos el tablero y jugadores
            int bloqueo = 0;
            Player p1 = new Player();
            Player p2 = new Player();
            bg = new BoardGame(size, p1, p2);

            // Empiezan los turnos
            for (int i = 0; i < this.turns; i++) {
                System.out.println("Starting turn " + (i + 1));
                this.bg.clearWalls();
                for (int j = 0; j < this.wallTokens; j++) {
                    this.bg.randomWall();
                    this.bg.randomEnhancer(); //////////
                }

                System.out.print(bg.toString());

                for (Player p : this.bg.players) {
                    System.out.println(this.calcularPuntos() + "Turn " + (i + 1));
                    // Sistema de deteccion de bloqueos
                    if (bg.playerCanPlaceToken(p) == false) {
                        System.out.println("Player " + p.getId() + " cant place any tokens, turn skipped\n");
                        if (bloqueo == 1) {
                            System.out.println("The two players are bloqued, game ends\n");
                            return;
                        } else {
                            bloqueo = 1;
                        }
                    } else {
                        while (true) {
                            try {
                                System.out
                                        .println("Player " + p.getId() + " enter the coordinates of the new token: \n");
                                String newToken = br.readLine();
                                if (newToken.equals("END")) {
                                    return;
                                }
                                String[] token = newToken.split(",");
                                this.bg.addToken(Integer.parseInt(token[0]), Integer.parseInt(token[1]),
                                        this.bg.newPlayerToken(p));
                                break;
                            } catch (ForbiddenToken e) {
                                System.out.println(e);
                            }
                        }
                        System.out.print(bg.toString() + "\n");

                    }
                }
            }
        }
    }

    public String calcularPuntos() {
        String puntos = "\n";
        for (Player p : this.bg.players) {
            puntos = (puntos + p.getId() + " points " + p.getPoints() + " last cell: "
                    + p.getLastCell().cordinatesToString()
                    + "\n");
        }
        return puntos;
    }
}
