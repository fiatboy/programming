package app;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class VistaNavigator {
	
	public static final String MAIN = "/app/Main.fxml";
	public static final String VISTA_1 = "/app/WelcomeScreen.fxml";
	public static final String VISTA_2 = "/app/Vista1.fxml.fxml";
	
	private static MainController mainController;
	
	public static void setMainController(MainController mainController) {
		VistaNavigator.mainController = mainController;
	}
	
	public static void loadVista(String fxml) {
		try {
			mainController.setVista(FXMLLoader.load(VistaNavigator.class.getResource(fxml)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
