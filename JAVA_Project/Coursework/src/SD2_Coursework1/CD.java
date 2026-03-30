package src.SD2_Coursework1;

import java.util.*;
/**
 * The CD class represents optical disc media.
 * It inherits from Audio and adds a unique numTracks (number of tracks) field.
 * 
 * @param numberOfDiscs the number of Discs in the CD
 * @param formate       the format of the CD (e.g., "flac", "mp3")
 * By calling super(...), it initializes the common fields to avoid duplicate code.
 */

public class CD extends Audio {
    private String format;
    private int numberOfDiscs;

    public CD(String title, String artist, List<String> genres, int runtime, String format, int numberOfDiscs) {
        super(title, artist, genres, runtime);
        this.format = format;
        this.numberOfDiscs = numberOfDiscs;
    }

    public String getFormat() {
        return format;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }
}