
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

                //pile.get(0).draw(g, xLoc, yLoc);
                int dLoc =yLoc;
                for (int i = 0; i < pile.size(); i++) { //end is top card
                    if(!pile.get(i).isFaceUp()){
                        pile.get(i).draw(g, xLoc, dLoc);
                        dLoc +=15;
                    }
                    else{
                        pile.get(i).draw(g, xLoc, dLoc);
                        dLoc +=30;
                    }


                }
        }
    }

    public void addPile(Pile other){
        this.pile.addAll(other.pile);
        allDown();
        setCardFaceUp(0);
    }

    public void shuffle(){
        ArrayList<Card> temp = new ArrayList<Card>();
        while(pile.size() > 0){
            int toRemove = (int)(Math.random()*pile.size());
            temp.add(pile.remove(toRemove));
            //pile.remove(toRemove);
        }
        pile = temp;
        allDown();
    }

    public void add(Card c){
        pile.add(c);
    }

    public void setCardFaceUp(int card){
        pile.get(card).setFaceUp(true);
    }
    public void setCardFaceDown(int card){
        pile.get(card).setFaceUp(false);
    }
    public void allDown(){
        for(Card c:pile){
            c.setFaceUp(false);
        }
    }
    public void test(){
        pile.add(new Card((int)(Math.random()*13), Card.Suits.DIAMONDS));

    }

}
