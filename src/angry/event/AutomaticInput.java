package angry.event;

import angry.util.DPoint;

public class AutomaticInput extends Input {

	public AutomaticInput() {
	}

	public void launch() {
		Runnable runna = new Runnable() {
			public void run() {
				DPoint aimPosition = new DPoint(25, 445);
				try {
					while (true) {
						Thread.sleep(300);
						com.onMouseMotionEvent(aimPosition);
						Thread.sleep(700);
						com.onMouseReleasedEvent(aimPosition);
						Thread.sleep(200);
					}
				} catch (InterruptedException e) {
					System.err.println("L'input automatique a été interrompu");
				}

			}
		};
		Thread t = new Thread(runna);
		t.start(); // demarrage du fils
	}

}
