package app;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Vista1Controller {

	@FXML
	Circle circle;

	@FXML
	Text target;

	@FXML
	GridPane gird;
	
	@FXML
	ImageView source;
	
	@FXML
	private void initalize() {
		source.setPreserveRatio(true);
		
	}
	
	double sceneX, sceneY;
	double translateX, translateY;
	
	

}
