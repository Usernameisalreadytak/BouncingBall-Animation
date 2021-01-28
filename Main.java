 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Adam Drenth
 * @date Nov 13, 2019
 * @version 1.0
 *
 * This is the driver class. It only sets up the
 * basic graphical elements and starts the application
 */
public class Main extends Application implements Window {
    Controller theController;   // Main game controller
    public static void main(String[] args) {
        launch(args);
    }

    /** start(primaryStage)
     * Starts the application by making the scene, canvas and
     * controller
     * @param primaryStage the main window
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bouncing Ball Example");

        Pane root = new Pane();
        Scene scene = new Scene(root, Window.WIDTH, Window.HEIGHT);

        Canvas canvas = new Canvas(Window.WIDTH, Window.HEIGHT);
        //root.getChildren().add(canvas);

        // This is where the magic starts
        theController = new Controller(scene, root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
