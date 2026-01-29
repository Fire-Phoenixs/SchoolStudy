package Test;
//nodhfauife123import java.util.InputMismatchException;
//import java.io.*;
import java.util.Scanner;
public class a1 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a binaryString");
        String binaryString = "";
        try{
            binaryString = scanner.nextLine();
            if (!binaryString.matches("[01]+")) {
                throw new NumberFormatException("Invalid binary string: " + binaryString);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
            System.out.println("Please enter a valid binary string.");
        }
        int decimalValue = 0;
        decimalValue = Integer.valueOf(binaryString, 2);
        System.out.println("The decimal value is: " + decimalValue);
        scanner.close();

    }
}
