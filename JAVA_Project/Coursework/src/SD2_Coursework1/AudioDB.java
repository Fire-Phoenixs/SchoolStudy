package src.SD2_Coursework1;

import java.util.*;

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
     * First of all, if there are no elements in the list, simply add them in.
     * If there are elements in the list, then use the compareTo method to compare
     * the dictionary order of the first element (That is, the i-th element, where
     * the initial value of i is 0.) in the list with the added element.
     * If the dictionary order of the added element comes after the i-th element,
     * then set i to i + 1 and repeat the comparison.
     * If the dictionary order of the added element is before the i-th element, then
     * place the added element at the i-th position in the list.
     * If the dictionary order of the added element is after all the elements in the list,
     * then place the added element at the end of the list.
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
     * In order to achieve the output function, we performed type checks on each
     * element in the list, and then specified the printing format for each type.
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

    // The search functions are implemented by iterating through the list and checking if the relevant field of each element matches the search criteria. If it does, the element is added to the result list, which is returned at the end.
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
    
    // To get all genres, we can use a set to store the genres, which will automatically handle duplicates. We iterate through each audio media and add all its genres to the set. Finally, we convert the set back to an ArrayList and return it.
    public ArrayList<String> getAllGenres() {
        Set<String> genreSet = new HashSet<>();
        for (Audio a : audioList) {
            genreSet.addAll(a.getGenres());
        }
        return new ArrayList<>(genreSet);
    }
    
    // To get audio media by genre, we iterate through each audio media and check if any of its genres match the search genre. If it does, we add it to the result list.
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
    
    // To get physical media, we check the class of each audio media and add it to the result list if it is a CD, vinyl, or CD audiobook.
    public ArrayList<Audio> getPhysicalMedia() {
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == CD.class || a.getClass() == Vinyl.class || a.getClass() == CDAudiobook.class) {
                result.add(a);
            }
        }
        return result;
    }
    
    // To get digital media, we check the class of each audio media and add it to the result list if it is a digital audio or digital audiobook.
    public ArrayList<Audio> getDigitalMedia() {
        ArrayList<Audio> result = new ArrayList<>();
        for (Audio a : audioList) {
            if (a.getClass() == Digital.class || a.getClass() == DigitalAudiobook.class) {
                result.add(a);
            }
        }
        return result;
    }
    
    // To get music by artist, we check the class of each audio media and if it is a CD, vinyl, or digital audio, we compare the artist field with the search artist. If it matches, we add it to the result list.
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
    
    // To get books by author or narrator, we check the class of each audio media and if it is a CD audiobook or digital audiobook, we compare both the author and narrator fields with the search name. If either of them matches, we add it to the result list...
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
