package src.SD2_Coursework1;

import java.util.*;

/**
 * Abstract base class representing general audio media.
 * DESIGN CHOICE (Minimizing Code Duplication):
 * To ensure no unnecessary code duplication, common fields shared across all 
 * audio types (title, artist, genres, and runtime) are centralized in this superclass. 
 * Subclasses (CD, Vinyl, Digital) will inherit these fields and their respective getters, 
 * eliminating the need to redefine them in every single class. 
 * Furthermore, the class is declared as 'abstract' to fulfill the requirement that 
 * a generic 'Audio' object cannot be instantiated directly.
 */
public abstract class Audio {
    private String title;
    private String artist;
    private List<String> genres;
    private int runtime;

    /**
     * Constructor for the Audio class.
     * @param title   the title of the audio media
     * @param artist  the artist of the audio media
     * @param genres  a list of genres associated with the audio media
     * @param runtime the runtime of the audio media in minutes
     */
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
