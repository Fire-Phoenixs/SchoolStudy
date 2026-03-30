package src.SD2_Coursework1;

import java.util.*;
/**
 * The Digital class represents digital audio media.
 * It inherits from Audio and adds specific fields for format and size.
 * 
 * @param format the format of the digital audio (e.g., "mp3", "wav")
 * @param size   the size of the digital audio file in megabytes
 * By calling super(...), it initializes the common fields, avoiding code duplication.
 * Obviously, the parameter "Format" has already been used in the CD class. However, creating a new class for this purpose would lead to even more severe code reusability issues. Therefore, I have decided to reintroduce this parameter.
 */

public class Digital extends Audio {
    private String format;
    private int size;

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
