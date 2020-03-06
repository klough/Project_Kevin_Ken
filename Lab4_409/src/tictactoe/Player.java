package tictactoe;

import java.io.*;

/**
 * Implementation of a player in a tic tac toe game.
 * @author Kevin
 * name Name of the player.
 * board the board the player will play on.
 * opponent the player's opponent.
 * mark the player's chosen mark(x or o).
 */
public abstract class Player {
	String name;
	Board board;
	Player opponent;
	char mark;
	

	/**
	 * Constructor which sets player name and mark.
	 * @param name name to be assigned to player.
	 * @param mark mark to be assigned to player.
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	/**
	 * Player play method, checks if end conditions are met and prints result; if end conditions has not been met, calls makeMove, displays board, then pass to opponent.
	 * @throws IOException
	 */
	public void play()
	{
		boolean full = this.board.isFull();
		boolean xWin = this.board.xWins();
		boolean oWin = this.board.oWins();
		
		if(full && !xWin && !oWin)
		{
			//this.board.display();
			System.out.println("Game Over: TIE\n");
		}
		else if(xWin||oWin)
		{
			//this.board.display();
			System.out.printf("Game Over: %s WINS\n", opponent.name);
		}
		else
		{
			this.makeMove();
			this.board.display();
			this.opponent.play();
		}
	}
	/**
	 * Prompts the user to make a move, places mark only if move is valid.
	 * @throws IOException
	 */
	abstract public void makeMove();
	
	/**
	 * sets the player's opponent.
	 * @param opp the opponent.
	 */
	public void setOpponent(Player opp)
	{
		this.opponent = opp;
	}
	/**
	 * sets the player's board.
	 * @param theBoard the board.
	 */
	public void setBoard(Board theBoard)
	{
		this.board = theBoard;
	}
	
	public Player getOpponent() {
		return opponent;
	}

	public char getMark() {
		return mark;
	}
}
