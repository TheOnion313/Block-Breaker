package Objects;

import java.awt.Graphics2D;

public class Block extends GameObject {
	private int hardness;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private boolean destroyed;
	public void setHardness(int hardness) {
		if(hardness <= 3)
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
	
	public static Block Block(int hardness) {
		Block b = new Block();
		b.setHardness(hardness);
		return b;
	}
	
	public Block() {}
	
	public Block(int hardness) {
		this.setHardness(hardness);
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.fillRect(this.x, this.y, this.WIDTH, this.HEIGHT);
	}
}
