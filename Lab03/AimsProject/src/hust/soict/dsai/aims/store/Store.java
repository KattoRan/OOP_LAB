package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private static final int MAX_NUMBERS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore;

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc disc) {
        if (this.qtyInStore < MAX_NUMBERS_IN_STORE) {
            this.itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The DVD has been added to the store: " + disc.toString());
        } else {
            System.out.println("The store is full! Cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift DVDs to fill the gap
            for (int i = index; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--;
            System.out.println("The DVD has been removed from the store: " + disc.toString());
        } else {
            System.out.println("The DVD is not in the store!");
        }
    }

    // Method to print all DVDs in the store
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available DVDs:");
        
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }
}
