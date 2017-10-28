package app;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Vista1Controller {
	
	@FXML
	Circle circle;
	
	@FXML
	Text target;
	
	double sceneX, sceneY;
	double translateX, translateY;
	
	
	@FXML
	void handleNext() {
		VistaNavigator.loadVista(VistaNavigator.VISTA_1);
	}
	
	@FXML
	private void handlePress(MouseEvent mouse) {
		sceneX = mouse.getSceneX();
		sceneY = mouse.getSceneY();
		translateX = ((Circle)(mouse.getSource())).getTranslateX();
		translateY = ((Circle)(mouse.getSource())).getTranslateY();
	}
	
	@FXML
	private void handleDrag(MouseEvent mouse) {
		double offsetX = mouse.getSceneX() - sceneX;
		double offsetY = mouse.getSceneY() - sceneY;
		
		double newTranslateX = translateX + offsetX;
		double newTranslateY = translateY + offsetY;
		
		((Circle)(mouse.getSource())).setTranslateX(newTranslateX);
		((Circle)(mouse.getSource())).setTranslateY(newTranslateY);
	}
	
	@FXML
	private void handleDragOver(DragEvent event) {
		 
	}
	

}
