import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HelenXiao extends Jewel{
    static final int MANGO_X =345, MANGO_Y =491, MANGO_W =80, MANGO_H=80;
    private static Image mangoImage;

    public HelenXiao(int x, int y){
        super(x,y,Color.pink, getImage());
    }



    private static Image getImage(){
        if(mangoImage==null){
            mangoImage = openImageFromSpriteSheet(MANGO_X, MANGO_Y, MANGO_W, MANGO_H);
        }
        return mangoImage;
    }


}

