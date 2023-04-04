package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import coach_o_matic_be.src.coach_o_matic_be.*;

/**
* <h1>EditTeamController</h1>
* EditTeamController class is used to edit or create a new team.
* Prompts user for Team name, number of shifts per game, formation, and players on the team.  
* TODO - BE Connection - Need to parameterize this and use it to both edit and add teams,
*  or need to make a separate CreateTeamController
*
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/

public class EditTeamController implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML Label usernameLabel;
	@FXML private Label formationLabel;
	
	@FXML private Button returnButton;
	@FXML private Button logoutButton;
	@FXML private Button addPlayerButton;
	@FXML private Button saveTeamButton;
	@FXML private Button editPlayerButton;
	@FXML private Button deletePlayerButton;
	
	@FXML private TextField teamNameTextField;
	
	@FXML private ChoiceBox<String> formationChoiceBox;	
	@FXML private ChoiceBox<String> test;	
	
	@FXML private Spinner<Integer> shiftsSpinner;
	
	@FXML private ListView<String> playerListView;	
	
	@FXML private AnchorPane editTeamPane;
	
	private ArrayList<String> stringPlayersList = new ArrayList<>();

	private String playerName;
	private String selectedPlayer;	
	
	public SoccerTeam team;
	public SoccerTeam test_team;
	
	private String next_scene;

	
	//TODO BE Connections -> remove this when we have a BE

	ObservableList<String> formations = FXCollections.observableArrayList();//for debug, temporary
	private String[] players = {"lucy", "callia"};

	public EditTeamController() {
		team = new SoccerTeam("new_team"); 
		Main.user.addTeam(team);
		next_scene = "UserMenuScene.fxml";
		
		
	}
	public EditTeamController(String team_name) {
		team = Main.user.getTeam(team_name);
		next_scene = "TeamMenuScene.fxml";
	}
	
	/**
	 * Returns a string array of the team's players that can be used in the gui for displaying a player list
	 * 
	 * @param ArrayList<Player>
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getStringPlayerList(ArrayList<SoccerPlayer> playerList){
		ArrayList<String> stringPlayerList = new ArrayList<>();
		for(Player p:playerList) {
			stringPlayerList.add(p.getName());
		}
		return stringPlayerList;
	}

	/**
	 * Returns a string array of all soccer formations that can a coach can select
	 * TODO - BE Connection - need Formation type
	 * 
	 * @param ArrayList<Formation>
	 * @return ArrayList<String>
	 */
//	public ArrayList<String> getStringFormationList(ArrayList<Formation> formationList){
//		ArrayList<String> stringFormationList = new ArrayList<>();
//		for(Formation f:formationList) {
//			stringFormationList.add(f.getFormationName());
//		}
//		return stringPlayerList;
//	}
	
	

	/**
	 * A GUI Class
	 * Initializes ChoiceBox, Spinner, and ListView
	 * @return void
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//formation ChoiceBox
		formations.add("test_string");
		formationChoiceBox.getItems().addAll(formations); //TODO Not populating!

		
		//shifts Spinner 
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);		
		valueFactory.setValue(team.getGameShifts());	

	
	
		shiftsSpinner.setValueFactory(valueFactory);		
		

		
		//Player List View		
		stringPlayersList = getStringPlayerList(team.getPlayers());
		stringPlayersList = getStringPlayerList(team.getPlayers());
		playerListView.getItems().addAll(stringPlayersList);
		//playerListView.getItems().addAll(players);
		playerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {//TODO -> <Player>

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				selectedPlayer = playerListView.getSelectionModel().getSelectedItem();
				
			}
		});
		
	}
	
	/**
	 * Sets the team that the user wants to edit
	 * @param String teamname
	 */
//	public void setTeamToEdit(String team_name) {
//		if (team_name.equals("new_team")){
//			//create a new team
//			team = new SoccerTeam("new_team"); 
//			
//		}
//		else {
//			//editing an existing team
//			team = Main.user.getTeam(team_name);
//			if (team.equals(null)) {
//				//Error
//				System.out.println("Error: Cannot find team");
//			}
//		}
//
//	}
	
	
	/**
	* A GUI Class
	* Logs out user, brings user to LoginScene. Doesn't save anything. 
	* 
	* @param event
	* @throws IOException
	* @return void
	*/
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
	 * A GUI Class
	 * Brings user to Edit Player Page
	 * TODO - BE Connection - "loads" the selected player
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
			
			//TODO tell BE which player to edit - get player object from string name 
			
		}
		return;
		
		

	}
	
	/**
	 * A GUI Class
	 * Permanently deletes a player from the team
	 * 
	 * @param event
	 * @return void
	 */
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
			boolean player_deleted = team.removePlayer(playerName);
			if (player_deleted == false) {
				System.out.println("Error: " + playerName + " could not be deleted.");
			}
			
		}
		return;
	}
	
	/**
	 * A GUI Class
	 * Brings user to add Player Scene
	 * TODO - BE Connection? maybe we don't want to create player object until we save play from edit player scene?
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void addPlayer(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
		EditPlayerController controller = new EditPlayerController(team.getName());
		loader.setController(controller);
		
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * A GUI Class
	 * Saves team name, formation, and shifts
	 * TODO - BE Connection
	 * 
	 * @param event
	 * @return void
	 * @throws IOException 
	 */
	public void saveTeam(ActionEvent event) throws IOException {

		boolean teamEmpty = teamNameTextField.getText().isBlank();
		String formation = formationChoiceBox.getValue();
		
		//Display alert if no team name or formation selected
		//if (teamEmpty == true || formation == null) {
		if (teamEmpty == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Team Settings");
			alert.setHeaderText("Missing Team Information");
			alert.setContentText("Please enter Team Name and Formation.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		} else {

			Main.user.updateTeam(team, teamNameTextField.getText(), team.getFormation(), shiftsSpinner.getValue());
			//Exit the edit team scene
			FXMLLoader loader = new FXMLLoader(getClass().getResource(next_scene));
			UserMenuController controller = new UserMenuController();

			loader.setController(controller);
			
			
			root = loader.load();
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			

			
			
		}
		
		//Edit or Create a New Team - TODO BE Connection
		//Check if we are editing or creating a new team
		//pass in all field and player list to object constructor
		
		
	}
	
	/**
	 * A GUI Class 
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void returnToPreviousScene(ActionEvent event) throws IOException
	{		
		//Delete new_team if not updated and saved
		if (team.getName().equals("new_team")) {
			Main.user.removeTeam("new_team");
		}
		//Return to User menu if new team was created, or return to Team Menu if team was edited.
		FXMLLoader loader = new FXMLLoader(getClass().getResource(next_scene));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
		
}