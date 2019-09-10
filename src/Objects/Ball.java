package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends GameObject {
	private int velx;
	private int vely;
	private int x;
	private int y;
	private int radius;
	private static Ball ball = null;

	private Ball(int vx, int vy, int x, int y, int rad) {
		x = x;
		y = y;
		velx = vx;
		vely = vy;
		radius = rad;
	}

	public static Ball getInstance(int vx, int vy, int x, int y, int radius) {
		if (ball == null)
			ball = new Ball(vx, vy, x, y, radius);
		return ball;

	}

	public void setVelX(int velx) {
		this.velx = velx;
	}

	public int getVelX() {
		return this.velx;
	}

	public void setVelY(int vely) {
		this.vely = vely;
	}

	public int getVelY() {
		return this.vely;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void setRad(int rad) {
		this.radius = rad;
	}

	public int getRad() {
		return this.radius;
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fill(new Ellipse2D.Double(x, y, radius, radius));
	}
}
