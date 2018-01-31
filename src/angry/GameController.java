package angry;

import angry.gameobject.Bird;
import angry.util.DPoint;

public class GameController {
	private DPoint target;
	private Game gameRef;

	public Game getGameRef() {
		return gameRef;
	}

	public void setGameRef(Game gameRef) {
		this.gameRef = gameRef;
	}

	private Drawing draw;

	public GameController(Game g, Drawing d) {
		gameRef = g;
		draw = d;
		target = new DPoint(0, 0);
	}

	public void aim(DPoint target) {
		this.target = target;
		draw.setMousePosition(target);
		draw.repaint();
	}

	public void shoot() {
		if (gameRef.isGameOver()) {
			if (gameRef.getArena().getLevel() == 1) {
				gameRef.init(1);
			} else {
				gameRef.init(2);
			}

		} else if (gameRef.isSelecting()) {
			Bird bird = gameRef.getArena().getBirds().get(0);
			DPoint vel = bird.getVelocity();
			vel.x = ((bird.getPosX() - target.x) / 20.0);
			vel.y = ((bird.getPosY() - target.y) / 20.0);
			bird.setVelocity(vel);
			gameRef.setMessage("L'oiseau prend sont envol");
			gameRef.setSelecting(false);
		}
		draw.repaint();
	}

}
