import java.awt.*;


public class Watermelon extends Jewel{
    static final int Watermelon_X =300, Watermelon_Y =240, Watermelon_W =40, Watermelon_H=40;
    static Image jewelImage;
    private String filePath = "src/spritesheet.jpg";
    public Watermelon(int x, int y){
        super(x,y,Color.pink, getImage());
    }


    private static Image getImage(){
        if(jewelImage==null){
            jewelImage = openImageFromSpriteSheet(Watermelon_X, Watermelon_Y, Watermelon_W, Watermelon_H);
        }
        return jewelImage;
    }

}
