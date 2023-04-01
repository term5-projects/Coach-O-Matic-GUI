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

/**
* <h1>TeamMenuController</h1>
* TeamMenuController class allows user to edit their team and
* select available players to create lineups.
* TODO - BE Connection
* 
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class TeamMenuController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML private Button logoutButton;
	@FXML private Button returnButton;
	@FXML private Button createLineupButton;
	@FXML private Button editTeamButton;
	
	@FXML private Label teamnamelabel;
	
	@FXML private AnchorPane teamMenuScenePane;
	
	@FXML private CheckListView<String> availablePlayersCheckListView;
	ArrayList<String> selectedPlayers =new ArrayList<>();
	
	
	//TODO -BE Connections -> remove this temporary stuff	
	private String[] players = {"Misha", "Glyn", "Howard"};//TODO -> Temporary
	int num_players_in_formation = 2; //TODO -> Temporary
	

	
	/**
	 * A GUI Class
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
		
	
	/**
	 * Returns a string array of players that can be used in the gui for displaying a player list
	 * TODO - BE Connection - need Player type
	 * 
	 * @param ArrayList<Player>
	 * @return ArrayList<String>
	 */
//	public ArrayList<String> getStringPlayerList(ArrayList<Player> playerList){
//		ArrayList<String> stringPlayerList = new ArrayList<>();
//		for(Player p:playerList) {
//			stringPlayerList.add(p.getName());
//		}
//		return stringPlayerList;
//	}
	
	
	/**
	 * A GUI Class
	 * Displays team name in a label
	 * 
	 * @param TeamName
	 * @return void
	 */
	public void displayTeamName(String TeamName) {
		teamnamelabel.setText( TeamName + " Menu");
	}
	

	/**
	 * A GUI Class
	 * Logs out user, brings user to LoginScene
	 * TODO - BE Connection? Delete temporary instance of user?
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void logout(ActionEvent event) throws IOException
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
	 * Brings user to User Menu
	 * TODO - BE Connection? Delete temporary instance of selected team?
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void returnToPreviousScene(ActionEvent event) throws IOException
	{		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMenuScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	/**
	 * A GUI Class
	 * Brings user to generated lineup scene
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void switchToLineupScene(ActionEvent event)throws IOException

	{	
		//TODO BE Connection - num_players_in_formation = formation.getPlayers();
		if (selectedPlayers.size() < num_players_in_formation) {
			String num_players_in_formation_str = String.valueOf(num_players_in_formation);
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Lineup Generation");
			alert.setHeaderText("Invalid Player Selection");
			alert.setContentText("Please select at least " +  num_players_in_formation_str + " players for the team formation.");
			
			if (alert.showAndWait().get() == ButtonType.OK) {
			}
		}else {
		
			System.out.println("The dynamic array is: " + selectedPlayers);			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LineupScene.fxml"));	
			root = loader.load();
	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();	
			scene = new Scene(root);	
			stage.setScene(scene);	
			stage.show();
		}

	}

	
	/**
	 * A GUI Class
	 * Brings user to edit team scene
	 * TODO - BE Connection - need to "pass" in current team and use modifying methods instead of creating a new team. 
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void switchToEditTeamScene(ActionEvent event)throws IOException

	{		
		//TODO BE Connection - pass in current team 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeamScene.fxml"));
		root = loader.load();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

