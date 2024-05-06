// Assignment 12: Arizona State University CSE205
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF: 10:10 - 11:00
//  Description: This class creates the controls for the wave pane such as the start, stop, clear, and default buttons along with the three sliders

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class WaveControlPane extends Pane 
{

	private WaveDisplayPane wavePane;
	private int width, height;
	private Color color;
	private ColorPicker picker;

	// ******************************************************************
	// Task #2a: add instance variables for sliders, buttons, and labels
	// ******************************************************************
	private Button startButton;
	private Button stopButton;
	private Button clearButton;
	private Button defaultButton;
	private Slider speedSlider;
	private Slider widthSlider;
	private Slider heightSlider;
	private Label speedLabel;
	private Label widthLabel;
	private Label heightLabel;

	// constructor to create all components, set their handler/listener,
	// and arrange them using layout panes.
	public WaveControlPane(int h, int w, Color initialColor) 
	{
		this.color = initialColor;
		this.width = (int) (h * 0.68);
		this.height = w - 10;

		// creates a pane to display waves with the specified color
		wavePane = new WaveDisplayPane(width, color);
		wavePane.setMinSize(width, height);
		wavePane.setMaxSize(width, height);

		// create a color picker with the specified initial color
		picker = new ColorPicker(color);
		picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// ************************************************************************
		// Task #2b: create 4 buttons and resize them to the width of the VBox pane,
		// then add them to the VBox buttonPane instantiated below.
		// *************************************************************************
		startButton = new Button("Start");
		stopButton = new Button("Stop");
		clearButton = new Button("Clear");
		defaultButton = new Button("Default");
		startButton.setMaxWidth(Double.MAX_VALUE);
		stopButton.setMaxWidth(Double.MAX_VALUE);
		clearButton.setMaxWidth(Double.MAX_VALUE);
		defaultButton.setMaxWidth(Double.MAX_VALUE);

		VBox buttonPane = new VBox(startButton,stopButton,clearButton,defaultButton, picker);
		
		buttonPane.setPrefSize(100, 100);
		buttonPane.setAlignment(Pos.CENTER);

		
		// ************************************************************************
		// Task #2c: create 3 sliders and 3 labels and add them to the VBox panes
		// instantiated below. 
		// *************************************************************************
		speedSlider = new Slider();
		speedLabel = new Label("Speed");
		speedSlider.setMajorTickUnit(10);
		speedSlider.setMinorTickCount(5);
		speedSlider.setMin(10);
		speedSlider.setMax(50);
		speedSlider.setValue(20);
		widthSlider = new Slider();
		widthLabel = new Label("Width");
		widthSlider.setMajorTickUnit(10);
		widthSlider.setMinorTickCount(5);
		widthSlider.setMin(20);
		widthSlider.setMax(100);
		widthSlider.setValue(50);
		heightSlider = new Slider();
		heightLabel = new Label("Height");
		heightSlider.setMajorTickUnit(10);
		heightSlider.setMinorTickCount(5);
		heightSlider.setMin(20);
		heightSlider.setMax(100);
		heightSlider.setValue(80);

		VBox speedSliderPane = new VBox(speedLabel, speedSlider);
		VBox waveLengthSliderPane = new VBox(widthLabel, widthSlider);
		VBox waveAmplitudeSliderPane = new VBox(heightLabel, heightSlider);

		TilePane sliderPane = new TilePane();
		sliderPane.setPrefColumns(3);
		sliderPane.setPadding(new Insets(5, 5, 5, 5));
		sliderPane.setAlignment(Pos.CENTER);
		sliderPane.getChildren().addAll(speedSliderPane, waveLengthSliderPane, waveAmplitudeSliderPane);

		HBox controls = new HBox(buttonPane, sliderPane);
		controls.setAlignment(Pos.CENTER);

		BorderPane controlsAndWaves = new BorderPane();
		controlsAndWaves.setLeft(controls);
		controlsAndWaves.setCenter(wavePane);

		this.getChildren().add(controlsAndWaves);

		// ************************************************************************
		// Task #2d: Register the buttons, sliders, and color picker with the
		// appropriate handler object 
		// *************************************************************************
		startButton.setOnAction(new ButtonHandler());
		stopButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		defaultButton.setOnAction(new ButtonHandler());
		picker.setOnAction(new ColorHandler());
		speedSlider.valueProperty().addListener(new SpeedHandler());
		widthSlider.valueProperty().addListener(new WaveLengthHandler());
		heightSlider.valueProperty().addListener(new WaveAmplitudeHandler());
		
	}

	// ************************************************************************
	// Task #3: Implement event handlers for the four buttons (task #3a), 
	// the color picker (task #3b), the speed slider (task #3c), and the
	// sliders for wave amplitude and length (tasks #3d, #3e)
	// *************************************************************************
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event){
			Object source = event.getSource();
			//if start button is pressed, the program will resume
			if(source == startButton)
			{
			wavePane.resume();
			}
			//if the stop button is pressed, the program will be suspended
			else if(source == stopButton)
			{
				wavePane.suspend();
			}
			//if the clear button is pressed, all waves will be removed
			else if (source == clearButton)
			{
				wavePane.clearPane();
			}
			//if the default button is pressed, a default wave of color red will be drawn
			else if(source == defaultButton)
			{
				wavePane.suspend();
				wavePane.setWaveAmplitude(60);
				wavePane.setWaveLength(50);
				wavePane.setRate(30);
				wavePane.changeColor(Color.RED);
				speedSlider.setValue(30);
				widthSlider.setValue(50);
				heightSlider.setValue(60);
				picker.setValue(Color.RED);
				wavePane.resume();
			}
		}
	}
	//This handler will change the color of the wave drawn
	private class ColorHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			wavePane.changeColor(picker.getValue());
		}
	}
	//This handler changes the speed at which the wave is drawn
	private class SpeedHandler implements ChangeListener<Number>
	{
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.setRate((int)speedSlider.getValue());
		}
	}
	//This handler changes the width of the wave
	private class WaveLengthHandler implements ChangeListener<Number>
	{
		public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			wavePane.setWaveLength((int)widthSlider.getValue());
		}
	}
	//This handler changes the height of the wave
	private class WaveAmplitudeHandler implements ChangeListener<Number>
	{
		public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			wavePane.setWaveAmplitude((int)heightSlider.getValue());

		}
	}







}
