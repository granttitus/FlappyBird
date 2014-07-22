import java.awt.Image;

public class Pipe {

    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 3;

    public String orientation;

    private Image image;

    public Pipe(String orientation) {
        this.orientation = orientation;
        reset();
    }

    public void reset() {
        width = 66;
        height = 400;
        x = App.WIDTH + 2;

        if (orientation.equals("south")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    public void update() {
        x -= speed;
    }

    public boolean collides(int _x, int _y, int _width, int _height) {

        int margin = 2;

        if (_x + _width - margin > x && _x + margin < x + width) {

            if (orientation.equals("south") && _y < y + height) {
                return true;
            } else if (orientation.equals("north") && _y + _height > y) {
                return true;
            }
        }

        return false;
    }

    public Render getRender() {
        Render r = new Render();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Util.loadImage("lib/pipe-" + orientation + ".png");
        }
        r.image = image;

        return r;
    }
}
