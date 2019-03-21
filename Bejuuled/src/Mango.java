import java.awt.Image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


public class Mango extends Jewel{
    static final int MANGO_X =198, MANGO_Y =437, MANGO_W =40, MANGO_H=40;
    static Image mangoImage;
    public String filePath = "src/spritesheet.jpg";
    public Mango (int x, int y){
        super(x,y,Color.yellow, getImage());
    }



    private static Image getImage(){
        if(mangoImage==null){
            mangoImage = openImageFromSpriteSheet(MANGO_X, MANGO_Y, MANGO_W, MANGO_H);
        }
        return mangoImage;
    }

}
