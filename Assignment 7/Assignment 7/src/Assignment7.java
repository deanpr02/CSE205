//Assignment #7, CSE205, Arizona State University 
//Name: Dean Prach     
//StudentID: 1222694057
//Lecture time: MWF 10:10 - 11:00
//Description: This class creates the GUI for a program that allows the user to draw rectangles, triangles, and ellipses
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Assignment7 extends Application
{
    public static final int WINSIZE_X = 800, WINSIZE_Y = 800;
    private final String WINTITLE = "Sketchy";
    @Override
    public void start(Stage stage) throws Exception
    {
        SketchPane rootPane = new SketchPane();
        rootPane.setPrefSize(WINSIZE_X, WINSIZE_Y);
        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);
        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Technically this is not needed for JavaFX applications. Added just in case.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}