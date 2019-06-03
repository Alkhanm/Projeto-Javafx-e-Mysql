package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	
	@FXML
	public void onMenuItemSeller() {
		System.out.println("menuItemSeller");
	}
	
	@FXML
	public void onMenuItemDepartment() {
		System.out.println("menuItemDepartment");
	}
	
	@FXML
	public void onMenuItemAbout() {
		loadView("/gui/About.fxml");
	}
	
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	private void loadView (String absoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		
		Scene mainScene = Main.getMainScene();
		VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(mainMenu);
		mainVBox.getChildren().addAll(newVBox.getChildren());
		
		} catch(IOException e) {
			Alerts.showAlert("IOExcpetion", null, e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}




