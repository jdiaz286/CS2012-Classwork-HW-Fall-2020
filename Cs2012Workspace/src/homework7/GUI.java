/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 7
 */

package homework7;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends BorderPane {
	private int numOfRows;
	private int numOfColumns;
	private int currentRow;
	private int currentColumn;
	private static GridPane gp = new GridPane();
	private static Label cursorLocationLabel = new Label("0,0");

	// constructor that sets the number of rows and columns
	public GUI(int numberOfRows, int numberOfColumns) {
		numOfRows = numberOfRows;
		numOfColumns = numberOfColumns;
	}

	// method to run the GUI
	public void runGUI(Stage primaryStage) throws Exception {
		gp.setFocusTraversable(true);
		Label cursorLabel = new Label("Cursor Location: ");
		cursorLabel.getStyleClass().add("topLeftLabels");
		cursorLocationLabel.getStyleClass().add("topLeftLabels");
		Label shakeLabel = new Label("Shake");
		shakeLabel.getStyleClass().add("topRightLabels");
		
		// event handler to be able to "shake" by reverting all labels back to normal
		shakeLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				for (int rowCounter = 0; rowCounter < numOfRows; rowCounter++) {
					for (int colCounter = 0; colCounter < numOfColumns; colCounter++) {
						Label labelToChange = (Label) getLabel(gp, colCounter, rowCounter);
						labelToChange.getStyleClass().remove("traversedLabel");
						labelToChange.getStyleClass().remove("nonTraversedLabel");
						labelToChange.getStyleClass().remove("currentLocationLabel");
						if (colCounter == currentColumn && rowCounter == currentRow) {
							labelToChange.getStyleClass().add("currentLocationLabel");
						}
						else {
							labelToChange.getStyleClass().add("nonTraversedLabel");
						}
						
					}
				}
			}
		});

		HBox mainCenterBox = new HBox();
		mainCenterBox.getStyleClass().add("topCenterStyle");
		mainCenterBox.getChildren().add(cursorLabel);
		mainCenterBox.getChildren().add(cursorLocationLabel);
		mainCenterBox.getChildren().add(shakeLabel);

		Scene sc = new Scene(this, 750, 700);
		sc.getStylesheets().add(getClass().getResource("Homework7.css").toExternalForm());

		for (int rowCounter = 0; rowCounter < numOfRows; rowCounter++) {
			for (int colCounter = 0; colCounter < numOfColumns; colCounter++) {
				Label l = new Label("");
				if (colCounter == 0 && rowCounter == 0) {
					l.setMinWidth(10);
					l.setMinHeight(10);
					l.getStyleClass().add("currentLocationLabel");
				} else {
					l.setMinWidth(10);
					l.setMinHeight(10);
					l.getStyleClass().add("nonTraversedLabel");
				}

				gp.add(l, colCounter, rowCounter);
			}
		}
		this.setTop(mainCenterBox);
		this.setCenter(gp);
		primaryStage.setTitle("Etch-A-Sketch");
		primaryStage.setScene(sc);
		primaryStage.show();
	}

	// method to make it easier to be able to use in event handler method
	public void changeCurrentPosition(int desiredRow, int desiredColumn) {
		Label labelToChange = (Label) getLabel(gp, desiredColumn, desiredRow);
		labelToChange.getStyleClass().remove("nonTraversedLabel");
		labelToChange.getStyleClass().add("traversedLabel");
		labelToChange.getStyleClass().add("currentLocationLabel");

	}

	public void changeOldSpaceBackground(int oldRow, int oldCol) {
		Label labelToChange = (Label) getLabel(gp, oldCol, oldRow);
		labelToChange.getStyleClass().remove("currentLocationLabel");
		labelToChange.getStyleClass().add("traversedLabel");

	}

	// method to update the label
	public void updateCursorLocationLabel() {
		String updatedText = currentRow + ", " + currentColumn;
		cursorLocationLabel.setText(updatedText);
	}

	// getters and setters
	public int returnCurrentRow() {
		return currentRow;
	}

	public int returnCurrentColumn() {
		return currentColumn;
	}

	public void setCurrentRow(int inputRow) {
		currentRow = inputRow;
	}

	public void setCurrentColumn(int inputColumn) {
		currentColumn = inputColumn;
	}

	
	public Node getLabel(GridPane gp, int col, int row) {
		// method to get any label
		for (Node currentLabel : gp.getChildren()) {
			if (GridPane.getColumnIndex(currentLabel) == col && GridPane.getRowIndex(currentLabel) == row) {
				return currentLabel;
			}
		}
		return null;
	}

}
