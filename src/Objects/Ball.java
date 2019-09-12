package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends GameObject {
    public static final int INIT_X = 300;
    public static final int INIT_Y = 300;
    public static final int INIT_VELX = 1;
    public static final int INIT_VELY = 1;
    public static final int INIT_RADIUS = 30;
	private int velx;
	private int vely;
	private int x;
	private int y;
	private int radius;
	private static Ball ball = null;

	private Ball(int x, int y, int velx, int vely, int radius) {
		this.x = x;
		this.y = y;
		this.velx = velx;
		this.vely = vely;
		this.radius = radius;
	}

	public static Ball getInstance() {
		if (ball == null)
			ball = new Ball(INIT_X, INIT_Y, INIT_VELX, INIT_VELY, INIT_RADIUS);
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
