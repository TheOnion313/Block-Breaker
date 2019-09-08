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
	JTextField GameOver = new JTextField("Game Over");
	JTextField Level = new JTextField("Level: ");
	ArrayList<ArrayList<Objects.Block>> blockMess = new ArrayList<ArrayList<Objects.Block>>();
	{
		for (int i = 0; i < 10; i++) {
			ArrayList<Block> a = new ArrayList<Block>();
			blockMess.add(a);
			for (int j = 0; j < 5; j++) {
				Block b = new Block();
				blockMess.get(i).add(b);
			}
		}
	}
	Ball ball = Ball.createBall(1, 1, 285, 350);
	Ramp ramp = Ramp.makeRamp(300, 0);

	public Graphic() {
		t.start();
		Font f = new Font("Arial", 300, 100);
		Font f2 = new Font("Arial", 150, 50);
		Dimension go = GameOver.getPreferredSize();
		Dimension s = Level.getPreferredSize();
		GameOver.setBounds(25, 200, (int) go.getWidth() * 8, (int) go.getHeight() * 5);
		GameOver.setFont(f);
		GameOver.setEditable(false);
		Level.setBounds(75, 350, (int) s.getWidth() * 12, (int) (s.getHeight() * 5));
		Level.setFont(f);
		Level.setEditable(false);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		collision();
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 10; i++) {
				if (!blockMess.get(i).get(j).getDestroyed()) {
					g2.setColor(Color.WHITE);
					g2.fill(new Rectangle2D.Double(65 + i * 45, 50 + j * 45, 45, 45));
					g2.setColor(Color.BLACK);
					g2.fill(new Rectangle2D.Double(67 + i * 45, 52 + j * 45, 41, 41));
				}
			}
		}
		g2.setColor(Color.BLUE);
		g2.fill(new Ellipse2D.Double(ball.getX(), ball.getY(), 30, 30));
		g2.setColor(Color.BLACK);
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
			ball.setX(ball.getX() + ball.getVelX());
			ball.setY(ball.getY() + ball.getVelY());
		}

	}

	public void collision() {
		if (ball.getX() + 30 == 585 || ball.getX() == 0)
			ball.setVelX(-ball.getVelX());
		if (ball.getY() + 30 == 562 || ball.getY() == 0)
			ball.setVelY(-ball.getVelY());
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if (blockMess.get(j).get(i).getDestroyed() == false
						&& (ball.getX() == 100 + j * 45 || ball.getX() + 30 == 65 + j * 45) && ball.getY() > 50 && ball.getY() < 275) {
					ball.setVelX(-ball.getVelX());
					blockMess.get(i).get(j).setHardness(blockMess.get(i).get(j).getHardness() - 1);
				}

				if (blockMess.get(j).get(i).getDestroyed() == false
						&& (ball.getY() == 50 + i * 45 || ball.getY() + 30 == 65 + i * 45) && ball.getX() > 65 && ball.getX() < 515) {
					ball.setVelX(-ball.getVelX());
					blockMess.get(i).get(j).setHardness(blockMess.get(i).get(j).getHardness() - 1);
				}
			}
		}
	}

}
