// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

// The class takes care of graphics display and user interactions (keyboard 
// input and mouse drag).

public class GUI {

	protected Stage primaryStage;
	protected int score = 0;
	protected int num;

	protected int [][]arr;

	protected Boolean gameOver = false;
	protected Boolean isUpdatedB = false;
	protected Boolean isUpdatedT = false;
	protected Boolean undo = false;

	protected GamePlay play;
	protected int []currentTiles;

	protected ImageView a = new ImageView();
	protected ImageView b = new ImageView();
	protected Group root = new Group();
	protected Scene scene;

	protected int caseTile = 0;

	protected GetImage clipboard = new GetImage();

	protected Stack field = new Stack();
	protected Stack tiles = new Stack();
	protected Stack sc = new Stack();
	protected int lastUndo = 0;

	// The GUI class will be instantiated in the Main class to allow 
	// graphics and user interactions for both 5*5 and 7*7 levels. 
	// A number representing the level is passed in through the constructor. 
	// And different dimensions and colors for the scenes are initialized.
	public GUI(int n) {
		num = n;
		arr = new int[n][n];
		if(n==5) {
			play = new Level5(arr);
			scene = new Scene(root, 600, 600, Color.LIGHTBLUE);
		}
		else if(n==7) {
			play = new Level7(arr);
			scene = new Scene(root, 746, 746, Color.rgb(180, 228, 204));
		}
		currentTiles = play.generateTiles();
	}

