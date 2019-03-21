import java.awt.*;

public class Deck extends Pile {
    //Pile pile;

    public Deck(int x, int y) {
        super(x,y);
        for(int v = 2;v< 15;v++)
        {
            pile.add(new Card(v, Card.Suits.CLUBS));
            pile.add(new Card(v, Card.Suits.HEARTS));
            pile.add(new Card(v, Card.Suits.DIAMONDS));
            pile.add(new Card(v, Card.Suits.SPADES));
        }
//        shuffle();
    }
    @Override
    public void draw(Graphics g){
        if(this.pile.size()>0){
            pile.get(0).draw(g, this.xLoc, yLoc);
        }
        else{
            g.setColor(Color.lightGray);
            g.drawRect(xLoc, yLoc, 50, 70);
        }
    }
}
