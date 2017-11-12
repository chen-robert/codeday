package main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import game.Entity;
import game.GameManager;

public class Board extends JPanel{
	private GameManager gm = new GameManager();
	@Override
	public void paintComponent(Graphics g) {
		Point view = gm.getView();
	
		List<Entity> entities = gm.getEntities();
		for(Entity e: entities) {
			BufferedImage img = e.getImg();
			g.drawImage(img, 250 + e.getX() - img.getWidth() / 2 - view.x, 
					250 + e.getY() - img.getHeight() / 2 - view.y, null);
		}
		
		try {
			Thread.sleep(100);
		}catch(Exception e) {}
		repaint();
	}
}
