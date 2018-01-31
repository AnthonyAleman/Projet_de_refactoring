package angry.gameobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import angry.physics.hitbox.CircleHitBox;
import angry.physics.hitbox.RectangleHitBox;
import angry.util.DPoint;

public class GameObjectBuilder {

	static public Bird newBird() {
		Bird b = new Bird();
		CircleHitBox hb = new CircleHitBox();

		hb.setRadius(30);
		b.setHitbox(hb);
		b.setLife(1);

		return b;
	}

	static public Pig newPig() {
		Pig p = new Pig();
		CircleHitBox hb = new CircleHitBox();

		hb.setRadius(30);
		p.setHitbox(hb);
		p.setLife(1);

		return p;
	}

	static public Obstacle newObstacle(int life, int width, int height) {
		Obstacle ob = new Obstacle();
		RectangleHitBox hb = new RectangleHitBox();

		hb.setSemiHeight(height / 2);
		hb.setSemiWidth(width / 2);
		ob.setHitbox(hb);
		ob.setLife(life);

		return ob;
	}

	static public BlackHole newBlackHole(DPoint position, double power, int radius) {
		BlackHole bh = new BlackHole();
		CircleHitBox hb = new CircleHitBox();
		CircleHitBox erad = new CircleHitBox();
		BufferedImage sprite = null;

		// chargement de l'image
		try {
			sprite = ImageIO.read(new File("ressources/images/black_hole.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bh.setImage(sprite);

		// préparation de la hitbox
		hb.setPosition(position);
		hb.setRadius(10);
		bh.setHitbox(hb);

		// préparation du black hole
		bh.setPower(power);
		erad.setRadius(radius);
		erad.setPosition(position);
		bh.setEffectArea(erad);
		bh.setVelocity(new DPoint());

		return bh;
	}
}
