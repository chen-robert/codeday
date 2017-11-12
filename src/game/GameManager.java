package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
	private List<Entity> entities;
	private Player p;
	public GameManager() {
		entities = new ArrayList<Entity>();
		p = new Player();
		entities.add(p);
	}
	public List<Entity> getEntities(){
		return entities;
	}
	public Point getView() {
		return new Point((int) p.getX(), (int) p.getY());
	}
}
