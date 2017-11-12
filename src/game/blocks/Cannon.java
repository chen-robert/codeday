package game.blocks;

import game.Bullet;

public class Cannon extends Block{
	private int delay = 0;
	public Cannon(int x, int y, Object parent) {
		super(x, y, parent);
	}
	@Override
	public void action() {
		if(delay < 0) {
			new Bullet((int) x, (int) y, 10, angle, parent);
			delay = (int) (10 * Math.random());
		}
	}
	@Override
	public void tick() {
		super.tick();
		
		delay--;
	}
}
