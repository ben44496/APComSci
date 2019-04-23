import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class KlondikeRunner {
    private int startingCorner = 50, distance = 75;
    private int yStart = 50, ydistance = 100;

    public static void main(String[] args) {
        new KlondikeRunner().start();
    }

    ArrayList<Card> cards = new ArrayList<Card>();
//    Pile benPile = new Pile(100, 100);
    FinishedPile diamond = new FinishedPile(startingCorner+distance*3, yStart);
    FinishedPile club = new FinishedPile(startingCorner+distance*4, yStart);
    FinishedPile heart = new FinishedPile(startingCorner+distance*5, yStart);
    FinishedPile spade = new FinishedPile(startingCorner+distance*6, yStart);

    Pile pile1 = new Pile(startingCorner,yStart+ydistance);
    Pile pile2 = new Pile(startingCorner+distance,yStart+ydistance);
    Pile pile3 = new Pile(startingCorner+distance*2,yStart+ydistance);
    Pile pile4 = new Pile(startingCorner+distance*3,yStart+ydistance);
    Pile pile5 = new Pile(startingCorner+distance*4,yStart+ydistance);
    Pile pile6 = new Pile(startingCorner+distance*5,yStart+ydistance);
    Pile pile7 = new Pile(startingCorner+distance*6,yStart+ydistance);


    FinishedPile[] gamepiles = {diamond, club, heart, spade};
    Pile[] seven_piles = {pile1, pile2, pile3, pile4, pile5, pile6, pile7};
    Deck deck = new Deck(startingCorner, yStart);
    DiscardPile discardPile = new DiscardPile(startingCorner+distance, yStart);

    Pile[] fullStack = {diamond, club, heart, spade, pile1, pile2, pile3, pile4, pile5, pile6, pile7, deck, discardPile};
    Pile[][] full = {gamepiles, seven_piles, deck, discardPile};

    public void start(){
        JFrame frame = new JFrame("Card Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0; i<gamepiles.length;i++){
            //gamepiles[i].test();

        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                deck.draw(g);
                discardPile.draw(g);
                for(int i = 0; i<gamepiles.length; i++) {
                   //cards.get(i).draw(g, i*40, 100+i*20);

                    //System.out.println("hUrLePsY");
                    gamepiles[i].draw(g);
                }

                for(int i = 0; i < seven_piles.length; i++){
                    seven_piles[i].draw(g);
                }
            }

        };

        panel.setPreferredSize(new Dimension(800,600));
        //panel.setOpaque(false);
        for(int i = 0; i < 7; i++){
            for(int j = -1; j < i;j++)
                seven_piles[i].add(deck.pile.remove(0));
        }
        lastCardUp();

    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            clickedAt(e);
            panel.repaint();
        }
    });
        //panel.repaint();
        /*
        cards.add( new Card(4,Card.Suits.CLUBS));
        cards.add( new Card(8,Card.Suits.HEARTS));
        cards.add( new Card(11,Card.Suits.SPADES));
        cards.add( new Card(1,Card.Suits.DIAMONDS));
        cards.add( new Card(12,Card.Suits.SPADES));
        cards.add( new Card(2,Card.Suits.DIAMONDS));
        */

        /*for(int i = 0; i<cards.size();i+=2)
            //cards.get(i).flip();
            */

            frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public void commence(){
        for (Pile p : seven_piles){

        }
    }



    int firstClickPile, secondClickPile;
    boolean firstClick = true;
    public void clickedAt(MouseEvent me){
        int x = me.getX(), y = me.getY();
        System.out.println(x+", "+y);
        if(firstClick) {
            for (int i = 0; i < fullStack.length && firstClick; i++) {
                Pile p = fullStack[i];
                if (x >= p.xLoc && x <= p.xLoc + 50 && y >= p.yLoc && y < p.yLoc + 75) {
                    if(p instanceof Deck){ deal(); firstClick = false;}
                    else firstClickPile = i;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < fullStack.length && !firstClick; i++) {
                Pile p = fullStack[i];
                if (x >= p.xLoc && x <= p.xLoc + 50 && y >= p.yLoc && y < p.yLoc + 75
                        && !(p instanceof Deck) && !(p instanceof  DiscardPile)) {
                    secondClickPile = i;
                    break;
                }
            }
        }
        if(!firstClick&&fullStack[firstClickPile].pile.size()>0){
            fullStack[secondClickPile].add(fullStack[firstClickPile].pile.remove(fullStack[firstClickPile].pile.size()-1));
            secondClickPile=-1;
            secondClickPile=-1;

        }
        firstClick = !firstClick;
    }


    public void lastCardUp(){
        for(int i=0;i<seven_piles.length;i++)
            if(seven_piles[i].pile.size()>0)
            seven_piles[i].pile.get(seven_piles[i].pile.size()-1).setFaceUp(true);
    }

    public void deal(){
        if(deck.pile.size()>0) {
            discardPile.pile.add(deck.pile.remove(deck.pile.size() - 1));
            discardPile.pile.get(discardPile.pile.size() - 1).setFaceUp(true);
        }
    }








}
