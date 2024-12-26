package hust.soict.dsai.aims.screen;

import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	@FXML
    private TextField tfTitle;
    @FXML
    private TextField tfCategory;
    @FXML
    private TextField tfAuthors;
    @FXML
    private TextField tfNumPages;
    @FXML
    private TextField tfCost;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        Stage stage = new Stage();
        stage.setTitle("Add Book to Store");
        stage.setWidth(1024);
        stage.setHeight(768);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addBook.fxml"));
                loader.setController(AddBookToStoreScreen.this);  // Ensure the correct controller is set
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                showError("Failed to load the FXML file", e.getMessage());
            }
        });
    }

    @FXML
    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        double cost = Double.parseDouble(tfCost.getText());
        String author = tfAuthors.getText();

        // Create a Book object using the input values
        Book book = new Book(title, category, cost, author);

        // Add the book to the store
        getStore().addMedia(book);
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void addBookToStore() {
        // Logic for adding the book to the store
        System.out.println("Adding Book to Store...");
    }

    @FXML
    public void addCDToStore() {
        // Logic for adding CD to the store
        System.out.println("Adding CD to Store...");
    }

    @FXML
    public void addDVDToStore() {
        // Logic for adding DVD to the store
        System.out.println("Adding DVD to Store...");
    }

    @FXML
    public void addAuthorBtnPressed() {
        // Logic to add author to the list
        System.out.println("Author added!");
    }

    @FXML
    public void addBtnPressed() {
        // Logic to add the book using information from the input fields
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String authors = tfAuthors.getText();
        int numPages = Integer.parseInt(tfNumPages.getText());
        double cost = Double.parseDouble(tfCost.getText());
        
        // Assuming you have a constructor to create a book
        Book book = new Book(title, category, cost, authors);
        getStore().addMedia(book); // Add the book to the store
    }
    @FXML
    public void viewStore() {
        // Logic để hiển thị cửa hàng
        System.out.println("View Store clicked!");
        // Bạn có thể thêm mã để mở cửa hàng hoặc thay đổi màn hình tại đây
    }
    @FXML
    public void viewCart() {
        // Logic để hiển thị cửa hàng
        System.out.println("View Cart clicked!");
        // Bạn có thể thêm mã để mở cửa hàng hoặc thay đổi màn hình tại đây
    }
}
