package game.blocks;

import java.awt.Color;
import java.awt.image.BufferedImage;

import game.Bullet;
import game.particles.Particle;
import main.ImageLoader;

public class Cannon extends Block{
	private int delay = 0;
	public Cannon(int x, int y, Object parent) {
		super(x, y, parent);
	}
	@Override
	public void action() {
		if(delay < 0) {
			new Bullet((int) x, (int) y, 10, angle, parent);
			new Particle((int) x, (int) y, Color.BLUE);
			delay = (int) (10 * Math.random()) + 2;
		}
	}
	@Override
	public void tick() {
		super.tick();
		
		delay--;
	}
	@Override
	public BufferedImage getImg() {
		return ImageLoader.get("cannon");
	}
}
