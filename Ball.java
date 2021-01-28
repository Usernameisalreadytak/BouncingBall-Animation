import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/** Ball Class
 * @author Adam Drenth
 * @date 
 * @version 1.5
 *
 * Defines the basic ball element that moves around the screen
 * It will simply bounce off walls.
 *
 * This class has be altered to allow for JavaFX features over Swing.
 */

public class Ball extends Circle{
    private Point vel;

    /** Constructor
     *
     * @param start Starting location of the ball as a vector
     * @param velocity Speed and direction of the ball as a vector
     * @param color The colour to be used for drawing
     */
    public Ball(Point start, Point velocity, Color color) {
        System.out.println("Making a ball");
        vel = velocity;

        setRadius(5);
        relocate(start.x, start.y);
        setFill(color);
    }

    /** update(createdElements)
     *
     * @param createdElements list to add any newly created elements (not used)
     * @return true if the ball should be destroyed (always false)
     */
    public boolean update(ArrayList<Ball> createdElements) {
        System.out.print("Updating a ball");
        double x = getLayoutX();
        double y = getLayoutY();
        double radius = getRadius();

        // Check boundaries & Bounce if necessary
        if(x < radius || x > Window.WIDTH - radius) { vel.x = -1*vel.x; }
        if(y < radius || y > Window.WIDTH - radius) { vel.y = -1*vel.y; }

        // Update position
        //Translate vector = new Translate(vel.x, vel.y);
        //getTransforms().add(vector);
        setLayoutX(getLayoutX() + vel.x);
        setLayoutY(getLayoutY() + vel.y);

        System.out.println(": " + getLayoutX() + ", " + getLayoutY());

        return false; // Always Alive
    }

    public void removeFrom(Pane root) {
        root.getChildren().remove(this);
    }

    public void addTo(Pane root) {
        root.getChildren().add(this);
    }
}
