

public class SmartPlayer extends BlockingPlayer{

	public SmartPlayer(String name, char mark) {
		super(name, mark);
	}
	
	@Override
	public void makeMove() {
		int blockingRow = -1;
		int blockingCol = -1;
		for(int row = 0; row<3; row++)
		{
			for(int col = 0; col<3; col++)
			{
				if(this.board.getMark(row, col)== ' ' && testForWinning(row, col))
				{
					this.board.addMark(row, col, this.mark);
					return;
				}
				else if(this.board.getMark(row, col)== ' ' && testForBlocking(row, col))
				{
					blockingRow = row;
					blockingCol = col;
				}
			}
		}
		if(blockingRow != -1 && blockingCol != -1)
		{
			this.board.addMark(blockingRow, blockingCol, this.mark);
		}
		else
		{
			makeRandomMove();
		}
	}

	public boolean testForWinning(int row, int col) {
		boolean canWin = false;
		int marksInRow = 0;
		int marksInCol = 0;
		int marksInLeftTopDiag = 0;
		int marksInRightTopDiag = 0;
		
		for(int i = 0; i<3; i++)
		{
			if(this.board.getMark(row, i)==this.getMark())
			{
				marksInRow++;
			}
			if(this.board.getMark(i, col)==this.getMark())
			{
				marksInCol++;
			}
			if(this.board.getMark(i, i)==this.getMark())
			{
				marksInLeftTopDiag++;
				if(i == 1)
				{
					marksInRightTopDiag++;
				}
			}
			if(i == 2)
			{
				if(this.board.getMark(i, 0)==this.getMark())
				{
					marksInRightTopDiag++;
				}
				if(this.board.getMark(0, i)==this.getMark())
				{
					marksInRightTopDiag++;
				}
			}
		}
		if(marksInRow == 2 || marksInCol == 2 || (row == col) && marksInLeftTopDiag == 2 || (row + col == 2) && marksInRightTopDiag == 2)
		{
			canWin = true;
		}
		return canWin;
	}

}
