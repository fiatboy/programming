package app;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Vista1Controller {
	
	@FXML
	Circle circle;
	
	MouseEvent event;
	
	@FXML
	void handleNext() {
		VistaNavigator.loadVista(VistaNavigator.VISTA_1);
	}
	
	@FXML
	private void hanldeDrag() {
		circle.setCenterX(event.getSceneX());
		circle.setCenterY(event.getSceneY());
	}

}
