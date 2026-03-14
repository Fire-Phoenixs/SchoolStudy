package SD2_Exercise2;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        // We'll keep the tasks in listsjav:
        ArrayList<GeneralTask> Tasks = new ArrayList<GeneralTask>();

        // Populating the list with some example tasks:
        Tasks.add(new GeneralTask("Go to gym.", 27));

        int[] problems1 = {1, 5, 17};
        Tasks.add(new CSTask("Java Exercises", 10, 1, problems1));

        int[] chapters1  = {2,5,8};
        Tasks.add(new HistoryTask("Russian history",
                                   15,
                                   "The Russian Revolution",
                                   "Sheila Fitzpatrick",
                                   chapters1
                                   ));

        Tasks.add(new GeneralTask("Cook lunch.", 11));

        int[] problems2 = {2, 3, 5};
        Tasks.add(new CSTask("C++ homework", 22, 1, problems2));

        Tasks.add(new GeneralTask("Pay bills.", 2));

        Tasks.add(new GeneralTask("Book flights.", 18));

        int[] chapters2  = {1,2,3,5,7};
        Tasks.add(new HistoryTask("Ancient history",
                                  8,
                                  "A History of Ancient Egypt",
                                  "Marc Van De Mieroop",
                                  chapters2
                                  ));


        Tasks.add(new GeneralTask("Assemble furniture.", 30));



        // EXERCISE: instead of simply printing out all the tasks,
        // sort the list of tasks so that the ones with the earlier deadlines come first,
        // and then print out the sorted list of tasks.
        for (int i = 0; i < Tasks.size(); i++) {
            for (int j = 0; j < Tasks.size() - 1; j++) {
                if (Tasks.get(j).getDate() > Tasks.get(j + 1).getDate()) {
                    GeneralTask temp = Tasks.get(j);
                    Tasks.set(j, Tasks.get(j + 1));
                    Tasks.set(j + 1, temp);
                }
            }
        }
        for(GeneralTask t : Tasks) {
            t.print();
            System.out.println();
        }
    }
}
