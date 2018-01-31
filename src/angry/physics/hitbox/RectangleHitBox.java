package angry.physics.hitbox;

public class RectangleHitBox extends HitBox {

	private int semiWidth;
	private int semiHeight;

	public RectangleHitBox() {
		super();
		this.semiWidth = 0;
		this.semiHeight = 0;
	}

	public int getSemiWidth() {
		return semiWidth;
	}

	public void setSemiWidth(int semiWidth) {
		this.semiWidth = semiWidth;
	}

	public int getSemiHeight() {
		return semiHeight;
	}

	public void setSemiHeight(int semiHeight) {
		this.semiHeight = semiHeight;
	}

}
