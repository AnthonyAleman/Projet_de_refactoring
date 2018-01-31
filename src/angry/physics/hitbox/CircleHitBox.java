package angry.physics.hitbox;

import angry.util.DPoint;

public class CircleHitBox extends HitBox {

	private int radius;

	public CircleHitBox() {
		super();
		this.radius = 0;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean isIn(DPoint p) {
		double dis = DPoint.squareDistance(position, p);
		return radius * radius >= dis;
	}

}
