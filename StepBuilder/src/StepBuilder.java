import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import javax.swing.*;


public class StepBuilder  implements Directions{
	// the robot to be used to build our stairs
	Robot worker = new Robot(1,1,North,200);
	// horizontal distance for each step
	final int TREAD_LENGTH = 5;
	// number of steps and height of each step, acquired from user
	int numSteps = -1, stepHeight = -1;

	JFrame panel = new JFrame();

	public static void main(String[] args) {
		// don't change this!!
		StepBuilder sb = new StepBuilder();
		World.setVisible(true);
		World.setSize(20,20);
		World.setDelay(1);
		sb.getInfoFromUser();
		sb.buildSteps();
	}

	/**
	 * This method directs the Robot to build the steps based on the info
	 * acquired from the user.
	 */
	private void buildSteps() {
		for (int a=0; a<numSteps; a++){
			steps();
		}
	}

	/**
	 * This method acquires info from the user using a JOptionPane.
	 * A JOptionPane is a built-in class that helps us get info:
	 * Here is a brief tutorial:  https://www.youtube.com/watch?v=q8gd2ih2-0c
	 * 
	 */
	private void getInfoFromUser() {
		JOptionPane.showMessageDialog(panel, "Welcome to StepBuilder V1.0!");
		//String name = JOptionPane.showInputDialog(panel, "Enter Name");
		numSteps = Integer.parseInt( JOptionPane.showInputDialog(panel, "Insert number of Steps"));
		stepHeight = Integer.parseInt( JOptionPane.showInputDialog(panel, "Insert step height"));


	}


	private void steps(){
		worker.putBeeper();
		for(int i=0; i<stepHeight-1; i++){
			worker.move();
			worker.putBeeper();
		}
		turnRight();
		for(int i=0; i<TREAD_LENGTH-1; i++){
			worker.move();
			worker.putBeeper();
		}
		worker.turnLeft();
	}
	/*private void stepsLeft(){
		worker.putBeeper();
		for (int i=0; i<stepHeight; i++){
			worker.move();
			worker.putBeeper();
		}
		turnRight();
		for (int i=0; i<TREAD_LENGTH; i++){
			worker.move();
			worker.putBeeper();
		}
	}

	private void stepsRight(){
		worker.putBeeper();
		for (int i=0; i<stepHeight; i++){
			worker.move();
			worker.putBeeper();
		}
		worker.turnLeft();
		for (int i=0; i<TREAD_LENGTH; i++){
			worker.move();
			worker.putBeeper();
		}
	}*/



	private void turnRight(){
		worker.turnLeft();
		worker.turnLeft();
		worker.turnLeft();
	}
}
