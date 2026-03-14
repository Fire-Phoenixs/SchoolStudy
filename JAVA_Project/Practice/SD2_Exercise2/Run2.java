// Examples illustrating the differnece between reference types and object types,
// and their relation to upcasting and downcasting.
package SD2_Exercise2;

public class Run2 {
    public static void main(String[] args) {
        GeneralTask gt = new GeneralTask("Cook lunch.", 11);
//        int[] chapters1  = {2,5,8};
//        GeneralTask gt = new HistoryTask("Russian history",
//                                         15,
//                                         "The Russian Revolution",
//                                         "Sheila Fitzpatrick",
//                                         chapters1);

        int[] chapters  = {1,2,3,5,7};
        HistoryTask ht = new HistoryTask("Ancient history",
                                         8,
                                         "A History of Ancient Egypt",
                                         "Marc Van De Mieroop",
                                         chapters);



        ht.print();

        System.out.println();

        ht = (HistoryTask) gt;
        ht.print();

    }
}
