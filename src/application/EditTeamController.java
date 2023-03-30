package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditTeamController {

	@FXML Label usernameLabel;
	
	@FXML private Button logoutButton;
	@FXML private Button addPlayerButton;
	
	@FXML private ChoiceBox<String> formationChoiceBox;
	private String[] formations = {"2-3-1", "2-2-2"}; //NEEDS UPDATE should use enum here
	
	@FXML private Label formationLabel;
	@FXML private Spinner<Integer> shiftsSpinner;
	
	@FXML private AnchorPane editTeamPane;
	

	private Stage stage;
//	private Scene scene;
//	private Parent root;
	int num_shifts;
	
	public void initializeSpinner(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		
		valueFactory.setValue(1);
		
		shiftsSpinner.setValueFactory(valueFactory);
		
		num_shifts = shiftsSpinner.getValue();
	}
	
	public void initializeChoiceBox(URL arg0, ResourceBundle arg1) {
		formationChoiceBox.getItems().addAll(formations);
		//formationChoiceBox.setOnAction(this::getFormation);
		
	}
//	public void getFormation(URL arg0, ResourceBundle arg1) {
//		String formation = formationChoiceBox.getValue();
//	}
	
	public void logout(ActionEvent event)
	{
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) editTeamPane.getScene().getWindow();
			System.out.println("You successfully logged out!");
			stage.close();
		}
	}
//	public void editPlayer(ActionEvent event)
//	{		
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
//		root = loader.load();
//		
//		EditPlayerController.getController();
//		
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
}