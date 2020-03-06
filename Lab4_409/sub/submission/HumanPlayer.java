

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}
	
	@Override 
	public void makeMove()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean validMove = false;
		while(!validMove)
		{
			System.out.println("Please enter your move (Row Col):\n");
			String line="";
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String [] input = line.split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			if(this.board.getMark(row, col)!= ' ')
			{
				System.out.println("Invalid move, there's already a mark there.\n");
			}
			else
			{
				this.board.addMark(row, col, this.mark);
				validMove = true;
			}
		}
	}
	

}
