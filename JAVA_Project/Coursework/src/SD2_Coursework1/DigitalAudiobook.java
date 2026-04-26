package src.SD2_Coursework1;

import java.util.*;

/**
 * The DigitalAudiobook class represents an audiobook in digital format.
 * DESIGN CHOICE:
 * It extends Digital to inherit digital-specific properties (size, format) and implements 
 * the Audiobook interface for narrator and author retrieval. This ensures a clean separation 
 * of concerns and avoids duplicating narrator logic across different audiobook formats.
 */
public class DigitalAudiobook extends Digital implements Audiobook {
    private String narrator;

    /**
     * Constructor for the DigitalAudiobook class.
     * @param title    the title of the audiobook
     * @param author   the author of the audiobook
     * @param genres   a list of genres
     * @param runtime  the runtime in minutes
     * @param format   the format of the digital file
     * @param size     the size of the file in megabytes
     * @param narrator the narrator of the audiobook
     */
    public DigitalAudiobook(String title, String author, List<String> genres, int runtime, String format, int size,
            String narrator) {
        super(title, author, genres, runtime, format, size);
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