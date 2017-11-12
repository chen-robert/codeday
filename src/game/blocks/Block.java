package game.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Bullet;
import game.Entity;
import game.particles.Particle;

public class Block extends Entity{
	protected int health = 10;
	protected Color particleColor = Color.RED;
	protected Object parent;
	public Block(int x, int y, Object parent) {
		super(x, y);
		angle = 0.5;
		
		this.parent = parent;
	}
	@Override
	public BufferedImage getImg() {
		BufferedImage ret = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		Graphics g = ret.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 10, 10);
		return ret;
	}
	public void action() {}
	public void hit(Bullet b) {
		if(!b.isAlive())return;
		b.hit();
		
		new Particle((int) x, (int) y, particleColor);
		health--;
		if(health <= 0) {
			alive = false;
			
			for(int i = 0; i < 10; i++)
				new Particle((int) x, (int) y, Color.RED);
		}
	}

}
