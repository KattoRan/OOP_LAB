package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
	private int id;
	private String title;
	private String category;
	private double cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(int id, String title, String category, double cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media(String title, String category, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
        this.title = title;
    }

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return cost;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null) {
	        return false;
	    }
	    if (!(obj instanceof Media)) {
	        return false;
	    }
	    Media other = (Media) obj;
	    return this.title != null && this.title.equals(other.title);
	}

	
	public String toString() {
		return "Title: " + this.title
				+ " - Category: " + this.category
				+ " - Cost: " + this.cost + "$";
	}
	
	public boolean isMatch(String keywords) {
		String[] splitKeywords = keywords.toLowerCase().split("\\s+");
		String toLowerTitle = this.title.toLowerCase();
		for(String s : splitKeywords) {
			if(toLowerTitle.contains(s)) {
				return true;
			}
		}
		return false;
	}
}