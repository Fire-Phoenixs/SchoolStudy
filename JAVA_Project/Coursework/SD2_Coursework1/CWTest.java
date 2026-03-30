import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import audiodb.*;

public class CWTest {

    ArrayList<Audio> myAudioLibrary = new ArrayList<Audio>(Arrays.asList(

            new Vinyl            ( "Meddle"
                                 , "Pink Floyd"
                                 , new ArrayList<String>(Arrays.asList("progressive", "psychedelic", "rock"))
                                 , 46       /* runtime, in minutes */
                                 , 33       /* RPM */
                                 )

          , new Digital          ( "Syro"
                                 , "Aphex Twin"
                                 , new ArrayList<String>(Arrays.asList("electronic", "techno", "breakbeat"))
                                 , 64       /* runtime, in minutes */
                                 , "wav"
                                 , 628      /* size in megabytes */
                                 )

          , new Vinyl            ( "The Campfire Headphase"
                                 , "Boards of Canada"
                                 , new ArrayList<String>(Arrays.asList("electronic", "ambient", "downtempo"))
                                 , 62       /* runtime, in minutes */
                                 , 33       /* RPM */
                                 )

          , new CD               ( "Just for a Day"
                                 , "Slowdive"
                                 , new ArrayList<String>(Arrays.asList("shoegaze", "rock", "dream-pop"))
                                 , 43       /* runtime, in minutes */
                                 , "flac"
                                 , 1        /* number of discs */
                                 )

          , new CD               ( "Super Trouper"
                                 , "ABBA"
                                 , new ArrayList<String>(Arrays.asList("pop", "disco"))
                                 , 42       /* runtime, in minutes */
                                 , "flac"
                                 , 1        /* number of discs */
                                 )

          , new DigitalAudiobook ( "Zen and the Art of Motorcycle Maintenance"
                                 , "Robert Pirsig" /* author */
                                 , new ArrayList<String>(Arrays.asList("fiction", "philosophical"))
                                 , 905      /* runtime, in minutes */
                                 , "mp3"
                                 , 224      /* size in megabytes */
                                 , "Stephen Fry" /* narrator */
                                 )

          , new CD               ( "Souvlaki"
                                 , "Slowdive"
                                 , new ArrayList<String>(Arrays.asList("shoegaze", "rock", "dream-pop"))
                                 , 40       /* runtime, in minutes */
                                 , "flac"
                                 , 1        /* number of discs */
                                 )

          , new DigitalAudiobook ( "Pride and Prejudice"
                                 , "Jane Austen" /* author */
                                 , new ArrayList<String>(Arrays.asList("fiction", "romance", "regency"))
                                 , 680      /* runtime, in minutes */
                                 , "mp3"
                                 , 124      /* size in megabytes */
                                 , "David Attenborough" /* narrator */
                                 )

          , new Vinyl            ( "Revolver"
                                 , "The Beatles"
                                 , new ArrayList<String>(Arrays.asList("rock", "pop", "psychedelic"))
                                 , 62       /* runtime, in minutes */
                                 , 45       /* RPM */
                                 )

          , new CDAudiobook      ( "Infinite Jest"
                                 , "David Foster Wallace"
                                 , new ArrayList<String>(Arrays.asList("fiction", "postmodern", "satire"))
                                 , 3844     /* runtime, in minutes */
                                 , "mp3"
                                 , 12       /* number of discs */
                                 , "Sean Pratt"
                                 )
      ));
	
	@Test
	public void testLibLength() {
        AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }
		
		assertEquals(10, adb.getAllAudio().size());
	}
	
	@Test
	public void testLibSorted() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }
		
		ArrayList<String> authors = new ArrayList<>(
				Arrays.asList("David Foster Wallace", "Slowdive", "Pink Floyd", "Jane Austen",
						      "The Beatles", "Slowdive", "ABBA", "Aphex Twin",
						      "Boards of Canada", "Robert Pirsig"));
		for (int i = 0; i < 10; i++) {
			assertEquals(authors.get(i),adb.getAllAudio().get(i).getArtist());
		}
	}
	
	@Test
	public void testGetAudioMediaByTitle() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(0,adb.getAudioMediaByTitle("non-existent name").size());
		assertEquals(2,adb.getAudioMediaByTitle("the").size());
		assertEquals(10,adb.getAudioMediaByTitle("").size());
	}	
	
	@Test
	public void testGetAllGenres() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(18,adb.getAllGenres().size());
	}
	
	@Test
	public void testGetAudioMediaByGenre() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(0,adb.getAudioMediaByGenre("").size());
		assertEquals(0,adb.getAudioMediaByGenre("non-existent").size());
		assertEquals(2,adb.getAudioMediaByGenre("pop").size());
		assertEquals(1,adb.getAudioMediaByGenre("disco").size());
	}	
	
	@Test
	public void testGetDigitalAndPhysicalMedia() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(3,adb.getDigitalMedia().size());
		assertEquals(7,adb.getPhysicalMedia().size());
	}
	
	@Test
	public void testGetMusicByArtist() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(2,adb.getMusicByArtist("slow").size());
		assertEquals(0,adb.getMusicByArtist("non-existent").size());
		assertEquals(7,adb.getMusicByArtist("").size());
	}
	
	
	@Test
	public void testGetBooksByAuthorNarrator() {
		AudioDB adb = new AudioDB();
        
		for (Audio b : myAudioLibrary) {
			adb.add(b);
        }

		assertEquals(3,adb.getBooksByAuthorNarrator("").size());
		assertEquals(2,adb.getBooksByAuthorNarrator("david").size());
		assertEquals(0,adb.getBooksByAuthorNarrator("richard").size());
		assertEquals(1,adb.getBooksByAuthorNarrator("robert").size());
	}
	
	

}
