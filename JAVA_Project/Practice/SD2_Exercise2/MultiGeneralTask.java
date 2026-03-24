import java.io.PrintWriter;

public class MultiGeneralTask extends GeneralTask implements MultiTask {
    public int weeksToRepeat;
    
    public int getWeeksToRepeat() {
        return weeksToRepeat;
    }
    
    public MultiGeneralTask(String description, int date, int weeksToRepeat) {
        super(description, date);
        this.weeksToRepeat = weeksToRepeat;
    }
    
    public void print() {
        super.print();
        System.out.println("Repeat for " + weeksToRepeat + " weeks.");
    }

    @Override
    public void save(PrintWriter out) {
        out.write("MultiGeneralTask\n");
        out.write(getDescription() + "\n");
        out.write(getDate() + "\n");
        out.write(weeksToRepeat + "\n");
    }
}
