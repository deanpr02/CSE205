//Assignment #7, CSE205, Arizona State University 
//Name: Dean Prach     
//StudentID: 1222694057
//Lecture time: MWF 10:10 - 11:00
//Description: This class will allow the user to create rectangle, ellipse, and triangle objects and the user will be able to
// change the fill and stroke color, along with the stroke width; they can also use an undo and erase button
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
public class SketchPane extends BorderPane {
//Task 1: Declare all instance variables listed in UML diagram
private ArrayList<Shape> shapeList = new ArrayList<>();
private ArrayList<Shape> tempList = new ArrayList<>();
private Button undoButton;
private Button eraseButton;
private Label fillColorLabel;
private Label strokeColorLabel;
private Label strokeWidthLabel;
private ComboBox<String> fillColorCombo = new ComboBox<>();
private ComboBox<String> strokeWidthCombo = new ComboBox<>();
private ComboBox<String> strokeColorCombo = new ComboBox<>();
private RadioButton radioButtonRectangle;
private RadioButton radioButtonEllipse;
private RadioButton radioButtonTriangle;
private Pane sketchCanvas;
private Color [] colors;
private String [] colorLabels;
String [] strokeWidth;
private Color currentStrokeColor;
private Color currentFillColor;
private int currentStrokeWidth;
private Rectangle rectangle;
private Ellipse ellipse;
private Polygon triangle;
private double x1;
private double y1;

//Task 2: Implement the constructor
public SketchPane() {
// Define colors, labels, stroke widths that are available to the user
//Initializes combo boxes, buttons, and labels used in program
//creates the GUI of the sketchPane, and HBoxes used for program
colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, 
Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, 
Color.DEEPSKYBLUE, Color.LIME} ;
colorLabels = new String[] { "black", "grey", "yellow", "gold", 
"orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
fillColorLabel = new Label("Fill Color:");
strokeColorLabel = new Label("Stroke Color:");
strokeWidthLabel = new Label("Stroke Width:");
strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"};  
undoButton = new Button("Undo");
eraseButton = new Button("Erase");
undoButton.setOnAction(new ButtonHandler());
eraseButton.setOnAction(new ButtonHandler());
fillColorCombo = new ComboBox<String>();
fillColorCombo.getItems().addAll(colorLabels);
strokeWidthCombo = new ComboBox<String>();
strokeWidthCombo.getItems().addAll(strokeWidth);
strokeColorCombo = new ComboBox<String>();
strokeColorCombo.getItems().addAll(colorLabels);
fillColorCombo.setValue("black");
strokeWidthCombo.setValue("1");
strokeColorCombo.setValue("black");
fillColorCombo.setOnAction(new ColorHandler());
strokeWidthCombo.setOnAction(new WidthHandler());
strokeColorCombo.setOnAction(new ColorHandler());
radioButtonRectangle = new RadioButton("Rectangle");
radioButtonEllipse = new RadioButton("Ellipse");
radioButtonTriangle = new RadioButton("Triangle");
ToggleGroup group = new ToggleGroup();
radioButtonRectangle.setToggleGroup(group);
radioButtonEllipse.setToggleGroup(group);
radioButtonTriangle.setToggleGroup(group);
radioButtonRectangle.setSelected(true);
sketchCanvas = new Pane();
sketchCanvas.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
HBox box1 = new HBox();
box1.setSpacing(20);
box1.setMinSize(20,40);
box1.setAlignment(Pos.CENTER);
box1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,CornerRadii.EMPTY,Insets.EMPTY)));
box1.getChildren().addAll(fillColorLabel,fillColorCombo,strokeWidthLabel,strokeWidthCombo,strokeColorLabel,strokeColorCombo);
HBox box2 = new HBox();
box2.setSpacing(20);
box2.setMinSize(20,40);
box2.setAlignment(Pos.CENTER);
box2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,CornerRadii.EMPTY,Insets.EMPTY)));
box2.getChildren().addAll(radioButtonRectangle,radioButtonEllipse,radioButtonTriangle,undoButton,eraseButton);
this.setTop(box1);
this.setCenter(sketchCanvas);
this.setBottom(box2);
sketchCanvas.setOnMousePressed(new MouseHandler());
sketchCanvas.setOnMouseDragged(new MouseHandler());
sketchCanvas.setOnMouseReleased(new MouseHandler());
box1.setViewOrder(-1);
x1 = 0;
y1 = 0;
currentStrokeColor = Color.BLACK;
currentFillColor = Color.BLACK;
currentStrokeWidth = 1;




}
private class MouseHandler implements EventHandler<MouseEvent> {
@Override
public void handle(MouseEvent event) {
// TASK 3: Implement the mouse handler for Triangle and Ellipse
// Rectangle Example given!
//If user chooses Rectangle
if (radioButtonRectangle.isSelected()) {
//Mouse is pressed
if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
x1 = event.getX();
y1 = event.getY();
rectangle = new Rectangle();
rectangle.setX(x1);
rectangle.setY(y1);
shapeList.add(rectangle);
rectangle.setFill(Color.WHITE);
rectangle.setStroke(Color.BLACK);
sketchCanvas.getChildren().add(rectangle);
}
//Mouse is dragged
else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) 
{
rectangle.setWidth(Math.abs(event.getX() - x1));
rectangle.setHeight(Math.abs(event.getY() - y1));
}
//If the Mouse is released
else if (event.getEventType() == MouseEvent.MOUSE_RELEASED)
{
rectangle.setFill(currentFillColor);
rectangle.setStroke(currentStrokeColor);
rectangle.setStrokeWidth(currentStrokeWidth);
}
}
// if user picks ellipse radio button
else if(radioButtonEllipse.isSelected()){
    //Mouse press
    if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
        x1 = event.getX();
        y1 = event.getY();
        ellipse = new Ellipse();
        ellipse.setCenterX(x1);
        ellipse.setCenterY(y1);
        shapeList.add(ellipse);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        sketchCanvas.getChildren().add(ellipse);
    }
    // Mouse drag
    else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
        double distance = Math.sqrt(Math.pow(event.getX() - x1,2) + Math.pow(event.getY() - y1,2));
        ellipse.setRadiusX(distance);
        ellipse.setRadiusY(distance/2);
    }
    // Mouse release
    else if(event.getEventType() == MouseEvent.MOUSE_RELEASED){
        ellipse.setFill(currentFillColor);
        ellipse.setStroke(currentStrokeColor);
        ellipse.setStrokeWidth(currentStrokeWidth);
    }
}
// if user picks triangle radio button
else if(radioButtonTriangle.isSelected()){
    // Mouse press
    if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
        x1 = event.getX();
        y1 = event.getY();
        triangle = new Polygon(x1,y1);
        shapeList.add(triangle);
        sketchCanvas.getChildren().add(triangle);
    }
    // Mouse drag
    else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
        double x2 = event.getX();
        double y2 = event.getY();
        double y3 = y1 - getDistance(x1,y1,x2,y2);
        triangle.getPoints().clear();
        triangle.getPoints().addAll(x1,y1,x2,y2,x1,y3);
    }
    // Mouse release
    else if(event.getEventType() == MouseEvent.MOUSE_RELEASED){
        triangle.setFill(currentFillColor);
        triangle.setStroke(currentStrokeColor);
        triangle.setStrokeWidth(currentStrokeWidth);
    }
}
}
}
private class ButtonHandler implements EventHandler<ActionEvent> {
@Override
public void handle(ActionEvent event) {
// TASK 4: Implement the button handler
Object source = event.getSource();
// if the user selects the undo button and the list is not empty, it will remove the last shape drawn
if(source == undoButton){
    if(shapeList.isEmpty() == false){
        sketchCanvas.getChildren().remove(shapeList.get(shapeList.size() - 1 ));
        shapeList.remove(shapeList.get(shapeList.size() - 1 ));
}
// if the user previously pushed the erase button, it will readd all previous shapes prior to pressing the erase button
    else{
        shapeList.addAll(tempList);
        tempList.clear();
        sketchCanvas.getChildren().addAll(shapeList);
}
}
// if the canvas has shapes on it, it will remove all shapes
else{
    if(shapeList.isEmpty() == false){
    tempList.clear();
    tempList.addAll(shapeList);
    shapeList.clear();
    sketchCanvas.getChildren().clear();
    }

}
}
}
private class ColorHandler implements EventHandler<ActionEvent> {
@Override
public void handle(ActionEvent event) {
// TASK 5: Implement the color handler
// changes the fill and stroke color depending on the user selection
    int i = fillColorCombo.getSelectionModel().getSelectedIndex();
    currentFillColor = colors[i];
    i = strokeColorCombo.getSelectionModel().getSelectedIndex();
    currentStrokeColor = colors[i];

}
}
private class WidthHandler implements EventHandler<ActionEvent> {
@Override
public void handle(ActionEvent event){
// TASK 6: Implement the stroke width handler
// changes the stroke width depending on the user selection
currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getValue());
}
}
// Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2)  {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}