// Assignment #: 6
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class creates the GUI for the AirCraftPane window. This will take input data from the user and if the data meets
//  the restrictions, it will create a new aircraft object and store it in aircraftList and display it on the left side of the window

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//There are 4 (FOUR) tasks to be completed in this file - Look for TODO: keywords
//TODO: 1. Build the GUI
//TODO: 2. Write "Random" Button Handler
//TODO: 3. "Add New Aircraft" button handler - Check for valid input before adding the new Aircraft to the list:
//TODO: 4. Update rightTextArea with updated information from aircraftList
public class AircraftPane extends HBox {
	// COMPLETED: contains a list of aircrafts
	ArrayList<Aircraft> aircraftList;

	// COMPLETED: Save current Aircraft Type
	String selectedAircraftType;


	// COMPLETED: Main layout components
	TextArea rightTextArea;
	VBox leftVBox;
	ComboBox<String> aircraftTypeComboBox;
	ImageView imageView;

	// TODO 1. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE GridPane to hold
	// FOUR Labels (Name, Bomb Carrying Capacity, Attack Power, Stealth Index),
	// FOUR corresponding TextFields
	// ONE "Random" Button
	// vvvvvv 1. a) vvvvvv (about 8-12 lines)
	GridPane inputPane;
    Label Name;
    Label bombCarryingCapacity;
    Label attackPower;
    Label stealthIndex;
    TextField nameField;
    TextField bombCapacityField;
    TextField attackPowerField;
    TextField stealthIndexField;
    Button rdmButton;

	// ^^^^^^ 1. a) ^^^^^^
	
	
	// TODO 1. b) "Declare" (Do not "initialize" them yet!!!)
	// ONE "Add New Aircraft!!!" Button
	// ONE red Label to display add aircraft status.
	// vvvvvv 1. b) vvvvvv (about 2 lines)
    Button newAircraftButton;
    Label displayAircraft;
	// ^^^^^^ 1. b) ^^^^^^
	
	// COMPLETED: Define window size
	public static final int WINSIZE_X = 1000, WINSIZE_Y = 600;


	// Constructor - what to do when AircraftPane is first created
	public AircraftPane(ArrayList<Aircraft> aircraftList) {

		// COMPLETED: Assign the aircraftList passed into this constructor
		this.aircraftList = aircraftList;

		// COMPLETED: Initialize main layout components
		this.leftVBox = new VBox();
		this.rightTextArea = new TextArea();
		
		// COMPLETED: Setting up ComboBox
		String[] aircraftType = { "Fighter Jet", "Bomber - Propeller Type", "Bomber - Jet Type", "Combat Helicopter" };
		aircraftTypeComboBox = new ComboBox<String>();
		aircraftTypeComboBox.setValue("Select Aircraft Type");
		aircraftTypeComboBox.getItems().addAll(aircraftType);
		aircraftTypeComboBox.setOnAction(new AircraftTypeComboBoxHandler());
		leftVBox.getChildren().add(aircraftTypeComboBox);

		
		// TODO 1. a) Initialize the instance variables
        Name = new Label("Name");
        bombCarryingCapacity = new Label("Bomb Carrying Capacity");
        attackPower = new Label("Attack Power");
        stealthIndex = new Label("Stealth Index");
        nameField = new TextField();
        bombCapacityField = new TextField();
        attackPowerField = new TextField();
        stealthIndexField = new TextField();
        rdmButton = new Button("Random");
        stealthIndexField.setEditable(false);

		
		// TODO 1. b) Initialize the instance variables and set Label color to RED
        newAircraftButton = new Button("Add New Aircraft!!!");
        displayAircraft = new Label("Aircraft added successfully");
        displayAircraft.setTextFill(Color.RED);
		
		// TODO 1. c) Organize Labels, TextFields, and Button onto the GridPane
		inputPane = new GridPane();
		inputPane.add(Name,0,0);
        inputPane.add(nameField,1,0);
        inputPane.add(bombCarryingCapacity,0,1);
        inputPane.add(bombCapacityField,1,1);
        inputPane.add(attackPower,0,2);
        inputPane.add(attackPowerField,1,2);
        inputPane.add(stealthIndex,0,3);
        inputPane.add(stealthIndexField,1,3);
        inputPane.add(rdmButton,2,3);

		
		
		// TODO: 1. d) Bind buttons to their handlers (RandomButtonHandler and AddNewAircraftButtonHandler)
        rdmButton.setOnAction(new RandomButtonHandler());
        newAircraftButton.setOnAction(new AddNewAircraftButtonHandler());
		

		
		// TODO: 1. e) Add GridPane, “Add Aircraft” Button, and red Label to leftVBox
		leftVBox.getChildren().addAll(inputPane,newAircraftButton,displayAircraft);



		// COMPLETED: VBox layout alignment
		inputPane.setHgap(20);
		leftVBox.setPadding(new Insets(40, 50, 0, 50));
		leftVBox.setSpacing(40);
		leftVBox.setAlignment(Pos.TOP_CENTER);
		leftVBox.setPrefWidth(WINSIZE_X / 2);

		// COMPLETED: Setting up ImageView
		imageView = new ImageView();
		imageView.setPreserveRatio(true);
		imageView.setFitWidth(100);
		leftVBox.getChildren().add(imageView);
		FileInputStream input;
		try {
			input = new FileInputStream("fighter jet.png");
			Image image = new Image(input);
			imageView.setImage(image);
		} catch (FileNotFoundException e) {
			imageView.setImage(null);
		}
		
		// COMPLETED: Add main components to "Add Aircraft" tab
		this.getChildren().addAll(leftVBox, rightTextArea);
	}

