package angry.gameobject;

import java.awt.Image;

import angry.physics.hitbox.HitBox;
import angry.util.DPoint;

public abstract class GameObject {
	protected HitBox hitbox;
	protected DPoint velocity;
	protected Image image;
	protected int life;

	protected GameObject() {
		velocity = new DPoint(0, 0);
	}

	public DPoint getPosition() {
		return hitbox.getPosition();
	}

	public void setPosition(DPoint position) {
		hitbox.setPosition(position);
	}

	public HitBox getHitbox() {
		return hitbox;
	}

	public void setHitbox(HitBox hitbox) {
		this.hitbox = hitbox;
	}

	public DPoint getVelocity() {
		return velocity;
	}

	public void setVelocity(DPoint velocity) {
		this.velocity = velocity;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	// getter et setter temporaire, juste pour assurer la cohérence du code
	public double getPosX() {
		return getPosition().x;
	}

	public double getPosY() {
		return getPosition().y;
	}

	public void setPosX(double x) {
		DPoint p = getPosition();
		p.x = x;
		setPosition(p);
	}

	public void setPosY(double y) {
		DPoint p = getPosition();
		p.y = y;
		setPosition(p);
	}

	public double getVelocityX() {
		return velocity.x;
	}

	public double getVelocityY() {
		return velocity.y;
	}

	public void setVelocityX(double x) {
		DPoint v = getVelocity();
		v.x = x;
		setVelocity(v);
	}

	public void setVelocityY(double y) {
		DPoint v = getVelocity();
		v.y = y;
		setVelocity(v);
	}

	public abstract void onCollideEvent(GameObject go);

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
