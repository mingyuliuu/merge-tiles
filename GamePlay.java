// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.util.Random;

// This class takes care of the game-playing part of the program, 
// including generating random tiles, merging and clearing.

public abstract class GamePlay {

	private int numPossi = 7;
	// The possibilities for each number: 25%, 20%, 20%, 15%, 10%, 5%, 5%
	private double bias[] = {0.25, 0.45, 0.65, 0.80, 0.90, 0.95, 1};
	private Random random = new Random();
	Boolean marked[][];
	private int[][] arr;
	private int score;
	private int numSame;
	private int aX, aY;

	// The constructor sets the initial array representing the board, 
	// and sets the size of another array called marked according to it.
	public GamePlay(int[][] array) {
		arr = array;
		marked = new Boolean[arr.length][arr.length];
	}

	// The generateTiles() method is abstract because Level5 and Level7
	// will have their own unique rules of generating tiles.
	public abstract int[] generateTiles();

	// This method can generate a random number from 1 to 7 according to the bias.
	public int roll() {
		double randNum = random.nextDouble();
		for(int i=0; i<bias.length-1; i++) {
			if(randNum<=bias[i]) 
				return i+1;
			else if(randNum>bias[i] && randNum<=bias[i+1]) {
				return i+2;
			}
		}
		return numPossi;
	}

	// This method is used to merge if possible when only one tile is placed.
	public int[][] merge1(int array[][], int aX, int aY, int score) {
		int a = array[aX][aY];
		arr = array;
		this.score = score;

		while(numSame(arr, a, aX, aY)>=3) {
			arr = mergeOne(arr, a, aX, aY);
			a = arr[aX][aY];
			if(a==0)
				break;
		}
		array = null;
		return arr;
	}

	// This method is used to merge if possible when two tiles are placed.
	public int[][] merge2(int array[][], int aX, int aY, int bX, int bY, int score) {
		int a = array[aX][aY];
		int b = array[bX][bY];
		arr = array;
		this.score = score;

		while(numSame(arr, a, aX, aY)>=3 || numSame(arr, b, bX, bY)>=3) {
			if(numSame(arr, a, aX, aY)>=3) {
				arr = mergeOne(arr, a, aX, aY);
				a = arr[aX][aY];
				if(a==0)
					break;
			}
			if(numSame(arr, b, bX, bY)>=3) {
				arr = mergeOne(arr, b, bX, bY);
				b = arr[bX][bY];
				if(b==0)
					break;
			}
		}
		array = null;
		return arr;

	}

	// This method helps to do one merge.
	public int[][] mergeOne(int array[][], int a, int aX, int aY) {

		arr = array;

		if(a==7) {
			arr = clear(arr, aX, aY);
			score+=50;
		}
		else {
			score+=a*5;
			arr[aX][aY]++;
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(marked[i][j]) {
					arr[i][j] = 0;
				}
			}
		}

		array = null;
		return arr;

	}

	// This method is able to return the number of tiles with the same number
	// placed together. It does so by using the Stack ADT. It also marks down 
	// those tiles with the same number in the marked array for future use. 
	public int numSame(int array[][], int a, int xPos, int yPos) {

		arr = array;
		numSame = 1;
		int start[] = {xPos, yPos};
		Stack stack = new Stack(start);
		
		Boolean ifChecked[][] = new Boolean[arr.length][arr.length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				marked[i][j] = false;
				ifChecked[i][j] = false;
			}
		}

		ifChecked[xPos][yPos] = true;

		while(stack.size()>0) {
			start = (int[]) stack.pop();
			aX = start[0];
			aY = start[1];

			if(aY>0) {
				if(arr[aX][aY-1]==a && ifChecked[aX][aY-1]==false) { // The one on the left
					numSame++;
					int temp[] = {aX, aY-1};
					stack.push(temp);
					ifChecked[aX][aY-1] = true;
					marked[aX][aY-1] = true;
				}
			}
			if(aX>0) {
				if(arr[aX-1][aY]==a && ifChecked[aX-1][aY]==false) { // The one on the top
					numSame++;
					int temp[] = {aX-1, aY};
					stack.push(temp);
					ifChecked[aX-1][aY] = true;
					marked[aX-1][aY] = true;
				}
			}
			if(aX<arr.length-1) {
				if(arr[aX+1][aY]==a && ifChecked[aX+1][aY]==false) { // The one on the bottom
					numSame++;
					int temp[] = {aX+1, aY};
					stack.push(temp);
					ifChecked[aX+1][aY] = true;
					marked[aX+1][aY] = true;
				}
			}
			if(aY<arr.length-1) {
				if(arr[aX][aY+1]==a && ifChecked[aX][aY+1]==false) { // The one on the right
					numSame++;
					int temp[] = {aX, aY+1};
					stack.push(temp);
					ifChecked[aX][aY+1] = true;
					marked[aX][aY+1] = true;
				}
			}
		}

		stack = null;
		array = null;
		return numSame;

	}

	// The method is used to clear the 3*3 area around if 3 or more Ms are placed together.
	public int[][] clear(int array[][], int xPos, int yPos) {
		array[xPos][yPos] = 0;
		if(xPos>0) {
			array[xPos-1][yPos] = 0;
			if(yPos>0)
				array[xPos-1][yPos-1] = 0;
			if(yPos<array.length-1)
				array[xPos-1][yPos+1] = 0;
		}
		if(yPos>0) {
			array[xPos][yPos-1] = 0;
			if(xPos<array.length-1)
				array[xPos+1][yPos-1] = 0;
		}
		if(xPos<array.length-1) {
			array[xPos+1][yPos] = 0;
			if(yPos<array.length-1)
				array[xPos+1][yPos+1] = 0;
		}
		if(yPos<array.length-1)
			array[xPos][yPos+1] = 0;
		return array;
	}

	// The method returns the current score. 
	public int getScore() {
		return score;
	}
	
}
