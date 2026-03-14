package SD2_Exercise2;

public class CSTask extends GeneralTask {
    private int problemSheet;
    private int[] problems;

    // getters and setters for the above
    public int getProblemSheet() {
        return this.problemSheet;
    }

    public void setProblemSheet(int problemSheet) {
        this.problemSheet = problemSheet;
    }

    public int[] getProblems() {
        return problems;
    }

    public void setProblems(int[] problems) {
        this.problems = problems;
    }

    // constructor
    public CSTask(String description, int date, int problemSheet, int[] problems) {
        super(description, date);
        this.problemSheet = problemSheet;
        this.problems = problems;
    }

    // printing the information about the task
    public void print() {
        super.print(); // print out the information using the print() method from GeneralTask
        System.out.println("Problem sheet: " + problemSheet);
        System.out.print("Problems: ");
        for (int p : problems) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
