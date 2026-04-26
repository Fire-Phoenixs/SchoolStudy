package src.SD2_Coursework1;

import java.util.*;

/**
 * The AudioDB class acts as the database managing a collection of Audio objects.
 * It provides methods to add, print, and search the media library.
 */
public class AudioDB {
    private ArrayList<Audio> audioList;
    
    public AudioDB() {
        audioList = new ArrayList<>();
    }

    public AudioDB(ArrayList<Audio> UninitialList) {
        audioList = new ArrayList<>();
        for (Audio a : UninitialList) {
            audioList.add(a);
        }
    }
    
    /**
     * Inserts the given Audio object into the list while maintaining 
     * alphabetical (lexicographical) order based on the title.
     * DESIGN CHOICE & LOGIC:
     * To achieve an ordered insertion, the method checks if the list is empty first. 
     * If not, it iterates through the list using String.compareTo(). When it finds an 
     * existing element whose title comes alphabetically after the new element's title, 
     * it inserts the new element at that index. If the loop finishes without finding 
     * such an element, it appends the new element to the end of the list.
     * @param b the Audio object to be added to the database
     */
    public void add(Audio b) {
        if (audioList.isEmpty()) {
            audioList.add(b);
            return;
        }

        int i = 0;

        while (i < audioList.size()) {
            if (audioList.get(i).getTitle().compareTo(b.getTitle()) < 0) {
                i++;
            } else {
                audioList.add(i, b);
                break;
            }
        }

        if (i == audioList.size()) {
            audioList.add(b);
        }
    }
    
    /**
     * Prints the details of each audio media in the provided list.
     * DESIGN CHOICE:
     * It uses getClass() to perform type checking on each element. This allows the 
     * method to safely cast the generic Audio object to its specific subclass 
     *  and print its unique fields in a formatted manner.
     * @param audioList the list of audio media to be printed
     */
    
    public void printList(ArrayList<Audio> audioList) {
        if (audioList.isEmpty()) {
            System.out.println("No audio media in DB.");
        } 
        for (Audio a : audioList) {
            if (a.getClass() == CD.class) {
                CD cd = (CD) a;
                System.out.println("Title: " + cd.getTitle());
                System.out.println("Artist: " + cd.getArtist());
                for (int i = 0; i < cd.getGenres().size() - 1; i++) {
                    System.out.print("Genres: " + cd.getGenres().get(i) + ", ");
                }
                System.out.println(cd.getGenres().get(cd.getGenres().size() - 1));
                System.out.println("Runtime: " + cd.getRuntime() + " minutes");
                System.out.println("Discs: " + cd.getNumberOfDiscs());
                System.out.println("Format: " + cd.getFormat());
                System.out.println("Type: CD");
                System.out.println();
            }

            else if (a.getClass() == Digital.class) {
                Digital da = (Digital) a;
                System.out.println("Title: " + da.getTitle());
                System.out.println("Artist: " + da.getArtist());
                for (int i = 0; i < da.getGenres().size() - 1; i++) {
                    System.out.print("Genres: " + da.getGenres().get(i) + ", ");
                }
                System.out.println(da.getGenres().get(da.getGenres().size() - 1));
                System.out.println("Runtime: " + da.getRuntime() + " minutes");
                System.out.println("Format: " + da.getFormat());
                System.out.println("Size: " + da.getSize() + " mb");
                System.out.println("Type: digital audio");
                System.out.println();
            }

            else if (a.getClass() == DigitalAudiobook.class) {
                DigitalAudiobook da = (DigitalAudiobook) a;
                System.out.println("Title: " + da.getTitle());
                System.out.println("Author: " + da.getArtist());
                for (int i = 0; i < da.getGenres().size() - 1; i++) {
                    System.out.print("Genres: " + da.getGenres().get(i) + ", ");
                }
                System.out.println(da.getGenres().get(da.getGenres().size() - 1));
                System.out.println("Runtime: " + da.getRuntime() + " minutes");
                System.out.println("Format: " + da.getFormat());
                System.out.println("Size: " + da.getSize() + " mb");
                System.out.println("Narrator: " + da.getNarrator());
                System.out.println("Type: digital audiobook");
                System.out.println();
            }

            else if (a.getClass() == Vinyl.class) {
                Vinyl v = (Vinyl) a;
                System.out.println("Title: " + v.getTitle());
                System.out.println("Artist: " + v.getArtist());
                for (int i = 0; i < v.getGenres().size() - 1; i++) {
                    System.out.print("Genres: " + v.getGenres().get(i) + ", ");
                }
                System.out.println(v.getGenres().get(v.getGenres().size() - 1));
                System.out.println("Runtime: " + v.getRuntime() + " minutes");
                System.out.println("RPM: " + v.getRpm());
                System.out.println("Type: vinyl");
                System.out.println();
            }

            else if (a.getClass() == CDAudiobook.class) {
                CDAudiobook ca = (CDAudiobook) a;
                System.out.println("Title: " + ca.getTitle());
                System.out.println("Author: " + ca.getArtist());
                for (int i = 0; i < ca.getGenres().size() - 1; i++) {
                    System.out.print("Genres: " + ca.getGenres().get(i) + ", ");
                }
                System.out.println(ca.getGenres().get(ca.getGenres().size() - 1));
                System.out.println("Runtime: " + ca.getRuntime() + " minutes");
                System.out.println("Discs: " + ca.getNumberOfDiscs());
                System.out.println("Format: " + ca.getFormat());
                System.out.println("Narrator: " + ca.getNarrator());
                System.out.println("Type: CD audiobook");
                System.out.println();
            }
        }
    }
    
