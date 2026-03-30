package src.SD2_Coursework1;

import java.util.*;

// The CDAudiobook class represents an audiobook in CD format. It inherits from the CD class and implements the Audiobook interface, which requires it to provide methods for retrieving the author and narrator of the audiobook. By calling super(...), it initializes the common fields inherited from the CD class, while also adding a unique narrator field specific to audiobooks.
public class CDAudiobook extends CD implements Audiobook {
    private String narrator;

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
