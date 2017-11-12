package game.blocks;

import game.Bullet;

public class Cannon extends Block{

	public Cannon(int x, int y) {
		super(x, y);
	}
	@Override
	public void action() {
		new Bullet((int) x, (int) y, 10, angle);
	}

}
