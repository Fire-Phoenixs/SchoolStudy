package simpleAIChat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AIChat {
    Scanner scanner;

    public static String textProcessing(String text){
        text = text.replaceAll("\\s+", " ");
        text = text.strip();
        String tempMaker = "##this is a i##";
        String punctuation = "[,.!?;:，。！？；：]";
        Pattern pattern = Pattern.compile("\\s+(" + punctuation + ")");
        text = pattern.matcher(text).replaceAll("$1");
        text = text.replaceAll("\\bI\\b", tempMaker);
        text = text.toLowerCase();
        text = text.replaceAll("##this is a i##", "I");
        text = text.replaceAll("\\bI\\b", "you");
        text = text.replaceAll("\\bme\\b", "you");
        text = text.replaceAll("\\bcan you\\b", "I can");
        text = text.replaceAll("\\bcould you\\b", "I could");
        text = text.replaceAll("\\?", "!");
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] sentense = new String[N];
        for (int i = 0; i < sentense.length; i++) {
            sentense[i] = scanner.nextLine();
        }
        for (int i = 0; i < sentense.length; i++) {
            System.out.println(sentense[i]);
            sentense[i] = textProcessing(sentense[i]);
            System.out.println("AI: " + sentense[i]);
        }
        scanner.close();

    }
}

