// Abstract class representing a general Shape
abstract class Shape {
    // Abstract method to calculate the area of a shape
    public abstract double area();
}
// Circle class inherits the Shape class
class Circle extends Shape {
    // Private variable to store the radius of the circle
    private double r;
    // Constructor to initialize the radius
    Circle(double r) {
        this.r = r;
    }
    // Overriding the area() method to calculate circle area
    @Override
    public double area() {
        return 3.14 * r * r;
    }
}
// Rectangle class inherits the Shape class
class Rectangle extends Shape {
    // Private variables to store length and width
    private double l;
    private double w;
    // Constructor to initialize length and width
    Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }
    // Overriding the area() method to calculate rectangle area
    @Override
    public double area() {
        return l * w;
    }
}
// Triangle class inherits the Shape class
class Triangle extends Shape {
    // Private variables to store base and height
    private double b;
    private double h;
    // Constructor to initialize base and height
    Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }
    // Overriding the area() method to calculate triangle area
    @Override
    public double area() {
        return 0.5 * b * h;
    }
}
// Main class of the program
public class ShapeArea {
    // Main method: execution starts from here
    public static void main(String arg[]) {
        // Creating an array of Shape objects
        // Each object represents a different shape
        Shape[] shapes = {
            new Circle(2.5),
            new Rectangle(2.5, 2.5),
            new Triangle(2.0, 4.0)
        };
        // Variable to store the sum of all areas
        double total = 0;
        // Variable to store the largest area
        double largest = 0;
        // Reference to store the shape having the largest area
        Shape largestShape = null;
        // Loop through each shape in the array
        for (Shape s : shapes) {
            // Calculate the area of the current shape
            double area = s.area();
            // Add the current area to the total
            total += area;
            // Check whether the current area is greater
            // than the previously stored largest area
            if (area > largest) {
                // Update the largest area
                largest = area;
                // Store the shape with the largest area
                largestShape = s;
            }
            // Display the current shape's area
            System.out.println("shape" + largest + "area:" + area);
        }
    }
}
