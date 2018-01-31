package angry;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import angry.gameobject.Bird;
import angry.gameobject.BlackHole;
import angry.gameobject.GameObjectBuilder;
import angry.gameobject.Obstacle;
import angry.gameobject.Pig;
import angry.util.DPoint;

public class Arena {

	Image image;
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	private List<Pig> pigs = new ArrayList<Pig>();
	private List<Bird> birds = new ArrayList<Bird>();
	private List<BlackHole> holes;
	private int level;
	private Bird bird;
	private Pig pig;

	public Arena() {
		holes = new ArrayList<BlackHole>();
	}

	private void clearLists() {
		obstacles.clear();
		pigs.clear();
		birds.clear();
		holes.clear();
	}

	public void setLevel1Positions() {
		// nettoyage des listes
		clearLists();

		// création des objects
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());

		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 82, 36));

		// positionnement des objets
		birds.get(0).setPosX(150);
		birds.get(0).setPosY(580);
		birds.get(1).setPosX(130);
		birds.get(1).setPosY(550);
		birds.get(2).setPosX(130);
		birds.get(2).setPosY(550);
		birds.get(3).setPosX(130);
		birds.get(3).setPosY(550);
		pigs.get(0).setPosX(750);
		pigs.get(0).setPosY(650);
		pigs.get(1).setPosX(643);
		pigs.get(1).setPosY(650);
		pigs.get(2).setPosX(640);
		pigs.get(2).setPosY(400);
		obstacles.get(0).setPosition(new DPoint(612, 573));
		obstacles.get(1).setPosition(new DPoint(683, 573));
		obstacles.get(2).setPosition(new DPoint(644, 453));
	}

	public void setLevel2Positions() {
		// nettoyage des listes
		clearLists();

		// création des objects
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());

		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 82, 36));

		// positionnement des objets
		birds.get(0).setPosX(150);
		birds.get(0).setPosY(580);
		birds.get(1).setPosX(130);
		birds.get(1).setPosY(550);
		birds.get(2).setPosX(130);
		birds.get(2).setPosY(550);
		birds.get(3).setPosX(130);
		birds.get(3).setPosY(550);
		pigs.get(0).setPosX(750);
		pigs.get(0).setPosY(650);
		pigs.get(1).setPosX(643);
		pigs.get(1).setPosY(650);
		pigs.get(2).setPosX(640);
		pigs.get(2).setPosY(410);
		obstacles.get(0).setPosition(new DPoint(612, 573));
		obstacles.get(1).setPosition(new DPoint(683, 573));
		obstacles.get(2).setPosition(new DPoint(644, 453));
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public List<Pig> getPigs() {
		return pigs;
	}

	public void setPigs(List<Pig> pigs) {
		this.pigs = pigs;
	}

	public List<Bird> getBirds() {
		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public Pig getPig() {
		return pig;
	}

	public void setPig(Pig pig) {
		this.pig = pig;
	}

	public void createLevel(int level) {

		this.level = level;
		if (level == 1) {
			setLevel1Positions();
			LevelLoader.getLevel1Images(this);
		} else if (level == 2) {
			setLevel2Positions();
			LevelLoader.getLevel2Images(this);
		} else {
			setLevel3Positions();
			LevelLoader.getLevel3Images(this);
		}

	}

	public void setLevel3Positions() {
		// nettoyage des listes
		clearLists();

		// création des objects
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		birds.add(GameObjectBuilder.newBird());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());
		pigs.add(GameObjectBuilder.newPig());

		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 20, 200));
		obstacles.add(GameObjectBuilder.newObstacle(1, 82, 36));

		// positionnement des objets
		birds.get(0).setPosX(150);
		birds.get(0).setPosY(580);
		birds.get(1).setPosX(130);
		birds.get(1).setPosY(550);
		birds.get(2).setPosX(130);
		birds.get(2).setPosY(550);
		birds.get(3).setPosX(130);
		birds.get(3).setPosY(550);
		pigs.get(0).setPosX(550);
		pigs.get(0).setPosY(660);
		pigs.get(1).setPosX(720);
		pigs.get(1).setPosY(660);
		pigs.get(2).setPosX(840);
		pigs.get(2).setPosY(275);
		pigs.get(3).setPosX(400);
		pigs.get(3).setPosY(350);
		pigs.get(4).setPosX(900);
		pigs.get(4).setPosY(585);
		obstacles.get(0).setPosX(360);
		obstacles.get(0).setPosY(365);
		obstacles.get(1).setPosX(880);
		obstacles.get(1).setPosY(630);
		obstacles.get(2).setPosX(800);
		obstacles.get(2).setPosY(290);
	}

	public List<BlackHole> getHoles() {
		return holes;
	}

	public void setHoles(List<BlackHole> holes) {
		this.holes = holes;
	}

}
