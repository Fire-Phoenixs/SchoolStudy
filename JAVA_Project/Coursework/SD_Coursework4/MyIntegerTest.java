package SD_Coursework4;

public class MyIntegerTest {
    public static void main(String[] args) {
        MyInteger number1 = new MyInteger(7);  //Test MyInteger()
        MyInteger number2 = new MyInteger(10);
        MyInteger number3 = new MyInteger(13);
        MyInteger number4 = new MyInteger(25);  
        System.out.println(number1.get() + ".isEven(): " + number1.isEven());  //Test methods get(), isEven(), isOdd(), isPrime()
        System.out.println(number2.get() + ".isEven(): " + number2.isEven());
        System.out.println(number1.get() + ".isOdd(): " + number1.isOdd());
        System.out.println(number2.get() + ".isOdd(): " + number2.isOdd());
        System.out.println(number1.get() + ".isPrime(): " + number1.isPrime());
        System.out.println(number4.get() + ".isPrime(): " + number4.isPrime());
        System.out.println("MyInteger.isEven(15): " + MyInteger.isEven(15));  //Test static methods isEven(int), isOdd(int), isPrime(int
        System.out.println("MyInteger.isEven(20): " + MyInteger.isEven(20));
        System.out.println("MyInteger.isOdd(15): " + MyInteger.isOdd(15));
        System.out.println("MyInteger.isOdd(20): " + MyInteger.isOdd(20));
        System.out.println("MyInteger.isPrime(17): " + MyInteger.isPrime(17));
        System.out.println("MyInteger.isPrime(25): " + MyInteger.isPrime(25));
        System.out.println("MyInteger.isEven(num1): " + MyInteger.isEven(number1));  //Test static methods isEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger)
        System.out.println("MyInteger.isEven(num2): " + MyInteger.isEven(number2));
        System.out.println("MyInteger.isOdd(num1): " + MyInteger.isOdd(number1));
        System.out.println("MyInteger.isOdd(num2): " + MyInteger.isOdd(number2));
        System.out.println("MyInteger.isPrime(num3): " + MyInteger.isPrime(number3));
        System.out.println("MyInteger.isPrime(num4): " + MyInteger.isPrime(number4));
        System.out.println("num1.equals(7): " + number1.equals(7));  //Test methods equals(int), equals(MyInteger)
        System.out.println("num1.equals(8): " + number1.equals(8));
        System.out.println("num1.equals(num3): " + number1.equals(number3));
        System.out.println("num1.equals(new MyInteger(7)): " + number1.equals(new MyInteger(7)));
        char[] charArray1 = { '1', '2', '3', '4' };  //Test static methods parseInt(char[]), parseInt(String)
        char[] charArray2 = { '5', '6', '7' };
        System.out.println(MyInteger.parseInt(charArray1));
        System.out.println(MyInteger.parseInt(charArray2));
        String str1 = "9876";
        String str2 = "543";
        System.out.println(MyInteger.parseInt(str1));
        System.out.println(MyInteger.parseInt(str2));
    }
}
