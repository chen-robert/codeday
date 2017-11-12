package game;

import game.blocks.Cannon;
import game.blocks.MissileLauncher;
import game.blocks.Shield;

public class AI extends Ship{
	private Ship target;
	public AI(int x, int y) {
		super(x, y);
	}
	private int cycle = 0;
	public void tick() {
		super.tick();
		cycle--;
		
		if(cycle > 15) {
			action(Shield.class);
		}else if(cycle < 0){
			action(MissileLauncher.class);
			action(Cannon.class);
			
			if(Math.random() < 0.1)cycle = 20;
		}
		
		if(target == null || !target.isAlive())target = GameManager.gm.getClosest(this, this);
		if(target == null)return;
		double angleTo = Math.atan2(target.getY() + 25 - y, target.getX() + 25 - x);
		
		if(Math.abs(angle - angleTo) < Math.PI / 50);
		else if(angle < angleTo)angle += Math.PI / 50;
		else angle -= Math.PI / 50;
		
		vx += 0.2 * getSpeed() * Math.cos(angle);
		vy += 0.2 * getSpeed() * Math.sin(angle);
	}

}
