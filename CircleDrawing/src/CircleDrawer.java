import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class CircleDrawer  implements Directions{
	Robot bobbie;

	public static void main(String[] args) {
		CircleDrawer cd = new CircleDrawer();
		int numCircles = 1;
		while(numCircles > 0){
			numCircles--;
			int[] deets = cd.prompt();
			World.setVisible(true);
			World.setDelay(10);
			cd.makeCircle(deets);
		}
	}

	/**
	*  Ask the user for the circle size and center
	   The returned array has the following info
	   index 0 - has the Street
	   index 1 - has the Avenue
	   index 2 - has the Radius
	*/	
	private int[]  prompt() {
		
	
		return null;
	}
	
	/**
	  Makes a circle with the conditions provided by the specified array
	  The specified array has the following info
	   index 0 - has the Street
	   index 1 - has the Avenue
	   assume street and avenue are large enough so that the circle is possible
	   index 2 - has the Radius
	*/
	private void makeCircle(int[] details){
		
		
	}
}
