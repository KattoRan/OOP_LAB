package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class AddItemToStoreScreen {
	protected Store store;
    protected Cart cart;

    @FXML
    public TextField tfTitle;
	@FXML
	public TextField tfCategory;
	@FXML
	public TextField tfCost;
    @FXML
    public Button btnAdd;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public void initialize() {
        btnAdd.setOnAction(event -> addItemToStore());
    }

    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String costText = tfCost.getText();
        double cost = Double.parseDouble(costText);
    }
    public Store getStore() {
        return this.store;
    }

    // Phương thức getter cho Cart (nếu cần)
    public Cart getCart() {
        return this.cart;
    }
    // Phương thức chung để kiểm tra đầu vào
    public boolean validateInputs() {
        return !(tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() || tfCost.getText().isEmpty());
    }
}
