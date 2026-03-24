import java.util.*;
import java.io.*;

public class TaskManager extends ArrayList<GeneralTask> {



    public void printAll() {
        for(GeneralTask t : this) { // this object is a list of tasks, so we can use the keyword "this" to refer to the list
            t.print();
        }
    }
    
    public ArrayList<GeneralTask> search(String str) {
        ArrayList<GeneralTask> result = new ArrayList<>();
        for(GeneralTask t : this) {
            if(t.getDescription().contains(str)) {
                result.add(t);
            }
        }
        return result;

    }
    
    public int removeOld(int date) {
        int removed = 0;
        Iterator<GeneralTask> it = this.iterator();
        while(it.hasNext()) {
            GeneralTask t = it.next();
            if(t.getDate() < date) {
                it.remove();
                ++removed;
            }
        }
        return removed;
    }
    
    public int removeDuplicates() {
       int originalSize = this.size();
       List<GeneralTask> uniqueTasks = new ArrayList<>();
    
    for (int i = 0; i < this.size(); i++) {
        GeneralTask currentTask = this.get(i);
        boolean isDuplicate = false;
        
        for (int j = 0; j < uniqueTasks.size(); j++) {
            GeneralTask uniqueTask = uniqueTasks.get(j);
            if (currentTask.toString().equals(uniqueTask.toString())) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            uniqueTasks.add(currentTask);
        }
    }

    this.clear();
    this.addAll(uniqueTasks);
    
    return originalSize - this.size();
    }
    
    public void saveToFile(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename));
            out.println(this.size());
            for(GeneralTask t : this) {
                t.save(out);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to save to file " + filename);
        }
    }
    
    public void loadFromFile(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        int count = Integer.parseInt(in.nextLine()); 
        for (int k = 0; k < count; ++k) {
            String type = in.nextLine();                                       
            if (type.equals("GeneralTask") || type.equals("MultiGeneralTask")) {
                String description = in.nextLine();
                int date = Integer.parseInt(in.nextLine());
                if (type.equals("GeneralTask")) {
                    this.add(new GeneralTask(description, date));
                } else {
                    int weeksToRepeat = Integer.parseInt(in.nextLine());
                    this.add(new MultiGeneralTask(description, date, weeksToRepeat));
                }
            }
            if (type.equals("CSTask") || type.equals("MultiCSTask")) {
                String description = in.nextLine();
                int date = Integer.parseInt(in.nextLine());
                int problemSheet = Integer.parseInt(in.nextLine());
                String problemsStr = in.nextLine();
                String[] problemsArr = problemsStr.split(",");
                int[] problems = new int[problemsArr.length];
                for (int i = 0; i < problems.length; ++i) {
                    problems[i] = Integer.parseInt(problemsArr[i].trim());
                }
                if (type.equals("CSTask")) {
                    this.add(new CSTask(description, date, problemSheet, problems));
                } else {
                    int weeksToRepeat = Integer.parseInt(in.nextLine());
                    this.add(new MultiCSTask(description, date, problemSheet, problems, weeksToRepeat));
                }
            }
            if (type.equals("HistoryTask") || type.equals("MultiHistoryTask")) {
                String description = in.nextLine();
                int date = Integer.parseInt(in.nextLine());
                String book = in.nextLine();
                String author = in.nextLine();
                String chaptersStr = in.nextLine();
                String[] chaptersArr = chaptersStr.split(",");
                int[] chapters = new int[chaptersArr.length];
                for (int i = 0; i < chapters.length; ++i) {
                    chapters[i] = Integer.parseInt(chaptersArr[i].trim());
                }
                if (type.equals("HistoryTask")) {
                    this.add(new HistoryTask(description, date, book, author, chapters));
                } else {
                    int weeksToRepeat = Integer.parseInt(in.nextLine());
                    this.add(new MultiHistoryTask(description, date, book, author, chapters, weeksToRepeat));
                }
            }
        }
        in.close();
    }    
}
