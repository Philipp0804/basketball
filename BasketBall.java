package basketball;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasketBall {

  private int width = 200;
  private int height = 200;
  private int y = 85;
  private int x = 10;
  private int v=0;
  private int r=10;
  private int s=4;
  
  public static void main(String[] args) {
    
    final BasketBall b = new BasketBall();
    JPanel panel = new JPanel() {
      
      @Override
      public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
        g.drawRect(0, 0, 200, 200);
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.ORANGE);
        g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
    	g.setColor(Color.BLACK);
        g.drawLine(b.x-10, b.y, b.x+10, b.y);
        g.drawLine(b.x, b.y-10, b.x, b.y+10);
        g.drawOval(b.x-8, b.y+4, 16, 11);
        g.drawOval(b.x-8, b.y-15, 16, 11);
        g.setColor(Color.WHITE);
        g.drawLine(176, 125, 176, 155);
        g.drawLine(200, 125, 200, 155);
        g.drawLine(176, 155, 200, 155);
        g.drawLine(176, 145, 200, 145);
        g.drawLine(176, 135, 200, 135);
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

    if (y >= height-r) {
      v = -v;
    }
    else {
    	v = v +1;
     }
    if (x >= width-r || x <= r || (y >= 125 && y <= 155 && x == 166 && s>0)) {
    	s = -s;
    }
    if (!(x == 188 && y <= 125 && y >= 115)) {
        x = x + s;
        }
}
}














