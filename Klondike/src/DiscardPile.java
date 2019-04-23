import java.awt.*;

public class DiscardPile extends Pile{

    public DiscardPile(int x, int y){
        super(x,y);
    }
    @Override
    public void draw(Graphics g){
        if(this.pile.size()>0){
            /**
             * importanttttttttttttttttt
             */
            //pile.get(pile.size()-1).setFaceUp(true);

            pile.get(pile.size()-1).draw(g, this.xLoc, yLoc);
        }
        else{
            g.setColor(Color.lightGray);
            g.drawRect(xLoc, yLoc, 50, 70);
        }
    }
}
