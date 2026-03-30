package src.SD2_Coursework1;

import java.util.*;

public abstract class Audio {
    private String title;
    private String artist;
    private List<String> genres;
    private int runtime;

    /**
     * Constructor for Audio class
     * 
     * @param title   the title of the audio media
     * @param artist  the artist of the audio media
     * @param genres  the genres of the audio media
     * @param runtime the runtime of the audio media, in minutes
     *                Abstract class, so we can't create an instance of Audio
     *                Avoud redefining these elements in the subclasses
     *                By applying the concept of inhheritance, we can avoid code
     *                duplication
     */
    // Constructor for Audio class
    public Audio(String title, String artist, List<String> genres, int runtime) {
        this.title = title;
        this.artist = artist;
        this.genres = genres;
        this.runtime = runtime;
    }

    // Four Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getRuntime() {
        return runtime;
    }
}
