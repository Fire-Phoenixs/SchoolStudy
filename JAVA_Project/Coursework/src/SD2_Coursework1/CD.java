package src.SD2_Coursework1;

import java.util.*;
/**
 * The CD class represents optical disc media.
 * It inherits from the Audio class and adds specific fields for format and number of discs.
 * DESIGN CHOICE (to Minimize Code Duplication):
 * The constructor utilizes super() to pass common parameters (title, artist, genres, runtime) 
 * up to the parent Audio class, effectively avoiding the duplication of field declarations 
 * and assignment code.
 */
public class CD extends Audio {
    private String format;
    private int numberOfDiscs;

   /**
     * Constructor for the CD class.
     * @param title         the title of the CD
     * @param artist        the artist of the CD
     * @param genres        a list of genres associated with the CD
     * @param runtime       the runtime in minutes
     * @param format        the format of the CD (e.g., "flac", "mp3")
     * @param numberOfDiscs the number of discs in the CD
     */
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