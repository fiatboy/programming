package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Stage primaryStage;

	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Mill Game");
		
		primaryStage.setScene(createScene(loadMainPane()));
		
		primaryStage.setResizable(false);

		primaryStage.show();
	}
	
	public Pane loadMainPane() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		
		Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(VistaNavigator.MAIN));
		
		MainController mainController = loader.getController();
		
		VistaNavigator.setMainController(mainController);
		VistaNavigator.loadVista(VistaNavigator.VISTA_1);
		
		return mainPane;
	}

	private Scene createScene(Pane mainPane) {
		Scene scene = new Scene(mainPane);
		return scene;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String args[]) {
		launch(args);
		
		
	}
	
	
}
