// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

// The Main class includes the main method which enables all the 
// JavaFX graphics and user interactions. It first sets the starting
// menu and the "HOW TO PLAY" button. When 5*5 or 7*7 is clicked, 
// a GUI object will be created to take care of corresponding graphics.

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception  {

		Text text = new Text(182, 180, "Merge Tiles");
		text.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40));
		text.setFill(Color.rgb(255, 255, 204));

		Rectangle rec1 = new Rectangle(210, 300, 180, 40);  
		rec1.setArcWidth(20); 
		rec1.setArcHeight(20); 
		rec1.setFill(Color.ALICEBLUE);
		Text ins1 = new Text(228, 328, "HOW TO PLAY");
		ins1.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 20));
		ins1.setFill(Color.CADETBLUE);

		Rectangle rec2 = new Rectangle(210, 350, 180, 40);  
		rec2.setArcWidth(20); 
		rec2.setArcHeight(20); 
		rec2.setFill(Color.ALICEBLUE);
		Text ins2 = new Text(275, 378, "5 * 5");
		ins2.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 20));
		ins2.setFill(Color.CADETBLUE);

		Rectangle rec3 = new Rectangle(210, 400, 180, 40);  
		rec3.setArcWidth(20); 
		rec3.setArcHeight(20); 
		rec3.setFill(Color.ALICEBLUE);
		Text ins3 = new Text(275, 428, "7 * 7");
		ins3.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 20));
		ins3.setFill(Color.CADETBLUE);

		Group rootOpen = new Group(text, rec1, rec2, rec3, ins1, ins2, ins3);

		for(int i=1; i<4; i++) {
			MyNode node = new MyNode(i, 100, i*80+170, 50, 50);
			rootOpen.getChildren().add(node.display());
		}

		for(int i=4; i<7; i++) {
			MyNode node = new MyNode(i, 450, i*80-70, 50, 50);
			rootOpen.getChildren().add(node.display());
		}

		Scene scene = new Scene(rootOpen ,600, 600, Color.LIGHTBLUE);
		primaryStage.setTitle("Merge Tiles!");
		primaryStage.setScene(scene);
		primaryStage.show();

		// When the first button (HOW TO PLAY) is clicked, a new
		// window showing the instructions will come out.
		EventHandler<MouseEvent> click1 = new EventHandler<MouseEvent>() { 

			public void handle(MouseEvent e) { 

				Text howToPlay = new Text(300, 200, ""
						+ "  Use left & right direction keys to rotate the current tiles."
						+ "\n             Drag and place the tiles onto empty cells."
						+ "\nThree or more tiles of the same number placed adjacently"
						+ "\n         will merge into one tile of the higher number."
						+ "\n   Three or more Ms (merged by 6s) placed together will "
						+ "\n                     clear the 3*3 area around it."
						+ "\n      Try to place and merge as many tiles as you can!");
				howToPlay.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 18));
				howToPlay.setFill(Color.WHITE);

				StackPane instructions = new StackPane();
				instructions.getChildren().add(howToPlay);

				Scene sceneI = new Scene(instructions, 600, 200);
				sceneI.setFill(Color.LIGHTPINK);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Instructions");
				newWindow.setScene(sceneI);
				newWindow.initModality(Modality.WINDOW_MODAL);
				newWindow.initOwner(primaryStage);

				newWindow.show();
			} 
		};  
		ins1.addEventFilter(MouseEvent.MOUSE_CLICKED, click1); 

		EventHandler<MouseEvent> click2 = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				GUI g5 = new GUI(5);
				g5.set();
			} 
		};  
		ins2.addEventFilter(MouseEvent.MOUSE_CLICKED, click2); 

		EventHandler<MouseEvent> click3 = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				GUI g7 = new GUI(7);
				g7.set();
			}
		};  
		ins3.addEventFilter(MouseEvent.MOUSE_CLICKED, click3); 

	}

	public static void main(String[] args) {
		launch(args);
	}

}
