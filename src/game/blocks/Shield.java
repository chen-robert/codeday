package game.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.ImageLoader;

public class Shield extends Block{
	public Shield(int x, int y, Object parent) {
		super(x, y, parent);
		
		this.health = 30;
		particleColor = Color.BLUE;
	}
	private int counter = 0;
	@Override
	public void action() {
		counter = 10;
	}
	@Override
	public void tick() {
		super.tick();
		
		counter--;
	}
	@Override
	public BufferedImage getImg() {
		if(counter > 0) {
			BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.drawImage(ImageLoader.get("thruster"), 45, 45, null);
			g.setColor(new Color(0,0,255,10));
			g.fillOval(0, 0, 100, 100);
			return img;
		}
		return ImageLoader.get("thruster");
	}
	public boolean isActive() {
		return counter > 0;
	}
}
