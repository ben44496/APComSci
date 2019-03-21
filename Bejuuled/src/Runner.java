import java.awt.*;
//import java.awt.Graphics;
import java.awt.event.*;
//import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {

    JFrame frame = new JFrame("Bejuuled");
    JPanel panel;
    private final Dimension DIM = new Dimension(800,600);
    Grid grid = new Grid(8, 8);
    private boolean firstClick = true;
    private Jewel selectedFruit1;
    private Jewel selectedFruit2;
    Image icon = Mango.mangoImage;
    Image backgroundImage = Toolkit.getDefaultToolkit().createImage("background.jpg");
    Timer timer = new Timer(5,null);
    private int points = 0;

    public static void main(String[] args) {
        new Runner().start();

    }


    private void start() {
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //g.drawImage(backgroundImage, 0, 0, 800, 800, null);
                grid.draw(g);
            }
        };
        //panel.setBackground(Color.GREEN);
        //panel.imag
        //panel.
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                clickedAt(me);
                panel.repaint();
            }
        });
        panel.setPreferredSize(DIM);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        timer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                timerPing();
            }
        });
    }


    protected void clickedAt(MouseEvent me) {
        //System.out.println("You just clicked "+me);
        System.out.println("click");
        if(firstClick){
            int col = me.getX()/Jewel.SQUARE_SIZE;
            int row = me.getY()/Jewel.SQUARE_SIZE;
            Jewel j = grid.getJewel(col,row);
            selectedFruit1 = j;
            j.selected();
        }
        else if(!firstClick){
            int col = me.getX()/Jewel.SQUARE_SIZE;
            int row = me.getY()/Jewel.SQUARE_SIZE;
            Jewel j = grid.getJewel(col,row);
            selectedFruit2 = j;
            if(selectedFruit1.getPosition() != selectedFruit2.getPosition()){
                grid.swap(selectedFruit1, selectedFruit2);
            }


        }

        firstClick = !firstClick;
        System.out.println(firstClick);
    }
    public void timerPing(){
        System.out.println("Updated: " + timer.toString());
        updateProgressBar();

        panel.repaint();
    }

    public void updateProgressBar(){

    }
    public int convertP(int x, int y){
        return (x*100)+y;
    }
    public int pConvertX(int p){
        return p%100;
    }
    public int pConvertY(int p){
        return p-pConvertX(p);
    }

}
