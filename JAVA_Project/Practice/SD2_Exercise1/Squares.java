package SD2_Exercise1;

public class Squares extends Shape {
    private double side;

    public Squares(double side) {
        this.side = side;

        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than 0");
        }
    }

    @Override
    public double Area() {
        return this.side * this.side;
    }

    @Override
    public double Perimeter() {
        return 4 * this.side;
    }
}


