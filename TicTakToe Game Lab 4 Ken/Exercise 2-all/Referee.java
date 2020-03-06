/**
 * 
 */
package lab2;

import java.io.IOException;

/**
 * Calls more class methods to start the game, does initializations of class Player.
 * The overall purpose of this class is to organize the Player class, such that the Player
 * Class is able to run the individual moves of the game until it announces a winner.
 * 
 * @author Ken
 * @version 1.0
 * @since February 7 2020
 */
public class Referee {
	
	
	/**
	 * the Player to set as X (first player)
	 */
	private Player xPlayer;
	
	/**
	 * the Player to set as O (second player)
	 */
	private Player oPlayer;
	
	/**
	 * the board to set, which the game is played on
	 */
	private Board board;
	
	

	/**
	 * @param xPlayer the Player to set as X (first player)
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	/**
	 * @param oPlayer the Player to set as O (second player)
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	/**
	 * @param board the board to set, which the game is played on
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Method that initializes the player classes, and starts the method to
	 * run the moves of the game until the game is over
	 * @param xPlayer the Player to set as X (first player)
	 * @param oPlayer the Player to set as O (second player)
	 * @param board the board to set, which the game is played on
	 */
	public void runTheGame()  throws IOException {

		System.out.println("\nReferee started the game... ");
		board.display();
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		while(!board.isFull() && !board.xWins() && !board.oWins() ) {
			
			if(board.isFull()|| board.xWins()||board.oWins()) {
				break;
			}
			xPlayer.play();
			
			if(board.isFull()|| board.xWins()||board.oWins()) {
				break;
			}			
			xPlayer.setBoard(board);
			xPlayer.getOpponent().play();

			
		}
		
		
		
		System.out.println("Game Ended...");
		

	}
	
	
}
