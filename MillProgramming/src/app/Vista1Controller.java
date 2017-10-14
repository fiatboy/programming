package app;

import javafx.fxml.FXML;

public class Vista1Controller {
	
	@FXML
	void handleNext() {
		VistaNavigator.loadVista(VistaNavigator.VISTA_2);
	}

}
