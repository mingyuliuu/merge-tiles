// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.util.Random;

//The class is a child of the GamePlay because it 
//inherits the basic functionalities of the game.

public class Level7 extends GamePlay {

	private Random random = new Random();
	
	public Level7(int[][] array) {
		super(array);
	}
	
	// Levels 5 and 7 have different rules for generating tiles.
	// In level 7, exactly two tiles are generated each time.
	public int[] generateTiles() {

		int[] returned = new int[3];
		returned[0] = random.nextInt(2)+1;
		returned[1] = roll();
		returned[2] = roll();
		return returned;
	}

}