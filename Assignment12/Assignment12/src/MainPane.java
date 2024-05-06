// Assignment 12: Arizona State University CSE205
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF: 10:10 - 11:00
//  Description: This class creates the two panes for the application

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MainPane extends Pane 
{

	// The constructor creates two panes with waves and movement controls
	// Initial colors for the waves are BLACK and PINK
	// The two panes are arranged in a GridPane
	public MainPane(int width, int height) 
	{
		WaveControlPane[] wavePane;
		wavePane = new WaveControlPane[2];
		wavePane[0] = new WaveControlPane(width, height / 2 - 5, Color.BLACK);
		wavePane[1] = new WaveControlPane(width, height / 2 - 5, Color.PINK);

		GridPane pane1 = new GridPane();
		pane1.setPadding(new Insets(10, 10, 10, 10));
		pane1.setVgap(10);
		pane1.add(wavePane[0], 0, 0);
		pane1.add(wavePane[1], 0, 1);

		this.getChildren().add(pane1);
	}
}
