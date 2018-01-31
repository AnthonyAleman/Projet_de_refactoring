package angry.gameobject;

import angry.physics.hitbox.CircleHitBox;
import angry.util.DPoint;

public class BlackHole extends GameObject {
	private CircleHitBox effectArea;
	private double power;

	public BlackHole() {
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	@Override
	public void setPosition(DPoint position) {
		super.setPosition(position);
		effectArea.setPosition(position);
	}

	public CircleHitBox getEffectArea() {
		return effectArea;
	}

	public void setEffectArea(CircleHitBox effectArea) {
		this.effectArea = effectArea;
	}

	@Override
	public void onCollideEvent(GameObject go) {
	}

}
