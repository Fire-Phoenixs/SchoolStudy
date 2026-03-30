package src.SD2_Coursework1;

import java.util.ArrayList;
import java.util.Arrays;

public class AudioCollection {

    static ArrayList<Audio> myAudioLibrary = new ArrayList<Audio>(Arrays.asList(

            new Vinyl(
                    "Meddle", "Pink Floyd", new ArrayList<String>(Arrays.asList("progressive", "psychedelic", "rock")),
                    46 /* runtime, in minutes */
                    , 33 /* RPM */
            )

            ,
            new Digital("Syro", "Aphex Twin", new ArrayList<String>(Arrays.asList("electronic", "techno", "breakbeat")),
                    64 /* runtime, in minutes */
                    , "wav", 628 /* size in megabytes */
            )

            , new Vinyl("The Campfire Headphase", "Boards of Canada", new ArrayList<String>(
                    Arrays.asList("electronic", "ambient", "downtempo")), 62 /* runtime, in minutes */
                    , 33 /* RPM */
            )

            , new CD("Just for a Day", "Slowdive",
                    new ArrayList<String>(Arrays.asList("shoegaze", "rock", "dream-pop")), 43 /* runtime, in minutes */
                    , "flac", 1 /* number of discs */
            )

            , new CD("Super Trouper", "ABBA", new ArrayList<String>(Arrays.asList("pop", "disco")), 42 /*
                                                                                                        * runtime, in
                                                                                                        * minutes
                                                                                                        */
                    , "flac", 1 /* number of discs */
            )

            , new DigitalAudiobook("Zen and the Art of Motorcycle Maintenance", "Robert Pirsig" /* author */
                    , new ArrayList<String>(Arrays.asList("fiction", "philosophical")), 905 /* runtime, in minutes */
                    , "mp3", 224 /* size in megabytes */
                    , "Stephen Fry" /* narrator */
            )

            , new CD("Souvlaki", "Slowdive", new ArrayList<String>(Arrays.asList("shoegaze", "rock", "dream-pop")),
                    40 /* runtime, in minutes */
                    , "flac", 1 /* number of discs */
            )

            , new DigitalAudiobook("Pride and Prejudice", "Jane Austen" /* author */
                    , new ArrayList<String>(Arrays.asList("fiction", "romance", "regency")), 680 /*
                                                                                                  * runtime, in minutes
                                                                                                  */
                    , "mp3", 124 /* size in megabytes */
                    , "David Attenborough" /* narrator */
            )

            , new Vinyl("Revolver", "The Beatles", new ArrayList<String>(Arrays.asList("rock", "pop", "psychedelic")),
                    62 /* runtime, in minutes */
                    , 45 /* RPM */
            )

            , new CDAudiobook("Infinite Jest", "David Foster Wallace", new ArrayList<String>(
                    Arrays.asList("fiction", "postmodern", "satire")), 3844 /* runtime, in minutes */
                    , "mp3", 12 /* number of discs */
                    , "Sean Pratt")));
}
