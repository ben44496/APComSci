import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import kareltherobot.*;
import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import org.omg.CORBA.Any;
import sun.font.LayoutPathImpl;

public class MakeADiamond implements Directions {
    Robot bobbie = new Robot(1, 1, North, infinity);
    int choice;
    int numberOfSides = 4;
    int number = 3;
    int sideLength;
    Scanner keyboard = new Scanner(System.in);
    int yorn;
    //static int worldSizeX = sideLength*2 -1;
    //int worldSizeY = sideLength+2;
    int radius;
    int multiplier = 1;
    int biggerRadius;
    int x, y;
    JFrame guiFrame = new JFrame();
    JOptionPane nani = new JOptionPane();


    public static void main(String[] args) {
        MakeADiamond ben = new MakeADiamond();
        World.setVisible(true);
        World.setDelay(0);
        //World.setStreetColor(java.awt.Color.white);

        //World.setBeeperColor(java.awt.Color color);
        System.out.println("Welcome! This is V1.0.0 of the ShapeMaker Program. We currently only support even-sided shapes. Have fun!");
        System.out.println("Welcome! This is V1.1.0 of the ShapeMaker Program. We currently only support even-sided shapes. Haven fun!");
        //ben.guiApp();
        ben.prompt();
    }


    private void prompt() {
        System.out.println("Hi there. Please choose your options: ");
        System.out.println("1: 5x5 diamond.");
        System.out.println("2: 5x5 FILLED diamond");
        System.out.println("3: Any sized diamond");
        System.out.println("4: Any Shape, Any Size");
        System.out.println("5: FiLlEd CiRcLe");

        choice = keyboard.nextInt();

        if (choice == 1) {
            System.out.println(choice);
            World.setSize(20, 20);
            fiveByFive();
        } else if (choice == 2) {
            System.out.println(choice);
            World.setSize(20, 20);
            fiveByFiveFilled();
        } else if (choice == 3) {
            System.out.println("c");
            System.out.println("Note: This only does diamonds.");
            System.out.println("What would be the side length?");
            sideLength = keyboard.nextInt();
            //World.setSize(worldSizeX, worldSizeY);
            World.setSize(20, 20);
            anySizeDiamond();
        } else if (choice == 4) {
            System.out.println(choice);
            World.setSize(20, 20);
            anySizeAnyShapePrompt();
        } else if (choice == 5) {
            System.out.println(choice);

            anySizeFilledCircle();
        } else {
            System.out.println(choice + " is not a choice.");
            tryAgain();
        }
    }

    private void fiveByFive() {
        //moves to best starting position
        for (int i = 0; i < 4; i++) {
            bobbie.move();
        }
        //makes the diamond
        for (int side = 0; side < 4; side++) {
            //makes one of the sides
            for (int a = 0; a < 4; a++) {
                sides();
            }
            //turns 90˚ to the right for next side
            turnRight();
        }
        //System.out.println("Close the window when you're done.");
        tryAgain();
    }

    private void fiveByFiveFilled() {
        //setup
        for (int i = 0; i < 5 - 1; i++) {
            bobbie.move();
        }
        for (int y = 0; y < 3; y++) {
            //on side
            for (int x = 0; x < 4; x++) {
                sides();
            }
            turnRight();
        }
        for (int h = 0; h < 3; h++) {

            for (int a = 0; a < 2; a++) {
                //on side
                for (int x = 0; x < number; x++) {
                    sides();
                }
                turnRight();
            }
            //if statements to check if number is 1 or more.
            if (number > 1) {
                number--;
            } else {
                number = 1;
            }
        }
        bobbie.putBeeper();
        bobbie.turnLeft();
        //System.out.println("Close the window when you're done.");
        tryAgain();
    }


