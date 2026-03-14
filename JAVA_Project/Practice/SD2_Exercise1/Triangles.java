package SD2_Exercise1;

public class Triangles extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangles(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        
        if (sideA <= 0) {
            throw new IllegalArgumentException("Side A must be greater than 0");
        }
        if (sideB <= 0) {
            throw new IllegalArgumentException("Side B must be greater than 0");
        }
        if (sideC <= 0) {
            throw new IllegalArgumentException("Side C must be greater than 0");
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("The sum of any two sides must be greater than the third side");
        }
    }

    @Override
    public double Area() {
        double s = (this.sideA + this.sideB + this.sideC) / 2;
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
    }

    @Override
    public double Perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    public boolean isRightAngled() {
  
        double maxSide = Math.max(sideA, Math.max(sideB, sideC));
        

        double tolerance = 1e-10;
        
        if (Math.abs(maxSide - sideA) < tolerance) {
            return Math.abs(sideA * sideA - (sideB * sideB + sideC * sideC)) < tolerance;
        } else if (Math.abs(maxSide - sideB) < tolerance) {
            return Math.abs(sideB * sideB - (sideA * sideA + sideC * sideC)) < tolerance;
        } else {
            return Math.abs(sideC * sideC - (sideA * sideA + sideB * sideB)) < tolerance;
        }
    }
}

