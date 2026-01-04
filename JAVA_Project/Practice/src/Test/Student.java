package Test;


public class Student {
    private String Name;
    private int[] Scores;

    public Student(String name, int[] scores) {
        this.Name = name;
        this.Scores = scores;
    }

    public Student ShallowCopy() {
        return new Student(this.Name, this.Scores);
    }

    public Student DeepCopy() {
        int[] newScores = new int[this.Scores.length];
        System.arraycopy(this.Scores, 0, newScores, 0, this.Scores.length);
        return new Student(this.Name, newScores);
    }
}

