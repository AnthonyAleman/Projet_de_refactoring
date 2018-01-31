package angry.physics.hitbox;

import angry.util.DPoint;

public class HitBoxCollision {

	public static boolean isHitting(HitBox hb1, HitBox hb2) {
		if (hb1 instanceof CircleHitBox) {
			if (hb2 instanceof CircleHitBox) {
				return circleHittingCircle((CircleHitBox) hb1, (CircleHitBox) hb2);
			} else if (hb2 instanceof RectangleHitBox) {
				return circleHittingRectangle((CircleHitBox) hb1, (RectangleHitBox) hb2);
			} else {
				new Exception("Classe du second argument de la méthode non reconnue").printStackTrace();
			}
		} else if (hb1 instanceof RectangleHitBox) {
			if (hb2 instanceof RectangleHitBox) {
				return rectangleHittingRectangle((RectangleHitBox) hb1, (RectangleHitBox) hb2);
			} else if (hb2 instanceof CircleHitBox) {
				return circleHittingRectangle((CircleHitBox) hb2, (RectangleHitBox) hb1);
			} else {
				new Exception("Classe du second argument de la méthode non reconnue").printStackTrace();
			}
		} else
			new Exception("Classe du premier argument de la méthode non reconnue").printStackTrace();

		return false;
	}

	private static boolean circleHittingCircle(CircleHitBox c1, CircleHitBox c2) {
		int r1 = c1.getRadius();
		int r2 = c2.getRadius();
		double dis = DPoint.squareDistance(c1.getPosition(), c2.getPosition());

		return dis <= (r1 + r2) * (r1 + r2);
	}

	private static boolean circleHittingRectangle(CircleHitBox c, RectangleHitBox r) {
		double dis_x, dis_y;
		int rad = c.getRadius();
		int w = r.getSemiWidth(), h = r.getSemiHeight();
		DPoint pc = c.getPosition();
		DPoint pr = r.getPosition();
		DPoint top_left, top_right, bot_left, bot_right;

		dis_x = Math.abs(pc.x - pr.x);
		dis_y = Math.abs(pc.y - pr.y);
		top_left = new DPoint(pr.x - w, pr.y + h);
		top_right = new DPoint(pr.x + w, pr.y + h);
		bot_left = new DPoint(pr.x - w, pr.y - h);
		bot_right = new DPoint(pr.x + w, pr.y - h);

		return (pc.x >= pr.x - w) && (pc.x <= pr.x + w) && (dis_y <= rad + h)
				|| (pc.y >= pr.y - h) && (pc.y <= pr.y + h) && (dis_x <= rad + w)
				|| (c.isIn(top_left) || c.isIn(top_right) || c.isIn(bot_left) || c.isIn(bot_right));
	}

	private static boolean rectangleHittingRectangle(RectangleHitBox r1, RectangleHitBox r2) {
		DPoint p1 = r1.getPosition();
		DPoint p2 = r2.getPosition();
		int w1 = r1.getSemiWidth(), h1 = r1.getSemiHeight();
		int w2 = r2.getSemiWidth(), h2 = r2.getSemiHeight();
		double dis_x, dis_y;
		dis_x = Math.abs(p2.x - p1.x);
		dis_y = Math.abs(p2.y - p1.y);

		return (dis_x <= (w1 + w2)) && (dis_y <= (h1 + h2));
	}

}
