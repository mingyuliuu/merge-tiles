// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

// The class is a child of the GamePlay because it 
// inherits the basic functionalities of the game.

public class Level5 extends GamePlay {

	public Level5(int[][] array) {
		super(array);
	}

	// Levels 5 and 7 have different rules for generating tiles.
	// In level 5, there is a 30% possibility that only one tile
	// is generated.
	public int[] generateTiles() {

		int[] returned = new int[3];

		double rand = Math.random();
		if(rand<0.3) {
			returned[0] = 0;
			returned[2] = 0;
		}
		else {
			returned[0] = (int)(Math.random()*2)+1;
			returned[2] = roll();
		}
		returned[1] = roll();
		return returned;
	}

}
