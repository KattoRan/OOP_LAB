package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title, String category, double d, int length, String director) {
		super(++nbDigitalVideoDiscs, title, category, d, length, director);		
	}

	public String toString() {
		return "DVD " + super.toString();
	}
	
	public boolean isMatch(String keywords) {
		String[] splitKeywords = keywords.toLowerCase().split("\\s+");
		String toLowerTitle = super.getTitle().toLowerCase();
		
		for(String s : splitKeywords) {
			if(toLowerTitle.contains(s)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public void setTitle(String title) {
	    super.setTitle(title); // Gọi phương thức setTitle của lớp Media
	}


}