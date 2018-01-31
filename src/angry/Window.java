package angry;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Panel {

	private static final long serialVersionUID = 1L;

	Drawing draw;
	Frame frame;

	public Window() {
		frame = new Frame("Oiseau pas content");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
	}

	public void setDrawing(Drawing d) {
		draw = d;
		frame.dispose();
		frame.add(draw);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
