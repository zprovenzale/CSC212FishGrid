package edu.smith.cs.csc212.fishgrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * This class is provided so that you don't have to make any drawing code yourself!
 * @author jfoley
 *
 */
public class FishFood extends WorldObject {

	public FishFood(World world) {
		super(world);
	}

	@Override
	public void draw(Graphics2D g) {
		// Feel free to draw something else if you want.
		g.setColor(Color.yellow);
		g.fill(new Ellipse2D.Double(-0.4, -0.4, 0.8, 0.8));
	}

	@Override
	public void step() {

	}

}
