package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.ImageLoader;

public class HomingBullet extends Bullet{
	private Entity target;
	private double speed;
	public HomingBullet(int x, int y, double speed, double angle, Entity target, Object parent) {
		super(x, y, 4, angle, parent);
		
		this.angle = angle;
		this.speed = speed;
		this.target = target;
		
		this.ticks = -1000;
	}
	@Override
	public void tick() {
		if(target.isAlive()) {
			double angleTo = Math.atan2(target.getY() - y, target.getX() - x);
			
			if(Math.abs(angle - angleTo) > Math.PI / 20) {
				angle += (angle > angleTo? -1: 1) * Math.PI/20;
			}
		}
		
		vx = speed * Math.cos(angle);
		vy = speed * Math.sin(angle);
		
		super.tick();
		if(delay)alive = false;
	}
	boolean delay = false;
	@Override
	public void hit() {
		delay = true;
		radius = 40;
	}
	@Override
	public BufferedImage getImg() {
		if(delay) {
			return ImageLoader.get("explode");
		}else return ImageLoader.get("homing");
	}

}
