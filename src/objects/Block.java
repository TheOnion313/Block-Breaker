package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends GameObject {
	private int hardness;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean destroyed;

	public void setHardness(int hardness) {
		if (hardness <= 3)
			this.hardness = hardness;
		else
			this.hardness = 3;
	}

	public int getHardness() {
		return this.hardness;
	}

	public void setDestroyed(boolean b) {
		this.destroyed = b;
	}

	public boolean getDestroyed() {
		return this.destroyed;
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

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public Block() {
	}

	public Block(int x, int y, int width, int height, int hardness) {
		this.hardness = hardness;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.destroyed = false;
	}

	@Override
	public void render(Graphics2D g2d) {
		if (this.destroyed == false) {
			g2d.setColor(Color.white);
			g2d.fillRect(this.x, this.y, this.width, this.height);
			g2d.setColor(Color.black);
			g2d.fillRect(this.x + 1, this.y + 1, this.width - 1, this.height - 1);
		}
	}
}
