package SD2_Coursework1;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    static String instructions = "[1] List all audio media\n"
                               + "[2] Search for audio media by title\n"
                               + "[3] List all the genres\n"
                               + "[4] List all audio media of a given genre\n"
                               + "[5] List all digital audio media\n"
                               + "[6] List all physical audio media\n"
                               + "[7] List all music by given artist\n"
                               + "[8] List all audiobooks by given author or narrator\n"
                               + "[0] Exit program\n";

    public static void main(String[] args) {
        AudioDB adb = new AudioDB();
        for (Audio b : AudioCollection.myAudioLibrary) {
            adb.add(b);
        }

        char option;

        // Print first set of instructions
        System.out.println("Welcome to AudioDB!\nPlease enter one of the options below.\n");
        System.out.println(instructions);
        Scanner input = new Scanner(System.in);
        option = input.nextLine().charAt(0);

        // Program loop
        while (option != '0') {
            System.out.println();
            if (option == '1') {
                ArrayList<Audio> audioList = adb.getAllAudio();
                if (audioList.isEmpty()) {
                    System.out.println("No audio media in DB.");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '2') {
                System.out.print("Enter the title: ");
                String title = input.nextLine();
                System.out.println();
                ArrayList<Audio> audioList = adb.getAudioMediaByTitle(title);
                if (audioList.isEmpty()) {
                    System.out.println("No audio media in DB matching title \"" + title + "\".\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '3') {
                ArrayList<String> genres = adb.getAllGenres();
                if (genres.isEmpty()) {
                    System.out.println("No genres found in DB.\n");
                } else {
                    for (int i = 0; i < genres.size() - 1; i++) {
                        System.out.print(genres.get(i) + ", ");
                    }
                    System.out.println(genres.get(genres.size() - 1) + "\n");
                }
            } else if (option == '4') {
                System.out.print("Enter the genre: ");
                String genre = input.nextLine();
                System.out.println();
                ArrayList<Audio> audioList = adb.getAudioMediaByGenre(genre);
                if (audioList.isEmpty()) {
                    System.out.println("No audio media in DB of genre \"" + genre + "\".\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '5') {
                ArrayList<Audio> audioList = adb.getDigitalMedia();
                if (audioList.isEmpty()) {
                    System.out.println("No digital media found in DB.\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '6') {
                ArrayList<Audio> audioList = adb.getPhysicalMedia();
                if (audioList.isEmpty()) {
                    System.out.println("No physical media found in DB.\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '7') {
                System.out.print("Enter the name of the artist: ");
                String artist = input.nextLine();
                System.out.println();
                ArrayList<Audio> audioList = adb.getMusicByArtist(artist);
                if (audioList.isEmpty()) {
                    System.out.println("No music in DB matching artist \"" + artist + "\".\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '8') {
                System.out.print("Enter the name of the author/narrator: ");
                String author = input.nextLine();
                System.out.println();
                ArrayList<Audio> audioList = adb.getBooksByAuthorNarrator(author);
                if (audioList.isEmpty()) {
                    System.out.println("No audiobooks in DB matching author/narrator \"" + author + "\".\n");
                } else {
                    adb.printList(audioList);
                }
            } else if (option == '0') {
                break;
            } else {
                System.out.println("\nInvalid option.\n");
            }
            System.out.println(instructions);
            option = input.nextLine().charAt(0);
        }
        System.out.println("See you later!");
        input.close();
    }

}
