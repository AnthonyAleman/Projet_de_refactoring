package angry.util;

public class DPoint {
	public double x, y;

	public DPoint() {
		x = y = 0;
	}

	public DPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public DPoint(DPoint dp) {
		if (dp != null) {
			x = dp.x;
			y = dp.y;
		} else
			x = y = 0;
	}

	public void add(DPoint dp) {
		x += dp.x;
		y += dp.y;
	}

	public void sub(DPoint dp) {
		x -= dp.x;
		y -= dp.y;
	}

	public double squareNorm() {
		return x * x + y * y;
	}

	static public double squareDistance(DPoint a, DPoint b) {
		DPoint tmp = new DPoint(b.x - a.x, b.y - a.y);
		return (tmp.x * tmp.x) + (tmp.y * tmp.y);
	}
}
