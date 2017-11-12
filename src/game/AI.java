package game;

import game.blocks.Cannon;
import game.blocks.MissileLauncher;

public class AI extends Ship{
	private Ship target;
	public AI(int x, int y) {
		super(x, y);
	}
	public void tick() {
		super.tick();
		action(MissileLauncher.class);
		action(Cannon.class);
		
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