    private void anySizeTriangle() {
        //no starting position
        for (int x = 1; x < 3; x++) {
            //makes the slanted sides
            for (int r = 0; r < sideLength - 1; r++) {
                sides();
            }
            bobbie.putBeeper();
            turnRight();
        }
        turnRight();
        //flat side (bottom)
        for (int x = 0; x < sideLength * 2 - 3; x++) {
            straight();
        }
        bobbie.move();
        turnRight();

        tryAgain();
    }

    private void anySizeSquare() {
        for (int i = 0; i < numberOfSides; i++) {
            for (int a = 0; a < sideLength - 1; a++) {
                straight();
            }
            turnRight();
        }
        bobbie.putBeeper();
        tryAgain();
    }

    private void anySizeDiamond() {
        //moves to best starting position
        for (int i = 0; i < sideLength - 1; i++) {
            bobbie.move();
        }
        //makes the diamond
        for (int side = 0; side < numberOfSides; side++) {
            //makes one of the sides
            for (int a = 0; a < sideLength - 1; a++) {
                sides();
            }
            //turns 90˚ to the right for next side
            turnRight();
        }
        //System.out.println("Close the window when you're done.");
        tryAgain();
    }

    private void anySizePentagon() {
        //moves to best starting position
        for (int i = 0; i < sideLength - 1; i++) {
            bobbie.move();
        }
        for (int i = 0; i < sideLength - 1; i++) {
            sides();
        }
        endSide();
        for (int i = 0; i < sideLength - 1; i++) {
            sides();
        }
        endSide();
        for (int i = 0; i < sideLength - 1; i++) {
            straight();
        }
        endSide();
        for (int i = 0; i < 2 * (sideLength - 1); i++) {
            straight();
        }
        endSide();
        for (int i = 0; i < sideLength - 1; i++) {
            straight();
        }
    }

    private void anySizeHexagon() {
        //moves to best starting position
        for (int i = 0; i < sideLength - 1; i++) {
            bobbie.move();
        }
        for (int twoTimes = 0; twoTimes < 2; twoTimes++) {
            for (int i = 0; i < sideLength - 1; i++) {
                sides();
            }
            endSide();
            for (int i = 0; i < sideLength - 1; i++) {
                straight();
            }
            for (int i = 0; i < sideLength - 1; i++) {
                sides();
            }
            turnRight();
        }
    }

    private void anySizeOctogon() {
        //moves to best starting position
        for (int i = 0; i < sideLength - 1; i++) {
            bobbie.move();
        }
        for (int twoTimes = 0; twoTimes < 2; twoTimes++) {
            for (int i = 0; i < sideLength - 1; i++) {
                straight();
            }
            for (int i = 0; i < sideLength - 1; i++) {
                sides();
            }
            endSide();
            for (int i = 0; i < sideLength - 1; i++) {
                straight();
            }
            for (int i = 0; i < sideLength - 1; i++) {
                sides();
            }
            endSide();
        }
    }

	/*private void anySizeCircle(){
		int x, y;
		System.out.println("What is the radius of the CiRcLe?");
		radius = keyboard.nextInt();
		System.out.println(radius);
		biggerRadius = multiplier*radius;
		//move to center of circle with biggerRadius
		for (int i = 0; i < biggerRadius-1; i++) {
			bobbie.move();
		}
		turnRight();
		for (int i = 0; i < biggerRadius-1; i++) {
			bobbie.move();
		}
		bobbie.turnLeft();
		x = bobbie.avenue();
		y=bobbie.street();

		if (Math.pow(x-biggerRadius, 2) + Math.pow(y-biggerRadius, 2) <= Math.pow(biggerRadius,2)){
			anySizeFilledCircle();
		}


		bobbie.avenue();
		bobbie.street();
		anySizeFilledCircle();

	}*/

