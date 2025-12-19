package Test;
import java.util.Scanner;
public class a3 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入数字A：");
    int a = scanner.nextInt();
    System.out.print("请输入数字B：");
    int b = scanner.nextInt();
    if (a > b) {
        int c = a;
        a = b;
        b = c;
    }
    for (int i = a; i <= b; i++) {
        int square = i * i;
        System.out.println(i + "的平方是：" + square);
    }
    scanner.close();
}
}
