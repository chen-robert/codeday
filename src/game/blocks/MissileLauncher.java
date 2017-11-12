package game.blocks;

import java.awt.Color;
import java.awt.image.BufferedImage;

import game.GameManager;
import game.HomingBullet;
import game.Ship;
import game.particles.Particle;
import main.ImageLoader;

public class MissileLauncher extends Block{
	private int delay = 0;
	public MissileLauncher(int x, int y, Object parent) {
		super(x, y, parent);
	}

	@Override
	public void action() {
		if(delay < 0) {
			Ship s = GameManager.gm.getClosest(this, parent);
			if(s == null)return;
			
			new HomingBullet((int) x, (int) y, 3, angle, s, parent);
			new Particle((int) x, (int) y, Color.GREEN);
			delay = (int) (20 * Math.random()) + 105;
		}
	}
	@Override
	public void tick() {
		super.tick();
		
		delay--;
	}
	@Override
	public BufferedImage getImg() {
		return ImageLoader.get("missile");
	}
}
