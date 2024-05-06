// Assignment 12: Arizona State University CSE205
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF: 10:10 - 11:00
//  Description: This class creates the pane that displays the wave which has variables of waveLength, waveAmplitude, and color

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WaveDisplayPane extends Pane 
{

// Task #1: implement instance variables, constructor, and methods
// as outlned in the UML diagram and assignment description
private Timeline timeline;
private int time;
private int waveLength;
private int waveAmplitude;
private int paneWidth;
private Color color;

public WaveDisplayPane(int paneWidth, Color color)
{
	this.paneWidth = paneWidth;
	this.color = color;
	waveAmplitude = 100;
	waveLength = 50;
	time = 0;
	this.setStyle("-fx-background-color: white");
	this.setStyle("-fx-border-color: black");
	KeyFrame kf = new KeyFrame(Duration.millis(500), new WaveHandler());
	timeline = new Timeline(kf);
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.setRate(20);
	timeline.play();

}
	//This method plays the wave drawing
	public void resume()
	{
		timeline.play();
	}
	//This method stops the wave drawing
	public void suspend()
	{
		timeline.pause();
		this.time = 0;
	}
	//This method changes the color of the wave
	public void changeColor(Color color)
	{
		this.color = color;
	}
	//This method removes all waves from the canvas
	public void clearPane()
	{
		this.getChildren().clear();
		this.suspend();
	}
	//This method sets the waveLength
	public void setWaveLength(int waveLength)
	{
		this.waveLength = waveLength;
	}
	//This method sets the waveAmplitude
	public void setWaveAmplitude(int waveAmplitude)
	{
		this.waveAmplitude = waveAmplitude;
	}
	//This method sets the speed at which the wave is drawn
	public void setRate(int speed)
	{
		timeline.setRate(speed);
	}

	// defines an event listener to draw a new point
	private class WaveHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event) 
		{
			time++;
			int x = (waveLength * time) / 314;
			int y = (int) (waveAmplitude * Math.sin((0.0174533) * time) + 115);

			if (x < paneWidth) 
			{
				Circle dot = new Circle(x, y, 2);
				dot.setFill(color);
				getChildren().add(dot);
			} else suspend();
		}
	}
}
