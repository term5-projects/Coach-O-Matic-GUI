package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckListView;

/**
* <h1>EditPlayerController</h1>
* EditPlayerController class is used to edit player name and positions.
* TODO - need to change so class uses a checklistview so that we can dynamically change available positions
*
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class EditPlayerController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String[] positions = {"GK", "LD", "RD"};//TEMPORARY

	private ArrayList<String> selectedPositions =new ArrayList<>();

	@FXML private CheckListView<String> positionsCheckListView;
	
	@FXML private Button returnButton;
	@FXML private Button logoutButton;
	@FXML private Button savePlayerButton;
	
	@FXML private TextField playerNameTextField;
	
	@FXML private CheckBox gkCheckBox;
	@FXML private CheckBox ldCheckBox;
	@FXML private CheckBox rdCheckBox;
	@FXML private CheckBox rmCheckBox;
	@FXML private CheckBox cmCheckBox;
	@FXML private CheckBox lmCheckBox;
	@FXML private CheckBox sCheckBox;
	
	@FXML private Label playerNameLabel;
	
	int min_positions = 2; //NEEDS UPDATE - BE should specify minimum number of positions player must play for algorithm to work
	
	//private Positions[] playerPositions = Positions.values(); TODO
	//private ArrayList<String> playerPositions = new ArrayList<String>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Player List View
		positionsCheckListView.getItems().addAll(positions);
		positionsCheckListView.getCheckModel().getCheckedItems().addListener((ListChangeListener<? super String>) new ListChangeListener<String>() {
		     public void onChanged(ListChangeListener.Change<? extends String> c) {
		    	 selectedPositions.clear();
		    	 selectedPositions.addAll(positionsCheckListView.getCheckModel().getCheckedItems());
		     }
		 });
		
	}
	
	
	public void returnToPreviousScene(ActionEvent event) throws IOException
	{		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeamScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	
	/**
	 * TODO
	 * Saves Player name and position updates
	 * @return void
	 */
	public void savePlayer(ActionEvent event) throws IOException
	{		
		boolean player_empty = playerNameTextField.getText().isBlank();
		
		//Display alert if no team name or formation selected
		if (player_empty == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Player Settings");
			alert.setHeaderText("Missing Name");
			alert.setContentText("Please enter Player Name.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}
		if (selectedPositions.size() < min_positions) {
			String min_positions_str = String.valueOf(min_positions);  
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Player Settings");
			alert.setHeaderText("Invalid Position Selection");
			alert.setContentText("Please select at least " + min_positions_str + " positions.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}
		
		//Edit or Create a New Team - TODO BE Connection
		//Check if we are editing or creating a new team
		//pass in all field and player list to object constructor
		
		return;

	}
	
	public void logout(ActionEvent event)throws IOException
	{
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
			root = loader.load();
					
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			System.out.println("You successfully logged out!");

		}
	}



	
	
	
	
	
}
