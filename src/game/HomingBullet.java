package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
		double angleTo = Math.atan2(target.getY() - y, target.getX() - x);
		
		
		if(Math.abs(angle - angleTo) > Math.PI / 20) {
			angle += (angle > angleTo? -1: 1) * Math.PI/50;
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
			BufferedImage img = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.setColor(Color.RED);
			g.fillRect(0, 0, 25, 25);
			return img;
		}else return super.getImg();
	}

}
