package game;

import java.awt.Point;
import java.util.List;

import game.blocks.Block;

public class DeadShip extends Ship{

	public DeadShip(int x, int y, double angle, List<Block> blocks) {
		super(x, y, blocks);
		
		this.angle = angle;
		
		Point offset = new Point(blocks.get(0).getX(), blocks.get(0).getY());
		x += offset.x;
		y += offset.y;
		for(Block b: blocks) {
			b.x -= offset.x;
			b.y -= offset.y;
		}
		
		buildInfo();
		removeUnconnected();
		System.out.println(blocks.size());
		
	}
}
