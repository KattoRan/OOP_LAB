package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args)
	{
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.printCart();
		
		System.out.println("\nSearch by ID:");
        cart.searchById(2);  // Should find "Interstellar"
        cart.searchById(5);  // Should notify no match

        // Test searching by title
        System.out.println("\nSearch by Title:");
        cart.searchByTitle("Aladin");  // Should find "The Matrix" and "Matrix Reloaded"
        cart.searchByTitle("Avatar");  // Should notify no match
	}
}
