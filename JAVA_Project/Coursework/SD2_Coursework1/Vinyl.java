package SD2_Coursework1;

import java.util.*;
/**
 * The Vinyl class represents the vinyl record medium.
 * It inherits from Audio and adds a specific rpm (rotation speed) field.
 * @param rpm the rotation speed of the vinyl record
 * It initializes the common fields by calling super(...), avoiding duplicate code.
 */

public class Vinyl extends Audio {
    private int rpm;

    public Vinyl(String title, String artist, List<String> genres, int runtime, int rpm) {
        super(title, artist, genres, runtime);
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }
}