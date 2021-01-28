 

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

/** Controller Class
 * This class manages the main logic for the program where it starts the animation
 * and links in the events with the objects that need it.
 *
 * It uses the basic animation loop technique of:
 *      for ALL ELEMENTS
 *          update the element
 *          redraw the element
 *       end loop
 *
 * @author Adam Drenth
 * @date Nov 13, 2019
 * @version 1.0
 */

public class Controller {
    Timeline running = new Timeline();              // Animation Object
    ArrayList<Ball> elements = new ArrayList<Ball>();  // All of the elements to be managed

    // Constructor
    public Controller(Scene theScene, Pane root) {
        init(root);
        initEvents(theScene, root);
    }

    /** Initialize the elements within the world. Setup and run animation
     * Setup animation process, etc.
     * @param root is the main node to hold all the graphical objects
     */
    private void init(Pane root) {
        // Create the animation class
        running = new Timeline();
        running.setCycleCount(Timeline.INDEFINITE);

        // Setup the actions within the animation using KeyFrame
        KeyFrame kf = new KeyFrame(Duration.seconds(0.015), new EventHandler<ActionEvent>() {
                    @Override
                    // This method will be called over and over
                    // It defines the transitions as things move
                    // This is where you would handle collisions, updates and drawing
                    public void handle(ActionEvent event) {
                        ArrayList<Ball> newElements = new ArrayList<>();
                        ArrayList<Ball> oldElements = new ArrayList<>();

                        // Basic animation principle
                        for (Ball b : elements) {
                            // Update & Redraw
                            boolean done = b.update(newElements);

                            // Handle dead elements
                            if (done) {
                                root.getChildren().remove(b);
                                oldElements.add(b);
                            }
                        }

                        // Clean-up my elements
                        // ** Must be done last to avoid Concurrency Errors within ArrayList
                        elements.addAll(newElements);
                        elements.removeAll(oldElements);

                    }
                });
        // Start the animation
        running.getKeyFrames().add(kf);
        running.play();
    }

    /** initEvents(theScene)
     * All user-based events are setup and linked in here.
     * @param theScene for adding mouse and keyboard events
     */
    private void initEvents(Scene theScene, Pane root) {
        // When the mouse is clicked, create a new ball
        theScene.setOnMousePressed(
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        Point pos = new Point(me.getX(), me.getY());
                        Point vel = new Point(1, -15);    // Using a standard speed
                        Ball b = new Ball(pos, vel, Color.RED);

                        elements.add(new Ball(pos, vel, Color.RED)); // standard colour
                        root.getChildren().add(b);
                    }
                }
        );
    }
}
