package game;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;

import game.blocks.Block;

public class Ship extends Entity{
	private HashSet<Block> blocks = new HashSet<>();
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
		
		blocks.add(new Block(0,0));
		blocks.add(new Block(10, 0));
		
		for(Block b: blocks) {
			double mag = b.getX() * b.getX() + b.getY() + b.getY();
			mag = Math.sqrt(mag);
			
			double angle = Math.atan2(b.getX(), b.getY());
			lookup.put(b, new Info(mag, angle));
		}
	}
	public void tick() {
		super.tick();
		
		for(Block b: blocks) {
			Info n = lookup.get(b);
			
			
			b.x = n.mag * Math.cos(n.angle + angle) + x;
			b.y = n.mag * Math.sin(n.angle + angle) + y;
			b.angle = angle;
		}
	}

	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return null;
	}

}
