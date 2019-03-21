import javax.swing.*;
import java.awt.*;
import java.util.*;

public class KlondikeRunner {


    public static void main(String[] args) {
        new KlondikeRunner().start();
    }

    ArrayList<Card> cards = new ArrayList<Card>();
//    Pile benPile = new Pile(100, 100);
    Pile diamond = new Pile(700, 50);
    Pile club = new Pile(775, 50);
    Pile heart = new Pile(850, 50);
    Pile spade = new Pile(925, 50);

    Pile pile1 = new Pile(100,50);
    Pile pile2 = new Pile(175,50);
    Pile pile3 = new Pile(250,50);
    Pile pile4 = new Pile(325,50);
    Pile pile5 = new Pile(400,50);
    Pile pile6 = new Pile(475,50);
    Pile pile7 = new Pile(550,50);


    Pile[] gamepiles = {diamond, club, heart, spade};
    Pile[] seven_piles = {pile1, pile2, pile3, pile4, pile5, pile6, pile7};
    Pile deck = new Deck(10, 50);



    public void start(){
        JFrame frame = new JFrame("Card Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0; i<gamepiles.length;i++){
            gamepiles[i].test();

        }
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                deck.draw(g);

                for(int i = 0; i<gamepiles.length; i++) {
                   //cards.get(i).draw(g, i*40, 100+i*20);
                    gamepiles[i].test();
                    System.out.println("tim kanarsky");
                    gamepiles[i].draw(g);
                }
4
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


        //panel.repaint();
        cards.add( new Card(4,Card.Suits.CLUBS));
        cards.add( new Card(8,Card.Suits.HEARTS));
        cards.add( new Card(11,Card.Suits.SPADES));
        cards.add( new Card(1,Card.Suits.DIAMONDS));
        cards.add( new Card(12,Card.Suits.SPADES));
        cards.add( new Card(2,Card.Suits.DIAMONDS));

        /*for(int i = 0; i<cards.size();i+=2)
            //cards.get(i).flip();
            */

            frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }




}
