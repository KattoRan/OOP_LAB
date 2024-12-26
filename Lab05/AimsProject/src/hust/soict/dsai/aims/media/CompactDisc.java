package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    private static int nbCompactDiscs = 0;

    // Constructor that includes the tracks
    public CompactDisc(String title, String category, double cost, String artist, int length, ArrayList<Track> tracks) {
        super(++nbCompactDiscs, title, category, cost, length, artist);  // Call the parent constructor (Disc)
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, double cost, String artist, int length, int tracksCount) {
        super(++nbCompactDiscs, title, category, cost, length, null);  // Chỉnh sửa nếu cần thiết
        this.artist = artist;
        
        // Tạo danh sách track dựa trên số lượng track được nhập vào
        for (int i = 0; i < tracksCount; i++) {
            tracks.add(new Track("Track " + (i + 1), 3));  // Giả sử mỗi track có độ dài 3 phút
        }
    }

    public String getArtist() {
        return this.artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track with title " + track.getTitle() + " is already in the list!");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully!");
        } else {
            System.out.println("Track with title " + track.getTitle() + " is not in the list!");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track t : tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        for (Track nextTrack : tracks) {
            try {
                nextTrack.play();
            } catch (PlayerException e) {
                throw new PlayerException("ERROR when playing track: " + nextTrack.getTitle() + ". " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "CD " + super.toString()
                + " - Artist: " + this.artist
                + " - Tracks: " + this.tracks.toString();
    }
}