    private void anySizeAnyShapePrompt() {
        System.out.println("What would be the number of sides?");
        numberOfSides = keyboard.nextInt();
        if (numberOfSides == 3) {
            System.out.println("Notice this is 45-45-90 triangle. Side length refers to the slanted sides.");
            System.out.println("What would be the side length?");
            sideLength = keyboard.nextInt();
            System.out.println("Triangle-45-45-90");
            anySizeTriangle();
        } else if (numberOfSides == 4) {
            System.out.println("Square or Diamond? Choose (insert '1' for Square or '2' for Diamond)");
            int sord = keyboard.nextInt();
            askForSideLengths();
            //World.setSize(worldSizeX, worldSizeY);
            if (sord == 1) {
                anySizeSquare();
            } else if (sord == 2) {
                anySizeDiamond();
            } else {
                System.out.println("Not and option. Try Again.");
                prompt();
            }
        } else if (numberOfSides == 5) {
            System.out.println("Pentagon");
            System.out.println("What would be the side length? ***This is the height and roof size.");
            sideLength = keyboard.nextInt();
            anySizePentagon();
            tryAgain();
        } else if (numberOfSides == 6) {
            askForSideLengths();
            System.out.println("Hexagon");
            anySizeHexagon();
            tryAgain();
        } else if (numberOfSides == 7) {
            //AskForSideLengths();
            System.out.println("Heptagon");
            System.out.println("Sorry, this edition of DiamondMaker does not support Heptagons!");
            tryAgain();
        } else if (numberOfSides == 8) {
            askForSideLengths();
            System.out.println("Octogan[or is it Pagtagon...]");
            anySizeOctogon();
            tryAgain();
        } else {
            System.out.println("No idea what you want. Polygons above 8 sides are not supported. Try Again.");
            anySizeAnyShapePrompt();
        }

    }


    //prompt for asking for side length
    private void askForSideLengths() {
        System.out.println("What would be the side length?");
        sideLength = keyboard.nextInt();
    }

    //not used yet... gotta make a new window every single time
    private void tryAgain() {
        System.out.println("Would you like to continue? 1 for yes, 2 for no");
        yorn = keyboard.nextInt();
        if (yorn == 2) {
            System.out.println("Have a Good Day! Remember to close the window on your way out.");
        } else if (yorn == 1) {
            prompt();
        } else {
            tryAgain();
        }
    }

    //makes the sides, use a for loop to determine how many beepers each side
    private void sides() {
        bobbie.putBeeper();
        turnRight();
        bobbie.move();
        bobbie.turnLeft();
        bobbie.move();
        //ends facing Straight
    }

    //straight sides
    private void straight() {
        bobbie.move();
        bobbie.putBeeper();
    }

    //turns right
    private void turnRight() {
        bobbie.turnLeft();
        bobbie.turnLeft();
        bobbie.turnLeft();
    }

    private void endSide() {
        bobbie.putBeeper();
        turnRight();
    }

