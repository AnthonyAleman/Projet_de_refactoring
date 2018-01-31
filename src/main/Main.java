package main;

import angry.Game;

public class Main {

	// execute le jeu
	public static void main(String args[]) {
		Game g = null;
		g = new Game();

		while (true) {
			g.init(1);
			g.run();
		}

	}

}
