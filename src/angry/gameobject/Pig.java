package angry.gameobject;

public class Pig extends GameObject {

	public Pig() {
		super();
	}

	@Override
	public void onCollideEvent(GameObject go) {
		life--;
	}
}
