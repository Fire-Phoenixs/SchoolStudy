import java.io.PrintWriter;

public class MultiHistoryTask extends HistoryTask implements MultiTask {
    public int weeksToRepeat;
    
    public int getWeeksToRepeat() {
        return weeksToRepeat;
    }    
    
    public MultiHistoryTask(String description, int date, String book, String author, int[] chapters, int weeksToRepeat) {
        super(description, date, book, author, chapters);
        this.weeksToRepeat = weeksToRepeat;
    }    
    
    public void print() {
        super.print();
        System.out.println("Repeat for " + weeksToRepeat + " weeks.");
    }

    @Override
    public void save(PrintWriter out) {
        out.write("MultiHistoryTask\n");
        out.write(getDescription() + "\n");
        out.write(getDate() + "\n");
        out.write(getBook() + "\n");
        out.write(getAuthor() + "\n");
        StringBuilder chaptersStr = new StringBuilder();
        for (int c : getChapters()) {
            chaptersStr.append(c).append(",");
        }
        out.write(chaptersStr.toString() + "\n");
        out.write(weeksToRepeat + "\n");
    }

}
