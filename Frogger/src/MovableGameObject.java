import java.awt.*;



public abstract class MovableGameObject extends GameObject{
    private int velocity;
    public int vScaleFactor = 1000;

    public MovableGameObject(int x, int y, int w, int h, int vel, String str){
        super(x,y,w,h,str);
        velocity = vel/vScaleFactor;
    }
    public MovableGameObject(int x, int y, int w, int h, int vel, Image i){
        super(x,y,w,h,i);
        velocity = vel/vScaleFactor;
    }

    public void move(Graphics g){
        super.rect.x += velocity;
//        if(super.rect.x == 100){
//            velocity = -1*velocity;
//        }
//        else if (velocity)
        this.draw(g);
    }

    public void setVelocity(int a){velocity=a;}
    public int getVelocity(){return velocity;}
}
