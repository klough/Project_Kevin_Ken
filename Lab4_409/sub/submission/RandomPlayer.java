

public class RandomPlayer extends Player{

	private RandomGenerator randomGen;
	
	public RandomPlayer(String name, char mark) {
		super(name, mark);
		this.randomGen = new RandomGenerator();
	}
	
	@Override
	public void makeMove() 
	{
		makeRandomMove();
	}
	
	public void makeRandomMove()
	{
		boolean validMove = false;
		while(!validMove)
		{
			int row = randomGen.discrete(0, 2);
			int col = randomGen.discrete(0, 2);
			if(this.board.getMark(row, col)== ' ')
			{
				this.board.addMark(row, col, this.mark);
				validMove = true;
			}
		}
	}
	
	public RandomGenerator getRandomGen() {
		return randomGen;
	}

}
