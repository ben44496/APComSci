import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObject {

    private static final double OVERLAP_THRESHOLD = .75, HIT_THRESHOLD = .1;
    public final static String PATH_PREFIX = "res/images/";
    protected Rectangle rect;
    //private int x,y;
    protected Image image;

    //private SoundClip sound;  // MUST be a class for this!!
    protected  Image getImage(String fn) {
        Image img = null;
      //  fn = PATH_PREFIX+fn;
        try {

            //img = ImageIO.read(this.getClass().getResource(fn));
            img = ImageIO.read(new File(fn));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }


    public GameObject(int x, int y, int w, int h, String str) {
        rect = new Rectangle(x,y,w,h);
        image = getImage(str);
    }

    public GameObject(int x, int y, int w, int h, Image i) {
        rect = new Rectangle(x,y,w,h);
        image = i;
    }


    public void draw(Graphics g) {
        if(image != null) {
            g.drawImage(image, rect.x, rect.y, rect.width,rect.height, null);
        }
    }

    public static double area(Rectangle rect) {
        return rect.width*rect.height;
    }

    public boolean hit(GameObject go) {
        Rectangle over = collisionRect(go);
        if(over.isEmpty())
            return false;
        double thisArea = area(rect),
                goArea = area(go.getRect()),
                overArea = area(over);
        return overArea > Math.min(thisArea, goArea)*HIT_THRESHOLD;
    }
    public Rectangle collisionRect(GameObject go) {
        return this.rect.intersection(go.getRect());
    }

    public boolean mostlyOverlapping(GameObject go) {
        Rectangle over = collisionRect(go);
        double thisArea = area(this.rect),
                goArea = area(go.rect),
                overArea = area(over);
        return overArea > Math.min(thisArea, goArea)*OVERLAP_THRESHOLD;
    }
    public Rectangle getRect() {
        return this.rect;
    }
    public void setRect(Rectangle rectangle) {
        rect = rectangle;
    }
}

