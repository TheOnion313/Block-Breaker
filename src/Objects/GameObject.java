package Objects;

import java.awt.Graphics2D;

public abstract class GameObject {
	public int x, y;
	public GameObject() {
		
	}
	
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void render(Graphics2D g2d);
}
