package BilibiliJavaClassWengKai;

import java.util.Scanner;

public class P34 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x;
        int cnt;
        int a = 0;
        cnt = scanner.nextInt();
        int[] numbers = new int[cnt];
        double sum = 0;
        x = scanner.nextInt();
        while (x != -1) {
            numbers[a] = x;
            sum += x;
            a++;
            x = scanner.nextInt();
        }
        if (a > 0) {
            double average = sum / cnt;
            for (int i = 0; i < cnt; i++){
                if (numbers[i] > average) {
                    System.out.println(numbers[i]);
                }

            }
            System.out.println(sum / cnt);
        }
        scanner.close();
    }
}
