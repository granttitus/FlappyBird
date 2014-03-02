import java.awt.event.KeyEvent;

public class Game {
    
    public Keyboard keyboard;
    public Bird bird;
    public Boolean paused = false;
    public int pauseDelay;

    public Game () {
        keyboard = Keyboard.getInstance();
        bird = new Bird();
    }

    public void update(){
    	if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) {
            paused = !paused;
            pauseDelay = 10;
        }

        if (!paused)
        	bird.update();
    }
}
