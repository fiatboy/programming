package app;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class MainController {
	
	
	
	@FXML
	private StackPane vistaHolder;
	
	public void setVista(Node node) {
		vistaHolder.getChildren().setAll(node);
	}
	
	

}
