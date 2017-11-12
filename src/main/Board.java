package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Entity;
import game.GameManager;

public class Board extends JPanel{
	private GameManager gm = new GameManager();
	public Board(JFrame f) {
		f.addKeyListener(gm.getPlayer());
	}
	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		g.clearRect(0, 0, 500, 500);
		Point view = gm.getView();
	
		gm.tick();
		
		List<Entity> entities = gm.getEntities();
		for(Entity e: entities) {
			double angle = e.getAngle();
			BufferedImage img = e.getImg();
			if(img == null)continue;
			
			AffineTransform ori = g.getTransform();
			g.translate(250 + e.getX() - view.x,
					250 + e.getY() - view.y);
			g.rotate(angle);
			
			
			g.drawImage(img, - img.getWidth() / 2, 
					- img.getHeight() / 2, null);
			g.setTransform(ori);
		}
		
		try {
			Thread.sleep(100);
		}catch(Exception e) {}
		repaint();
	}
}
