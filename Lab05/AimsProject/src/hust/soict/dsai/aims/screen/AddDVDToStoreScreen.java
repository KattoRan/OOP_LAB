package hust.soict.dsai.aims.screen;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
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

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    @FXML
    private TextField tfLength;  // Độ dài của DVD (đặc trưng riêng của DVD)

    public AddDVDToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        // Tạo Stage cho JavaFX (thay thế JFrame)
        Stage stage = new Stage();
        stage.setTitle("Add DVD to Store");
        stage.setWidth(1024);
        stage.setHeight(768);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addDVD.fxml"));
                // Đảm bảo controller được thiết lập chính xác
                loader.setController(AddDVDToStoreScreen.this); // Sử dụng 'this' để sử dụng controller hiện tại
                Parent root = loader.load();

                // Set Scene và hiển thị cửa sổ
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                showError("Failed to load the FXML file", e.getMessage());
            }
        });
    }

    // Phương thức thêm DVD vào store
    @FXML
    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        double cost = Double.parseDouble(tfCost.getText());
        int length = Integer.parseInt(tfLength.getText());  // Lấy độ dài DVD

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, category);
        getStore().addMedia(dvd);  // Thêm DVD vào store
    }

	// Phương thức hiển thị lỗi nếu có vấn đề
    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
