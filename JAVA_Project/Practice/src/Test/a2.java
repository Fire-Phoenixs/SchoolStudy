package Test;
import java.util.Scanner;
public class a2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = scanner.nextInt();
        System.out.print("请输入月份：");
        int month = scanner.nextInt();
        System.out.print("请输入日期：");
        int day = scanner.nextInt();
        int daysInYear = calculateWithSwitch(year, month, day);
        System.out.println("该日期是该年的第 " + daysInYear + " 天.");
        scanner.close();
    }
    public static int calculateWithSwitch(int year, int month, int day) {
        int daysInYear = 0;
        switch (month) {
            case 12:
                daysInYear += 30; 
            case 11:
                daysInYear += 31; 
            case 10:
                daysInYear += 30; 
            case 9:
                daysInYear += 31; 
            case 8:
                daysInYear += 31; 
            case 7:
                daysInYear += 30; 
            case 6:
                daysInYear += 31; 
            case 5:
                daysInYear += 30; 
            case 4:
                daysInYear += 31; 
            case 3:
                if (isLeapYear(year)) {
                    daysInYear += 29; 
                } else {
                    daysInYear += 28; 
                }
            case 2:
                daysInYear += 31; 
            case 1:
                daysInYear += day; 
                break;
            default:
                System.out.println("无效的月份输入");
                return -1;
        }
        return daysInYear;
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
