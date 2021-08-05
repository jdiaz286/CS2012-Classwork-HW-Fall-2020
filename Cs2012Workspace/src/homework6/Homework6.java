/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 6
 */

package homework6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * Note that the css file is supposed to be placed outside of the 
 * package, if you want to make the css file work while inside of the 
 * the package then you will have to change the line of code that
 * gets the style sheet.
 */

public class Homework6 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Homework 6");
		BorderPane bp = new BorderPane();
		bp.getStyleClass().add("grid");

		GridPane gp = new GridPane();
		gp.setPrefHeight(500);
		Label mainTitle = new Label("Reverse Multiplication Table ");

		HBox mainTitleBox = new HBox();
		mainTitleBox.getStyleClass().add("mainTitleBox");
		mainTitleBox.getChildren().add(mainTitle);

		Label textLabel = new Label("Enter Answer: ");
		TextField inputField = new TextField();
		inputField.setPrefHeight(8);
		Button findProblems = new Button("Find Problems");
		HBox inputHBox = new HBox();
		inputHBox.getStyleClass().add("inputHBox");
		inputHBox.getChildren().add(textLabel);
		inputHBox.getChildren().add(inputField);
		inputHBox.getChildren().add(findProblems);

		Scene sc = new Scene(bp);
		primaryStage.setHeight(650);
		primaryStage.setWidth(820);
		//if you are having problems running then you are going to have change this line of code below
		sc.getStylesheets().add("Homework6Style.css");
		for (int rowCounter = 0; rowCounter < 11; rowCounter++)
			for (int colCounter = 0; colCounter < 11; colCounter++) {
				Label l = new Label(rowCounter + ", " + colCounter);
				l.setMinWidth(73);
				l.setMinHeight(45);
				if (colCounter == 0) {
					l.setText((rowCounter) + "");
					l.getStyleClass().add("firstLabel");
				} else if (rowCounter == 0) {
					l.setText((colCounter) + "");
					l.getStyleClass().add("firstLabel");
				} else {
					l.setText(rowCounter+ " * " + colCounter);
					l.getStyleClass().add("productLabels");
					l.setTextFill(Color.web("#10de02"));
				}

				gp.add(l, colCounter, rowCounter);
			}
		
		//event handler to try and find the products that match the number
		findProblems.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if(inputField.getText()!=null) {
					//print the original labels (like resetting)
					for (int rowCounter = 0; rowCounter < 11; rowCounter++)
						for (int colCounter = 0; colCounter < 11; colCounter++) {
							Label l = new Label(rowCounter + ", " + colCounter);
							l.setMinWidth(73);
							l.setMinHeight(45);
							if (colCounter == 0) {
								l.setText((rowCounter) + "");
								l.getStyleClass().add("firstLabel");
							} else if (rowCounter == 0) {
								l.setText((colCounter) + "");
								l.getStyleClass().add("firstLabel");
							} else {
								l.setText(rowCounter+ " * " + colCounter);
								l.getStyleClass().add("productLabels");
								l.setTextFill(Color.web("#10de02"));
							}

							gp.add(l, colCounter, rowCounter);
						}
					
					//nested loop to try and find the products that match
					for (int rowCounter = 0; rowCounter < 11; rowCounter++)
						for (int colCounter = 0; colCounter < 11; colCounter++) {
							//change the labels to highlighted version
							int userTypedValue=Integer.parseInt(inputField.getText());
							//if the row*column equals the above int then execute...
							int currentProduct=colCounter*rowCounter;
							if(currentProduct==userTypedValue) {
								//add new label 
								Label newLabelToAdd=new Label(rowCounter + " * " + colCounter);
								newLabelToAdd.getStyleClass().add("highlightedAnswer");
								newLabelToAdd.setTextFill(Color.web("#ff5b36"));
								newLabelToAdd.setMinWidth(73);
								newLabelToAdd.setMinHeight(45);
								gp.add(newLabelToAdd, colCounter, rowCounter);
							}
							
						}
				}
				
				//change all the textStyles back to normal if no input when button clicked
				else if(inputField.getText()==null){
					for (int rowCounter = 0; rowCounter < 11; rowCounter++)
						for (int colCounter = 0; colCounter < 11; colCounter++) {
							Label l = new Label(rowCounter + ", " + colCounter);
							l.setMinWidth(73);
							l.setMinHeight(45);
							if (colCounter == 0) {
								l.setText((rowCounter) + "");
								l.getStyleClass().add("firstLabel");
							} else if (rowCounter == 0) {
								l.setText((colCounter) + "");
								l.getStyleClass().add("firstLabel");
							} else {
								l.setText(rowCounter+ " * " + colCounter);
								l.getStyleClass().add("productLabels");
								l.setTextFill(Color.web("#10de02"));
							}

							gp.add(l, colCounter, rowCounter);
						}
				}

			}
		});
		
		bp.setTop(mainTitleBox);
		bp.setCenter(inputHBox);
		bp.setBottom(gp);
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
}