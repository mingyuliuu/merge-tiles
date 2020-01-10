// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// This class is used to set parameters to display the current tile(s) in the circle.

public class DisplayCurrent extends ImageView {

	private int numCase;
	private int level;
	private int num1;
	private int num2;

	// The constructor gathers information including: whether the tiles are placed vertically
	// or horizontally, whether the board is 5*5 or 7*7, and number(s) on the tile(s) generated. 
	public DisplayCurrent(int arr[], int level) {

		this.numCase = arr[0];
		this.level = level;
		this.num1 = arr[1];
		this.num2 = arr[2];

	}

	// This method deals with the situation when there's only one upcoming tile.
	// It sets the location and dimensions, and returns the ImageView of the current tile.
	public ImageView displayOne() throws FileNotFoundException {

		GetImage gi =  new GetImage();
		Image a = gi.getImage(num1);
		ImageView a1 = new ImageView(a);

		a1.setX(275); 
		a1.setY(484);
		a1.setFitHeight(50); 
		a1.setFitWidth(50);

		a = null;
		return a1;
	}

	// This method deals with the situation when there are two upcoming tiles.
	// It sets the location and dimensions of each individual tile. 
	// It returns the ImageView of one of the current tiles each time, 
	// so it is called twice every time in order to display both tiles.
	public ImageView displayTwo(int c) throws FileNotFoundException {

		int num;

		if(c==1)
			num = num1;
		else
			num = num2;

		GetImage gi =  new GetImage();
		ImageView a1 = new ImageView(gi.getImage(num));

		if(level==5) {
			if(numCase==1) { // Vertical
				a1.setX(275); 
				if(c==1) 
					a1.setY(458); 
				else 
					a1.setY(510);
			}

			if(numCase==2) { // Horizontal
				a1.setY(484); 
				if(c==1) 
					a1.setX(249); 
				else 
					a1.setX(301);
			}
		}

		if(level==7) {
			if(numCase==1) { // Vertical
				a1.setX(348); 
				if(c==1) 
					a1.setY(604); 
				else 
					a1.setY(656);
			}

			if(numCase==2) { // Horizontal
				a1.setY(630); 
				if(c==1) 
					a1.setX(322); 
				else 
					a1.setX(374);
			}
		}

		a1.setFitHeight(50); 
		a1.setFitWidth(50);
		
		return a1;
	}

}
