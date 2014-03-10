import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    
    public Keyboard keyboard;
    public Bird bird;
    public Background background;

    public Boolean paused;
    public Boolean gameover;
    public Boolean started;

    public int pauseDelay;
    public int restartDelay;

    public Game () {
        keyboard = Keyboard.getInstance();
        background = new Background();

        restart();
    }

    public void update () {

        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }

        if (!started)
            return;

        if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) {
            paused = !paused;
            pauseDelay = 10;
        }

        if (restartDelay > 0)
            restartDelay--;

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) {
            restart();
            restartDelay = 10;
        }

        if (!paused && !gameover) {

        	bird.update();

            if (bird.y + bird.height > App.HEIGHT - 80) {
                gameover = true;

                // keep the bird above ground
                bird.y = App.HEIGHT - 80 - bird.height;
            }
        }
    }

    public void restart () {
        bird = new Bird();

        paused = false;
        gameover = false;
        started = false;

        pauseDelay = 0;
        restartDelay = 0;
    }
    
    public ArrayList<Render> getRenders() {
        ArrayList<Render> renders = new ArrayList<Render>();
        renders.add(background.getRender());
        renders.add(bird.getRender());
        return renders;
    }
}
