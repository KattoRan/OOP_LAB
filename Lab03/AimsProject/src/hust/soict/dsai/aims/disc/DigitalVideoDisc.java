package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private double cost;
	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public double getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, double cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, double cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		
		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public void displayDVDInformation() {
		System.out.println("Title: " + this.title);
		System.out.println("Category: " + this.category);
		System.out.println("Director: " + this.director);
		System.out.println("Length: " + this.length);
		System.out.println("Cost: " + this.cost);
		System.out.println();
	}
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	
	public int getId() {
        return id;
    }

    // toString method for a readable representation of a DigitalVideoDisc object
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + String.format("%.2f", cost) + " $";
    }

    // Method to check if the DVD title matches a given string
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
