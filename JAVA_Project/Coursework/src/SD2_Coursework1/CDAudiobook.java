package src.SD2_Coursework1;

import java.util.*;

/**
 * The CDAudiobook class represents an audiobook in CD format.
 * DESIGN CHOICE:
 * This class demonstrates multiple type inheritance. It extends the CD class to inherit 
 * physical media properties and implements the Audiobook interface 
 * to enforce audiobook-specific behaviors. This approach maximizes 
 * code reuse while satisfying all functional requirements.
 */
public class CDAudiobook extends CD implements Audiobook {
    private String narrator;

    /**
     * Constructor for the CDAudiobook class.
     * @param title         the title of the audiobook
     * @param author        the author of the audiobook
     * @param genres        a list of genres
     * @param runtime       the runtime in minutes
     * @param format        the format of the CD
     * @param numberOfDiscs the number of discs
     * @param narrator      the narrator of the audiobook
     */
    public CDAudiobook(String title, String author, List<String> genres, int runtime, String format, int numberOfDiscs,
            String narrator) {
        super(title, author, genres, runtime, format, numberOfDiscs);
        this.narrator = narrator;
    }

    @Override
    public String getAuthor() {
        return getArtist();
    }

    @Override
    public String getNarrator() {
        return narrator;
    }

}
