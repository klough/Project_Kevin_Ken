package lab2;

import java.util.ArrayList;

public class SmartPlayer extends BlockingPlayer {

	public SmartPlayer(String name, char letter) {
		super(name, letter);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void makeMove()  {
		if(testForWinning() || testForBlocking() ) { //check for winning action, then for blocking action
			return;
		}
		ArrayList<Integer> rowCol = new ArrayList<Integer>();
		
		do {
			rowCol = super.genRandom(0,2);
		} while (super.getBoard().getMark(rowCol.get(0), rowCol.get(1)) !=' ');
	
	
		//add mark and display board
		super.getBoard().addMark(rowCol.get(0), rowCol.get(1), getMark());
	}

	

	private boolean testForWinning() {
		int countMarks = 0;
		//check for horizontal winning options
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(super.getBoard().getMark(i, j) == super.getMark()) {
					countMarks++;
				}
			}
			if(countMarks == 2 && blockRow(i)) {
				return true;
			}
			countMarks = 0;
		}
		countMarks = 0;

		//check for vertical winning options
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(super.getBoard().getMark(j, i) == super.getMark()) {
					countMarks++;
				}
			}
			if(countMarks == 2 && blockCol(i)) {
				return true;
			}
			countMarks = 0;
		}
		countMarks = 0;
		
		//check diagonals
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(j, j) == super.getMark()) {
				countMarks++;
			}
		}
		if(countMarks == 2 && blockDiagP()) {
			return true;
		}	
		countMarks = 0;
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(2-j, j) == super.getMark()) {
				countMarks++;
			}
		}
		if(countMarks == 2 && blockDiagN()) {
			return true;
		}	
		
		return false; //no winning condition found
	}
}