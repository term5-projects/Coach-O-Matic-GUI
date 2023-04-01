package application;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
* <h1>EditTeamController</h1>
* EditTeamController class is used to edit or create a new team.
* Prompts user for Team name, number of shifts per game, formation, and players on the team.  
*
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/

public class EditTeamController implements Initializable{

	@FXML Label usernameLabel;
	
	@FXML private Button returnButton;
	@FXML private Button logoutButton;
	@FXML private Button addPlayerButton;
	@FXML private Button saveTeamButton;
	@FXML private Button editPlayerButton;
	@FXML private Button deletePlayerButton;
	
	@FXML private TextField teamNameTextField;

	private String playerName;
	
	@FXML private ChoiceBox<String> formationChoiceBox;
	private String[] formations = {"2-3-1", "2-2-2"}; //NEEDS UPDATE should use enum here
	
	@FXML private Label formationLabel;
	@FXML private Spinner<Integer> shiftsSpinner;
	
	@FXML private ListView<String> playerListView;
	
	private String[] players = {"Misha", "Glyn", "Thumeera", "a", "b", "c", "d", "e","f","g"}; //NEEDS UPDATE -> Player[] = 
	private String selectedPlayer; //NEEDS UPDATE -> Player selectedPlayer;
	
	@FXML private AnchorPane editTeamPane;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	int num_shifts;
	
	
	/**
	 * Initializes ChoiceBox, Spinner, and ListView
	 * @return void
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//formation ChoiceBox
		formationChoiceBox.getItems().addAll(formations);
		
		//shifts Spinner 
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);		
		valueFactory.setValue(1);		
		shiftsSpinner.setValueFactory(valueFactory);		
		num_shifts = shiftsSpinner.getValue();
		
		//Player List View
		playerListView.getItems().addAll(players);
		playerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {//TODO -> <Player>

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				selectedPlayer = playerListView.getSelectionModel().getSelectedItem();
				
			}
		});
		
	}
	


	
	public void logout(ActionEvent event)throws IOException
	{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	
	/**
	 * 
	 * @param player
	 * @return void
	 * @throws IOException 
	 */
	public void editPlayer(ActionEvent event) throws IOException//TODO -> Player
	{		
		playerName = playerListView.getSelectionModel().getSelectedItem();
		
		//Display alert if no player selected
		if (playerName == null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Select Player");
			alert.setHeaderText("No Player Selected");
			alert.setContentText("Please select a player from the list.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}else{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
			root = loader.load();
					
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			//TODO tell BE which player to edit
			
		}
		return;
		
		

	}
	
	
	public void deletePlayer(ActionEvent event) {
		playerName = playerListView.getSelectionModel().getSelectedItem();
		
		//Display alert if no player selected
		if (playerName == null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Select Player");
			alert.setHeaderText("No Player Selected");
			alert.setContentText("Please select a player from the list.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}else{
			//Delete Player
		
			//TODO - BE Connection
			//team.deletePlayer(
			
		}
		return;
	}
	public void addPlayer(ActionEvent event) throws IOException {
		
		//TODO - BE CONNECTION
		//Create player object
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void saveTeam(ActionEvent event) {

		boolean teamEmpty = teamNameTextField.getText().isBlank();
		num_shifts = shiftsSpinner.getValue();
		String formation = formationChoiceBox.getValue();
		
		//Display alert if no team name or formation selected
		if (teamEmpty == true || formation == null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Team Settings");
			alert.setHeaderText("Missing Team Information");
			alert.setContentText("Please enter Team Name and Formation.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}
		
		//Edit or Create a New Team - TODO BE Connection
		//Check if we are editing or creating a new team
		//pass in all field and player list to object constructor
		
		
	}
	
	public void returnToPreviousScene(ActionEvent event) throws IOException
	{		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMenuScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	public void switchScenes(ActionEvent event, String sceneName) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}