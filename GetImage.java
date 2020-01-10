// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

// This class is used to get corresponding images.

public class GetImage {

	// The method returns an image based on the number passed in as a parameter.
	public Image getImage(int num) throws FileNotFoundException {
		
		Image a = null;

		switch(num) {
		case -1:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/a.jpg"));
			break;
		case -2:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/b.jpg"));
			break;
		case -3:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/c.jpg"));
			break;
		case -4:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/d.jpg"));
			break;
		case -5:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/e.jpg"));
			break;
		case -6:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/f.jpg"));
			break;
		case -7:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/g.jpg"));
			break;
		case 0:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 0.jpg"));
			break;
		case 1:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 1.jpg"));
			break;
		case 2:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 2.jpg"));
			break;
		case 3:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 3.jpg"));
			break;
		case 4:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 4.jpg"));
			break;
		case 5:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 5.jpg"));
			break;
		case 6:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile 6.jpg"));
			break;
		case 7:
			a = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Tile M.jpg"));
			break;
		}

		return a;
	}
}
