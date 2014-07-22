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
