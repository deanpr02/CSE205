// Assignment 12: Arizona State University CSE205
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF: 10:10 - 11:00
//  Description: This class acts as the driver for the program and runs the application

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Assignment12 extends Application 
{
	private final int WIDTH = 780;
	private final int HEIGHT = 480;

	public void start(Stage primaryStage) 
    {
		// create a ControlPane object
		MainPane pane = new MainPane(WIDTH, HEIGHT);

		// put pane onto the rootPane
		Pane rootPane = new Pane();
		rootPane.getChildren().add(pane);

		// Create a scene and place rootPane in the stage
		Scene scene = new Scene(rootPane, WIDTH, HEIGHT);

		primaryStage.setTitle("Big Waves!");
		
		// Place the scene in the stage
		primaryStage.setScene(scene); 
		
		// Display the stage
		primaryStage.show(); 
	}

	public static void main(String[] args) 
    {
		Application.launch(args);
	}
}