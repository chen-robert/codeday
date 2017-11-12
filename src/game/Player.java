package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity{

	@Override
	public BufferedImage getImg() {
		BufferedImage rect = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB);
		Graphics g = rect.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 10, 10);
		return rect;
	}

}
