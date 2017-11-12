package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.ImageLoader;

public class Bullet extends Entity{
	protected int ticks = 0;
	private Object parent;
	protected int radius = 5;
	public Bullet(int x, int y, double speed, double angle, Object parent) {
		super(x, y);
		
		vx = speed * Math.cos(angle);
		vy = speed * Math.sin(angle);
		
		Ship hack = (Ship) parent;
		vx += hack.vx;
		vy += hack.vy;
		
		this.parent = parent;
		
		GameManager.gm.addBullet(this);
	}

	@Override
	public BufferedImage getImg() {
		return ImageLoader.get("bullet");
	}
	@Override
	public void tick() {
		super.tick();
		ticks++;
		
		if(ticks > 100)alive = false;
	}
	public void hit() {
		alive = false;
	}
	public int getRadius() {
		return radius;
	}
	public Object getParent() {
		return parent;
	}	
}