	// We have finished setting up the GUI for Add Aircraft tab, let's move on to the
	// logic/back-end side!
	// Writing handlers
	
	// Generate random stealth index value (1 <= stealthIndex <= 10)
	private class RandomButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			stealthIndexField.setEditable(false);
            if(stealthIndexField.getText().isEmpty()){
                int num = (int)(Math.random() * 10);
                String rdm = Integer.toString(num);
                stealthIndexField.setText(rdm);
            }
            else{
                displayAircraft.setText("Stealth Index is already generated");
            }


		}
	}


	// TODO 3. "Add New Aircraft" button handler - Check for valid input before adding the new Aircraft to the list
	private class AddNewAircraftButtonHandler implements EventHandler<ActionEvent> {

		// This method will be called once we click the button
		public void handle(ActionEvent event) {

			// TODO 3. a) Create 4 String variables and assign them to the values retrieved from TextFields using .getText()
			String nameValue = nameField.getText();
            String bombCapacityValue = bombCapacityField.getText();
            String attackPowerValue = attackPowerField.getText();
            String stealthIndexValue = stealthIndexField.getText();

			// "Always sanitize user input"
			// You need to make sure the input is valid, for example:
			// 		- Not empty 
			// 		- In the correct format (String, Integer, Double, etc)
			//  	- Satisfied all input requirement (non-negative, between a range, etc) 
			// Use this try/catch block AND "throw new Exception()" to handle invalid input
			try {
				
				// EXAMPLE: When the aircraft type is not selected
				if (selectedAircraftType == null) {
					// When you throw a new Exception, the program STOPS immediately 
					// and SKIPS to the catch{} block, so the lines below will NOT execute.
					// Check out the catch{} block below
					throw new Exception("Aircraft type is not yet selected");
				}

				// TODO: 3. b) If one of the TextFields is empty, throw exception with
				// error message: "At least one of the text fields is empty"
				if(nameField.getText() == "" || bombCapacityField.getText() == "" || attackPowerField.getText() == "" || stealthIndexField.getText() == ""){
                    throw new Exception("At least one of the text fields is empty");
                }



				// TODO: 3. c) Loop through aircraftList to check for aircraft that has the same name; throw exception with
				// error message: "Aircaft existed!"

				for(int i = 0; i < aircraftList.size(); i++){
                    if(nameField.getText().equals(aircraftList.get(i).getType())){
                        throw new Exception("Aircraft existed!");
                    }
                }

				
				// TODO: 3. d) Now try to parse Bomb Carryig Capacity, Attack Power, and Stealth Index to integers 
				// The parseInt method will automatically throw error for you if the input is not in the integer format
				// Create 3 integers and convert the Strings from 3. a)
				int value1 = Integer.parseInt(bombCapacityValue);
                int value2 = Integer.parseInt(attackPowerValue);
                int value3 = Integer.parseInt(stealthIndexValue);

				
				// TODO: 3. e) Check if Bomb Carrying Capacity or Attack Power is a negative number
				// if so, throw exception with error message "Both Bomb Carrying Capacity and Attack Power must be positive numbers"
				if(value1 < 0|| value2 < 0){
                    throw new Exception("Both Bomb Carrying Capacity and Attack Power must be positive numbers");
                }



				// TODO: 3. f) Check if the sum of Carrying Capacity and Attack Power exceeds 5000. 
				// If so, throw exception with error message "The sum of Carrying Capacity and Attack Power must be less or equal to 5000"
				if(value1 + value2 > 5000){
                    throw new Exception("The sum of the Carrying Capacity and Attack Power must be less or equal to 5000");
                }


				
				
				// TODO: 3. g) Input is valid, now create new Aircraft object (remember to check out Aircraft.java file)
				// with data from user input. Don't forget "selectedAircraftType"
				// Finally, add the newly created aircraft to aircraftList
                Aircraft craft = new Aircraft(nameValue, selectedAircraftType, value1, value2, value3);
                aircraftList.add(craft);

				
				// TODO 3: Set the Red Label to "Aircraft added successfully" and empty all TextFields
				displayAircraft.setText("Aircraft added successfully");
                nameField.clear();
                bombCapacityField.clear();
                attackPowerField.clear();
                stealthIndexField.clear();
			

				// TODO 4. b) Call updateTextArea() to update aircrafts list
				updateTextArea();

			} catch (NumberFormatException exception) {
				// set RED LABEL to "At least one of the text fields is in the incorrect format"
				displayAircraft.setText("At least one of the text fields is in the incorrect format");

			} catch (Exception exception) {
				// TODO: 3. b) The message that we passed in "throw new Exception(MESSAGE);" above
				//			can be retrieved using exception.getMessage()
				// Set the value of the RED LABEL to exception.getMessage() to display error message 
                displayAircraft.setText(exception.getMessage());

			}

		}
	}

	// TODO 4. a) Create a String containing all aircraft information
	// and loop through aircraftList to add all aircrafts' data together
	private void updateTextArea() {
        String information = "";
        for(int j = 0; j < aircraftList.size(); j++){
            information = information + aircraftList.get(j).toString() + "\n";
        }
        rightTextArea.setText(information);
		
		
	}
	
	
	// Completed: AircraftTypeComboBoxHandler - You don't need to modify this handler
	private class AircraftTypeComboBoxHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			selectedAircraftType = aircraftTypeComboBox.getSelectionModel().getSelectedItem();
			FileInputStream input;
			try {
				input = new FileInputStream(selectedAircraftType.toLowerCase() + ".png");
				Image image = new Image(input);
				imageView.setImage(image);
			} catch (FileNotFoundException e) {
				imageView.setImage(null);
			}

		}
	}


}