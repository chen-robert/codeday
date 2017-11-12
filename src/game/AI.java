package game;

import game.blocks.MissileLauncher;

public class AI extends Ship{
	private Ship target;
	public AI(int x, int y) {
		super(x, y);
	}
	public void tick() {
		super.tick();
		if(Math.random() < 0.1)action(MissileLauncher.class);
		
		if(target == null || !target.isAlive())target = GameManager.gm.getClosest(this, this);
		if(target == null)return;
		double angleTo = Math.atan2(target.getY() - y, target.getX() - x);
		
		vx += 0.2 * getSpeed() * Math.cos(angleTo);
		vy += 0.2 * getSpeed() * Math.sin(angleTo);
	}

}
