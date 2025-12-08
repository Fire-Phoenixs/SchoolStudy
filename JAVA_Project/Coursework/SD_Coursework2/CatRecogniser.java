package Coursework.SD_Coursework2;

import java.util.Scanner;

public class CatRecogniser {
    public static void main(String[] args) {
        System.out.println("Welcomr to the Cat Recogniser!");
        System.out.println("How many cats do you have?"); // 实现用户界面
        Scanner scanner = new Scanner(System.in);
        int NumberofCats = scanner.nextInt(); // 获取用户输入的猫的数量
        String[] CatNames = new String[NumberofCats];
        String[] CatHair = new String[NumberofCats];
        Double[] CatOld = new Double[NumberofCats]; // 创建数组存储猫的信息
        for (int i = 0; i < NumberofCats; i++) { // 循环获取每只猫的信息
            System.out.println("Please enter the name of cat #" + (i + 1) + ":");
            CatNames[i] = scanner.next();
            System.out.println("Does " + CatNames[i] + " have 'long' or 'short' hair?:");
            CatHair[i] = scanner.next();
            System.out.println("How old is " + CatNames[i] + "?:");
            CatOld[i] = scanner.nextDouble();
        }
        System.out.println("Do you wish to identify a cat?"); // 实现用户界面
        if (scanner.next().equalsIgnoreCase("yes")) { // 如果想要获取信息，则开始询问要求
            System.out.println("Does it have 'long' or 'short' hair?");
            String Hair_Type = scanner.next();
            System.out.println("Is it 'old' or 'young'?");
            String Age_Type = scanner.next();
            System.out.println("The following cats meet this criteria:");

            for (int i = 0; i < NumberofCats; i++) { // 遍历数组寻找符合条件的猫
                if (CatHair[i].equalsIgnoreCase(Hair_Type)
                        && ((Age_Type.equalsIgnoreCase("old") && CatOld[i] >= 10) ||
                                (Age_Type.equalsIgnoreCase("young") && CatOld[i] < 10))) {
                    System.out.println("- " + CatNames[i] + ", who is " + CatOld[i]);
                }
            }
        } else {
            System.out.println("Thank for using Cat Recogniser! Goodbye."); // 如果不想寻找，则输出结束语
        }
        scanner.close(); // 关闭输入区
    }
}