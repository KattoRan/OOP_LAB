package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Create a list to store various media objects
        ArrayList<Media> mediaList = new ArrayList<Media>();

        // Creating a list of authors for a Book
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Sarah Rose Summer");
        authors.add("Catriona Gray");

        // Create a Book
        Book b = new Book("Snow White", "Comic book", 50.99, authors);

        // Create a list of tracks for a Compact Disc
        ArrayList<Track> tracks = new ArrayList<Track>();
        Track track1 = new Track("Let it go", 30);  // Track 1
        Track track2 = new Track("Hero", 70);      // Track 2
        tracks.add(track1);
        tracks.add(track2);

        // Create a Compact Disc
        CompactDisc cd = new CompactDisc("Frozen", "Animation", 30.95, "Elsa", 200, tracks);

        // Create a Digital Video Disc
        DigitalVideoDisc dvd = new DigitalVideoDisc("Snow white", "Animation", 40.15, 150, "Anna");

        // Add media items to the media list
        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(b);

        // Print information for each media item
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
