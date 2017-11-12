package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.blocks.Block;
import game.blocks.MissileLauncher;
import game.blocks.Thruster;

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
		
		for(int i = -3; i < 4; i++) {
			for(int z = -3; z < 4; z++) {
				if(Math.random() < 1) {
					if(Math.random() < 0.5) blocks.add(new MissileLauncher(10*i,10*z,this));
					else blocks.add(new Thruster(10*i,10*z,this));
				}
			}
		}
		removeUnconnected();
		
		GameManager.gm.addShip(this);
	}
	protected void buildInfo() {
		for(Block b: blocks) {
			double mag = b.getX() * b.getX() + b.getY() * b.getY();
			mag = Math.sqrt(mag);
			
			double angle = Math.atan2(b.getX(), b.getY());
			lookup.put(b, new Info(mag, angle));
		}
	}
	public void tick() {
		if(vx < -4)vx = -4;
		if(vx > 4)vx = 4;

		if(vy < -4)vy = -4;
		if(vy > 4)vy = 4;
		
		super.tick();
		
		for(Block b: blocks) {
			Info n = lookup.get(b);
			
			
			b.x = n.mag * Math.cos(n.angle + angle) + x;
			b.y = n.mag * Math.sin(n.angle + angle) + y;
			b.angle = angle;
		}
		
		cleanup();
	}
	public void action(Class<? extends Block> c) {
		for(Block b: blocks) {
			if(b.getClass().equals(c))b.action();
		}
	}
	public void collide(Bullet e) {
		if(e.getParent() == this)return;
		
		for(Block b: blocks) {
			int dx = e.getX() - b.getX();
			int dy = e.getY() - b.getY();
			double dist = Math.sqrt(dx * dx + dy * dy);
			if(dist < 10 + e.getRadius()) {
				b.hit(e);
			}
		}
	}
	public void cleanup() {
		boolean remove = false;
		for(int i = 0; i < blocks.size(); i++) {
			if(!blocks.get(i).isAlive()) {
				blocks.remove(i--);
				remove = true;
			}
		}
		if(remove)removeUnconnected();
	}

	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getSpeed() {
		int count = 0;
		for(Block b: blocks) {
			if(b.getClass().equals(Thruster.class))count++;
		}
		return (double) count / blocks.size();
	}
	public void removeUnconnected() {
		boolean[][] map = new boolean[200][200];
		for(Block b: blocks) {
			Info n = lookup.get(b);
			
			int x = 100 + (int) Math.round(n.mag * Math.cos(n.angle)) / 10;
			int y = 100 + (int) Math.round(n.mag * Math.sin(n.angle)) / 10;
			map[x][y] = true;
		}
		boolean[][] connected = new boolean[map.length][map[0].length];
		dfs(100, 100, connected, map);
		
		for(int i = 0; i < blocks.size(); i++) {
			Info n = lookup.get(blocks.get(i));
			
			int x = 100 + (int) Math.round(n.mag * Math.cos(n.angle)) / 10;
			int y = 100 + (int) Math.round(n.mag * Math.sin(n.angle)) / 10;
			
			if(!connected[x][y])blocks.remove(i--);
		}
	}
	private void dfs(int x, int y, boolean[][] connected, boolean[][] map) {
		connected[x][y] = true;
		map[x][y] = false;
		if(map[x][y-1])dfs(x, y-1, connected, map);
		if(map[x][y+1])dfs(x, y+1, connected, map);
		if(map[x-1][y])dfs(x-1, y, connected, map);
		if(map[x+1][y])dfs(x+1, y, connected, map);
	}
	@Override
	public boolean isAlive() {
		return blocks.size() > 0;
	}

}
