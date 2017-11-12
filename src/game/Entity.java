package game;

import java.awt.image.BufferedImage;

public abstract class Entity {
	private double x;
	private double y;
	public abstract BufferedImage getImg();
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
}
