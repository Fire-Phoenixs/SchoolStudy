import java.io.PrintWriter;

public class GeneralTask {
    private String description;
    private int date;
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public GeneralTask(String description, int date) {
        this.description = description;
        this.date = date;
    }

    public void print() {
        System.out.println("Description: " + description);
        System.out.println("Date: " + date);
    }

    @Override
    public String toString() {
        return "GeneralTask{" +
                "description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public void save(PrintWriter out) {
        out.write("GeneralTask\n");
        out.write(description + "\n");
        out.write(date + "\n");       
    }
}
