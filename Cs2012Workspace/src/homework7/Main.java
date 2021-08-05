/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 7
 */

package homework7;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		// main method
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// instantiated Game and GUI classes
		GUI myGUI = new GUI(50, 69);
		Game myGame = new Game(50, 69);

		myGUI.runGUI(arg0);
		myGUI.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				int oldRow=myGUI.returnCurrentRow();
				int oldCol=myGUI.returnCurrentColumn();
				int desireRow = myGame.returnCurrentRow();
				int desireCol = myGame.returnCurrentColumn();
				
				if (event.getCode() == KeyCode.UP) {
					System.out.println("Hitting up");
					desireRow--;
					boolean isValidPoint = myGame.isValidSquare(desireRow, desireCol);
					if (isValidPoint) {
						myGUI.changeOldSpaceBackground(oldRow, oldCol);
						myGame.setCurrentRow(desireRow);
						myGame.setCurrentColumn(desireCol);
						myGUI.setCurrentRow(desireRow);
						myGUI.setCurrentColumn(desireCol);
						myGUI.changeCurrentPosition(desireRow, desireCol);
						myGUI.updateCursorLocationLabel();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.DOWN) {
					System.out.println("Hitting down");
					desireRow++;
					boolean isValidPoint = myGame.isValidSquare(desireRow, desireCol);
					if (isValidPoint) {
						myGUI.changeOldSpaceBackground(oldRow, oldCol);
						myGame.setCurrentRow(desireRow);
						myGame.setCurrentColumn(desireCol);
						myGUI.setCurrentRow(desireRow);
						myGUI.setCurrentColumn(desireCol);
						myGUI.changeCurrentPosition(desireRow, desireCol);
						myGUI.updateCursorLocationLabel();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.LEFT) {
					System.out.println("Hitting left");
					desireCol--;
					boolean isValidPoint = myGame.isValidSquare(desireRow, desireCol);
					if (isValidPoint) {
						myGUI.changeOldSpaceBackground(oldRow, oldCol);
						myGame.setCurrentRow(desireRow);
						myGame.setCurrentColumn(desireCol);
						myGUI.setCurrentRow(desireRow);
						myGUI.setCurrentColumn(desireCol);
						myGUI.changeCurrentPosition(desireRow, desireCol);
						myGUI.updateCursorLocationLabel();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.RIGHT) {
					System.out.println("Hitting right");
					desireCol++;
					boolean isValidPoint = myGame.isValidSquare(desireRow, desireCol);
					if (isValidPoint) {
						myGame.setCurrentRow(desireRow);
						myGame.setCurrentColumn(desireCol);
						myGUI.setCurrentRow(desireRow);
						myGUI.setCurrentColumn(desireCol);
						myGUI.changeOldSpaceBackground(oldRow, oldCol);
						myGUI.changeCurrentPosition(desireRow, desireCol);
						myGUI.updateCursorLocationLabel();
					} else {
						System.out.println("The point is not valid");
					}
				}

			}
		});

	}

}
