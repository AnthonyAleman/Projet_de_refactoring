package angry.event;

import angry.GameController;
import angry.util.DPoint;

public class Command implements ICommand {

	private GameController gc;

	public Command(GameController gc) {
		this.gc = gc;
	}

	@Override
	public void onMouseMotionEvent(DPoint dest) {
		gc.aim(dest);
	}

	@Override
	public void onMouseClickedEvent(DPoint pos) {
		// System.out.println("La souris a été cliquée");
	}

	@Override
	public void onMousePressedEvent(DPoint pos) {
		// System.out.println("La souris a été préssée");
	}

	@Override
	public void onMouseReleasedEvent(DPoint pos) {
		gc.shoot();
	}

	@Override
	public void onMouseExitWindowEvent() {
		// System.out.println("La souris sort de la fenêtre");
	}

	@Override
	public void onMouseEnterWindowEvent() {
		// System.out.println("La souris entre dans la fenêtre");
	}

}
