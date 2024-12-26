package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------");
        System.out.println("1. See a media's detail");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        // Mở cửa sổ CartScreen
        new CartScreen(cart);

        try {
            // Tạo một số đối tượng Media mẫu
            DigitalVideoDisc dvd = new DigitalVideoDisc("Movie Title", "Category", 15.99, 120, "Director Name");
            CompactDisc cd = new CompactDisc("Album Title", "Music", 19.99, "Artist Name", 180, new ArrayList<>());

            // Thêm track cho CompactDisc
            cd.addTrack(new Track("Track 1", 200));
            cd.addTrack(new Track("Track 2", -5));  // Độ dài track không hợp lệ

            // Thử phát các đối tượng Media
            dvd.play();
            cd.play();
        } catch (PlayerException e) {
            // In chi tiết ngoại lệ ra console
            System.err.println("Exception Message: " + e.getMessage());
            e.printStackTrace();  // In stack trace để debug

            // Hiển thị hộp thoại cho người dùng
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        /*int option;
        String inputTitle = "";
        showMenu();
        option = sc.nextInt();

        switch (option) {
            case 1:
                storeMenu();
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Please enter the media's title: ");
                        inputTitle = sc.nextLine();
                        Media m = store.searchItemInStore(inputTitle);
                        while (m == null) {
                            System.out.println("Try again!");
                            System.out.println("Please enter the media's title: ");
                            inputTitle = sc.nextLine();
                        }
                        mediaDetailsMenu();
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                cart.addMedia(m);
                                break;
                            case 2:
                                if (m instanceof CompactDisc) {
                                    CompactDisc cd = (CompactDisc) m;
                                    cd.play();
                                } else if (m instanceof DigitalVideoDisc) {
                                    DigitalVideoDisc dvd = (DigitalVideoDisc) m;
                                    dvd.play();
                                } else if (m instanceof Book) {
                                    System.out.println("Play is not available for book!");
                                }
                                break;
                            case 0:
                                storeMenu();
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the media's title: ");
                        inputTitle = sc.nextLine();
                        m = store.searchItemInStore(inputTitle);
                        while (m == null) {
                            System.out.println("Try again!");
                            System.out.println("Please enter the media's title: ");
                            inputTitle = sc.nextLine();
                        }
                        cart.addMedia(m);
                        break;
                    case 3:
                        System.out.println("Please enter the media's title: ");
                        inputTitle = sc.nextLine();
                        m = store.searchItemInStore(inputTitle);
                        while (m == null) {
                            System.out.println("Try again!");
                            System.out.println("Please enter the media's title: ");
                            inputTitle = sc.nextLine();
                        }
                        if (m instanceof CompactDisc) {
                            CompactDisc cd = (CompactDisc) m;
                            try {
								cd.play();
							} catch (PlayerException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        } else if (m instanceof DigitalVideoDisc) {
                            DigitalVideoDisc dvd = (DigitalVideoDisc) m;
                            try {
								dvd.play();
							} catch (PlayerException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        } else if (m instanceof Book) {
                            System.out.println("Play is not available for book!");
                        }
                        break;
                    case 4:
                        cartMenu();
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("--------------------------");
                                System.out.println("Filter by title or id?");
                                System.out.println("1. id");
                                System.out.println("2. title");
                                System.out.println("--------------------------");
                                System.out.println("Please choose a number: 1-2");
                                option = sc.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("Please enter the media's id: ");
                                        int id = sc.nextInt();
                                        m = cart.search(id);
                                        while (m == null) {
                                            System.out.println("Try again!");
                                            System.out.println("Please enter the media's id: ");
                                            id = sc.nextInt();
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Please enter the media's title: ");
                                        inputTitle = sc.nextLine();
                                        m = cart.search(inputTitle);
                                        while (m == null) {
                                            System.out.println("Try again!");
                                            System.out.println("Please enter the media's title: ");
                                            inputTitle = sc.nextLine();
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("--------------------------");
                                System.out.println("Sort by cost or title?");
                                System.out.println("1. cost");
                                System.out.println("2. title");
                                System.out.println("--------------------------");
                                System.out.println("Please choose a number: 1-2");
                                option = sc.nextInt();
                                switch (option) {
                                    case 1:
                                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                                        break;
                                    case 2:
                                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                                        break;
                                }
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println("Please enter the media's title: ");
                                inputTitle = sc.nextLine();
                                m = cart.search(inputTitle);
                                while (m == null) {
                                    System.out.println("Try again!");
                                    System.out.println("Please enter the media's title: ");
                                    inputTitle = sc.nextLine();
                                }
                                if (m instanceof CompactDisc) {
                                    CompactDisc cd = (CompactDisc) m;
                                    try {
										cd.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
                                } else if (m instanceof DigitalVideoDisc) {
                                    DigitalVideoDisc dvd = (DigitalVideoDisc) m;
                                    dvd.play();
                                } else if (m instanceof Book) {
                                    System.out.println("Play is not available for book!");
                                }
                                break;
                            case 5:
                                System.out.println("An order is created!");
                                break;
                            case 0:
                                storeMenu();
                                break;
                        }
                        break;
                    case 0:
                        showMenu();
                        break;
                }
                break;
            case 2:
                System.out.println("1. Add a new media to store");
                System.out.println("2. Remove a media in store");
                System.out.println("Please choose a number: 1-2");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case 3:
                cartMenu();
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("--------------------------");
                        System.out.println("Filter by title or id?");
                        System.out.println("1. id");
                        System.out.println("2. title");
                        System.out.println("--------------------------");
                        System.out.println("Please choose a number: 1-2");
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("Please enter the media's id: ");
                                int id = sc.nextInt();
                                Media m = cart.search(id);
                                while (m == null) {
                                    System.out.println("Try again!");
                                    System.out.println("Please enter the media's id: ");
                                    id = sc.nextInt();
                                }
                                break;
                            case 2:
                                System.out.println("Please enter the media's title: ");
                                inputTitle = sc.nextLine();
                                m = cart.search(inputTitle);
                                while (m == null) {
                                    System.out.println("Try again!");
                                    System.out.println("Please enter the media's title: ");
                                    inputTitle = sc.nextLine();
                                }
                                break;
                        }
                        break;
                    case 0:
                        showMenu();
                        break;
                }
                break;
            case 0:
                break;
        }*/
    }
}
