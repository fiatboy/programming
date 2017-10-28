package app;

import javafx.fxml.FXML;

public class WelcomeScreenController {
	
	
	
	@FXML
	void hanldeNext() {
		VistaNavigator.loadVista(VistaNavigator.VISTA_2);
	}
	
	@FXML
	void handleExit() {
		System.exit(0);
	}

}
