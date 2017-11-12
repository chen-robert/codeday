package game.particles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Entity;

public class Particle extends Entity{
	private Color c;
	private int ticks = 10;
	public Particle(int x, int y, Color c) {
		super(x, y);
		
		vx = 4 * Math.random() - 2;
		vy = 4 * Math.random() - 2;
		
		this.c = c;
	}
	@Override
	public void tick() {
		super.tick();
		
		ticks--;
		if(ticks < 0)alive = false;
	}

	@Override
	public BufferedImage getImg() {
		BufferedImage img = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.setColor(c);
		g.fillRect(0, 0, 2, 2);
		return img;
	}

}
