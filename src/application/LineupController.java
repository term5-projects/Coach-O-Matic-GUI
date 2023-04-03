package application;

import coach_o_matic_be.*;

import java.net.URL;


import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineupController implements Initializable{
	
	@FXML private Label formationLabel;
	
	@FXML private AnchorPane LineupScenePane;
	
	@FXML private Button logoutButton;
	
	@FXML private TableView<SoccerPlayer> LineupTableView;
	
	
	//@FXML private TableColumn<Integer> shiftcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> GKcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> LDcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> RDcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> LMcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> CMcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> RMcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> STcolumn;
	
	@FXML private TableColumn<SoccerPlayer, String> Subcolumn;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GKcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		LDcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		RDcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		LMcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		CMcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		RMcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		STcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		Subcolumn.setCellValueFactory(new PropertyValueFactory<SoccerPlayer, String>("name"));
		
		LineupTableView.setItems(getPeople());
	}
	
	public ObservableList<SoccerPlayer> getPeople(){
		ObservableList<SoccerPlayer> soccerplayers = FXCollections.observableArrayList();
		soccerplayers.add();
		
		return soccerplayers;
	}
	
	public void logout(ActionEvent event)

	{
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
