import java.awt.*;


public class Orange extends Jewel{
    static final int Kiwi_X =198, Kiwi_Y =345, Kiwi_W =40, Kiwi_H=40;
    static Image jewelImage;
    public String filePath = "src/spritesheet.jpg";
    public Orange(int x, int y){
        super(x,y,Color.orange, getImage());
    }



    private static Image getImage(){
        if(jewelImage==null){
            jewelImage = openImageFromSpriteSheet(Kiwi_X, Kiwi_Y, Kiwi_W, Kiwi_H);
        }
        return jewelImage;
    }

}
