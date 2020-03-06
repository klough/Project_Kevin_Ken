package lab2;

/**
 * Contains all the important markings to provide consistency to playing the game. 
 * The overall purpose of this class is to organize the various markings that each
 * player will use to play the game, including X, O, and blank spaces, to keep these 
 * consistent throughout the various implemented classes
 * 
 * @author ENSF409
 * @version 1.0
 * @since February 7 2020
 */

public interface Constants {
	
	/**
	 * Empty character, used to populate spaces that have not been claimed by either
	 * player
	 */
	static final char SPACE_CHAR = ' ';
	
	/**
	 * Character used for player O (second player) to mark their positions on the 
	 * board, and determine if they have won the game
	 */
	static final char LETTER_O = 'O';
	
	/**
	 * Character used for player X (first player) to mark their positions on the 
	 * board, and determine if they have won the game
	 */
	static final char LETTER_X = 'X';
}
