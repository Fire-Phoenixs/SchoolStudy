public class a4 {
    public static void main(String[] args) {
        String[] array = { "I","like","smelly","blue","chess"};
        int[] lengths = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            lengths[i] = array[i].length();
        }
        System.out.print("{");
        for (int i = 0; i < lengths.length; i++) {
            System.out.print(lengths[i]);
            if (i < lengths.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
