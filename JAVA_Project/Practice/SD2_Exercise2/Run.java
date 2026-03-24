import java.util.*;
import java.io.*;

public class Run {

    private static Console console = System.console();

    public static void main(String[] args) throws FileNotFoundException {
        TaskManager tasks = new TaskManager();
        
        boolean quit = false;
        while(!quit) {
            // display the menu
            System.out.println("1 - Show all tasks");
            System.out.println("2 - Add a new task");
            System.out.println("3 - Search");
            System.out.println("4 - Remove old tasks");
            System.out.println("5 - Remove duplicate tasks");
            System.out.println("6 - Save to file");
            System.out.println("7 - Load from file");
            System.out.println("0 - Quit");
            int selection;
            try{
                selection = Integer.parseInt(console.readLine("Select an option: "));
            } catch(NumberFormatException e) {
                selection = -1; // an illegal option in case of a non-integer input
            }
            switch(selection) {
                case 1: {
                    System.out.println();
                    tasks.printAll();
                    break;
                }
                case 2: {
                    GeneralTask t = inputTask();
                    tasks.add(t);
                    break;
                }
                case 3: {
                    String str = console.readLine("Phrase to search for: ");
                    ArrayList<GeneralTask> searchResult = tasks.search(str);
                    System.out.println("\nTasks mentioning \"" + str + "\":");
                    for(GeneralTask t : searchResult) {
                        t.print();
                    }
                    break;
                }
                case 4: {
                   int date = readInt("Tasks due before which date are considered old? ");
                   int removed = tasks.removeOld(date);
                   System.out.println("Number of tasks removed: " + removed);
                   break;
                }
                case 5: {
                   int removed = tasks.removeDuplicates();
                   System.out.println("Number of tasks removed: " + removed);
                   break;
                }
                case 6: {
                   String filename = console.readLine("File to save to: ");
                   tasks.saveToFile(filename);
                   break;
                }
                case 7: {
                   String filename = console.readLine("File to load: ");
                   tasks.loadFromFile(filename);
                   break;
                }
                case 0: {
                   quit = true;
                   System.out.println("Exiting the program.");
                   break;
                }
                default: {
                    System.err.println("Unknown option selected.");
                    break;
                }
            }
            System.out.println("\n"); 
        }
    }
 
    // Function for entering a task from a keyboard.
    // Has its own mini-menu.
    private static GeneralTask inputTask() {
        GeneralTask newTask = null;
        while(newTask == null) {
            System.out.println("\tChoose the kind of task: ");
            System.out.println("\t1 - General Task");
            System.out.println("\t2 - CS Task");
            System.out.println("\t3 - History Task");
            int selection = readInt("\tSelect an option: ");
            switch(selection) {
                case 1: {
                    String description = console.readLine("\tDescription: ");
                    int date = readInt("\tDate: ");
                    int weeksToRepeat = Integer.parseInt(console.readLine("\tRepeat for how many weeks(0 for no repeat)? "));
                    if(weeksToRepeat == 0) {
                        newTask = new GeneralTask(description, date);
                    } else {
                        newTask = new MultiGeneralTask(description, date, weeksToRepeat);
                    }
                    break;
                }
                
                case 2: {
                     String description = console.readLine("\tDescription: ");
                    int date = readInt("\tDate: ");
                    int ProblemSheet = Integer.parseInt(console.readLine("\tProblem sheet number: "));
                    int[] problems = null;
                    // repeating the request to input the problems until the user inputs it in a correct format
                    boolean problemsOK;
                    do {
                        try {
                            String problemStr = console.readLine("\tComma-separated list of problems (e.g., 1, 5, 8): ");
                            String[] problemArr = problemStr.split(",");
                            problems = new int[problemArr.length];
                            for(int i = 0; i < problems.length; ++i) {
                                problems[i] = Integer.parseInt(problemArr[i].trim());
                            }
                            problemsOK = true;
                        } catch(NumberFormatException e) {
                            System.out.println("Please enter a comma-separated list of integers.");
                            problemsOK = false;
                        }
                    } while(!problemsOK);
                    int weeksToRepeat = Integer.parseInt(console.readLine("\tRepeat for how many weeks(0 for no repeat)? "));
                    if(weeksToRepeat == 0) {
                        newTask = new CSTask(description, date, ProblemSheet, problems);
                    } else {
                        newTask = new MultiCSTask(description, date, ProblemSheet, problems, weeksToRepeat);
                    }
                    break;
                }
                
                case 3: {
                    String description = console.readLine("\tDescription: ");
                    int date = readInt("\tDate: ");
                    String book = console.readLine("\tBook title: ");
                    String author = console.readLine("\tAuthor: ");
                    int[] chapters = null;
                    // repeating the request to input the chapters until the user inputs it in a correct format
                    boolean chaptersOK;
                    do {
                        try {
                            String chapterStr = console.readLine("\tComma-separated list of chapters (e.g., 1, 5, 8): ");
                            String[] chapterArr = chapterStr.split(",");
                            chapters = new int[chapterArr.length];
                            for(int i = 0; i < chapters.length; ++i) {
                                chapters[i] = Integer.parseInt(chapterArr[i].trim());
                            }
                            chaptersOK = true;
                        } catch(NumberFormatException e) {
                            System.out.println("Please enter a comma-separated list of integers.");
                            chaptersOK = false;
                        }
                    } while(!chaptersOK);
                    int weeksToRepeat = Integer.parseInt(console.readLine("\tRepeat for how many weeks(0 for no repeat)? "));
                    if(weeksToRepeat == 0) {
                        newTask = new HistoryTask(description, date, book, author, chapters);
                    } else {
                        newTask = new MultiHistoryTask(description, date, book, author, chapters, weeksToRepeat);
                    }
                    break;
                }
                default: {
                    System.err.println("\tUnknown option selected.");
                    break;
                }
            }
        }
        return newTask;
    }
    
    // Helper function for reading integers.
    // Repeats the request to input an integer until the input format is correct.
    private static int readInt(String prompt) {
        int value = 0;
        boolean ok;
        do{
            try { 
                value = Integer.parseInt(console.readLine(prompt));
                ok = true;
            } catch(NumberFormatException e) {
                System.err.println("Please input an integer.");
                ok = false;
            }
        } while(!ok);
        return value;
    }   
}    


















