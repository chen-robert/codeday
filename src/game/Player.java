package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;

public class Player extends Ship implements KeyListener{
	public Player() {
		super(0,0);
	}
	@Override
	public BufferedImage getImg() {
		BufferedImage rect = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB);
		Graphics g = rect.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0,0,10,10);
		return rect;
	}
	@Override
	public void tick() {
		super.tick();		
		processKeys();
	}
	private HashSet<Integer> keys = new HashSet<>();
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		keys.add(code);		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys.remove(e.getKeyCode());
		
	}
	public void processKeys() {
		for(Integer code: keys) {
			int v = 0;
			switch(code) {
			case KeyEvent.VK_W:
				v = 1;
				break;
			case KeyEvent.VK_S:
				v = -1;
				break;
			case KeyEvent.VK_D:
				angle+=Math.PI/20;
				break;
			case KeyEvent.VK_A:
				angle-=Math.PI/20;
				break;
					
			}

			vx += v * Math.cos(angle);
			vy += v * Math.sin(angle);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
