import java.awt.image.BufferedImage;


public class Tree extends GameObject {

    public Tree (int x, int y, int w, int h){
        super(x,  y,  w,  h, "image/realTree.png");
    }
    public Tree (int x, int y){
        super(x,  y,  50,  50, "image/realTree.png");
    }

}
