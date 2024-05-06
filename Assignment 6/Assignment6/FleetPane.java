// Assignment #: 6
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class creates the GUI for the FleetPane window and will allow the user to create a fleet
//  by selecting the aircrafts they would like and it will add their attack powers, stealth index, and bomb capacity together

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FleetPane extends BorderPane {
	// COMPLETED: contains a list of aircrafts
	ArrayList<Aircraft> aircraftList;
	
	// COMPLETED: Variables containing fleet Stealth Index, Bomb Carrying Capacity, and Attack Power
	int totalStealthIndex;
	int totalBombCarryingCapacity;
	int totalAttackPower;

	
	// TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Fleet information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Aircrafts/Clear Selection" Button
	Label displayInformation;
    VBox checkBoxes;
    Button loadAircraftsAndClear;


	public FleetPane(ArrayList<Aircraft> aircraftList) {
		this.aircraftList = aircraftList;

		// TODO 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		displayInformation = new Label("Select aircrafts to add to your fleet");
        checkBoxes = new VBox();
        loadAircraftsAndClear = new Button("Load Aircrafts/Clear Selection");


		// TODO: 5. b) Bind "Load Aircrafts/Clear Selection" Button to its handler
		loadAircraftsAndClear.setOnAction(new LoadAircraftsButtonHandler());
		
		// TODO: 5. c) Organize components to their positions on BorderPane
		// Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		//this.getChildren().addAll(displayInformation,checkBoxes,loadAircraftsAndClear);
        this.setTop(displayInformation);
        this.setCenter(checkBoxes);
        this.setBottom(loadAircraftsAndClear);


	}
	
	private class LoadAircraftsButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			// TODO: 6. Clear the VBox (1 line)
			checkBoxes.getChildren().clear();

			// TODO: Create new checkbox for new aircraft  
			for(int i = 0; i < aircraftList.size(); i++){
                String str = "";
                str = aircraftList.get(i).toString();
                CheckBox check = new CheckBox(str);
                check.setOnAction(new CheckBoxHandler(aircraftList.get(i)));
                checkBoxes.getChildren().add(check);
            }
			

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Aircraft aircraft;
		
		// When creating a new CheckBoxHandler, pass in a Aircraft object so it can be accessed later
		public CheckBoxHandler(Aircraft _aircraft) {
			this.aircraft = _aircraft;
		}

		@Override
		public void handle(ActionEvent event) {
			// TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			CheckBox checkbox = (CheckBox)event.getSource();
			
			// TODO: 7. b) If the CheckBox was selected, add the current aircraft scores to totalBombCarryingCapacity, 
			// 	totalAttackPower, and totalStealthIndex. Otherwise, subtract the current aircraft scores
			if(checkbox.isSelected()){
                totalBombCarryingCapacity = totalBombCarryingCapacity + aircraft.getBombCarryingCapacity();
                totalAttackPower = totalAttackPower + aircraft.getAttackPower();
                totalStealthIndex = (totalStealthIndex + aircraft.getStealthIndex());
            }
            else{
                totalBombCarryingCapacity = totalBombCarryingCapacity - aircraft.getBombCarryingCapacity();
                totalAttackPower = totalAttackPower - aircraft.getAttackPower();
                totalStealthIndex = totalStealthIndex - aircraft.getStealthIndex();
            }


			// TODO: 7. c) Set the Label to 
			// "Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower
			displayInformation.setText("Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower);
			

		}
	}

}
