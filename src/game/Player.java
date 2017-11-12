package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;

import game.blocks.Cannon;
import game.blocks.MissileLauncher;
import game.blocks.Shield;

public class Player extends Ship implements KeyListener{
	private HashSet<Integer> keys = new HashSet<>();
	public Player() {
		super(0,0);
	}
	@Override
	public BufferedImage getImg() {
		return null;
	}
	@Override
	public void tick() {
		super.tick();		
		processKeys();
	}
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
		if(keys == null)return;
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
				angle+=Math.PI/40;
				break;
			case KeyEvent.VK_A:
				angle-=Math.PI/40;
				break;
			case KeyEvent.VK_Z:
				action(Cannon.class);
				break;
			case KeyEvent.VK_X:
				action(MissileLauncher.class);
				break;
			case KeyEvent.VK_SHIFT:
				action(Shield.class);
				vx *= 0.9;
				vy *= 0.9;
				break;
			}

			if(v != 0) {
				double speed = getSpeed();
				vx += speed * v * Math.cos(angle);
				vy += speed * v * Math.sin(angle);
				
				action(Shield.class);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
