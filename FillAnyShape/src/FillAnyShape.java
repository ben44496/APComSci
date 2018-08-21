import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class FillAnyShape  implements Directions {
	Robot bobbie = new Robot(8, 8, North, 30);
	String upOrDown;

	public static void main(String[] args) {
		FillAnyShape temp = new FillAnyShape();

		World.setVisible(true);

	}




/*
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
*/
}

