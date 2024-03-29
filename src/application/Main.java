package application;
//--module-path C:\java-libs\javafx-sdk\lib --add-modules=javafx.fxml,javafx.controls
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();

			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			mainScene = new Scene(scrollPane);
			//scrollPane.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
			stage.setScene(mainScene);
			stage.setTitle("Projeto JavaFX e Mysql");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		launch(args);
	}
}
