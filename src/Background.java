import java.awt.Image;

public class Background {

    public int x = 0;
    public int y = 0;
    private Image image;

    public Render getRender() {

        Render r = new Render();
        r.x = x;
        r.y = y;
        
        if (image == null) {
            image = Util.loadImage("lib/background.png");     
        }
        r.image = image;

        return r;
    }
}
