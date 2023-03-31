package application;



import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckListView;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;

import javafx.scene.Node;

import javafx.scene.Parent;

import javafx.scene.Scene;

import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;



public class TeamMenuController implements Initializable{


	@FXML private Button logoutButton;

	@FXML private Button createLineupButton;

	@FXML private Button editTeamButton;
	
	@FXML private Label teamnamelabel;
	
	@FXML private AnchorPane teamMenuScenePane;
	
	private String[] players = {"Misha", "Glyn", "Howard"};//TODO
	@FXML private CheckListView<String> availablePlayersCheckListView;
	
	ArrayList<String> selectedPlayers =new ArrayList<>();

	private Stage stage;

	private Scene scene;

	private Parent root;
	
	/**
	 * Initializes the available players checklist. 
	 * Clears then updates selectedPlayers every time a box is ticked.
	 * @return void
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		availablePlayersCheckListView.getItems().addAll(players);
		availablePlayersCheckListView.getCheckModel().getCheckedItems().addListener((ListChangeListener<? super String>) new ListChangeListener<String>() {
		     public void onChanged(ListChangeListener.Change<? extends String> c) {
		         selectedPlayers.clear();
		    	 selectedPlayers.addAll(availablePlayersCheckListView.getCheckModel().getCheckedItems());
		     }
		 });
	}
		
	
	
	public void displayTeamName(String TeamName) {
		teamnamelabel.setText( TeamName + " Menu");
	}


	public void logout(ActionEvent event) throws IOException

	{

		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	

	public void switchToLineupScene(ActionEvent event)throws IOException

	{	

		
		System.out.println("The dynamic array is: " + selectedPlayers);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LineupScene.fxml"));

		root = loader.load();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

	}

	

	public void switchToEditTeamScene(ActionEvent event)throws IOException

	{		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeamScene.fxml"));

		root = loader.load();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();
	}
}

