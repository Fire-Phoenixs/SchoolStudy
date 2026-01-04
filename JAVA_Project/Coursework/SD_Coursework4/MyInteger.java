package SD_Coursework4;

public class MyInteger {

    private int value;  //Create a private int data named value

    public MyInteger(int value) {  //A constructor method that creates a MyInteger object with a int data named value
        this.value = value;
    }

    public int get() {  //A get method to get the int data named value
        return value;
    }

    public boolean isEven() {  //A method that returns true if the value is even
        return value % 2 == 0;
    }

    public boolean isOdd() {  //A method that returns true if the value is odd
        return value % 2 != 0;
    }

    public boolean isPrime() {  //A method that returns true if the value is prime
        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        if (value % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isEven(int value) {  //A static method that returns true if thint data named e value is even
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {  //A static method that returns true if the int data named value is odd
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {  //A static method that returns true if the int data named value is prime
        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        if (value % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger myInteger) {  //A static method that returns true if the value of myInteger is even
        return myInteger.get() % 2 == 0;
    }

    public static boolean isOdd(MyInteger myInteger) {  //A static method that returns true if the value of myInteger is odd
        return myInteger.get() % 2 != 0;
    }

    public static boolean isPrime(MyInteger myInteger) {  //A static method that returns true if the value of myInteger is prime
        int value = myInteger.get();
        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        if (value % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int value) {  //A method that returns true if the value is equal to the value of this object
        return this.value == value;
    }

    public boolean equals(MyInteger myInteger) {  //A method that returns true if the value of myInteger is equal to the value of this object
        return this.value == myInteger.get();
    }

    public static int parseInt(char[] chars) {  //A static method that converts an array of numeric characters to an int value
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                result = result * 10 + (chars[i] - '0');
            }
        }
        return result;
    }

    public static int parseInt(String str) {  //A static method that converts a string to an int value
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + (str.charAt(i) - '0');
            }
        }
        return result;
    }
}
