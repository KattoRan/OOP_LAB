package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			int i = this.qtyOrdered;
			this.itemOrdered[i] = disc;
			System.out.println("The disc has been added.");
			this.itemOrdered[i].displayDVDInformation();
			this.qtyOrdered++;
		}
		else {
			System.out.println("The cart is almost full!");
			System.out.println();
		}
	}
	// New overloaded method to add an array of DVDs
    /*public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);  // Use the existing single-DVD method
        }
    }*/
	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);  // Use the existing single-DVD method
        }
    }
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int index = -1;
		if(this.qtyOrdered < 0) {
			System.out.println("The cart is empty!");
			System.out.println();
		}
		else {
			for(int i = 0; i < this.qtyOrdered; i++) {
				if(this.itemOrdered[i].equals(disc)) {
					index = i;
					break;
				}
			}
			
			if(index != -1) {
				for(int i = index; i < qtyOrdered - 1; i++) {
					this.itemOrdered[i] = this.itemOrdered[i + 1];
				}
				this.itemOrdered[this.qtyOrdered - 1] = null;
				this.qtyOrdered--;
				System.out.println("The disc has been removed.");
				System.out.println();
			}
			
			else {
				System.out.println("The disc is not in the cart!");
				System.out.println();
			}
			
		}
	}
	
	public double totalCost() {
		double sum = 0;
		for(int i = 0; i < this.qtyOrdered; i++) {
			sum += this.itemOrdered[i].getCost();
		}
		return sum;
	}
	
	public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        
        for (int i = 0; i < this.qtyOrdered; i++) {
            DigitalVideoDisc dvd = this.itemOrdered[i];
            System.out.printf("%d. DVD - %s - %s - %s - %d: %.2f $\n",
                (i + 1),
                dvd.getTitle(),
                dvd.getCategory(),
                dvd.getDirector(),
                dvd.getLength(),
                dvd.getCost()
            );
        }

        // Print total cost
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }
	
	public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println("DVD found: " + itemOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Method to search DVDs by title and display the results
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for title \"" + title + "\":");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].isMatch(title)) {
                System.out.println(itemOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title matching: " + title);
        }
    }
}
