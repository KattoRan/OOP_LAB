package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a Store instance
        Store store = new Store();

        // Create some DVD instances
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Science Fiction", 19.99f, 148, "Christopher Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Interstellar", "Science Fiction", 24.99f, 169, "Christopher Nolan");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Matrix", "Action", 14.99f, 136, "Wachowskis");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Fantasy", 22.50f, 162, "James Cameron");

        store.addMedia(dvd2);
        store.addMedia(dvd4);
        store.removeMedia(dvd3);
        store.removeMedia(dvd3);
        
    }
}
