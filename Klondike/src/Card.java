import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card implements Comparable<Card> {

    public final static String PATH_PREFIX = "src/";
    private int value;
    public static enum Suits {SPADES, DIAMONDS, HEARTS, CLUBS};
    private Suits suit;
    private boolean isRed, faceUp = false, clicked = false;

    public Card(int v, Suits s) {
        this.value = v;
        suit = s;
        if(s.ordinal()== Suits.HEARTS.ordinal() || s.ordinal() == Suits.HEARTS.ordinal())
            isRed = true;
        else {
            isRed = false;
        }
    }

    @Override
    public int compareTo(Card c) {
        return this.value - c.value;
    }

    private String imgName() {
        String img = "";
        if(this.suit.ordinal() == 0)
            img += "s";
        else if(this.suit.ordinal() == 1)
            img += "d";
        else if(this.suit.ordinal() == 2)
            img += "h";
        else if(this.suit.ordinal() == 3)
            img += "c";
        if(this.value < 11)
            img += this.value+"";
        if(this.value == 11)
            img += "j";
        if(this.value == 12)
            img += "q";
        if(this.value == 13)
            img += "k";
        if(this.value == 14)
            img += "1";
        return img;
    }

    protected  Image getImage() {
        Image img = null;
        String prefix = "images/";
        String suffix = ".png";
        try {
            if(this.faceUp)
                img = ImageIO.read(this.getClass().getResource(prefix+this.imgName()+suffix));
            else if(!faceUp){
                img = ImageIO.read(this.getClass().getResource(prefix+"b1fv"+suffix));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public void draw(Graphics g, int x, int y) {
        Image img = this.getImage();
        g.drawImage(img, x, y, 50, 70, null);

    }
//    public void draw(Graphics g){
//        Image img = this.getImage();
//
//    }

    public void flip() {
        this.faceUp = !this.faceUp;
    }

    public void isClicked(MouseEvent me){
        if(!clicked) clicked = true;
        else clicked = false;
    }

    public boolean isFaceUp(){
        return faceUp;
    }

}