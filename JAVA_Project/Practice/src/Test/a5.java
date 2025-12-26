package Test;

public class a5 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2, 2, 5.5);
        System.out.println("Area is " + c1.getArea());
        System.out.println("Perimeter is " + c1.getPerimeter());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle(3, 5, 2.3)));
    }
}

class Circle {
    private double x;
    private double y;
    private double radius;


    public Circle() {
        this(0, 0, 1);
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }


    public double getArea() {
        return Math.PI * radius * radius;
    }


    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }


    public boolean contains(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= radius;
    }

    public boolean contains(Circle circle) {
        double distance = getDistance(circle.x, circle.y);
        return distance + circle.radius <= radius;
    }

    public boolean overlaps(Circle circle) {
        double distance = getDistance(circle.x, circle.y);
        return distance < radius + circle.radius && distance > Math.abs(radius - circle.radius);
    }

    // 辅助方法：计算圆心距离
    private double getDistance(double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - this.x, 2) + Math.pow(y2 - this.y, 2));
    }
}
