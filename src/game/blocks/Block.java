package game.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Entity;

public class Block extends Entity{
	public Block(int x, int y) {
		super(x, y);
		angle = 0.5;
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

}
