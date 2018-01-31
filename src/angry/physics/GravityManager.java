package angry.physics;

import java.util.ArrayList;
import java.util.List;

import angry.gameobject.BlackHole;
import angry.gameobject.GameObject;
import angry.gameobject.GameObjectBuilder;
import angry.util.DPoint;

public class GravityManager {
	private double gravity;
	private double dragFactor;
	private List<BlackHole> blackHoles;

	public GravityManager() {
		gravity = 1;
		dragFactor = 0;
		blackHoles = new ArrayList<BlackHole>();
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public void applyGravityToGameObject(GameObject go) {
		go.getVelocity().y += gravity;
		for (BlackHole bh : blackHoles) {
			if (bh.getEffectArea().isIn(go.getPosition())) {
				DPoint vec = new DPoint();
				vec.x = bh.getPosition().x - go.getPosition().x;
				vec.y = bh.getPosition().y - go.getPosition().y;
				double dis = DPoint.squareDistance(go.getPosition(), bh.getPosition());
				double pow = bh.getPower();
				int rad = bh.getEffectArea().getRadius();
				double coeff = Math.abs((pow * (rad - dis)) / (rad * dis));
				vec.x *= coeff * coeff * 0.9;
				vec.y *= coeff * coeff * 0.9;
				go.getVelocity().add(vec);
			}
		}
		go.getVelocity().x *= 1 - dragFactor;
		go.getVelocity().y *= 1 - dragFactor;
	}

	public void addNewBlackHole(DPoint position, double power, int radius) {
		BlackHole bh = GameObjectBuilder.newBlackHole(position, power, radius);
		blackHoles.add(bh);
	}

	public List<BlackHole> getBlackHoles() {
		return blackHoles;
	}

	public void clearBlackHoleList() {
		blackHoles.clear();
	}

	public double getDragFactor() {
		return dragFactor;
	}

	public void setDragFactor(double dragFactor) {
		this.dragFactor = dragFactor;
	}

}
