package application;



import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



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


	@FXML 
	
	private Button logoutButton;

	@FXML 
	
	private Button createLineupButton;

	@FXML 
	
	private Button editTeamButton;
	
	@FXML 
	
	private Label teamnamelabel;
	
	@FXML 
	
	private AnchorPane teamMenuScenePane;
	
	@FXML
	
	private CheckBox player_one;
	@FXML
	
	private CheckBox player_two;
	@FXML
	
	private CheckBox player_three;
	@FXML
	
	private CheckBox player_four;
	@FXML
	
	private CheckBox player_five;
	@FXML
	
	private CheckBox player_six;
	@FXML
	
	private CheckBox player_seven;
	@FXML
	
	private CheckBox player_eight;
	


	private Stage stage;

	private Scene scene;

	private Parent root;

	

	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {


	}
	
	public void displayTeamName(String TeamName) {
		teamnamelabel.setText( TeamName + " Menu");
	}


	public void logout(ActionEvent event)

	{

		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Logout");

		alert.setHeaderText("You're about to logout!");

		alert.setContentText("Do you want to save before exiting?");

		

		if (alert.showAndWait().get() == ButtonType.OK) {

			stage = (Stage) teamMenuScenePane.getScene().getWindow();

			System.out.println("You successfully logged out!");

			stage.close();

		}

	}

	

	public void switchToLineupScene(ActionEvent event)throws IOException

	{	
		ArrayList<String> selecteditems =new ArrayList<>();
		
		if (player_one.isSelected()) {
			selecteditems.add("Andrew");
		}

		if (player_two.isSelected()) {
			selecteditems.add("Reza");			
		}
		
		if (player_three.isSelected()) {
			selecteditems.add("Thumeera");
		}
		
		if (player_four.isSelected()) {
			selecteditems.add("Ebrahim");
		}
		
		if (player_five.isSelected()) {
			selecteditems.add("Siu");
		}
		
		if (player_six.isSelected()) {
			selecteditems.add("Glyn");
		}
		
		if (player_seven.isSelected()) {
			selecteditems.add("Misha");
		}
		
		if (player_eight.isSelected()) {
			selecteditems.add("Rajeevan");
		}
		
		System.out.println("The dynamic array is: " + selecteditems);
		

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

