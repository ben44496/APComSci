import java.awt.*;
import java.util.ArrayList;

public class Grid {
    private Jewel[][] jewelGrid;
    private Boolean[][] boolGrid;
    public Grid(int row, int col) {
        jewelGrid = new Jewel[row][col];
        for(int r = 0; r < jewelGrid.length;r++){
            for (int c=0; c<jewelGrid[r].length;c++){
                jewelGrid[r][c] = Jewel.randomJewel(r,c);
                boolGrid[row][col] = false;
            }
        }
    }

    public void draw(Graphics g) {
        // draws all the jewels after drawing stuff on the
        // background, if desired
        for(int row = 0; row < jewelGrid.length;row++){
            for (int col=0; col<jewelGrid[row].length;col++){
                jewelGrid[row][col].draw(g);
            }
        }
    }

    public Jewel getJewel(int x, int y){
        return jewelGrid[x][y];
    }


    public void swap(int r1, int c1, int r2, int c2) {
        if (Math.abs(r1 - r2) == 1 || Math.abs(c1 - c2) == 1) {
            Jewel temp = jewelGrid[r1][c1];
            jewelGrid[r1][c1] = jewelGrid[r2][c2];
            jewelGrid[r2][c2] = temp;
            jewelGrid[r1][c1].setX(c2);
            jewelGrid[r1][c1].setY(r2);
            jewelGrid[r2][c2].setX(c1);
            jewelGrid[r2][c2].setY(r1);
        } else {
            System.out.println("Bad Swap!");
            jewelGrid[r1][c1].unselected();
            jewelGrid[r2][c2].unselected();
            // more of course
        }
    }
    public void swap(Jewel j, Jewel j1){
        swap(j.getY(),j.getX(),j1.getY(),j1.getX());
    }
    /*public ArrayList<Jewel> _3InARow(int r, int c) {
        ArrayList<Jewel> list = _3InARowHor(r,c);
        list.addAll(_3InARowVert(r,c));
        return list;
    }*/

    /*
     * @param r is row of a Jewel that was just moved.
     *        c is col of a Jewel that was just moved.
     *
     * @return returns an ArrayList of Jewels that make up three or more in
     *         a row vertically or an empty list if fewer than 3 in a row exist
     */
    /*private ArrayList<? extends Jewel> _3InARowVert(int r, int c) {

        return null;
    }*/
    /*
     * @param r is row of a Jewel that was just moved.
     *        c is col of a Jewel that was just moved.
     *
     * @return returns an ArrayList of Jewels that make up three or more in
     *         a row horizontally or an empty list if fewer than 3 in a row exist
     */
    /*private ArrayList<Jewel> _3InARowHor(int r, int c) {

        return null;
    }*/
    private ArrayList<? extends Jewel> _Ben3inRowHor(){

    }
    /**
     * This method drops all Jewels that should drop...
     */
    public void drop() {

    }

    /**
     * Fill in any empty positions with randomly selected Jewel
     */
    public void refill() {

    }

    public boolean isAjacent(int r1, int c1, int r2, int c2){
        if((Math.abs(r1 - r2) == 1 && ! (Math.abs(c1 - c2) == 1))|| (!((Math.abs(r1 - r2) == 1) && Math.abs(c1 - c2) == 1))){
            return true;
        }
        return false;
    }

}