    // Getters for the search functions
    public ArrayList<Audio> getAllAudio() {
        return audioList;
    }

    /**
     * Searches for audio media by matching the given title.
     * DESIGN CHOICE:
     * The search is implemented to be case-insensitive to improve user experience. 
     * It converts both the search query and the audio titles to lowercase. 
     * It uses the .contains() method to allow for partial string matching.
     * @param title the title keyword to search for
     * @return an ArrayList of matching Audio objects
     */
    public ArrayList<Audio> getAudioMediaByTitle(String title) {
        ArrayList<Audio> result = new ArrayList<>();
        String ResearchTitle = title.toLowerCase();
        for (Audio a : audioList) {
            String AudioTitle = a.getTitle().toLowerCase();
            if (AudioTitle.contains(ResearchTitle)) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Retrieves a list of all unique genres across all audio media in the database.
     * DESIGN CHOICE:
     * A HashSet is utilized internally to store the genres during iteration. 
     * This data structure automatically handles duplicates, ensuring that the final 
     * list contains only unique genre strings before returning it as an ArrayList.
     * @return an ArrayList containing all unique genres
     */
    public ArrayList<String> getAllGenres() {
        Set<String> genreSet = new HashSet<>();
        for (Audio a : audioList) {
            genreSet.addAll(a.getGenres());
        }
        return new ArrayList<>(genreSet);
    }
    
    /**
     * Searches for audio media that matches the specified genre.
     * DESIGN CHOICE:
     * The method converts the search input to lowercase to ensure case-insensitive matching. 
     * It iterates through each audio object and checks its genre list for an exact string match.
     * @param genre the genre to search for
     * @return an ArrayList of matching Audio objects
     */
    public ArrayList<Audio> getAudioMediaByGenre(String genre) {
        String ResearchGenre = genre.toLowerCase();
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            for (String g : a.getGenres()) {
                if (g.equals(ResearchGenre)) {
                    result.add(a);
                }
            }
        }
        return result;
    }
    
    /**
     * Retrieves all physical audio media from the database.
     * DESIGN CHOICE:
     * It uses getClass() to filter the collection. Only objects that are explicitly 
     * instances of CD, Vinyl, or CDAudiobook are classified as physical media 
     * and added to the result list.
     * @return an ArrayList of physical Audio objects
     */
    public ArrayList<Audio> getPhysicalMedia() {
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == CD.class || a.getClass() == Vinyl.class || a.getClass() == CDAudiobook.class) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Retrieves all digital audio media from the database.
     * DESIGN CHOICE:
     * It uses getClass() to filter the collection. Only objects that are explicitly 
     * instances of Digital or DigitalAudiobook are classified as digital media.
     * @return an ArrayList of digital Audio objects
     */
    public ArrayList<Audio> getDigitalMedia() {
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == Digital.class || a.getClass() == DigitalAudiobook.class) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Searches for music media by a specific artist.
     * DESIGN CHOICE:
     * The method first filters out audiobooks by checking classes (allowing only CD, Vinyl, and Digital). 
     * Then, it performs a case-insensitive, partial-match search using .contains() on the artist's name.
     * @param artist the artist name to search for
     * @return an ArrayList of matching music Audio objects
     */
    public ArrayList<Audio> getMusicByArtist(String artist) {
        String ResearchArtist = artist.toLowerCase();
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == CD.class || a.getClass() == Vinyl.class || a.getClass() == Digital.class) {
                String AudioArtist = a.getArtist().toLowerCase();
                if (AudioArtist.contains(ResearchArtist)) {
                    result.add(a);
                }
            }
        }
        return result;
    }
    
    /**
     * Searches for audiobooks by either the author's or the narrator's name.
     * DESIGN CHOICE:
     * It first filters the list to include only CDAudiobook and DigitalAudiobook objects. 
     * It then performs a case-insensitive, partial-match check against BOTH the author 
     * (stored as artist) and the narrator fields. If either matches, the object is included.
     * @param name the name of the author or narrator to search for
     * @return an ArrayList of matching audiobook objects
     */
    public ArrayList<Audio> getBooksByAuthorNarrator(String name) {
        String ResearchName = name.toLowerCase();
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == CDAudiobook.class) {
                CDAudiobook ca = (CDAudiobook) a;
                String AuthorName = ca.getArtist().toLowerCase();
                String NarratorName = ca.getNarrator().toLowerCase();
                if (AuthorName.contains(ResearchName) || NarratorName.contains(ResearchName)) {
                    result.add(a);
                }
            }
            else if (a.getClass() == DigitalAudiobook.class) {
                DigitalAudiobook da = (DigitalAudiobook) a;
                String AuthorName = da.getArtist().toLowerCase();
                String NarratorName = da.getNarrator().toLowerCase();
                if (AuthorName.contains(ResearchName) || NarratorName.contains(ResearchName)) {
                    result.add(a);
                }
            }
        }
        return result;
    }
}
