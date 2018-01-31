package angry.physics.hitbox;

import angry.util.DPoint;

public abstract class HitBox {
	protected DPoint position;

	public HitBox() {
		position = new DPoint(0, 0);
	}

	public DPoint getPosition() {
		return position;
	}

	public void setPosition(DPoint position) {
		this.position = position;
	}

}
