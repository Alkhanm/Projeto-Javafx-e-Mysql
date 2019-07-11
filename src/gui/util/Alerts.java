package gui.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerts {
	public static void showAlert(String title, String header, String content, AlertType type ) {
		Alert aler = new Alert(type);
		aler.setTitle(title);
		aler.setHeaderText(header);
		aler.setContentText(content);
		aler.show();

	}
	public static Optional<ButtonType> showConfirmation(String title, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		return alert.showAndWait();
		}
}
