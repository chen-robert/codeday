package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Entity{
	
	public Bullet(int x, int y, double speed, double angle) {
		super(x, y);
		
		vx = speed * Math.cos(angle);
		vy = speed * Math.sin(angle);
	}

	@Override
	public BufferedImage getImg() {
		BufferedImage img = new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 3, 3);
		return img;
	}
	
}
