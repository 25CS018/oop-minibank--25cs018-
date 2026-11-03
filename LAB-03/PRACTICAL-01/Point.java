import java.util.*;
// Point class represents a point with x and y coordinates
public class Point {
    // Private variables to store x and y coordinates
    private int x;
    private int y;
    // Constructor to initialize x and y values
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Converts the Point object into a string format (x,y)
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    // Compares two Point objects to check whether they are equal
    @Override
    public boolean equals(Object o) {
        // Checks if both references point to the same object
        if (this == o)
            return true;
        // Checks whether the given object belongs to the Point class
        if (!(o instanceof Point))
            return false;
        // Typecasts the object into Point class
        Point p = (Point) o;
        // Compares x and y coordinates of both points
        return x == p.x && y == p.y;
    }
    // Generates a hash code based on x and y coordinates
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
