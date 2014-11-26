import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class GamePanel extends JPanel implements Runnable {

    private Game game;

    public GamePanel() {
        game = new Game();
        new Thread(this).start();
    }

    public void update() {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        Graphics2D g2D = (Graphics2D) g;
        for (Render r : game.getRenders())
            if (r.transform != null)
                g2D.drawImage(r.image, r.transform, null);
            else
                g.drawImage(r.image, r.x, r.y, null);
                
                
        g2D.setColor(Color.ORANGE);
        g2D.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g2D.drawString(Integer.toString(game.getScore()), 10, 40);
        
        if(!game.gameStarted()){
        	g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        	g2D.drawString("Press Space to start", 100, 250);
        	
        	g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        	g2D.drawString("Press P to pause game", 150, 300);
        	g2D.drawString("Press R to reset game", 150, 320);
        }
        
        if(game.gameOver()){
        	g2D.setColor(Color.RED);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            g2D.drawString("Game Over!", 150, 200);
            g2D.drawString("Press R to restart game", 80, 250);
        }
    }
    
    public void run() {
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
