package SD2_Exercise2;

public class HistoryTask extends GeneralTask {
    private String book;
    private String author;
    private int[] chapters;

    // getters and setters for the above
    public String getBook() {
        return this.book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String Author) {
        this.author = author;
    }

    public int[] getChapters() {
        return this.chapters;
    }

    public void setChapters(int[] chapters) {
        this.chapters = chapters;
    }

    // constructor
    public HistoryTask(String description, int date, String book, String author, int[] chapters) {
        super(description, date);
        this.book = book;
        this.author = author;
        this.chapters = chapters;
    }

    // printing the information about the task
    public void print() {
        super.print(); // print out the information using the print() method from GeneralTask
        System.out.println("Book: " + book);
        System.out.println("Author: " + author);
        System.out.print("Chapters: ");
        for (int c : chapters) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
