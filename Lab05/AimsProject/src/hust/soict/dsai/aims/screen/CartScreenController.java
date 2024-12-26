package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;    
    @FXML
    private Button btnRemove; 
    
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    private FilteredList<Media> filteredList;
    
    @FXML
    private Label costLabel;

	private boolean sortByTitle;

	private Store store;

	private JFrame stage;

	private boolean filterByID;
    
    // Constructor
	public CartScreenController(Store store, Cart cart, JFrame stage) {
        super();
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true); // Hiển thị tất cả ban đầu
        
        tblMedia.setItems(filteredList);
        
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        colMediaCost.setCellFactory(tc -> new TableCell<Media, Float>() {
            @Override
            protected void updateItem(Float cost, boolean empty) {
                super.updateItem(cost, empty);
                if (empty || cost == null) {
                    setText(null);
                } else {
                    setText(String.format("$%.2f", cost));
                }
            }
        });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            });
    }

    private void updateButtonBar(Media media) {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            } 
    }
    
    @FXML
    private void removeBtnPressed(ActionEvent event) {
    	Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            System.out.println("Removed: " + selectedMedia.getTitle());
        } else {
            System.out.println("No media selected to remove.");
        }
    }
    
    private void showFilteredMedia(String filterText) {
        filteredList.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filterText.toLowerCase();

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }
    
    @FXML
    private void placeOrderPressed(ActionEvent event) {
        if (this.cart.getSize() > 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Notification");
            alert.setHeaderText("Success!");
            alert.setContentText("Your order has been placed.");
            alert.showAndWait();
            this.cart.empty();
            costLabel.setText(String.valueOf(this.cart.totalCost()) + " $");
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Notification");
            alert.setHeaderText("ERROR: Failed to place order.");
            alert.setContentText("Your cart is empty");
            alert.showAndWait();
        }
    }

    private void updateTotalCost() {
        costLabel.setText(String.valueOf(this.cart.totalCost()) + " $");
    }

    @FXML
    private void playButtonPressed(ActionEvent event) {
        Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
				((Playable) media).play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    @FXML
    private void setFilterByID() {
        this.filterByID = true;
    }

    @FXML
    private void setFilterByTitle() {
        this.filterByID = false;
    }

    @FXML
    private void setSortByTitle() {
        this.sortByTitle = true;
    }

    @FXML
    private void setSortByCost() {
        this.sortByTitle = false;
    }

    @FXML
    private void viewStore() {
        new StoreScreen(store,cart);
    }

    @FXML
    private void addDVDToStore() {
        new AddDVDToStoreScreen(store, cart);
    }

    @FXML
    private void addBookToStore() {
        new AddBookToStoreScreen(store, cart);
    }

    @FXML
    private void addCDToStore() {
        new AddCompactDiscToStoreScreen(store, cart);
    }



    
}
