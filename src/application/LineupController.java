package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineupController implements Initializable{
	
	@FXML private Label formationLabel;
	
	@FXML private AnchorPane LineupScenePane;
	
	@FXML private Button logoutButton;
	
	@FXML private TableView<SoccerPlayer> LineupTable;
	
	
	@FXML private TableColumn<Person, String> shiftcolumn;
	
	@FXML private TableColumn<Person, String> GKcolumn;
	
	@FXML private TableColumn<Person, String> LDcolumn;
	
	@FXML private TableColumn<Person, String> RDcolumn;
	
	@FXML private TableColumn<Person, String> LMcoolumn;
	
	@FXML private TableColumn<Person, String> CMcolumn;
	
	@FXML private TableColumn<Person, String> RMcolumn;
	
	@FXML private TableColumn<Person, String> STcolumn;
	
	@FXML private TableColumn<Person, String> Subcolumn;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void logout(ActionEvent event)

	{
Pl
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Logout");

		alert.setHeaderText("You're about to logout!");

		alert.setContentText("Do you want to save before exiting?");


		if (alert.showAndWait().get() == ButtonType.OK) {

			stage = (Stage) LineupScenePane.getScene().getWindow();

			System.out.println("You successfully logged out!");

			stage.close();

		}

	}

}
