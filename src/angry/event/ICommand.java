package angry.event;

import angry.util.DPoint;

public interface ICommand {
	public void onMouseMotionEvent(DPoint dest);

	public void onMouseClickedEvent(DPoint pos);

	public void onMousePressedEvent(DPoint pos);

	public void onMouseReleasedEvent(DPoint pos);

	public void onMouseExitWindowEvent();

	public void onMouseEnterWindowEvent();
}
