package simpleAIChat;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replaceAll("\\s+", " ");
        String tempMaker = "##this is a i##";
        text = text.replaceAll("\\bI\\b", tempMaker);
        text = text.toLowerCase();
        text = text.replaceAll("##this is a i##", "I");
        System.out.println(text);
        scanner.close();
    }
}
