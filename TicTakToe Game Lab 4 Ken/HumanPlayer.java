/**
 * 
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ken
 *
 */
public class HumanPlayer extends Player {

	
	public HumanPlayer(String name, char letter) {
		super(name, letter);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void makeMove() throws IOException{

		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int column = 0;
		int row  = 0;
	
		do {	//this loop will run until a response has been received for a row and column that is blank
			System.out.println(super.getName() + ", what row should your next " + super.getMark() + " be placed in? ");
		
			do  { //this loop will run until a non empty response has been received that is within the boundaries of the board
				input= stdin.readLine();
				if(input == null) {
					System.out.print("Please try again: ");
				}
				else {
					row = Integer.parseInt(input);
					if(row < 0 || row > 2) {
						System.out.print("Number is out of bounds. Please try again: ");
					}
				}
			} while (input == null || row < 0 || row > 2);
		
		
			System.out.println(getName() + ", what column should your next " + getMark() + " be placed in? ");
			do  {//this loop will run until a non empty response has been received that is within the boundaries of the board
				input= stdin.readLine();
				if(input == null) {
					System.out.print("Please try again: ");
				}
				else {
					column = Integer.parseInt(input);
					if(column < 0 || column > 2) {
						System.out.print("Number is out of bounds. Please try again: ");
					}
				}
			} while (input == null || column < 0 || column > 2);
		
			//check to see if mark can be placed
			if(super.getBoard().getMark(row, column) != ' ') {
				System.out.println("This space is occupied, please try another.");
			}
		} while (super.getBoard().getMark(row, column) !=' ');
	
	
		//add mark and display board
		super.getBoard().addMark(row, column, getMark());

	
	}





}
