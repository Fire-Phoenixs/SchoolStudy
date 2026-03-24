import java.io.PrintWriter;
import java.util.Arrays;

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

    //public void setAuthor(String Author) {
    //    this.author = author;
    //}

    public int[] getChapters() {
        return this.chapters;
    }

    public void setChapters(int[] chapters) {
        this.chapters = chapters;
    }

    public HistoryTask(String description, int date, String book, String author, int[] chapters) {
        super(description, date);
        this.book = book;
        this.author = author;
        this.chapters = chapters;
    }

    public void print() {
        super.print();
        System.out.println("Book: " + book);
        System.out.println("Author: " + author);
        System.out.print("Chapters: ");
        for (int c : chapters) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "HistoryTask{" +
                "description='" + getDescription() + '\'' +
                ", date=" + getDate() +
                ", book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + Arrays.toString(chapters) +
                '}';
    }

    @Override
    public void save(PrintWriter out) {
        out.write("HistoryTask\n");
        out.write(getDescription() + "\n");
        out.write(getDate() + "\n");
        out.write(book + "\n");
        out.write(author + "\n");
        StringBuilder chaptersStr = new StringBuilder();
        for (int c : chapters) {
            chaptersStr.append(c).append(",");
        }
        out.write(chaptersStr.toString() + "\n");
    }

}
