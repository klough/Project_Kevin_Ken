package tictactoe;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Implementation of a tic tac toe board.
 * @author Kevin
 * theBoard 2D array of chars which represents each of the 9 grid locations.
 * markCount total number of marks on the board at any given time.
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	
	/**
	 * Default constructor for Board, sets markCount to 0 then constructs a 3x3 array and fills it with SPACE_CHAR.
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
	 * Returns the char/mark at the grid coordinate dictated by row and col.
	 * @param row row of desired char/mark.
	 * @param col column of desired char/mark.
	 * @return the character at theBoard[row][col].
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	
	/**
	 * Checks if board is full by checking if markCount is equal to 9.
	 * @return true if markCount is 9, false otherwise.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if player X has won. 
	 * @return true if player X has won, false otherwise.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if player O has won.
	 * @return true if player O has won, false otherwise.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Displays the current board state using x's, o's and spaces along with headers.
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
	 * Adds a mark at the desired row and col with the desired mark.
	 * @param row row at which to place the mark.
	 * @param col column which to place the mark.
	 * @param mark the mark to be placed.
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the board of x's and o's and replaces them with spaces.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	
	/**
	 * Checks if player with mark has won the game.
	 * @param mark mark to be checked.
	 * @return 1 if the player with mark has won, 0 otherwise.
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
	 * Displays the column headers.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Displays hyphens as row borders/gridlines.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Displays spaces as column borders/gridlines.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
