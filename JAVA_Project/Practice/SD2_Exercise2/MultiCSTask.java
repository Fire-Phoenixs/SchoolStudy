import java.io.PrintWriter;

public class MultiCSTask extends CSTask implements MultiTask {
    public int weeksToRepeat;
    
    public int getWeeksToRepeat() {
        return weeksToRepeat;
    }
    
    public MultiCSTask(String description, int date, int problemSheet, int[] problems, int weeksToRepeat) {
        super(description, date, problemSheet, problems);
        this.weeksToRepeat = weeksToRepeat;
    }    
    
    public void print() {
        super.print();
        System.out.println("Repeat for " + weeksToRepeat + " weeks.");
    }

    @Override
    public void save(PrintWriter out) {
        out.write("MultiCSTask\n");
        out.write(getDescription() + "\n");
        out.write(getDate() + "\n");
        out.write(getProblemSheet() + "\n");
        StringBuilder problemsStr = new StringBuilder();
        for (int p : getProblems()) {
            problemsStr.append(p).append(",");
        }
        out.write(problemsStr.toString() + "\n");
        out.write(weeksToRepeat + "\n");
    }
}
