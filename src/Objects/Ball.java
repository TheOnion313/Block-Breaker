package Objects;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends GameObject {
	private int velx;
	private int vely;
	private int x;
	private int y;
	private int RADIUS;
	private static Ball ball = null;
	
	private Ball(int vx, int vy, int x, int y) {
			x = x;
			y = y;
			velx = vx;
			vely = vy;
	}
	
	public static Ball createBall(int vx, int vy, int x, int y) {
		if(ball == null) 
			ball = new Ball(vx, vy, x, y);
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

	@Override
	public void render(Graphics2D g2d) {
		g2d.fill(new Ellipse2D.Double(x, y, RADIUS, RADIUS));
	}
}
