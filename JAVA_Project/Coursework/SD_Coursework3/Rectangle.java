package Coursework.SD_Coursework3;

public class Rectangle {
    protected double width;  //two protected double attributes.
    protected double height;

    public Rectangle(double width, double height) {  // A constructor that creates a rectangle with the specified width and height.
        this.width = width;
        this.height = height;
    }

    public Rectangle() { //A default constructor that creates a rectangle with width and height of 1.0.
        this.width = 1.0;
        this.height = 1.0;
    }
    
    public double getArea() { // A method getArea() that returns the area of this rectangle.
        return width * height;
    }
    
    public double getPerimeter() { // A method named getPerimeter() that returns the perimeter.
        return 2 * (width + height);
    }

    public static double minimumBoundingRectangle(Rectangle a1, Rectangle a2) {  //A static method to calculate the area of the minimum bounding rectangle
        double maxWidth = Math.max(a1.width, a2.width);
        double maxHeight = Math.max(a1.height, a2.height);
        return maxWidth * maxHeight;       
    }
}
