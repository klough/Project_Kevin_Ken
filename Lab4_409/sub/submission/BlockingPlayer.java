

public class BlockingPlayer extends RandomPlayer{

	public BlockingPlayer(String name, char mark) {
		super(name, mark);
		
	}
	
	@Override
	public void makeMove() {
		for(int row = 0; row<3; row++)
		{
			for(int col = 0; col<3; col++)
			{
				if(this.board.getMark(row, col)== ' ' && testForBlocking(row, col))
				{
					this.board.addMark(row, col, this.mark);
					return;
				}
			}
		}
		makeRandomMove();
	}
	
	public boolean testForBlocking(int row, int col)
	{
		boolean needsBlocking = false;
		int marksInRow = 0;
		int marksInCol = 0;
		int marksInLeftTopDiag = 0;
		int marksInRightTopDiag = 0;
		
		for(int i = 0; i<3; i++)
		{
			if(this.board.getMark(row, i)==this.getOpponent().getMark())
			{
				marksInRow++;
			}
			if(this.board.getMark(i, col)==this.getOpponent().getMark())
			{
				marksInCol++;
			}
			if(this.board.getMark(i, i)==this.getOpponent().getMark())
			{
				marksInLeftTopDiag++;
				if(i == 1)
				{
					marksInRightTopDiag++;
				}
			}
			if(i == 2)
			{
				if(this.board.getMark(i, 0)==this.getOpponent().getMark())
				{
					marksInRightTopDiag++;
				}
				if(this.board.getMark(0, i)==this.getOpponent().getMark())
				{
					marksInRightTopDiag++;
				}
			}
		}
		if(marksInRow == 2 || marksInCol == 2 || (row == col) && marksInLeftTopDiag == 2 || (row + col == 2) && marksInRightTopDiag == 2)
		{
			needsBlocking = true;
		}
		return needsBlocking;
	}
}
