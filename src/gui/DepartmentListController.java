package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{
	
	
	private DepartmentService service;// não colocar um New aqui pq isso seria um aclopamento forte.
	
	@FXML
	private TableView<Department> tableViewDepartment;
	

	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	
	@FXML
	private TableColumn <Department, String> tableColumnName;
	
	@FXML
	private Button btnNew;
	
	//Injetar depêndencia
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtnNewAction() {
		System.out.println("onBtnNewAction");
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}


	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		if (service == null) {// caso o programador se esqueça injetar a depêndencia
			throw new IllegalStateException("Service was null");
		}
		List <Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
		
		
	}
	

}





