package hust.soict.program.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class PainterController {
	@FXML
    private Pane drawingAreaPane;
	private Boolean erase = false;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged (MouseEvent event) {
    	Circle newCircle;
        if (erase) {
            newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE); // Dùng màu trắng để xóa
            System.out.println("Chế độ: Eraser (erase = " + erase + ")");
        } else {
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK); // Dùng màu đen để vẽ
            System.out.println("Chế độ: Pen (erase = " + erase + ")");
        }
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    
    @FXML
    void changeToPen(ActionEvent event){
        erase = false;
    }

    @FXML
    void changeToErase(ActionEvent event){
        erase = true;
    }

}
