package Coursework.SD_Coursework1.src;                                                                                                           //package declaration

import java.util.Scanner;                                                                                                     //importing Scanner class for user input
public class RegularShapeArea {                                                                                                                    //class declaration
    public static void main(String[] args) {                                                                                                             //main method
        int ShapeSides;
        double ShapeLength;
        double Area;                                                                                                                           //variable declarations
        Scanner scanner = new Scanner(System.in);                                                                             //creating Scanner object for user input
        System.out.println("How many sides does the shape have (between 3 and 6):");
        ShapeSides = scanner.nextInt();                                                                                          //getting number of sides from user
        if (ShapeSides < 3 || ShapeSides > 6)                                                                                                //Compare number of sides
        {                                                                               
            System.out.println("Error: Shape must have between 3 and 6 sides.");                                                   //error message for invalid input               
        }
        else              
        {  
            System.out.println("What is each side:");                                                                           //prompting user for length of sides
            ShapeLength = scanner.nextDouble();                                                                                     //getting length of sides from user
            if (ShapeSides == 3)
            {
                Area = (Math.sqrt(3) / 4) * Math.pow(ShapeLength, 2);                                                               //calculating area of triangle
            }
            else if (ShapeSides == 4)
            {
                Area = Math.pow(ShapeLength, 2);                                                                                        //calculating area of square
            }
            else if (ShapeSides == 5)
            {
                Area = (1.0/4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(ShapeLength, 2);                                 //calculating area of pentagon
            }
            else if (ShapeSides == 6)
            {
                Area = (3 * Math.sqrt(3) / 2) * Math.pow(ShapeLength, 2);                                                              //calculating area of hexagon
            }
            else
            {
                Area = 0;                                                                                                                                   //default case
            }
            System.out.println("The surface area of a shape with " + ShapeSides + " sides, each of length " + ShapeLength + ", is: " + Area);     //outputting area to user
        }
        scanner.close();                                                                                                                                 //closing scanner
    }
}

