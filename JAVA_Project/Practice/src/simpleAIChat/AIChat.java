package simpleAIChat;
import java.util.Scanner;

public class AIChat {
    Scanner scanner;
    int N;
    String[] sentense;

    public static String textProcessing(String text){
        text = text.replaceAll("\\s+", " ");
        String tempMaker = "##this is a i##";
        text = text.replaceAll("\\bI\\b", tempMaker);
        text = text.toLowerCase();
        text = text.replaceAll("##this is a i##", "I");
        text = text.replaceAll("\\bcan you\\b", "I can");
        text = text.replaceAll("\\bcould you\\b", "I could");
        text = text.replaceAll("\\bI\\b", "you");
        text = text.replaceAll("\\bme\\b", "you");
        text = text.replaceAll("\\b?\\b", "!");
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] sentense = new String[N];
        for (int i = 0; i < sentense.length; i++) {
            sentense[i] = scanner.nextLine();
            System.out.println(sentense[i]);
            sentense[i] = textProcessing(sentense[i]);
            System.out.println("AI: " + sentense[i]);
        }
        scanner.close();

    }
}

