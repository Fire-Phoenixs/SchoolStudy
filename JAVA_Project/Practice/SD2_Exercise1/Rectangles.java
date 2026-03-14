package SD2_Exercise1;

public class Rectangles extends Shape {
    private double length;
    private double width;

    public Rectangles(double length, double width) {
        this.length = length;
        this.width = width;
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    @Override
    public double Area() {
        return this.length * this.width;
    }
    
    @Override
    public double Perimeter() {
        return 2 * (this.length + this.width);
    }

}
