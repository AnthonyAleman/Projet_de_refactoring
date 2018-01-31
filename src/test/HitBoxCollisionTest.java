package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import angry.physics.hitbox.CircleHitBox;
import angry.physics.hitbox.HitBoxCollision;
import angry.physics.hitbox.RectangleHitBox;
import angry.util.DPoint;

public class HitBoxCollisionTest {

	public HitBoxCollisionTest() {
	}

	@Test
	public void testCircleIsIn() {
		CircleHitBox c = new CircleHitBox();
		DPoint p;

		c.setPosition(new DPoint(0, 0));
		c.setRadius(10);
		p = new DPoint(1, 1);
		assertTrue(c.isIn(p));
		p.x = -5;
		assertTrue(c.isIn(p));
		p.y = -4;
		assertTrue(c.isIn(p));
		p = new DPoint(0, 10);
		assertTrue(c.isIn(p));
		p = new DPoint(-10, 0);
		assertTrue(c.isIn(p));

		p = new DPoint(10, 10);
		assertFalse(c.isIn(p));
		p = new DPoint(-10, -10);
		assertFalse(c.isIn(p));
		p = new DPoint(-11, 1);
		assertFalse(c.isIn(p));
		p = new DPoint(2, -12);
		assertFalse(c.isIn(p));
	}

	@Test
	public void testCircleHitCircleBasic() {
		CircleHitBox c1 = new CircleHitBox();
		CircleHitBox c2 = new CircleHitBox();

		c1.setRadius(10);
		c2.setRadius(10);
		c1.setPosition(new DPoint(0, 0));

		c2.setPosition(new DPoint(0, 5));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(5, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(0, -5));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-5, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));

		c2.setPosition(new DPoint(0, 11));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(0, -11));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(11, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-11, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));

		c2.setPosition(new DPoint(10, 10));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(10, -10));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-10, 10));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-10, -10));
		assertTrue(HitBoxCollision.isHitting(c1, c2));

		c2.setPosition(new DPoint(0, 20));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(0, -20));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(20, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-20, 0));
		assertTrue(HitBoxCollision.isHitting(c1, c2));

		c2.setPosition(new DPoint(0, 21));
		assertFalse(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(0, -21));
		assertFalse(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(21, 0));
		assertFalse(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-21, 0));
		assertFalse(HitBoxCollision.isHitting(c1, c2));

		c2.setPosition(new DPoint(20, 20));
		assertFalse(HitBoxCollision.isHitting(c1, c2));
		c2.setPosition(new DPoint(-20, -20));
		assertFalse(HitBoxCollision.isHitting(c1, c2));

		c2.setRadius(0);
		c2.setPosition(new DPoint(1, 1));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
		c1.setRadius(0);
		c1.setPosition(new DPoint(1, 1));
		assertTrue(HitBoxCollision.isHitting(c1, c2));
	}

	@Test
	public void testRectangleHitRectangleBasic() {
		RectangleHitBox r1 = new RectangleHitBox();
		RectangleHitBox r2 = new RectangleHitBox();

		r1.setPosition(new DPoint(0, 0));
		r1.setSemiHeight(5);
		r1.setSemiWidth(5);
		r2.setSemiHeight(10);
		r2.setSemiWidth(2);

		r2.setPosition(new DPoint(0, 0));
		assertTrue(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(5, 0));
		assertTrue(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(-5, 0));
		assertTrue(HitBoxCollision.isHitting(r1, r2));

		r2.setPosition(new DPoint(0, 15));
		assertTrue(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(0, -15));
		assertTrue(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(7, 0));
		assertTrue(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(-7, 0));
		assertTrue(HitBoxCollision.isHitting(r1, r2));

		r2.setPosition(new DPoint(0, 16));
		assertFalse(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(0, -16));
		assertFalse(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(8, 0));
		assertFalse(HitBoxCollision.isHitting(r1, r2));
		r2.setPosition(new DPoint(-8, 0));
		assertFalse(HitBoxCollision.isHitting(r1, r2));

		r1.setSemiHeight(1);
		r1.setSemiWidth(1);
		r2.setPosition(new DPoint(2, 2));
		r2.setSemiHeight(1);
		r2.setSemiWidth(1);
		assertTrue(HitBoxCollision.isHitting(r1, r2));
	}

	@Test
	public void testCircleHitRectangleBasic() {
		CircleHitBox c = new CircleHitBox();
		RectangleHitBox r = new RectangleHitBox();

		c.setRadius(5);
		r.setPosition(new DPoint(0, 0));
		r.setSemiHeight(5);
		r.setSemiWidth(10);

		c.setPosition(new DPoint(0, 7));
		assertTrue(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(0, -7));
		assertTrue(HitBoxCollision.isHitting(r, c));
		c.setPosition(new DPoint(12, 0));
		assertTrue(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(-12, 0));
		assertTrue(HitBoxCollision.isHitting(r, c));

		c.setPosition(new DPoint(11, 6));
		assertTrue(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(-11, 6));
		assertTrue(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(11, -6));
		assertTrue(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(-11, -6));
		assertTrue(HitBoxCollision.isHitting(c, r));

		c.setPosition(new DPoint(14, 9));
		assertFalse(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(-14, 9));
		assertFalse(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(14, -9));
		assertFalse(HitBoxCollision.isHitting(c, r));
		c.setPosition(new DPoint(-14, -9));
		assertFalse(HitBoxCollision.isHitting(c, r));
	}

	@Test(timeout = 1000)
	public void testCircleHitCircleSpeed() {
		CircleHitBox c1 = new CircleHitBox();
		CircleHitBox c2 = new CircleHitBox();

		c1.setPosition(new DPoint(0, 0));
		c2.setPosition(new DPoint(100, 0));
		c1.setRadius(2);
		Random rnd = new Random();

		for (int i = 0; i < 10000000; i++) {
			c2.setRadius(rnd.nextInt(97));
			HitBoxCollision.isHitting(c1, c2);
		}
	}

	@Test(timeout = 1000)
	public void testRectangleHitRectangleSpeed() {
		RectangleHitBox r1 = new RectangleHitBox();
		RectangleHitBox r2 = new RectangleHitBox();

		r1.setPosition(new DPoint(0, 0));
		r2.setPosition(new DPoint(100, 0));
		r1.setSemiHeight(2);
		Random rnd = new Random();

		for (int i = 0; i < 10000000; i++) {
			r2.setSemiWidth(rnd.nextInt(97));
			HitBoxCollision.isHitting(r1, r2);
		}
	}

	@Test(timeout = 1000)
	public void testCircleHitRectangleSpeed() {
		CircleHitBox c = new CircleHitBox();
		RectangleHitBox r = new RectangleHitBox();

		c.setPosition(new DPoint(0, 0));
		r.setPosition(new DPoint(100, 0));
		c.setRadius(2);
		Random rnd = new Random();

		for (int i = 0; i < 10000000; i++) {
			r.setSemiWidth(rnd.nextInt(97));
			HitBoxCollision.isHitting(c, r);
		}
	}
}
