package game;

import java.awt.image.BufferedImage;

public abstract class Entity {
	protected double x;
	protected double y;
	
	protected double vx;
	protected double vy;
	
	protected double angle;
	
	protected boolean alive = true;
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
	private static int maxSpeed = 4;
	public void tick() {
		
		if(vx < -4)vx = -4;
		if(vx > 4)vx = 4;

		if(vy < -4)vy = -4;
		if(vy > 4)vy = 4;
		
		x += vx;
		y += vy;
	}
	public boolean isAlive() {
		return alive;
	}
}
