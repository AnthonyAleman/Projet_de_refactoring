package angry.physics;

import java.util.ArrayList;
import java.util.List;

import angry.gameobject.Bird;
import angry.gameobject.BlackHole;
import angry.gameobject.GameObject;
import angry.gameobject.Obstacle;
import angry.gameobject.Pig;
import angry.physics.hitbox.HitBoxCollision;
import angry.util.DPoint;

public class PhysicManager {

	public static void stepForward(GravityManager gm, Bird currentBird, List<Pig> pigs, List<Obstacle> obs,
			List<BlackHole> bh) {
		// application de la gravité
		gm.applyGravityToGameObject(currentBird);

		// avancé des objets
		DPoint pos = currentBird.getPosition();
		pos.add(currentBird.getVelocity());
		currentBird.setPosition(pos);
		for (Pig p : pigs) {
			pos = p.getPosition();
			pos.add(p.getVelocity());
			p.setPosition(pos);
		}
		for (Obstacle o : obs) {
			pos = o.getPosition();
			pos.add(o.getVelocity());
			o.setPosition(pos);
		}
	}

	@SuppressWarnings("unused")
	private static void applyGravityToPigs(GravityManager gm, List<Pig> pigs) {
		for (Pig p : pigs) {
			gm.applyGravityToGameObject(p);
		}
	}

	@SuppressWarnings("unused")
	private static void applyGravityToObstacles(GravityManager gm, List<Obstacle> obs) {
		for (Obstacle o : obs) {
			gm.applyGravityToGameObject(o);
		}
	}

	public static void checkCollision(Bird currentBird, List<Pig> pigs, List<Obstacle> obs, List<BlackHole> bh) {
		List<GameObject> allObject = new ArrayList<>();
		allObject.add(currentBird);
		allObject.addAll(pigs);
		allObject.addAll(obs);
		allObject.addAll(bh);

		GameObject current = null;
		GameObject compared = null;
		for (int i = 0; i < allObject.size() - 1; i++) {
			current = allObject.get(i);
			for (int j = i + 1; j < allObject.size(); j++) {
				compared = allObject.get(j);
				if (HitBoxCollision.isHitting(current.getHitbox(), compared.getHitbox())) {
					current.onCollideEvent(compared);
					compared.onCollideEvent(current);
				}
			}
		}

		// si l'oiseau touche le sol
		if (currentBird.getPosition().y > 650) {
			currentBird.getPosition().y = 650;
			currentBird.reboundToHorizontal();
		}

		allObject.clear();
	}

}
