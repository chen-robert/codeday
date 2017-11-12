package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.blocks.Block;
import game.blocks.Cannon;

public class Ship extends Entity{
	private List<Block> blocks = new ArrayList<>();
	private HashMap<Block, Info> lookup = new HashMap<>();
	private class Info{
		public double mag;
		public double angle;
		public Info(double mag, double angle) {
			this.mag = mag;
			this.angle = angle;
		}
	}
	public Ship(int x, int y) {
		super(x, y);
		
		blocks.add(new Cannon(0,0));
		blocks.add(new Block(10, 0));
		
		for(Block b: blocks) {
			double mag = b.getX() * b.getX() + b.getY() + b.getY();
			mag = Math.sqrt(mag);
			
			double angle = Math.atan2(b.getX(), b.getY());
			lookup.put(b, new Info(mag, angle));
		}
		
		GameManager.gm.addShip(this);
	}
	public void tick() {
		super.tick();
		
		for(Block b: blocks) {
			Info n = lookup.get(b);
			
			
			b.x = n.mag * Math.cos(n.angle + angle) + x;
			b.y = n.mag * Math.sin(n.angle + angle) + y;
			b.angle = angle;
		}
		
		cleanup();
	}
	public void action() {
		for(Block b: blocks) {
			b.action();
		}
	}
	public void collide(Bullet e) {
		for(Block b: blocks) {
			int dx = e.getX() - b.getX();
			int dy = e.getY() - b.getY();
			double dist = Math.sqrt(dx * dx + dy * dy);
			if(dist < 10) {
				b.hit(e);
			}
		}
	}
	public void cleanup() {
		for(int i = 0; i < blocks.size(); i++) {
			if(!blocks.get(i).isAlive())blocks.remove(i--);
		}
	}

	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return null;
	}

}
