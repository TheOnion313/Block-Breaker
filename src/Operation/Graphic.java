package Operation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import Objects.Block;
import Objects.GameObject;
import Objects.Ramp;
import Objects.Ball;

public class Graphic extends JPanel implements ActionListener, KeyListener {
	Timer t = new Timer(10, this);
	int lives = 3;
	JTextField gameOver = new JTextField("Game Over");
	JTextField level = new JTextField("level: ");
	List<Block> blocks = new ArrayList<Block>();
	Ball ball = Ball.getInstance(1, 1, 285, 350, 30);
	Ramp ramp = Ramp.getInstance(300, 0);
	{
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				Block block = new Block(65 + j * 45, 50 + i * 45, 45, 45, 1);
				blocks.add(block);
			}
		}
	}

	public Graphic() {
		t.start();
		Font f = new Font("Arial", 300, 100);
		Font f2 = new Font("Arial", 150, 50);
		Dimension gameOverDim = gameOver.getPreferredSize();
		Dimension levelDim = level.getPreferredSize();
		gameOver.setBounds(25, 200, (int) gameOverDim.getWidth() * 8, (int) gameOverDim.getHeight() * 5);
		gameOver.setFont(f);
		gameOver.setEditable(false);
		level.setBounds(75, 350, (int) levelDim.getWidth() * 12, (int) (levelDim.getHeight() * 5));
		level.setFont(f);
		level.setEditable(false);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Block b : blocks)
			collision(b);
		wallCollision();

		for (Block i : blocks) {
			i.render(g2);
		}
		ball.render(g2);
		ramp.render(g2);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Main.gameOver == false) {
			repaint();
			if (ball.getClass() == Ball.class)
				ball.setX(ball.getX() + ball.getVelX());
			ball.setY(ball.getY() + ball.getVelY());
		}

	}

	public void collision(Block b) {
//		if (ball.getX() + 30 == 585 || ball.getX() == 0)
//			ball.setVelX(-ball.getVelX());
//		if (ball.getY() + 30 == 562 || ball.getY() == 0)
//			ball.setVelY(-ball.getVelY());
//			for (int j = 0; j < 50; j++) {
//				if (blocks.get(j).getDestroyed() == false
//						&& (ball.getX() == 100 + j * 45 || ball.getX() + 30 == 65 + j * 45) && ball.getY() > 50
//						&& ball.getY() < 275) {
//					ball.setVelX(-ball.getVelX());
//					blocks.get(j).setHardness(blocks.get(j).getHardness() - 1);
//				}
//
//				if (blocks.get(j).getDestroyed() == false
//						&& (ball.getY() == 50 + blocks.get(j).getY() || ball.getY() + 30 == blocks.get(j).getY()) && ball.getX() > 65
//						&& ball.getX() < 515) {
//					ball.setVelX(-ball.getVelX());
//					blocks.get(j).setHardness(blocks.get(j).getHardness() - 1);
//				}
//			}
		if (b.getDestroyed() == false) {
			if ((b.getX() == ball.getX() + ball.getRad() || b.getX() + b.getWidth() == ball.getX()
					^ ((b.getY() == ball.getY() + 2 * ball.getRad() || b.getY() + b.getHeight() == ball.getY())))) {
				if (b.getX() == ball.getX() + ball.getRad() || b.getX() + b.getWidth() == ball.getX()) {
					ball.setVelX(-ball.getVelX());
				} else {
					ball.setVelY(-ball.getVelY());
				}

			} else if ((b.getX() == ball.getX() + ball.getRad() || b.getX() + b.getWidth() == ball.getX()
					&& ((b.getY() == ball.getY() + 2 * ball.getRad() || b.getY() + b.getHeight() == ball.getY())))) {
				if (ball.getX() > blocks.get(0).getX()
						&& ball.getX() < blocks.get(blocks.size()).getX() + blocks.get(blocks.size()).getWidth())
					ball.setVelY(-ball.getVelY());
			} else {
				ball.setVelX(-ball.getVelX());
			}
		}
	}
	
	public void wallCollision() {
		if (ball.getX() + 2 * ball.getRad() == Main.SCREEN_WIDTH || ball.getX() == 0)
			ball.setVelX(-ball.getVelX());
		if (ball.getY() + 2 * ball.getRad() == Main.SCREEN_HEIGHT || ball.getY() == 0)
			ball.setVelY(-ball.getVelY());

	}
}