package Test;
public class Exercise_1 {
    private double length;
    private double width;

    public Exercise_1(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double AreaOfRectangle() {
        return length * width;
    }
    
    public static void main(String[] args) {
        Exercise_1 FirstRectangle = new Exercise_1(5.0, 3.0);
        System.out.println("The area of the rectangle is: " + FirstRectangle.AreaOfRectangle());
    }
}
