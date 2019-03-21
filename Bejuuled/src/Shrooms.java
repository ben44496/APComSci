import java.awt.*;


public class Shrooms extends Jewel{
    static final int Kiwi_X =400, Kiwi_Y =340, Kiwi_W =40, Kiwi_H=40;
    static Image jewelImage;
    private String filePath = "src/spritesheet.jpg";
    public Shrooms(int x, int y){
        super(x,y,Color.magenta, getImage());
    }



    private static Image getImage(){
        if(jewelImage==null){
            jewelImage = openImageFromSpriteSheet(Kiwi_X, Kiwi_Y, Kiwi_W, Kiwi_H);
        }
        return jewelImage;
    }

}
