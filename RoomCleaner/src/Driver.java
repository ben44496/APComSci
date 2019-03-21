//import java.awt.*;
//import java.awt.Image;
//import java.awt.Toolkit;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

import kareltherobot.*;
import kareltherobot.Robot;
import java.applet.Applet;




public class Driver implements Directions{

	Robot roomba ;
	JFrame pane;
	JPanel myPanel;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
		d.getInfo();
		d.cleanRoom();
		d.printResults();
		//OK ! SORRY !


	}

	private void printResults() {
		// A bunch of System.out.prints go here
		// or a big JOptionPane displaying results
		System.out.println("The biggest pile was ");
	}

	private void cleanRoom() {
		// all the code that cleans and counts goes here

		System.out.println(roomba);

		//roomba.move();// obviously, lots more here
		//goToACorner();
		int piles = 21;
		int area = 10;
		System.out.println("dirty "+1.0*piles/area);
		
	}

	private void getInfo() {
		// this method acquires the starting street, avenue and direction
		// of the robot from the user.  Also it inputs the name of the world
		// file.  It then opens the world file and creates the robot
		String wrldName = "basicRoom.wld";
		
		int beepers=0,piles =0;
		piles++;
		System.out.println("Beepers: "+beepers+"\nPiles: "+piles);

		myPanel = new JPanel();






		pane = new JFrame("Room Cleaner");
		pane.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pane.setTitle("Room Cleaner");
		pane.setSize(500, 500);
		pane.setLocationRelativeTo(null);
/*
		Toolkit tk = new Toolkit.getDefaultToolkit();
		Image titleIcon = tk.getImage("roomba.png");
		setIconImage(titleIcon);
*/
		




		pane.setVisible(true);


		JFileChooser jfc = new JFileChooser();
		//jfc.setVisible(true);
		//jfc.showOpenDialog(null);
	
		World.readWorld(wrldName);
		//World.setVisible(true);
		
	}

	protected void makeButton (String buttonName, GridBagLayout gridbag, GridBagConstraints c){
		Button button = new Button(buttonName);
		gridbag.setConstraints(button, c);
		myPanel.add(button);
	}
	public void init(){
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();




	}



}
