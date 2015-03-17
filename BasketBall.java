import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasketBall {

	private int width = 200;
	private int height = 200;
	private int y = height/2;
	private int x = width/2;
	private int v=0;
	private int r=10;
	
	public static void main(String[] args) {
		
		final BasketBall b = new BasketBall();
		JPanel panel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.BLUE);
				g.drawOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
			}
			
		};
		
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		panel.setSize(b.width, b.height);
		
		frame.setSize(250, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		while (true) {
			b.simulate();
			panel.repaint();
			System.out.println("hallo");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void simulate() {
		
		y = y + v;
		v = v -1;
		if (y <= r) {
			v = -v;
		}
		
		
	}
	
	
}














