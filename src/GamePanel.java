import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable {

    private Background bg;
    private Game game;

    public GamePanel () {
        game = new Game();

        new Thread(this).start();
    }

    public void update () {
        game.update();
        repaint();
    }

    protected void paintComponent (Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        for (Render r : game.getRenders())
            g.drawImage(r.image, r.x, r.y, null);
    }
    
    public void run () {
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
