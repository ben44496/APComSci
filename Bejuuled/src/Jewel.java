

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Graphics.*;
import java.nio.Buffer;
//import java.imageio.*;


public abstract class Jewel {
    private Color color;
    private int row, col;
    private Image image;
    public static BufferedImage spriteSheet;
    public static final int SQUARE_SIZE = 50;
    private boolean chosenOne = false;

    public Jewel(int xx, int yy, Color colour, Image myImage) {
        col = xx;
        row = yy;

        image = myImage;
        color = colour;
    }

    public static Jewel randomJewel(int x, int y) {
        switch ((int) (Math.random() * 6)) {
            case 0:
                return new Mango(x, y);
            case 1:
                return new Watermelon(x, y);
            case 2:
                return new Kiwi(x,y);
            case 3:
                return new Shrooms(x, y);
            case 4:
                return new Orange(x,y);
            case 5:
                return new HelenXiao(x,y);

        }
        return null;
    }



    public int getX(){
        return col;
    }
    public int getY(){
        return row;
    }
    public void setX(int x){
         col = x;
    }
    public void setY(int y){
        row = y;
    }
    public int getPosition(){
        return col*100+row;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color colour) { color = colour;}

    private static void main(String[] args){

    }

    protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
        openSpriteSheet();
        return  (spriteSheet).getSubimage(x,y,w,h).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);
    }
    private static void openSpriteSheet() {
        if(spriteSheet==null) {
            try {
                spriteSheet = ImageIO.read(new File("src/spritesheet.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, this.col*this.SQUARE_SIZE, this.row*this.SQUARE_SIZE, Color.black, null);
        if(chosenOne){
            //make yellowSelect rainbow
            Color yellowSelect = new Color(255,255,0,100);
            g.setColor(yellowSelect);
            g.fillRect(this.col*this.SQUARE_SIZE, this.row*this.SQUARE_SIZE, this.SQUARE_SIZE, this.SQUARE_SIZE);
        }
    }


    public void move(int dr, int dc) {
        this.col+= dc;
        this.row += dr;
    }
    public void moveUp() {
        this.move(-1, 0);
    }
    public void moveDown() {
        this.move(1, 0);
    }
    public void selected(){
        chosenOne = true;
        System.out.println("("+this.getX()+","+this.getY()+")");
    }
    public void unselected(){
        chosenOne =false;
    }

}
