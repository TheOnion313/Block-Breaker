package Operation;

import javax.swing.JFrame;

public class Main {
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;
	
	public static boolean gameOver = false;

	public static void main(String[] args) {
		Graphic g = new Graphic();
		JFrame j = new JFrame();
		
		j.add(g);
		j.setVisible(true);
		j.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setTitle("Block Breaker");
		while(gameOver == false);

	}

}
