package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import game.blocks.Block;

public class GameManager {
	public static final GameManager gm = new GameManager();
	static {
		gm.init();
	}
	private List<Entity> entities;
	private List<Entity> futureEntity;
	
	private List<Bullet> bullets;
	private List<Ship> collidable;
	private Player p;
	public void init() {
		entities = new ArrayList<Entity>();
		futureEntity = new LinkedList<Entity>();
		bullets = new ArrayList<Bullet>();
		collidable = new ArrayList<Ship>();
		
		p = new Player();
	}
	public void tick() {
		for(Entity e: entities) {
			e.tick();
		}
		
		while(futureEntity.size() > 0)entities.add(futureEntity.remove(0));
		
		testCollisions();
		cleanup();
		
		if(collidable.size() < 25) {
			new AI(p.getX() + (int) (1000 * Math.random()) - 500,
					p.getY() + (int) (1000 * Math.random()) - 500);
		}
		if(!p.isAlive()) {
			Ship s = collidable.get(0);
			int n = 0;
			while(s.getClass().equals(DeadShip.class))s = collidable.get(n++);
			
			p.x = s.x;
			p.y = s.y;
		}
		
	}
	public Ship getClosest(Entity e, Object parent) {
		int bestDist = 1 << 30;
		Ship ret = null;
		for(Ship s: collidable) {
			if(s == parent)continue;
			
			int dx = s.getX() - e.getX();
			int dy = s.getY() - e.getY();
			double dist = Math.sqrt(dx * dx + dy * dy);
			
			if(dist < bestDist) {
				bestDist = (int) dist;
				ret = s;
			}
		}
		return ret;
	}
	public void testCollisions() {
		for(Bullet b: bullets) {
			for(Ship s: collidable) {
				s.collide(b);
			}
		}
	}
	public void cleanup() {
		for(int i = 0; i < entities.size(); i++) {
			if(!entities.get(i).isAlive())entities.remove(i--);
		}
		for(int i = 0; i < collidable.size(); i++) {
			if(!collidable.get(i).isAlive())collidable.remove(i--);
		}
		for(int i = 0; i < bullets.size(); i++) {
			if(!bullets.get(i).isAlive())bullets.remove(i--);
		}
	}
	public void addEntity(Entity e) {
		futureEntity.add(e);
	}
	public void addBullet(Bullet b) {
		bullets.add(b);
	}
	public void addShip(Ship s) {
		collidable.add(s);
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
