 

/** Point Class
 * This class is used to represent a point or vector.  It simplies having an
 * (x, y) position and the math that generally comes with that like adding,
 * subtracting and equality.
 */
public class Point {
    public double x;
    public double y;

    // Constructors
    public Point() { x = 0; y = 0; }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** add(other)
     * Adds the x and y values together separately.
     * @param other
     */
    public void add(Point other) {
        x += other.x;
        y += other.y;
    }

    /** sub(other)
     * Subtracts the x and y values together separately.
     * @param other
     */
    public void sub(Point other) {
        x -= other.x;
        y -= other.y;
    }

    /** equals(other)
     * @param other the other point
     * @return True if and only if both x and y values are the same
     */
    public boolean equals(Point other) {
        return x == other.x && y == other.y;
    }
}
