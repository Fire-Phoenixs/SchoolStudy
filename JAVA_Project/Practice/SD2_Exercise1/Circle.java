package SD2_Exercise1;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
    }

    @Override
    public double Area() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double Perimeter() {
        return 2 * Math.PI * this.radius;
    }
}