    private void anySizeFilledCircle() {


        System.out.println("What is the radius of the CiRcLe?");
        radius = keyboard.nextInt();
        System.out.println(radius);
        if (radius >70){
            multiplier = 4;
            World.setSize(multiplier * 50, multiplier * 50);
        }else if (radius>=20 && radius < 45){
            multiplier = 2;
            World.setSize(multiplier * 50, multiplier * 50);
        }else if (radius >=45 && radius <=70){
            multiplier = 3;
            World.setSize(multiplier * 50, multiplier * 50);
        }else{
            multiplier = 1;
            World.setSize(multiplier * 50, multiplier * 50);
        }


        biggerRadius = 2 * multiplier * (radius - 1) + 1;
        //move to center of circle with biggerRadius
        for (int i = 0; i < radius - 1; i++) {
            bobbie.move();
        }
        turnRight();
        for (int i = 0; i < radius - 1; i++) {
            bobbie.move();
        }
        bobbie.turnLeft();

        bobbie.putBeeper();

        int i = 0;
        while (i < biggerRadius) {
            //World.repaint();
            for (int a = 0; a < 2; a++) {
                for (int b = 0; b < i; b++) {
                    y = bobbie.avenue();
                    x = bobbie.street();
                    if ((Math.pow((x - radius), 2) + Math.pow((y - radius), 2)) <= (Math.pow((radius), 2))) {
                        bobbie.putBeeper();
                        bobbie.move();

                    } else {
                        bobbie.move();
                    }
                }
                turnRight();
            }
            i++;
        }
//last side
        for (int b = 0; b < i - 1; b++) {
            x = bobbie.avenue();
            y = bobbie.street();
            if ((Math.pow((x - radius), 2) + Math.pow((y - radius), 2)) <= (Math.pow((radius), 2))) {
                bobbie.move();
                bobbie.putBeeper();
            } else {
                bobbie.move();
            }
        }

//so you can see
        bobbie.move();
        bobbie.move();


    }

/*
    private void guiApp(){

        //program will exit when frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        //guiFrame.pack();
        guiFrame.setTitle("Diamond Maker V1.1.0");
        guiFrame.setSize(300,500);
        guiFrame.setLocationRelativeTo(null); //JFrame in the middle of the screen.

        //gotta create an empty label
        //guiFrame.getContentPane().add(emptyLabel, BorderLayout.CENTER);






        guiFrame.setVisible(true);
    }
    */
/*
    public class MenuDemo implements ActionListener, ItemListener {
        JTextArea output;
        JScrollPane scrollPane;
        String newline = "\n";

        public JMenuBar createMenuBar() {
            JMenuBar menuBar;
            JMenu menu, submenu;
            JMenuItem menuItem;
            JRadioButtonMenuItem rbMenuItem;
            JCheckBoxMenuItem cbMenuItem;

            //Create the menu bar.
            menuBar = new JMenuBar();

            //Build the first menu.
            menu = new JMenu("A Menu");
            menu.setMnemonic(KeyEvent.VK_A);
            menu.getAccessibleContext().setAccessibleDescription(
                    "The only menu in this program that has menu items");
            menuBar.add(menu);

            //a group of JMenuItems
            menuItem = new JMenuItem("A text-only menu item",
                    KeyEvent.VK_T);
            //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
            menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            menuItem.addActionListener(this);
            menu.add(menuItem);

            ImageIcon icon = createImageIcon("images/middle.gif");
            menuItem = new JMenuItem("Both text and icon", icon);
            menuItem.setMnemonic(KeyEvent.VK_B);
            menuItem.addActionListener(this);
            menu.add(menuItem);

            menuItem = new JMenuItem(icon);
            menuItem.setMnemonic(KeyEvent.VK_D);
            menuItem.addActionListener(this);
            menu.add(menuItem);

            //a group of radio button menu items
            menu.addSeparator();
            ButtonGroup group = new ButtonGroup();

            rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
            rbMenuItem.setSelected(true);
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            rbMenuItem.addActionListener(this);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem("Another one");
            rbMenuItem.setMnemonic(KeyEvent.VK_O);
            group.add(rbMenuItem);
            rbMenuItem.addActionListener(this);
            menu.add(rbMenuItem);

            //a group of check box menu items
            menu.addSeparator();
            cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
            cbMenuItem.setMnemonic(KeyEvent.VK_C);
            cbMenuItem.addItemListener(this);
            menu.add(cbMenuItem);

            cbMenuItem = new JCheckBoxMenuItem("Another one");
            cbMenuItem.setMnemonic(KeyEvent.VK_H);
            cbMenuItem.addItemListener(this);
            menu.add(cbMenuItem);

            //a submenu
            menu.addSeparator();
            submenu = new JMenu("A submenu");
            submenu.setMnemonic(KeyEvent.VK_S);

            menuItem = new JMenuItem("An item in the submenu");
            menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_2, ActionEvent.ALT_MASK));
            menuItem.addActionListener(this);
            submenu.add(menuItem);

            menuItem = new JMenuItem("Another item");
            menuItem.addActionListener(this);
            submenu.add(menuItem);
            menu.add(submenu);

            //Build second menu in the menu bar.
            menu = new JMenu("Another Menu");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription(
                    "This menu does nothing");
            menuBar.add(menu);

            return menuBar;
        }

*/
}

