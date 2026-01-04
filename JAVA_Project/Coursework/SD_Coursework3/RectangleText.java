package SD_Coursework3;

public class RectangleText {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9); //Create two Rectangle objects
        System.out.println("The width of rectangle1 is " + rectangle1.width);
        System.out.println("The height of rectangle1 is " + rectangle1.height);
        System.out.println("The area of rectangle1 is " + rectangle1.getArea());
        System.out.println("The perimeter of rectangle1 is " + rectangle1.getPerimeter());
        System.out.println("The width of rectangle2 is " + rectangle2.width);
        System.out.println("The height of rectangle2 is " + rectangle2.height);
        System.out.println("The area of rectangle2 is " + rectangle2.getArea());
        System.out.println("The perimeter of rectangle2 is " + rectangle2.getPerimeter());
        System.out.println("The area of the minimum bounding rectangle is " + Rectangle.minimumBoundingRectangle(rectangle1, rectangle2));
    }
}

