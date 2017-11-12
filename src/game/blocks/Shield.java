package game.blocks;

import java.awt.Color;
import java.awt.image.BufferedImage;

import game.particles.Particle;
import main.ImageLoader;

public class Shield extends Block{
	public Shield(int x, int y, Object parent) {
		super(x, y, parent);
		
		this.health = 30;
		particleColor = Color.BLUE;
	}
	@Override
	public void action() {
	}
	@Override
	public BufferedImage getImg() {
		return ImageLoader.get("thruster");
	}
}
