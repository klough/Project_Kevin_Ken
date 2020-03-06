package tictactoe;

import java.io.IOException;
/**
 * Implementation of a referee of a tic tac toe game.
 * @author Kevin
 * xPlayer the player playing with mark x.
 * oPlayer the player playing with mark o.
 * board the board the players are to play on.
 */
public class Referee {
	Player xPlayer;
	Player oPlayer;
	private Board board;
	
	/**
	 * sets each player as the other's opponent, displays the board, then prompts xPlayer to play.
	 * @throws IOException
	 */
	public void runTheGame() throws IOException
	{
		xPlayer.opponent = oPlayer;
		oPlayer.opponent = xPlayer;
		this.board.display();
		xPlayer.play();
	}
	
	/**
	 * sets the player as oPlayer.
	 * @param oPlayer the player to assign to oPlayer.
	 */
	public void setoPlayer(Player oPlayer)
	{
		this.oPlayer = oPlayer;
	}
	
	/**
	 * sets the player as xPlayer.
	 * @param xPlayer the player to assign to xPlayer.
	 */
	public void setxPlayer(Player xPlayer)
	{
		this.xPlayer = xPlayer;
	}
	
	/**
	 * Getter for the board.
	 * @return this board.
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * setter for the board.
	 * @param board the board to be assigned.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
}