	// When the ? button is clicked, instructions will come out. 
	// This method helps to set the five pages of instructions.
	public void setIns() {
		Image p1= null, f1 = null;
		try {
			p1 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/P1.png"));
			f1 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/FORWARD.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView P1 = new ImageView(p1);
		P1.setFitHeight(360); 
		P1.setFitWidth(600);
		ImageView F1 = new ImageView(f1);
		F1.setX(545); 
		F1.setY(305);
		F1.setFitHeight(50); 
		F1.setFitWidth(50);

		Group insP1 = new Group(P1, F1);
		Scene scene1 = new Scene(insP1, 600, 360);

		Image p2= null, b2 = null, f2 = null;
		try {
			p2 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/P2.png"));
			b2 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/BACK.png"));
			f2 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/FORWARD.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView P2 = new ImageView(p2);
		P2.setFitHeight(360); 
		P2.setFitWidth(600);
		ImageView B2 = new ImageView(b2);
		B2.setX(5); 
		B2.setY(305);
		B2.setFitHeight(50); 
		B2.setFitWidth(50);
		ImageView F2 = new ImageView(f2);
		F2.setX(545); 
		F2.setY(305);
		F2.setFitHeight(50); 
		F2.setFitWidth(50);

		Group insP2 = new Group(P2, F2, B2);
		Scene scene2 = new Scene(insP2, 600, 360);

		Image p3= null, b3 = null, f3 = null;
		try {
			p3 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/P3.png"));
			b3 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/BACK.png"));
			f3 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/FORWARD.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView P3 = new ImageView(p3);
		P3.setFitHeight(360); 
		P3.setFitWidth(600);
		ImageView B3 = new ImageView(b3);
		B3.setX(5); 
		B3.setY(305);
		B3.setFitHeight(50); 
		B3.setFitWidth(50);
		ImageView F3 = new ImageView(f3);
		F3.setX(545); 
		F3.setY(305);
		F3.setFitHeight(50); 
		F3.setFitWidth(50);

		Group insP3 = new Group(P3, F3, B3);
		Scene scene3 = new Scene(insP3, 600, 360);

		Image p4= null, b4 = null, f4 = null;
		try {
			p4 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/P4.png"));
			b4 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/BACK.png"));
			f4 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/FORWARD.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView P4 = new ImageView(p4);
		P4.setFitHeight(360); 
		P4.setFitWidth(600);
		ImageView B4 = new ImageView(b4);
		B4.setX(5); 
		B4.setY(305);
		B4.setFitHeight(50); 
		B4.setFitWidth(50);
		ImageView F4 = new ImageView(f4);
		F4.setX(545); 
		F4.setY(305);
		F4.setFitHeight(50); 
		F4.setFitWidth(50);

		Group insP4 = new Group(P4, B4, F4);
		Scene scene4 = new Scene(insP4, 600, 360);

		Image p5= null, b5 = null;
		try {
			p5 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/P5.png"));
			b5 = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/BACK.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView P5 = new ImageView(p5);
		P5.setFitHeight(360); 
		P5.setFitWidth(600);
		ImageView B5 = new ImageView(b5);
		B5.setX(5); 
		B5.setY(305);
		B5.setFitHeight(50); 
		B5.setFitWidth(50);

		Group insP5 = new Group(P5, B5);
		Scene scene5 = new Scene(insP5, 600, 360);

		Stage newWindow = new Stage();
		newWindow.setTitle("Instructions");
		newWindow.setScene(scene1);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.initOwner(primaryStage);

		newWindow.show();

		F1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene2);
			}
		});
		B2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene1);
			}
		});
		F2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene3);
			}
		});
		B3.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene2);
			}
		});
		F3.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene4);
			}
		});
		B4.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene3);
			}
		});
		F4.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene5);
			}
		});
		B5.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newWindow.setScene(scene4);
			}
		});
	}

	// The method determines whether the game is over based on the upcoming tile(s).
	public Boolean isDead(int[][] array, int[] current) {
		if(current[0]==0) {
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array.length; j++) {
					if(array[i][j]==0) {
						current = null;
						array = null;
						return false;
					}
				}
			}
			return true;
		}
		else {
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array.length; j++) {
					if(array[i][j]==0) {
						if(i==0 && j==0) {
							if(array[i+1][j]==0 || array[i][j+1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(i==array.length-1 && j==0) {
							if(array[i-1][j]==0 || array[i][j+1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(i==0 && j==array.length-1) {
							if(array[i+1][j]==0 || array[i][j-1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(i==array.length-1 && j==array.length-1) {
							if(array[i-1][j]==0 || array[i][j-1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(i==0) {
							if(array[i+1][j]==0 || array[i][j-1]==0 || array[i][j+1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(j==0) {
							if(array[i+1][j]==0 || array[i-1][j]==0 || array[i][j+1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(i==array.length-1) {
							if(array[i-1][j]==0 || array[i][j-1]==0 || array[i][j+1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(j==array.length-1) {
							if(array[i+1][j]==0 || array[i-1][j]==0 || array[i][j-1]==0) {
								current = null;
								array = null;
								return false;
							}
						}
						else if(array[i+1][j]==0 || array[i-1][j]==0 || array[i][j-1]==0 || array[i][j+1]==0) {
							current = null;
							array = null;
							return false;
						}
					}
				}
			}
		}
		current = null;
		array = null;
		return true;
	}

	// The method updates the array used to represent the board when new tiles are 
	// placed onto the game board. It also updates the score based on tiles being placed.
	public int[][] placeTiles(int x, int y, int[] current, int[][] array, int c) {
		if(current[0]==0) {
			array[x][y] = current[1];
		}
		else if(c==1) {
			if(current[0]==1) {
				array[x][y] = current[1];
				array[x+1][y] = current[2];
			}
			else {
				array[x][y] = current[1];
				array[x][y+1] = current[2];
			}
		}
		else {
			if(current[0]==1) {
				array[x][y] = current[2];
				array[x-1][y] = current[1];
			}
			else if(current[0]==2) {
				array[x][y] = current[2];
				array[x][y-1] = current[1];
			}
		}
		score+=current[1]+current[2];
		current = null;
		return array;
	}

	// When the player drags tile(s) onto a particular position on the board,
	// the method returns whether it is a valid movement.
	public Boolean isValidMove(int x, int y, int[] current, int[][] array, int c) {

		if(current[0]==0) {
			if(array[x][y]==0) {
				current = null;
				array = null;
				return true;
			}
		}
		else if(c==1) {
			if(current[0]==1) {
				if(x<=array.length-2 && array[x][y]==0 && array[x+1][y]==0) {
					current = null;
					array = null;
					return true;
				}
			}
			if(current[0]==2) {
				if(y<=array.length-2 && array[x][y]==0 && array[x][y+1]==0) {
					current = null;
					array = null;
					return true;
				}
			}
		}
		else {
			if(current[0]==1) {
				if(x>=1 && array[x][y]==0 && array[x-1][y]==0) {
					current = null;
					array = null;
					return true;
				}
			}
			if(current[0]==2) {
				if(y>=1 && array[x][y]==0 && array[x][y-1]==0) {
					current = null;
					array = null;
					return true;
				}
			}
		}
		current = null;
		array = null;
		return false;
	}

	// The method updates the upcoming tile(s) graphically. 
	public void updateTiles(int[] current) {

		DisplayCurrent cur = new DisplayCurrent(current, num);

		if(current[0]==0) {
			try {
				a = cur.displayOne();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			root.getChildren().add(a);
		}
		else {
			try {
				a = cur.displayTwo(1);
				b = cur.displayTwo(2);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			root.getChildren().add(a);
			root.getChildren().add(b);
		}
		isUpdatedT = true;
		current = null;
		cur = null;
	}

	// The method sets the instructions window that is going to 
	// come out when the game is over. 
	public void deadIns(int num, Stage newWindow, Text scoreLine, Group root, int score) {

		Stage newDead = new Stage();
		newDead.initModality(Modality.APPLICATION_MODAL);
		newDead.initOwner(primaryStage);
		Text deadIns = new Text("                 Game Over !\n"
				+ "            Your score was " + score + ".\n");
		deadIns.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 16));
		deadIns.setFill(Color.WHITE);
		deadIns.setLayoutY(35);

		Button button = new Button("OK!");
		button.setLayoutX(130);
		button.setLayoutY(72);

		EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				newDead.close();
				newWindow.close();
			}
		};
		button.addEventFilter(MouseEvent.MOUSE_CLICKED, click); 

		Pane dialogBox = new Pane();
		dialogBox.getChildren().addAll(button, deadIns); 
		dialogBox.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		Scene dialogScene = new Scene(dialogBox, 300, 120, Color.CADETBLUE);
		newDead.setScene(dialogScene);
		newDead.show();

	}

	// The method updates the game board graphically. 
	public void updateBoard(int[][] array) {

		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length; j++) {
				try {
					MyNode node = new MyNode(array[i][j], (j*73+119), (i*73+58), 70, 70);
					root.getChildren().add(node.display());
					node = null;
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		array = null;
		isUpdatedB = true;
	}

	// The method sets the display window, circle, buttons, and takes care of user interactions. 
	public void set() {

		Stage newWindow = new Stage();
		newWindow.setScene(scene);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.initOwner(primaryStage);

		newWindow.show();

		Circle cir = new Circle(num*36.5+117.5, num*73+145, 70);
		cir.setFill(Color.ALICEBLUE);
		root.getChildren().add(cir);

		Image i = null;
		try {
			i = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Button - ?.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Circle cirI = new Circle(50, num*73+105, 35); 
		cirI.setFill(new ImagePattern(i)); 
		cirI.setEffect(new DropShadow(+25d, 0d, +2d, Color.ALICEBLUE));
		root.getChildren().add(cirI);
		cirI.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				setIns();
			}
		});

		Image u = null;
		try {
			u = new Image(new FileInputStream("/Users/mingyuliu/eclipse-workspace/ICS4U - Final Project/src/finalProj/Button - Undo.png"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Circle cirU = new Circle(num*73+185, num*73+105, 35); 
		cirU.setFill(new ImagePattern(u)); 
		root.getChildren().add(cirU);
		cirU.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				undo = true;
			}
		});

		Text scoreLine = new Text(num*36.5+72.5, 34, "Score: "+score);
		scoreLine.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 20));
		scoreLine.setFill(Color.CADETBLUE);
		root.getChildren().add(scoreLine);

		updateTiles(currentTiles);
		updateBoard(arr);
		tiles.push(currentTiles);

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				if(undo) {
					if(lastUndo>0 && field.size()>0 && tiles.size()>0) {
						root.getChildren().remove(a);
						if(currentTiles[0]!=0)
							root.getChildren().remove(b);
						System.out.println(field.size());
						arr = (int[][]) field.pop();

						currentTiles = (int[]) tiles.pop();
						isUpdatedT = false;

						isUpdatedB = false;
						updateBoard(arr);
						isUpdatedB = true;

						score = (int) sc.pop();
						lastUndo = 0;
						field.clear();
						tiles.clear();
						sc.clear();
					}
					undo = false;
				}

				if(lastUndo>0) {
					cirU.setEffect(new DropShadow(+25d, 0d, +2d, Color.ALICEBLUE));
				}
				else
					cirU.setEffect(new DropShadow(0d, 0d, 0d, Color.ALICEBLUE));

				a.setOnDragDetected(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {

						Dragboard db = a.startDragAndDrop(TransferMode.ANY);

						caseTile = 1;

						ClipboardContent content = new ClipboardContent();
						try {
							content.putImage(clipboard.getImage(-1*currentTiles[1]));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						db.setContent(content);

						event.consume();
					}
				});

				b.setOnDragDetected(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {

						Dragboard db = b.startDragAndDrop(TransferMode.ANY);

						caseTile = 2;

						ClipboardContent content = new ClipboardContent();
						try {
							content.putImage(clipboard.getImage(-1*currentTiles[2]));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						db.setContent(content);

						event.consume();
					}
				});

				if(isUpdatedT==false)
					updateTiles(currentTiles);
				if(isUpdatedB==false)
					updateBoard(arr);
				gameOver = isDead(arr, currentTiles);
				scoreLine.setText("Score: "+score);

				if(gameOver) {
					this.stop();
					deadIns(num, newWindow, scoreLine, root, score);
					lastUndo = 0;
					field.clear();
					tiles.clear();
					sc.clear();
				}
			}
		};

		root.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {

				if (event.getGestureSource() != root && event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			}
		});

		root.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {

				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasImage()) {

					double xPos = event.getSceneX();
					double yPos = event.getSceneY();

					int xInd = (int)(xPos-119)/73;
					int yInd = (int)(yPos-58)/73;

					if(xInd>=0 && xInd<=num-1 && yInd>=0 && yInd<=num-1) {
						if(isValidMove(yInd, xInd, currentTiles, arr, caseTile)) {

							lastUndo++;
							int tempc[][] = new int[num][num];
							for(int i=0; i<num; i++) {
								for(int j=0; j<num; j++) {
									tempc[i][j] = arr[i][j];
								}
							}
							field.push(tempc);
							sc.push(score);

							arr = placeTiles(yInd, xInd, currentTiles, arr, caseTile);
							root.getChildren().remove(a);
							if(currentTiles[0]!=0)
								root.getChildren().remove(b);

							isUpdatedT = false;
							if(currentTiles[0]==0) {
								arr = play.merge1(arr, yInd, xInd, score);
								score = play.getScore();
							}
							else if(caseTile==1) {
								if(currentTiles[0]==1) {
									arr = play.merge2(arr, yInd, xInd, yInd+1, xInd, score);
									score = play.getScore();
								}
								else if(currentTiles[0]==2) {
									arr = play.merge2(arr, yInd, xInd, yInd, xInd+1, score);
									score = play.getScore();
								}
							}
							else {
								if(currentTiles[0]==1) {
									arr = play.merge2(arr, yInd, xInd, yInd-1, xInd, score);
									score = play.getScore();
								}
								else if(currentTiles[0]==2) {
									arr = play.merge2(arr, yInd, xInd, yInd, xInd-1, score);
									score = play.getScore();
								}
							}
							tiles.push(currentTiles);
							currentTiles = play.generateTiles();
							updateTiles(currentTiles);
							isUpdatedB = false;
							updateBoard(arr);

						}
					}
					success = true;
				}
				event.setDropCompleted(success);

				event.consume();
			}
		});

		root.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				event.consume();
			}
		});

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(currentTiles[0]!=0) {
					if (event.getCode() == KeyCode.RIGHT) {
						if(currentTiles[0] == 1) {
							currentTiles[0] = 2;
							int temp = currentTiles[1];
							currentTiles[1] = currentTiles[2];
							currentTiles[2] = temp;
						}
						else {
							currentTiles[0] = 1;
						}

						root.getChildren().remove(a);
						root.getChildren().remove(b);
						isUpdatedT = false;

					}

					if (event.getCode() == KeyCode.LEFT) {
						if(currentTiles[0] == 2) {
							currentTiles[0] = 1;
							int temp = currentTiles[1];
							currentTiles[1] = currentTiles[2];
							currentTiles[2] = temp;
						}
						else {
							currentTiles[0] = 2;
						}

						root.getChildren().remove(a);
						root.getChildren().remove(b);
						isUpdatedT = false;

					}
				}
			}
		});

		timer.start();
	}
}
