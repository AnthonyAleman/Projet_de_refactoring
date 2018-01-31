package angry;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import angry.gameobject.Bird;

public class LevelLoader {

	static BufferedImage image_bird1 = null, image_bird2, image_pig = null, image_arena = null, image_obs1 = null,
			image_obs2 = null, image_obs3 = null;
	static BufferedImage image_bird3;
	static BufferedImage image_bird4;
	private static BufferedImage image_pig2;

	public static BufferedImage loadImage(String file) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;

	}

	public static void getLevel1Images(Arena arena) {

		Bird bird = arena.getBirds().get(0);

		try {
			image_arena = ImageIO.read(new File("ressources/images/level1.png"));
			image_bird1 = ImageIO.read(new File("ressources/images/red_bird.png"));
			image_bird2 = ImageIO.read(new File("ressources/images/yellow_bird1.png"));
			image_bird3 = ImageIO.read(new File("ressources/images/bird3.png"));
			image_bird4 = ImageIO.read(new File("ressources/images/bird4.png"));
			image_pig = ImageIO.read(new File("ressources/images/pig.png"));
			image_obs1 = ImageIO.read(new File("ressources/images/wood2.png"));
			image_obs2 = ImageIO.read(new File("ressources/images/wood3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		arena.setImage(image_arena);
		bird.setImage(image_bird1);
		arena.getBirds().get(1).setImage(image_bird2);
		arena.getBirds().get(2).setImage(image_bird3);
		arena.getBirds().get(3).setImage(image_bird4);

		for (int i = 0; i < arena.getPigs().size(); i++) {
			arena.getPigs().get(i).setImage(image_pig);
		}

		arena.getObstacles().get(0).setImage(image_obs1);
		arena.getObstacles().get(1).setImage(image_obs1);
		arena.getObstacles().get(2).setImage(image_obs2);

	}

	public static void getLevel2Images(Arena arena) {

		Bird bird = arena.getBirds().get(0);

		try {
			image_arena = ImageIO.read(new File("ressources/images/level2.png"));
			image_bird1 = ImageIO.read(new File("ressources/images/red_bird.png"));
			image_bird3 = ImageIO.read(new File("ressources/images/bird3.png"));
			image_bird2 = ImageIO.read(new File("ressources/images/yellow_bird1.png"));
			image_bird4 = ImageIO.read(new File("ressources/images/bird4.png"));
			image_pig = ImageIO.read(new File("ressources/images/pig.png"));
			image_pig2 = ImageIO.read(new File("ressources/images/pig4.png"));
			image_obs2 = ImageIO.read(new File("ressources/images/wood3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		arena.setImage(image_arena);
		bird.setImage(image_bird1);
		arena.getBirds().get(1).setImage(image_bird2);
		arena.getBirds().get(2).setImage(image_bird3);
		arena.getBirds().get(3).setImage(image_bird4);

		for (int i = 0; i < arena.getPigs().size() - 1; i++) {
			arena.getPigs().get(i).setImage(image_pig);
		}
		arena.getPigs().get(arena.getPigs().size() - 1).setImage(image_pig2);

		arena.getObstacles().get(0).setImage(image_obs2);
		arena.getObstacles().get(1).setImage(image_obs2);
		arena.getObstacles().get(2).setImage(image_obs2);

	}

	public static void getLevel3Images(Arena arena) {

		Bird bird = arena.getBirds().get(0);

		try {
			image_arena = ImageIO.read(new File("ressources/images/level3.png"));
			image_bird1 = ImageIO.read(new File("ressources/images/red_bird.png"));
			image_bird3 = ImageIO.read(new File("ressources/images/bird3.png"));
			image_bird2 = ImageIO.read(new File("ressources/images/yellow_bird1.png"));
			image_bird4 = ImageIO.read(new File("ressources/images/bird4.png"));
			image_pig = ImageIO.read(new File("ressources/images/pig.png"));
			image_pig2 = ImageIO.read(new File("ressources/images/pig4.png"));
			image_obs2 = ImageIO.read(new File("ressources/images/wood3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		arena.setImage(image_arena);
		bird.setImage(image_bird1);
		arena.getBirds().get(1).setImage(image_bird2);
		arena.getBirds().get(2).setImage(image_bird3);
		arena.getBirds().get(3).setImage(image_bird4);

		for (int i = 0; i < arena.getPigs().size() - 1; i++) {
			arena.getPigs().get(i).setImage(image_pig);
		}
		arena.getPigs().get(arena.getPigs().size() - 1).setImage(image_pig2);

		arena.getObstacles().get(0).setImage(image_obs2);
		arena.getObstacles().get(1).setImage(image_obs2);
		arena.getObstacles().get(2).setImage(image_obs2);

	}

}
