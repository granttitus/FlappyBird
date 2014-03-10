import java.awt.Image;
import java.awt.event.KeyEvent;

public class Bird {

    public int x;
    public int y;
    public int width;
    public int height;

    // y velocity
    public double yvel;
    public double gravity;

    // delay between key presses
    private int jumpDelay;

    private Image image;
    private Keyboard keyboard;

    public Bird () {
        x = 100;
        y = 200;
        yvel = 0;
        width = 40;
        height = 40;
        gravity = 0.5;
        jumpDelay = 0;

        keyboard = Keyboard.getInstance();
    }

    public void update () {
        yvel += gravity;

        if (jumpDelay > 0)
            jumpDelay--;

        if (keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
            yvel = -10;
            jumpDelay = 10;
        }

        y += (int)yvel;
    }

    public Image getImage () {

        if (image == null) {
            image = Util.loadImage("lib/bird.png");     
        }
        
        return image;
    }
}
