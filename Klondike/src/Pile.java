
import java.awt.*;
import java.util.*;

public class Pile {
    ArrayList<Card> pile = new ArrayList<>();
    protected int xLoc;
    protected int yLoc;


    public Pile(int x, int y){
        super();
        xLoc = x;
        yLoc = y;

    }

    public void draw(Graphics g){
        if(pile.size()==0){
            g.setColor(Color.lightGray);
            g.drawRect(xLoc, yLoc, 50, 70);
        }else {
            if(pile.size()>0) {
                pile.get(0).draw(g, xLoc, yLoc);
                int sum = yLoc;
                for (int i = 1; i < pile.size(); i++) { //end is top card

                    for (int x = 0; x< i; x++){
                        if(! pile.get(x).isFaceUp()){
                            sum += 15;
                        } else {
                            sum += 30;
                        }
                    }
//                    Card c = pile.get(i - 1);
//                    if (!c.isFaceUp()) {
//                        pile.get(i).draw(g, xLoc, ));
//                    } else {
//                        pile.get(i).draw(g, this.xLoc, this.yLoc * (i * 30));
//                    }
                    pile.get(i).draw(g, this.xLoc, sum);
                    sum=0;
                }

            }
        }
    }

    public void addPile(Pile other){
        this.pile.addAll(other.pile);
    }

    public void shuffle(){
        ArrayList<Card> temp = new ArrayList<Card>();
        while(pile.size() > 0){
            int toRemove = (int)Math.random()*pile.size();
            temp.add(pile.get(toRemove));
            pile.remove(toRemove);
        }
        pile = temp;
    }

    public void add(Card c){
        pile.add(c);
    }
    public void test(){
//        for(int i=0; i<7; i++){
//            pile.add(new Card(i, Card.Suits.DIAMONDS));
//        }
        //pile.add( new Card(4,Card.Suits.CLUBS));
        pile.add( new Card(8,Card.Suits.HEARTS));
        pile.add( new Card(11,Card.Suits.SPADES));
        pile.add( new Card(1,Card.Suits.DIAMONDS));
        pile.add( new Card(12,Card.Suits.SPADES));
        pile.add( new Card(2,Card.Suits.DIAMONDS));
    }

}
