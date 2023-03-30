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
	
	/**
	 * 
	 * @param player
	 * @return void
	 * @throws IOException 
	 */
	public void editPlayer(ActionEvent event) throws IOException//TODO -> Player
	{		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		//TODO tell BE which player to edit
	}
	
	
//	public Player getSelectedPlayer() { TODO
//		return selectedPlayer;
//	}
	
	public void deletePlayer(ActionEvent event) {
		//TODO 
	}
	public void addPlayer(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlayerScene.fxml"));
		root = loader.load();
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void saveTeam(ActionEvent event) {
		//Save team changes TODO
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
}