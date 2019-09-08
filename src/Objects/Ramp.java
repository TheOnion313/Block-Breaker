package Objects;

import java.awt.Graphics2D;

public class Ramp extends GameObject {
	private int x;
	private int y = 500;
	private int vel;
	private int WIDTH;
	private int HEIGHT;
	private static Ramp ramp = null;
	
	private Ramp(int x, int vel) {
		this.x = x;
		this.vel = vel;
	}
	
	public static Ramp makeRamp(int x, int vel) {
		if(ramp == null)
			ramp = new Ramp(x, vel);
		
		return ramp;
	}
	
	public void move() {
		this.x += this.vel; 
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setVel(int vel) {
		this.vel = vel;
	}
	
	public int getVel() {
		return this.vel;
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.fillRect(x, y, WIDTH, HEIGHT);
	}
}
