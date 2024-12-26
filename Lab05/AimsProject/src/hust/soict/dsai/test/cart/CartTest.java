package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args)
	{
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95, 87, "Roger Allers");
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95, 87, "George Lucas");
		cart.addMedia(dvd2);
		cart.print();
		if (cart.search("Lion") != null) System.out.println("Can find lion");
        else System.out.println("Can't find lion");
	}
}
