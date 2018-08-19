import java.awt.*;
import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import org.omg.CORBA.Any;
import sun.font.LayoutPathImpl;

public class MakeADiamond implements Directions {
	Robot bobbie = new Robot(1, 1, North, infinity);
	int choice;
	int numberOfSides = 4;
	int number =3;
	int sideLength;
	Scanner keyboard = new Scanner(System.in);
	int yorn;
	//static int worldSizeX = sideLength*2 -1;
	//int worldSizeY = sideLength+2;



	public static void main(String[] args) {
		MakeADiamond ben = new MakeADiamond();
		World.setVisible(true);
		World.setDelay(1);
		World.setSize(20, 20);
		System.out.println("Welcome! This is V1.0.0 of the ShapeMaker Program. We currently only support even-sided shapes. Have fun!");
		ben.prompt();
	}




	private void prompt(){
		System.out.println("Hi there. Please choose your options: ");
		System.out.println("1: 5x5 diamond.");
		System.out.println("2: 5x5 FILLED diamond");
		System.out.println("3: Any sized diamond");
		System.out.println("4: Any Shape, Any Size");

		choice = keyboard.nextInt();

		if (choice == 1) {
			System.out.println(choice);
			fiveByFive();
		} else if (choice == 2) {
			System.out.println(choice);
			fiveByFiveFilled();
		} else if (choice == 3){
			System.out.println("c");
			System.out.println("Note: This only does diamonds.");
			System.out.println("What would be the side length?");
			sideLength = keyboard.nextInt();
			//World.setSize(worldSizeX, worldSizeY);
			anySizeDiamond();
		} else if (choice ==4){
			System.out.println(choice);
			anySizeAnyShapePrompt();
		}else{
			System.out.println(choice +" is not a choice.");
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
		for (int h=0; h<3; h++) {

			for (int a = 0; a < 2; a++) {
				//on side
				for (int x = 0; x < number; x++) {
					sides();
				}
				turnRight();
			}
			//if statements to check if number is 1 or more.
			if (number>1){
				number--;
			}
			else{
				number = 1;
			}
		}
		bobbie.putBeeper();
		bobbie.turnLeft();
		//System.out.println("Close the window when you're done.");
		tryAgain();
	}






	private void anySizeTriangle(){
		//no starting position
		for (int x=1; x<3; x++) {
			//makes the slanted sides
			for (int r = 0; r<sideLength-1; r++){
				sides();
			}
				bobbie.putBeeper();
				turnRight();
		}
		turnRight();
		//flat side (bottom)
		for (int x=0; x< sideLength*2-3; x++){
			straight();
		}
		bobbie.move();
		turnRight();

		tryAgain();
	}

	private void anySizeSquare(){
		for (int i=0; i<numberOfSides; i++){
			for (int a=0; a<sideLength-1; a++){
				straight();
			}
			turnRight();
		}
		bobbie.putBeeper();
		tryAgain();
	}

	private void anySizeDiamond(){
		//moves to best starting position
		for (int i = 0; i < sideLength-1; i++) {
			bobbie.move();
		}
		//makes the diamond
		for (int side = 0; side < numberOfSides; side++) {
			//makes one of the sides
			for (int a = 0; a < sideLength-1; a++) {
				sides();
			}
			//turns 90˚ to the right for next side
			turnRight();
		}
		//System.out.println("Close the window when you're done.");
		tryAgain();
	}

	private void anySizePentagon(){
		//moves to best starting position
		for (int i = 0; i < sideLength-1; i++) {
			bobbie.move();
		}
		for (int i=0; i<sideLength-1; i++){
			sides();
		}
		endSide();
		for (int i=0; i<sideLength-1; i++){
			sides();
		}
		endSide();
		for (int i=0; i<sideLength-1; i++){
			straight();
		}
		endSide();
		for (int i=0; i<2*(sideLength-1); i++){
			straight();
		}
		endSide();
		for (int i=0; i<sideLength-1; i++){
			straight();
		}
	}

	private void anySizeHexagon(){
		//moves to best starting position
		for (int i = 0; i < sideLength-1; i++) {
			bobbie.move();
		}
		for (int twoTimes =0; twoTimes<2; twoTimes++){
			for (int i =0; i<sideLength-1; i++){
				sides();
			}
			endSide();
			for (int i=0; i<sideLength-1; i++){
				straight();
			}
			for (int i=0; i<sideLength-1; i++){
				sides();
			}
			turnRight();
		}
	}

	private void anySizeOctogon(){
		//moves to best starting position
		for (int i = 0; i < sideLength-1; i++) {
			bobbie.move();
		}
		for (int twoTimes =0; twoTimes<2; twoTimes++){
			for (int i=0; i<sideLength-1; i++){
				straight();
			}
			for (int i =0; i<sideLength-1; i++){
				sides();
			}
			endSide();
			for (int i=0; i<sideLength-1; i++){
				straight();
			}
			for (int i=0; i<sideLength-1; i++){
				sides();
			}
			endSide();
		}
	}

	private void anySizeAnyShapePrompt (){
		System.out.println("What would be the number of sides?");
		numberOfSides = keyboard.nextInt();
		if (numberOfSides == 3){
			System.out.println("Notice this is 45-45-90 triangle. Side length refers to the slanted sides.");
			System.out.println("What would be the side length?");
			sideLength = keyboard.nextInt();
			System.out.println("Triangle-45-45-90");
			anySizeTriangle();
		}else if (numberOfSides ==4){
			System.out.println("Square or Diamond? Choose (insert '1' for Square or '2' for Diamond)");
			int sord = keyboard.nextInt();
			askForSideLengths();
			//World.setSize(worldSizeX, worldSizeY);
			if (sord == 1){
				anySizeSquare();
			}else if (sord == 2){
				anySizeDiamond();
			}else{
				System.out.println("Not and option. Try Again.");
				prompt();
			}
		}else if (numberOfSides ==5){
			System.out.println("Pentagon");
			System.out.println("What would be the side length? ***This is the height and roof size.");
			sideLength = keyboard.nextInt();
			anySizePentagon();
			tryAgain();
		}else if (numberOfSides == 6){
			askForSideLengths();
			System.out.println("Hexagon");
			anySizeHexagon();
			tryAgain();
		}else if (numberOfSides ==7){
			//AskForSideLengths();
			System.out.println("Heptagon");
			System.out.println("Sorry, this edition of DiamondMaker does not support Heptagons!");
			tryAgain();
		}else if (numberOfSides ==8){
			askForSideLengths();
			System.out.println("Octogan[or is it Pagtagon...]");
			anySizeOctogon();
			tryAgain();
		}else {
			System.out.println("No idea what you want. Polygons above 8 sides are not supported. Try Again.");
			anySizeAnyShapePrompt();
		}

	}




	//prompt for asking for side length
	private void askForSideLengths(){
		System.out.println("What would be the side length?");
		sideLength = keyboard.nextInt();
	}
	//not used yet... gotta make a new window every single time
	private void tryAgain(){
		System.out.println("Would you like to continue? 1 for yes, 2 for no");
		yorn = keyboard.nextInt();
		if (yorn == 2){
			System.out.println("Have a Good Day! Remember to close the window on your way out.");
		}else if (yorn == 1){
			prompt();
		}else{
			tryAgain();
		}
	}

	//makes the sides, use a for loop to determine how many beepers each side
	private void sides(){
		bobbie.putBeeper();
		turnRight();
		bobbie.move();
		bobbie.turnLeft();
		bobbie.move();
		//ends facing Straight
	}

	//straight sides
	private void straight(){
		bobbie.move();
		bobbie.putBeeper();
	}

	//turns right
	private void turnRight(){
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.turnLeft();
	}

	private void endSide(){
		bobbie.putBeeper();
		turnRight();
	}























int random;
/*
public class MakeADiamond  implements Directions{
	Robot bobbie = new Robot(8,8,North,30);
	String upOrDown;

	public static void main(String[] args) {
		MakeADiamond temp = new MakeADiamond();

		temp.prompt();
	}

	private void prompt() {
		// Ask the user for the diamond size
		//System.out.println("Hey dude, I see you want to make a diamond.  Give me the deets: ");
		Scanner keyboard  = new Scanner(System.in);
		//int beepersOnSide = keyboard.nextInt();
		//System.out.println(beepersOnSide);
//		World.setVisible(true);
//		World.setDelay(100);

		System.out.println("Which direction?  Up or down");
		 upOrDown = keyboard.nextLine();
		if(upOrDown .equalsIgnoreCase("up") ){
			System.out.println("You picked up!! ");
		}
		else {
			System.out.println("You picked down!");
		}
		System.out.println("Your pick was: "+upOrDown);

		//diamond(beepersOnSide);

	}

	private void diamond(int beepersOnSide) {
		// make the robot street 1, middle of diamond (corner)
		bobbie.move();
		bobbie.move();
		bobbie.turnLeft();

	}

	private void drawSide(Robot r, int beepersOnSide) {

	}

}
*/
}