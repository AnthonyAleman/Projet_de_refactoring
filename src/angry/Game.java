
package angry;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import angry.event.Command;
import angry.event.UserInput;
import angry.gameobject.Bird;
import angry.gameobject.GameObject;
import angry.gameobject.Pig;
import angry.physics.GravityManager;
import angry.physics.PhysicManager;
import angry.util.DPoint;

public class Game extends Panel {

	private static final long serialVersionUID = 1L;
	private GravityManager gravity; // gravité
	private String message = new String(); // message à afficher en haut de l'écran

	private int score; // nombre de fois où le joueur a gagné
	private boolean gameOver; // vrai lorsque le joueur a touché un bord ou le cochon
	private boolean selecting; // vrai lorsque le joueur sélectionne l'angle et la vitesse
	private boolean levelCompleted;
	private Drawing draw;
	private Window win;
	private Arena arena;
	private UserInput input;
	private GameController gc;

	// constructeur
	public Game() {
		// Création de la fenêtre
		win = new Window();
		draw = new Drawing(this);
		gc = new GameController(this, draw);
		arena = new Arena();

		win.setDrawing(draw);
		draw.setArena(arena);

		// Création du module de commande
		Command cmd = new Command(gc);
		// Création et connection de l'input utilisateur
		input = new UserInput();
		input.setCommand(cmd);
		draw.addMouseListener(input);
		draw.addMouseMotionListener(input);

		init(1);
		run();
	}

	// début de partie
	public void init(int level) {
		gravity = new GravityManager();

		score = 0;

		gravity.setGravity(0.05);

		arena.setHoles(gravity.getBlackHoles());

		// crée le 1er niveau
		arena.createLevel(level);

		gravity.addNewBlackHole(new DPoint(500, 200), 6, 200);

		gameOver = false;
		selecting = true;
		levelCompleted = false;

		message = "Choisissez l'angle et la vitesse.";
		System.out.println(message);

		draw.repaint();
	}

	// fin de partie
	void stop() {
		gameOver = true;
	}

	// boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et
	// teste les conditions de victoire
	public void run() {
		while (!gameOver) {
			// un pas de simulation toutes les 10ms
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			if ((!gameOver && !selecting) || levelCompleted) {
				// moteur physique
				PhysicManager.stepForward(gravity, arena.getBirds().get(0), arena.getPigs(), arena.getObstacles(),
						arena.getHoles());

				// conditions de victoire
				List<GameObject> toRemove = new ArrayList<GameObject>();
				PhysicManager.checkCollision(arena.getBirds().get(0), arena.getPigs(), arena.getObstacles(),
						arena.getHoles());
				// nettoyage des cochons
				for (Pig p : arena.getPigs()) {
					if (p.getLife() == 0) {
						message = "Gagné !!!";
						score++;
						toRemove.add(p);
					}
				}
				arena.getPigs().removeAll(toRemove);
				toRemove.clear();

				// nettoyage des obstacles
				arena.getObstacles().removeIf(ob -> ob.getLife() == 0);

				// nettoyages des oiseaux
				for (Bird b : arena.getBirds()) {
					if (b.getLife() == 0) {
						message = "Perdu : cliquez pour recommencer.";
						selecting = true;
						toRemove.add(b);
					}
				}
				arena.getBirds().removeAll(toRemove);
				toRemove.clear();

				if (arena.getPigs().size() == 0) {
					// tous les cochons sont morts, on passe au niveau suivant
					stop();
					levelCompleted = true;
					init(2);
				}
				if (arena.getBirds().isEmpty() && !levelCompleted) {
					// tous les oiseaux sont morts, Game Over !
					stop();
					gameOver = true;
					break;
				}
			}

			// redessine
			draw.repaint();
		}

		message = "GameOver...";
		draw.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// on sort simplement du sommeil
		}
	}

	public void setGameOver(boolean go) {
		this.gameOver = go;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setSelecting(boolean s) {
		this.selecting = s;
	}

	public boolean isSelecting() {
		return selecting;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
}
