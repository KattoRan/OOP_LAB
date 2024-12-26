package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book {
    // Private fields
    private int id;
    private String title;
    private String category;
    private float cost;
    private ArrayList<String> authors;

    // Constructor
    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = new ArrayList<>(); // Initialize the ArrayList
    }

    // Getters and setters (except for authors)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Methods to add and remove authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) { // Check if the author is already in the list
            authors.add(authorName);
        } else {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { // Check if the author is in the list
            authors.remove(authorName);
        } else {
            System.out.println("Author \"" + authorName + "\" is not in the list.");
        }
    }

    // Method to display the authors
    public ArrayList<String> getAuthors() {
        return authors;
    }
}

