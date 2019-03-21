import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

import info.gridworld.grid.*;
import info.gridworld.world.*;

public final class KnightsTourRunner {

	private JFrame frame = new JFrame("Moving the knight");
	private JPanel panel;

	private int numMoves = 1;// keeps track of how many squares the knight has been to
	private int[][] board;// to be constructed in the makeGrid method
	public int rmag = 70,
			cmag = 70,
			knightRow=-10, knightCol=-10,
			boardRows =8, boardCols=8,
			fontSize = 1;
	public Color color1 = Color.white,
	color2 = Color.black;
	private java.awt.Font font = new Font("Serif", Font.BOLD, rmag*fontSize);
	
	public static void main(String[] args) {
		new KnightsTourRunner().start();
	}

	private void start() {
		makeBoard(boardRows,boardCols);// makes the chess board
		makeFrame();
		printBoard();
	}


	private void printBoard() {
		
	}

	private void makeFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				drawBoard(g);
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			int state = 0;
			
			@Override
			public void mousePressed(MouseEvent me) {
				if(state == 0) {
					putKnightOnBoard(me);
					state++;
				}
				else if(state == 1){
					moveKnight();
					if(knightTrapped()) {
						showNotificationAndPromptRestart();
						state++;
					}	
				}
				else if(state == 2) {
					makeBoard(boardRows,boardCols);
					state = 0;
				}
				frame.repaint();
			}
		});
		frame.add(panel);
		panel.setPreferredSize(new Dimension(800,800));
		frame.pack();
		frame.setVisible(true);
	}

	protected void showNotificationAndPromptRestart() {
		// TODO Auto-generated method stub
		
	}

	protected boolean knightTrapped() {
		// TODO Auto-generated method stub
		return false;
	}

	// figure out where the mouse event is on the board and put the knight there
	protected void putKnightOnBoard(MouseEvent me) {
		System.out.println("Placing the knight "+me);
		java.awt.Point p = me.getLocationOnScreen();
		int x = p.x;
		int y= p.y;
		knightCol = x/cmag;
		knightRow =y/rmag;
	}
	
	// draw the chessboard (alternating colors) and draw a "K" where the knight 
	// currently is and numbers where the knight has been
	protected void drawBoard(Graphics g) {
		for(int r=2; r+2<board.length;r++) {
			for (int c = 2; c + 2 < board[r].length; c++) {
				//need to make this code better and more concise, works for now
				if (r % 2 == 0) {
					if (c % 2 == 0) {
						g.setColor(color1);
						g.fillRect(c * cmag, r * rmag, cmag, rmag);
					} else {
						g.setColor(color2);
						g.fillRect(c * cmag, r * rmag, cmag, rmag);
					}
				} else {
					if (c % 2 == 0) {
						g.setColor(color2);
						g.fillRect(c * cmag, r * rmag, cmag, rmag);
					} else {
						g.setColor(color1);
						g.fillRect(c * cmag, r * rmag, cmag, rmag);
					}
				}

		}


		}
		if(knightRow>-1||knightCol>-1){
			g.setColor(Color.CYAN);
			g.setFont(font);
			//haven't centered it. appears on bottom-most left
			g.drawString("K", knightCol*cmag, knightRow*rmag);
	}


	}

	/**
	 * Make the chessboard
	 */
	private void makeBoard(int row, int col) {
		board = new int[row][col];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = 0;
			}
		}
		board = bufferOnBoard(board, 2);

	}

		/**
		 * Makes a move of the knight.  Find a random location on the board where the knight
		 * hasn't been (and that the knight can go to) and move there
		 */
		private void moveKnight () {
			System.out.println("moving the knight");
			//0 means that spot is open, 1 means it has been there
			int random = (int)(Math.random()*2);
			int randomRandom = 2-random;


		}
		private int[][] bufferOnBoard(int[][] array2,int bufferSize){
			int[][] array = new int[array2.length + bufferSize][array2.length + bufferSize];
			for (int r = 0; r < array.length; r++) {
				for (int c = 0; c < array[r].length; c++) {
					if (r < 2 || r > array.length - 2 || c < 2 || c > array.length - 2) array[r][c] = 9;
				}
			}
			return array;
		}


	}


