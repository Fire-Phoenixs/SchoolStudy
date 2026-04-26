package src.SD2_Coursework1;

import java.util.*;
/**
 * The Digital class represents digital audio media.
 * It inherits from the Audio class and adds specific fields for file format and file size.
 * DESIGN CHOICE:
 * It calls super() to handle common properties. Although the 'format' field also exists 
 * in the CD class, declaring it here avoids creating an unnecessarily complex intermediate 
 * superclass, balancing code reusability with structural clarity.
 */

public class Digital extends Audio {
    private String format;
    private int size;

    /**
     * Constructor for the Digital class.
     * @param title   the title of the digital audio
     * @param artist  the artist of the digital audio
     * @param genres  a list of genres
     * @param runtime the runtime in minutes
     * @param format  the format of the digital audio (e.g., "mp3", "wav")
     * @param size    the size of the digital audio file in megabytes
     */
    public Digital(String title, String artist, List<String> genres, int runtime, String format, int size) {
        super(title, artist, genres, runtime);
        this.format = format;
        this.size = size;
    }

    public String getFormat() {
        return format;
    }

    public int getSize() {
        return size;
    }
}
