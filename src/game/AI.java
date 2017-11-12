package game;

import game.blocks.MissileLauncher;

public class AI extends Ship{

	public AI(int x, int y) {
		super(x, y);
	}
	public void tick() {
		super.tick();
		if(Math.random() < 0.1)action(MissileLauncher.class);
		
		Entity target = GameManager.gm.getClosest(this, this);
		double angleTo = Math.atan2(target.getY() - y, target.getX() - x);
		
		vx += 0.2 * getSpeed() * Math.cos(angleTo);
		vy += 0.2 * getSpeed() * Math.sin(angleTo);
	}

}
