/**
 * 
 */
package lab2;
import java.io.*;
/**
 * Contains the methods operating the individual moves for each player, including checking for a winner.
 * The overall purpose of this class is to allow the external players (users) to make moves that will be 
 * updated onto the board. These moves will be sequential, one player after the other, until one user wins
 * or no more moves can be made (a tie). 
 * 
 * @author Ken
 * @version 1.0
 * @since February 7 2020
 */
public abstract class Player {

	/**
	 * the entered name for this Player
	 */
	private String name;
	
	
	/**
	 * the board, which the game is played on
	 */
	private Board board;
	
	/**
	 * the Player to set as the opponent to this Player
	 */
	private Player opponent;
	
	/**
	 * the mark, as defined by Constants (as X or O) that will define this Players moves on the board
	 */
	private char mark;
	
	/**
	 * @param name the entered name for this Player
	 * @param mark the mark, as defined by Constants (as X or O) that will define this Players moves on the board
	 */
	public Player(String name, char letter) {
		this.name = name;
		this.mark = letter;
	}

	
	/**
	 * this method operates a loop responsible for each player making their turn, ending if 
	 * the game has reached a win or tie condition
	 * @param opponent the Player as the opponent to this Player
	 * @param board the board, which the game is played on
	 */
	public  void play() throws IOException{
		// TODO Auto-generated method stub
		System.out.println(" ");
		makeMove();
		getBoard().display();
		
		//check if this move resulted in the game ending with a winner, or a tie
		if(getBoard().xWins()||getBoard().oWins()) {
			System.out.println("THE GAME IS OVER: "+ getName() + " is the winner!");
			return;
		}
		else if(getBoard().isFull()) {
			System.out.println("THE GAME IS OVER: it is a tie!");
			return;
		}
	}
	
	
	/**
	 * This method operates the moves each player makes, getting the input from the respective
	 * player in the form of a row and column to place their mark into. The method checks if there 
	 * is not already a marking in that designated spot, and will continue asking the respective player
	 * to enter a coordinate until an appropriate response is found. The method will then update the 
	 * board with this response, and output any end of game declarations if this move has resulted in a 
	 * victory or tie
	 * @param name the entered name for this Player
	 * @param mark the mark, as defined by Constants (as X or O) that will define this Players moves on the board
	 * @param opponent the Player to set as the opponent to this Player
	 * @param board the board, which the game is played on
	 * @param row the row index of the desired marking, as input by the user
	 * @param column the column index of the desired marking, as input by the user
	 * @param input the input the user has entered into the console, to be used for row or column
	 */	
	public abstract void makeMove() throws IOException;

	
	
	/**
	 * @param opponent the Player to set as the opponent to this Player
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	/**
	 * @param board the board to set that the game is played on
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the mark
	 */
	public char getMark() {
		return mark;
	}

	/**
	 * @return the opponent
	 */
	public Player getOpponent() {
		return opponent;
	}
	
	
}
