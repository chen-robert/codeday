package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameManager {
	public static final GameManager gm = new GameManager();
	static {
		gm.init();
	}
	private List<Entity> entities;
	private List<Entity> futureEntity;
	private Player p;
	public void init() {
		entities = new ArrayList<Entity>();
		futureEntity = new LinkedList<Entity>();
		p = new Player();
		entities.add(p);
		entities.add(new Block(105, 5));
	}
	public void tick() {
		for(Entity e: entities) {
			e.tick();
		}
		
		while(futureEntity.size() > 0)entities.add(futureEntity.remove(0));
	}
	public void addEntity(Entity e) {
		futureEntity.add(e);
	}
	public List<Entity> getEntities(){
		return entities;
	}
	public Point getView() {
		return new Point((int) p.getX(), (int) p.getY());
	}
	public Player getPlayer() {
		return p;
	}
}
