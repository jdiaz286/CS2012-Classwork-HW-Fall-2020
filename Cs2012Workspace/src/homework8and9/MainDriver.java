/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 8 and 9
 */

package homework8and9;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainDriver extends Application {
	public static void main(String[] args) {
		// main method
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		// dont forget to set running to false if ending text.equals("E")
		GridPane gp = new GridPane();
		Scene sc = new Scene(gp, 750, 650);
		// sc.getStylesheets().add(getClass().getResource("PastureGUIPane.css").toExternalForm());
		PastureGUIPane myGUIPane = new PastureGUIPane();
		Coordinate playerCoordinate = new Coordinate();
		Coordinate cow1 = new Coordinate();
		Coordinate cow2 = new Coordinate();
		Coordinate cow3 = new Coordinate();
		Coordinate cow4 = new Coordinate();
		Coordinate cow5 = new Coordinate();
		PastureMap mapForCows = new PastureMap();
		myGUIPane.runGUI(arg0);
		boolean running=true;
		myGUIPane.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					System.out.println("Hitting up key");
					int desireRow = playerCoordinate.getRow() - 1;
					int desireCol = playerCoordinate.getColumn();
					boolean isValidPoint = playerCoordinate.isInRange(desireRow, desireCol);
					if (isValidPoint) {
						myGUIPane.setPlayerPosition(playerCoordinate);
						playerCoordinate.setColumn(desireCol);
						playerCoordinate.setRow(desireRow);
						System.out.println("Col: "+playerCoordinate.getColumn()+" Row: "+playerCoordinate.getRow());

						// running=myGUIPane.checkIfOver();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.DOWN) {
					System.out.println("Hitting down key");
					int desireRow = playerCoordinate.getRow() + 1;
					int desireCol = playerCoordinate.getColumn();
					boolean isValidPoint = playerCoordinate.isInRange(desireRow, desireCol);
					if (isValidPoint) {
						myGUIPane.setPlayerPosition(playerCoordinate);
						playerCoordinate.setColumn(desireCol);
						playerCoordinate.setRow(desireRow);
						System.out.println("Col: "+playerCoordinate.getColumn()+" Row: "+playerCoordinate.getRow());
						// running=myGUIPane.checkIfOver();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.LEFT) {
					System.out.println("Hitting up key");
					int desireRow = playerCoordinate.getRow();
					int desireCol = playerCoordinate.getColumn() - 1;
					boolean isValidPoint = playerCoordinate.isInRange(desireRow, desireCol);
					if (isValidPoint) {
						myGUIPane.setPlayerPosition(playerCoordinate);
						playerCoordinate.setColumn(desireCol);
						playerCoordinate.setRow(desireRow);
						System.out.println("Col: "+playerCoordinate.getColumn()+" Row: "+playerCoordinate.getRow());
						// running=myGUIPane.checkIfOver();
					} else {
						System.out.println("The point is not valid");
					}
				} else if (event.getCode() == KeyCode.RIGHT) {
					System.out.println("Hitting up key");
					int desireRow = playerCoordinate.getRow();
					int desireCol = playerCoordinate.getColumn() + 1;
					boolean isValidPoint = playerCoordinate.isInRange(desireRow, desireCol);
					if (isValidPoint) {
						myGUIPane.setPlayerPosition(playerCoordinate);
						playerCoordinate.setColumn(desireCol);
						playerCoordinate.setRow(desireRow);
						System.out.println("Col: "+playerCoordinate.getColumn()+" Row: "+playerCoordinate.getRow());
						// running=myGUIPane.checkIfOver();
					} else {
						System.out.println("The point is not valid");
					}
				}

			}
		});

	}
	public void handle(final KeyEvent keyEvent) {
		
	}
}
