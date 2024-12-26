package hust.soict.dsai.aims.screen;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
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

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    @FXML
    private TextField tfArtist;  // Trường nhập liệu cho nghệ sĩ
    @FXML
    private TextField tfLength;  // Trường nhập liệu cho độ dài của CD
    @FXML
    private TextField tfTracks;  // Trường nhập liệu cho số lượng bài hát trong CD

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        Stage stage = new Stage();
        stage.setTitle("Add Compact Disc to Store");
        stage.setWidth(1024);
        stage.setHeight(768);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addCompactDisc.fxml"));
                loader.setController(AddCompactDiscToStoreScreen.this);  // Đảm bảo controller chính xác
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
        String artist = tfArtist.getText();
        int length = Integer.parseInt(tfLength.getText());  // Độ dài của CD
        int tracks = Integer.parseInt(tfTracks.getText());  // Số lượng bài hát trong CD

        CompactDisc cd = new CompactDisc(title, category, cost, artist, length, tracks);
        getStore().addMedia(cd);  // Thêm CD vào store
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
