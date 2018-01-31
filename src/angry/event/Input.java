package angry.event;

public class Input {

	protected ICommand com;

	public Input() {
	}

	public void setCommand(ICommand c) {
		this.com = c;
	}

	public ICommand getCommand() {
		return this.com;
	}

}
