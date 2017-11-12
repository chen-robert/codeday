package game;

import java.awt.image.BufferedImage;

public abstract class Entity {
	protected double x;
	protected double y;
	
	protected double vx;
	protected double vy;
	
	protected double angle;
	
	public abstract BufferedImage getImg();
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		
		GameManager.gm.addEntity(this);
	}
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	public double getAngle() {
		return angle;
	}
	public void tick() {
		x += vx;
		y += vy;
	}
}
