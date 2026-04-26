package src.SD2_Coursework1;

import java.util.*;
/**
 * The Vinyl class represents the vinyl record medium.
 * It inherits from the Audio class and adds a specific field for rotation speed (RPM).
 * DESIGN CHOICE (Code Reusability):
 * By calling super(), it initializes the common fields defined in the Audio superclass, 
 * maintaining a clean class structure and preventing redundant code.
 */

public class Vinyl extends Audio {
    private int rpm;

    /**
     * Constructor for the Vinyl class.
     * @param title   the title of the vinyl record
     * @param artist  the artist of the vinyl record
     * @param genres  a list of genres associated with the vinyl record
     * @param runtime the runtime of the vinyl record in minutes
     * @param rpm     the rotation speed in Revolutions Per Minute (RPM)
     */
    public Vinyl(String title, String artist, List<String> genres, int runtime, int rpm) {
        super(title, artist, genres, runtime);
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }
}