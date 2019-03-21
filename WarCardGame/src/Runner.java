import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;


public class Runner {
    public static void main(String[] args) {
        new Runner().start();
    }
    ArrayList<Card>cards = new ArrayList<>();
    private void start() {
        JFrame frame = new JFrame("Card Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                for(int i = 0; i<cards.size(); i++) {
                    cards.get(i).draw(g, i*40, 100+i*20);
                }
            }
        };

        panel.setPreferredSize(new Dimension(800,600));
		cards.add( new Card(4,Card.Suit.CLUB));
		cards.add( new Card(8,Card.Suit.HEART));
		cards.add( new Card(11,Card.Suit.SPADE));
		cards.add( new Card(1,Card.Suit.DIAMOND));
		cards.add( new Card(12,Card.Suit.SPADE));
		cards.add( new Card(2,Card.Suit.DIAMOND));
        for(int i = 0; i<cards.size();i+=2)
            //cards.get(i).flip();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}


