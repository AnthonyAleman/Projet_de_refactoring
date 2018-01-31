package angry.gameobject;

public class Obstacle extends GameObject {

	@Override
	public void onCollideEvent(GameObject go) {
		if (go instanceof Bird)
			life--;

	}

}
