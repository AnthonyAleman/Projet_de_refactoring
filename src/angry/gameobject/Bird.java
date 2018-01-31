package angry.gameobject;

public class Bird extends GameObject {

	public Bird() {
		super();
	}

	@Override
	public void onCollideEvent(GameObject go) {
		life--;
	}

	public void reboundToHorizontal() {
		final double reboundFactor = 0.6;
		velocity.y = -velocity.y * reboundFactor;
		velocity.x *= reboundFactor;
		if (velocity.squareNorm() <= 1)
			life--;
	}

}
