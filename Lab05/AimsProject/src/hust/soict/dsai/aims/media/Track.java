package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    	this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.length <= 0) {
            System.err.println("Error: Track cannot be played because the length is less than or equal to zero.");
            throw new PlayerException("Invalid length for Track: " + this.title);
        }
        else {
        	System.out.println("Playing Track: " + title);
            System.out.println("DVD length: " + length);
        }
    }
    @Override
    public boolean equals(Object obj) {
        Track otherTrack = (Track) obj;
        return this.title != null && this.title.equals(otherTrack.title)
                && this.length == otherTrack.length;
    }
    

}
