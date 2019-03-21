import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import info.gridworld.grid.*;
import info.gridworld.world.*;

public final class LifeRunner {

	private JFrame frame = new JFrame("Life, as we know it!");
	private JPanel panel;
	private int currentGen;
	private int numClicks;
	private int[][] grid;// to be constructed in the makeGrid method
	private final boolean SHOW_GUI = true;
	private int m = 20; //multiplier

	public static void main(String[] args) {
		new LifeRunner().start();
	}

	private void start() {
		makeGrid(25,20, 50);// add 50 "lives" to a 25 row X 20 col grid
		if(this.SHOW_GUI)
			makeFrame();

		printGrid(grid);

		/*if(this.SHOW_GUI)
			showGrid();
*/
		nextGen();

		printGrid(grid);
/*		if(this.SHOW_GUI)
			showGrid();
*/

	}



	private void makeFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// code to draw on graphics
				//g.fillRect(200, 100, 75, 20);
				//g.setColor(Color.RED);
				//g.drawLine(10, 50, 600, 100);
				showGrid(g);
			}
		};
		frame.add(panel);
		panel.setLayout(null);
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Code to be performed when button is clicked
				nextGen();
				panel.repaint();
			}
		});
		panel.add(button);
		button.setBounds(350, 250, 100,100);
		panel.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
	}

	private void showGrid(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g.drawString("Generation"+currentGen, 20,20);

		/*
		for(int r=1;r<grid.length-1;r++){
			for(int c=1; c<grid[r].length-1; c++){
				java.awt.Color color = Color.YELLOW, ocolor = Color.LIGHT_GRAY;
				if (grid[r][c]==1) g.fillRect(20,20,20,20);
			}
		}
		*/
		for(int r=1;r<grid.length-1;r++){
			for(int c=1; c<grid[r].length-1; c++){
				java.awt.Color color = Color.YELLOW, ocolor = Color.LIGHT_GRAY;
				if (grid[r][c]==1) g.fillRect(20*r,20*c,20,20);
			}
		}

	}

	/**
	 * create a grid with dimension of rows X cols with lives objects
	 * randomly placed into the grid.  One tricky part is to make sure you are 
	 * placing the correct number of objects in the grid.  If you randomly 
	 * come up with the same location, your code needs to account for that!
	 * 
	 * After making the grid, it is added to the List of grids
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of cols in the grid
	 * @param lives number of lives to be added to the grid
	 */
	private void makeGrid(int rows, int cols, int lives) {
		grid = new int[rows+2][cols+2];

		while (lives>0){
			int r= (int)(Math.random()*(rows+1)),
					c= (int)(Math.random()*(cols+1));
			if (grid[r][c]==1) continue;
			lives--;
			grid[r][c]=1;

		}

	}
	/**
	 * Prints the specified 2D array of int to the console.
	 * @param grid2 
	 */
	private void printGrid(int[][] grid2) {
		for(int[] r :grid2){
			for(int num: r){
				if(num==0)System.out.print("_");
				else System.out.print("*");
			}
			System.out.println();
		}
	}
	/**
	 * This method advances grid from the previous generation to the next generation
	 * based on these two simple rules:
	 * 1.  If there are 3 neighboring objects around a cell, that cell will contain a 
	 *     life in the subsequent generation.
	 * 2.  If there are 3 neighboring objects around a cell that currently contains an 
	 *     object, then that object lives on into the next generation.
	 *     
	 * Be sure to make all the changes to a different grid.
	 * Finally, the newest grid is added to the list of generations
	 */
	private void nextGen() {
		System.out.println("creating next gen");
		int[][] grid1= grid;

		for(int r=0; r<grid.length; r++){
			for(int c=0; c<grid[r].length;c++){
				int n = countN(r,c);
				if(n>=4)grid1[r][c]=0;
				else if(n==3)grid1[r][c]=1;
				else if(n==2)grid1[r][c]=grid[r][c];
			}
		}
	}
	private int countN(int r, int c){
		int count=0;
		for(int row=-1;row<1;row++){
			for(int col=-1; col<2; col++){
				if(r>0 && c>0 && r<this.grid.length-1 && c<this.grid[r].length-1 && grid[r+row][c+col]==1)count++;
			}
		}

		return count-grid[r][c];
	}

}
