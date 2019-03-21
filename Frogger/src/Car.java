import java.awt.*;

public class Car extends MovableGameObject{
    Image helenCar = getImage("image/helenAndLimo.png");

    public Car (int x, int y, int w, int h, int vel, Image i){
        super(x,y,w,h,vel, i);
    }
    public Car (int x, int y, int w, int h, int vel, String str){
        super(x,y,w,h,vel, str);
    }


}
