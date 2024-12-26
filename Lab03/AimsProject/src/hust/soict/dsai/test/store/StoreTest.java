package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a Store instance
        Store store = new Store();

        // Create some DVD instances
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 24.99);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Matrix", "Action", "Wachowskis", 136, 14.99);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 162, 22.50);

        // Test adding DVDs to the store
        System.out.println("Adding DVDs to the store:");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);

        // Print the store's content
        store.printStore();

        // Test removing a DVD from the store
        System.out.println("\nRemoving DVDs from the store:");
        store.removeDVD(dvd3);  // Should remove "The Matrix"
        store.removeDVD(dvd4);  // Should remove "Avatar"

        // Print the store's content after removal
        store.printStore();

        // Attempt to remove a DVD not in the store
        System.out.println("\nAttempt to remove a non-existent DVD:");
        store.removeDVD(dvd3);  // Should notify that the DVD is not in the store
    }
}
