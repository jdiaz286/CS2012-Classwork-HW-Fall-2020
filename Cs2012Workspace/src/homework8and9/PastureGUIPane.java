/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 8 and 9
 */

package homework8and9;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PastureGUIPane extends BorderPane {
	private static GridPane gp = new GridPane();
	private static Label statusOfGame = new Label("");
	// constructor for this class
	public PastureGUIPane() {

	}

	public void runGUI(Stage primaryStage) throws Exception {
		gp.getStyleClass().add("gridPaneStyle");
		//gp.setFocusTraversable(true);
		

		// main title box in example
		Label headerLabel = new Label("Traverse The Back 40");
		headerLabel.getStyleClass().add("topHeaderLabel");

		// HBox to hold the header label in the center
		HBox mainCenterBox = new HBox();
		mainCenterBox.getStyleClass().add("topHeaderHBox");
		mainCenterBox.getChildren().add(headerLabel);

		Scene sc = new Scene(this, 750, 650);
		sc.getStylesheets().add(getClass().getResource("PastureGUIPane.css").toExternalForm());

		// everything to print out GUI in the beginning
		for (int rowCounter = 0; rowCounter < 21; rowCounter++)
			for (int colCounter = 0; colCounter < 27; colCounter++) {
				Label l = new Label("");
				l.setMinWidth(25);
				l.setMinHeight(25);
				// start label
				if (colCounter == 1 && rowCounter == 0) {
					l.setText("S");
					l.getStyleClass().add("startAndEnd");
				}
				// end label
				else if (colCounter == 25 && rowCounter == 20) {
					l.setText("E");
					l.getStyleClass().add("startAndEnd");
				}
				// outermost labels that can't be changed
				else if ((rowCounter == 0 && colCounter != 1) || (rowCounter == 20 && colCounter != 25)
						|| (colCounter == 26) || (colCounter == 0)) {
					l.getStyleClass().add("greyFence");
				}
				// all the inner labels starting from [1,1] to [19,25]
				else if ((colCounter >= 1 && colCounter <= 25) && (rowCounter >= 1 && rowCounter <= 19)) {
					l.getStyleClass().add("squareSpace");
					// event handler to change playable spaces
					l.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
						@Override
						public void handle(Event event) {
							// if the style is a grey fence...
							if (l.getStyleClass().contains("greyFence")) {
								l.getStyleClass().remove("greyFence");
								l.getStyleClass().add("squareSpace");
								l.setText("");
								System.out.println("Changing the grey fence to playable square");
							}
							// if the style is a green space...
							else if (l.getStyleClass().contains("squareSpace")) {
								l.getStyleClass().remove("squareSpace");
								l.getStyleClass().add("greyFence");
								l.setText("F");
								System.out.println("Changing playable square to a grey fence");
							}
						}
					});
				}
				gp.add(l, colCounter, rowCounter);
			}

		// everything to do with the button is below
		Button runButton = new Button("Run");
		
		runButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("Starting game");
				statusOfGame.setText("Running");
				// this resets all the squares to playable squares
				for (int rowCounter = 1; rowCounter <= 20; rowCounter++)
					for (int colCounter = 1; colCounter <= 26; colCounter++) {
						Label l = new Label("");
						l.getStyleClass().remove("greyFence");
						l.getStyleClass().add("squareSpace");
						gp.add(l, colCounter, rowCounter);
					}

				// the bottom sets the random walls when the "Run" button is pressed
				int numOfFences = 0;
				while (numOfFences < 19) {
					int rangeOfRows = (int) ((Math.random() * (20 - 1)) + 1);
					int rangeOfCols = (int) ((Math.random() * (26 - 1)) + 1);
					// same method as below
					Label labelToChange = (Label) getLabel(gp, rangeOfCols, rangeOfRows);
					labelToChange.getStyleClass().remove("squareSpace");
					labelToChange.setText("F");
					labelToChange.getStyleClass().add("greyFence");

					numOfFences++;
				}
			}

		});

		HBox bottomCenterBox = new HBox();
		bottomCenterBox.getStyleClass().add("bottomHBox");
		bottomCenterBox.getChildren().add(runButton);
		bottomCenterBox.getChildren().add(statusOfGame);

		this.setTop(mainCenterBox);
		this.setCenter(gp);
		this.setBottom(bottomCenterBox);
		primaryStage.setTitle("homework 8 and 9");
		primaryStage.setScene(sc);
		primaryStage.show();
		gp.requestFocus();
		this.requestFocus();
	}

	// helper methods
	public Node getLabel(GridPane gp, int col, int row) {
		//method to get any label
		for (Node currentLabel : gp.getChildren()) {
			if (GridPane.getColumnIndex(currentLabel) == col && GridPane.getRowIndex(currentLabel) == row) {
				return currentLabel;
			}
		}
		return null;
	}

	public void setPlayerPosition(Coordinate playerPosition) {
		// method to set player position on map
		int newRow=playerPosition.getRow();
		int newCol=playerPosition.getColumn();
		Label labelToChange = (Label) getLabel(gp, newCol, newRow);
		if(labelToChange.getStyleClass().contains("greyFence")) {
			//do nothing if new space is fence
			System.out.println("Don't walk into a fence!");
		}
		if(labelToChange.getStyleClass().contains("squareSpace")) {
			labelToChange.getStyleClass().remove("squareSpace");
			Label newPlayerLabel=new Label("");
			newPlayerLabel.getStyleClass().add("playerPosition");
			gp.add(newPlayerLabel, newCol, newRow);
		}
		if(labelToChange.getStyleClass().contains("pasture")) {
			statusOfGame.setText("Game Over");
			
		}
		
		labelToChange.setText("");
		labelToChange.getStyleClass().add("greyFence");
	}
	public void getPlayerPosition() {
		//method to get current player position
	}

	public void setCowPosition(Coordinate cowPosition) {
		// method to set the current position of the cow

	}
	public void getCowPosition() {
		//method to get the current position of the cow
	}
	
	public boolean checkIfOver() {
		boolean running=true;
		if(statusOfGame.getText()=="Game Over!") {
			running=false;
		}
		return running;
	}

}
