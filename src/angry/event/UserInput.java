package angry.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import angry.util.DPoint;

public class UserInput extends Input implements MouseListener, MouseMotionListener {

	public UserInput() {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.mouseMoved(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.com.onMouseMotionEvent(new DPoint(e.getX(), e.getY()));
		// System.out.println("coo : " + e.getX() + " ; " + e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.com.onMouseClickedEvent(new DPoint(e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.com.onMouseEnterWindowEvent();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.com.onMouseExitWindowEvent();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.com.onMousePressedEvent(new DPoint(e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.com.onMouseReleasedEvent(new DPoint(e.getX(), e.getY()));
	}
}
