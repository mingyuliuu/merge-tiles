// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// The class treats the game board as an array of nodes, each containing
// the number on the tile/board, x and y locations and the dimensions. 

public class MyNode {

	private int num;
	private double x;
	private double y;
	private double width;
	private double height;

	// The constructor sets the number on the tile, position and dimensions.
	public MyNode(int num, double x, double y, double width, double height) {

		this.num = num;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	// The method returns an ImageView of a node to display the node.
	public ImageView display() throws FileNotFoundException {

		GetImage gi =  new GetImage();
		Image a = gi.getImage(num);
		ImageView a1 = new ImageView(a); 
		a1.setX(x); 
		a1.setY(y); 
		a1.setFitHeight(width); 
		a1.setFitWidth(height);
		a = null;
		return a1;

	}

}
