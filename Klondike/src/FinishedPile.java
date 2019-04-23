import java.awt.*;

public class FinishedPile extends Pile{

    public FinishedPile(int x,int y){
        super(x,y);

    }

    @Override
    public void draw(Graphics g){
        if(pile.size()>0) {
            pile.get(pile.size() - 1).setFaceUp(true);
            pile.get(pile.size() - 1).draw(g, this.xLoc, this.yLoc);
        }
        else {
            g.setColor(Color.lightGray);
            g.drawRect(xLoc, yLoc, 50, 70);
        }

    }
}
