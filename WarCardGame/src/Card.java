import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card implements Comparable<Card>{
    private int number;
    enum Suit{DIAMOND, CLUB, HEART, SPADE}

    private Suit suit;
    private BufferedImage image;
    private BufferedImage currentImage;
    private boolean isRed = false;

    private String suffix = ".png";

    public Card(int numbers, Suit suits){
        number = numbers;
        suit = suits;
        image = getImage("src/cards_png/"+findSuit(suits)+findNumber(numbers)+suffix);
        currentImage = getImage("src/cards_png/"+"b1fh"+suffix);
    }
    public Card(String filePath){

        image = getImage("src/cards_png/"+filePath);

    }


    public void draw(Graphics g, int x, int y){

        g.drawImage(currentImage, x, y, null);
    }

    public BufferedImage getImage(String pathName){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(pathName));
        }catch (IOException e){
            System.out.println(e);
        }
        return img;
    }
    @Override
    public int compareTo(Card o) {
        return 0;
    }

    public Image getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }
    public String findSuit(Suit inputSuit){
        switch(inputSuit){
            case DIAMOND : return "d";
            case CLUB : return "c";
            case HEART : return "h";
            case SPADE: return "s";
        }
        return "";
    }
    public String findNumber(int num){
        switch (num){
            case 1 : return "1";
            case 2 : return "2";
            case 3 : return "3";
            case 4 : return "4";
            case 5 : return "5";
            case 6 : return "6";
            case 7 : return "7";
            case 8 : return "8";
            case 9 : return "9";
            case 10 : return "10";
            case 11 : return "j";
            case 12 : return "q";
            case 13 : return "k";
        }
        return "";
    }
}
