/**
 * 
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Ken
 *
 */
public class RandomPlayer extends Player{

	public RandomPlayer(String name, char letter) {
		super(name, letter);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void makeMove() {
		// TODO Auto-generated method stub

		ArrayList<Integer> rowCol = new ArrayList<Integer>();
		

		do {
			rowCol = genRandom(0,2);
		} while (super.getBoard().getMark(rowCol.get(0), rowCol.get(1)) !=' ');
	
	
		//add mark and display board
		super.getBoard().addMark(rowCol.get(0), rowCol.get(1), getMark());

	}
	
	public ArrayList<Integer> genRandom(int lo, int hi) {
		ArrayList<Integer> numbs = new ArrayList<Integer>();
		RandomGenerator Rand = new RandomGenerator();
		numbs.add(Rand.discrete(lo, hi));
		numbs.add(Rand.discrete(lo, hi));
		return numbs;
	}

}
