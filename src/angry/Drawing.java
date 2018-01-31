package angry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;

import angry.gameobject.Bird;
import angry.gameobject.BlackHole;
import angry.gameobject.Obstacle;
import angry.gameobject.Pig;
import angry.physics.hitbox.RectangleHitBox;
import angry.util.DPoint;

public class Drawing extends Panel {

	private static final long serialVersionUID = 1L;
	Image buffer; // image pour le rendu hors écran
	Pig pig;
	double mouseX;
	double mouseY;
	Arena arena;
	private Game game;

	public Drawing(Game g) {
		mouseX = mouseY = 0;
		this.game = g;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	// dessine le contenu de l'écran dans un buffer puis copie le buffer à l'écran
	public void paint(Graphics g2) {

		Bird bird = null;

		if (buffer == null)
			buffer = createImage(1280, 800);
		Graphics2D g = (Graphics2D) buffer.getGraphics();
		if (!arena.getBirds().isEmpty()) {
			bird = arena.getBirds().get(0);
		}

		// fond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(arena.getImage(), 0, 0, null);
		// décor
		g.setColor(Color.BLACK);
		g.drawLine(150, 680, 150, 580);

		// holes
		for (BlackHole bh : arena.getHoles()) {
			Image bhimg = bh.getImage();
			g.drawImage(bhimg, (int) bh.getPosition().x - bhimg.getWidth(null) / 2,
					(int) bh.getPosition().y - bhimg.getHeight(null) / 2, null);
		}

		if (bird != null) {
			g.drawImage(bird.getImage(), (int) bird.getPosX() - 20, (int) bird.getPosY() - 20, null);

			if (game.isSelecting())
				g.drawLine((int) bird.getPosX(), (int) bird.getPosY(), (int) mouseX, (int) mouseY); // montre l'angle et
																									// la
																									// vitesse
		}

		// cochons
		for (Pig p : arena.getPigs()) {
			g.drawImage(p.getImage(), (int) p.getPosX() - 20, (int) p.getPosY() - 30, null);
		}

		// obstacles
		for (Obstacle obs : arena.getObstacles()) {
			g.drawImage(obs.getImage(), (int) obs.getPosX() - ((RectangleHitBox) obs.getHitbox()).getSemiWidth(),
					(int) obs.getPosY() - ((RectangleHitBox) obs.getHitbox()).getSemiHeight(), null);

		}

		// messages
		g.setColor(Color.BLACK);
		g.drawString(game.getMessage(), 300, 100);
		g.drawString("score: " + game.getScore(), 20, 20);

		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// évite les scintillements
	public void update(Graphics g) {
		paint(g);
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(1280, 800);
	}

	public void setMousePosition(DPoint target) {
		this.mouseX = target.x;
		this.mouseY = target.y;
	}

}
