import java.awt.*;


public class Player extends GameObject{
    private Image front = getImage("image/ashKetchumFront.png");
    private Image back = getImage("image/ashKetchumBack.png");
    private Image right = getImage("image/ashKetchumRight.png");
    private Image left = getImage("image/ashKetchumLeft.png");
    //private Image currentImage = front;
    /*public Player (int x, int y, Image i){
        super(x,y,50,50,i);
    }*/
    private int step = 5;

    public Player (int x, int y){
        super(x,y,25,25,/*"image/ashKetchumFront.png"*/"image/ashKetchumBack.png");
    }

    public void setImage(String str){image = getImage(str);}

    public void setCurrentImage(int a){
        switch(a){
            case 0 : image=front;
            case 1 : image=right;
            case 2 : image=back;
            case 3 : image=left;
        }
    }
    public void setCurrentImage(String str){
        if(str.equals("up")){
            image = front;
        }else if(str.equals("left")){
            image = left;
        }else if (str.equals("right")){
            image = right;
        }else if (str.equals("down")){
            image = back;
        }
    }

    public int getStep(){return step;}
}
