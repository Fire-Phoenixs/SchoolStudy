package SD2_Exercise2;

public class GeneralTask {
    private String description;
    private int date; // For the sake of simplicity "date" is just a number.
                      // Think of it as thenumber of days since 2026-01-01 or something like that :)

    // getters and setters for the above
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

    // constructor
    public GeneralTask(String description, int date) {
        this.description = description;
        this.date = date;
    }

    // printing the information about the task
    public void print() {
        System.out.println("Description: " + description);
        System.out.println("Date: " + date);
    }
}
