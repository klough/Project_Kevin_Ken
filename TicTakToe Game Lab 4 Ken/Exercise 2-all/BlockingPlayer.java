/**
 * 
 */
package lab2;

import java.util.ArrayList;

/**
 * @author Ken
 *
 */
public class BlockingPlayer extends RandomPlayer{

	public BlockingPlayer(String name, char letter) {
		super(name, letter);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void makeMove()  {
		if(testForBlocking()) { //check whether blocking action is needed
			return;
		}
		ArrayList<Integer> rowCol = new ArrayList<Integer>();
		
		do {
			rowCol = super.genRandom(0,2);
		} while (super.getBoard().getMark(rowCol.get(0), rowCol.get(1)) !=' ');
	
	
		//add mark and display board
		super.getBoard().addMark(rowCol.get(0), rowCol.get(1), getMark());

	}
	
	public boolean testForBlocking() {
		
		int countMarks = 0;
		//check for horizontal blocking
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(super.getBoard().getMark(i, j) != super.getMark() && super.getBoard().getMark(i, j) != ' ') {
					countMarks++;
				}
			}
			if(countMarks == 2 && blockRow(i)) {
				return true;
			}
			countMarks = 0;
		}
		countMarks = 0;

		//check for vertical blocking
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(super.getBoard().getMark(j, i) != super.getMark() && super.getBoard().getMark(j, i) != ' ') {
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
			if(super.getBoard().getMark(j, j) != super.getMark() && super.getBoard().getMark(j, j) != ' ') {
				countMarks++;
			}
		}
		if(countMarks == 2 && blockDiagP()) {
			return true;
		}	
		countMarks = 0;
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(2-j, j) != super.getMark() && super.getBoard().getMark(2-j, j) != ' ') {
				countMarks++;
			}
		}
		if(countMarks == 2 && blockDiagN()) {
			return true;
		}		
		
		return false;
	}
	
	//marks blank space for positive diagonal (returns positive if successful) 
	public boolean blockDiagP() {
 		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(j, j) == ' ') {
				super.getBoard().addMark(j, j, getMark());
				return true;
			}
		}
		return false;
	}
	
	//marks blank space for negative diagonal(returns positive if successful) 
	public boolean blockDiagN() {
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(2-j, j) == ' ') {
				super.getBoard().addMark(2-j, j, getMark());
				return true;
			}
		}
		return false;
	}
	
	
	//marks blank space in specified row (returns positive if successful) 
	public boolean blockRow(int row) {
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(row, j) == ' ') {
				super.getBoard().addMark(row, j, getMark());
				return true;
			}
		}
		return false;
	}
	
	//marks blank space in specified column (returns positive if successful) 
	public boolean blockCol(int col) {
		for(int j = 0; j<3; j++) {
			if(super.getBoard().getMark(j, col) == ' ') {
				super.getBoard().addMark(j, col, getMark());
				return true;
			}
		}
		return false;
	}
}
