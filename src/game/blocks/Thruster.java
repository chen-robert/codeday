package game.blocks;

import java.awt.Color;
import java.awt.image.BufferedImage;

import game.particles.Particle;
import main.ImageLoader;

public class Thruster extends Block{
	public Thruster(int x, int y, Object parent) {
		super(x, y, parent);
	}
	@Override
	public void action() {
		new Particle((int) x, (int) y, Color.BLUE);
	}
	@Override
	public BufferedImage getImg() {
		return ImageLoader.get("thruster");
	}
}
