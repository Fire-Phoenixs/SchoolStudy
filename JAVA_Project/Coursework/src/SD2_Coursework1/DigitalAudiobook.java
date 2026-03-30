package src.SD2_Coursework1;

import java.util.*;

// The DigitalAudiobook class represents an audiobook in digital format. It inherits from the Digital class and implements the Audiobook interface, which requires it to provide methods for retrieving the author and narrator of the audiobook. By calling super(...), it initializes the common fields inherited from the Digital class, while also adding a unique narrator field specific to audiobooks.
public class DigitalAudiobook extends Digital implements Audiobook {
    private String narrator;

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