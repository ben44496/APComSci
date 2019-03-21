import java.awt.*;


public class Kiwi extends Jewel{
    static final int Kiwi_X =199, Kiwi_Y =290, Kiwi_W =40, Kiwi_H=40;
    static Image jewelImage;
    public Kiwi(int x, int y){
        super(x,y,Color.green, getImage());
    }



    private static Image getImage(){
        if(jewelImage==null){
            jewelImage = openImageFromSpriteSheet(Kiwi_X, Kiwi_Y, Kiwi_W, Kiwi_H);
        }
        return jewelImage;
    }

}
