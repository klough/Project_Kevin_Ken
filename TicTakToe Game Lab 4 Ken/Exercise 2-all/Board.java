package lab2;


//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Contains and maintains the Board on which the game is to be played. 
 * The overall purpose of this class is to organize the board of play, keeping
 * track of the various markings, including who wins or any other end of game 
 * condition. The board also is able to update and display itself with grid-lines
 * 
 * @author ENSF409
 * @version 1.0
 * @since February 7 2020
 */
public class Board implements Constants {
	
	/**
	 * Character grid that makes up the board, containing the grid lines, and any
	 * markings
	 */
	private char theBoard[][];
	
	/**
	 * Count of the total number of markings placed on the board so far
	 */
	private int markCount;
	
	/**
	 * Constructor method that initiates the grid with white spaces as defined in 
	 * the constants class. It also initializes the marker counter
	 * @param markCount the number of marks on the board
	 * @param SPACE_CHAR the white character set by class Constants
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * @param row the row index of the desired marking
	 * @param col the column index of the desired marking
	 * @return marking found at a specific coordinate on the board
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	
	/**
	 * @param markCount the number of markings that have been made on the board
	 * @return true if the board is full of markings, false otherwise
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * @param LETTER_X the  character set by class Constants for the X (or first) player
	 * @return true true if player using the X-mark as defined in the constants class
	 * has achieved 3 markings in a row, false otherwise
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * @param LETTER_O the  character set by class Constants for the O (or second) player
	 * @return true if player using the O-mark as defined in the constants class
	 * has achieved 3 markings in a row, false otherwise
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the board, with all markings and a set of grid-lines and 
	 * marked rows and columns
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * adds a specified marking to a specific row and column
	 * @param row the row index of the desired marking
	 * @param col the column index of the desired marking
	 * @param mark the marking that is being added to the board- should be found in Constants
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the entire board of all markings
	 * @param SPACE_CHAR the white character set by class Constants
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * checks to see if the player of a specified mark has won, by achieving 
	 * 3 of their own marks in a row (in any orientation). This method returns
	 * 1 if the player has won, and 0 if not
	 * @param row the row index of the desired marking
	 * @param col the column index of the desired marking
	 * @param markCount the number of markings that have been made on the board
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * displays the headers containing the column labels
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * displays the headers containing the column labels 
	 * as part of the visual output of the board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * displays the spaces as part of the visual output of the board
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
