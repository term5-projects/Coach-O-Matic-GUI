package application;

import java.io.IOException;

import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
* <h1>UserMenuController</h1>
* UserMenuController class allows user to create a new team or select an existing.
* TODO - BE Connection
* 
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class UserMenuController implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML Label usernameLabel;
	
	@FXML private Button logoutButton;
	@FXML private Button newTeamButton;
	@FXML private Button submitButton;
	
	@FXML private ChoiceBox<String> selectTeamChoiceBox;	
	
	@FXML private AnchorPane userMenuScenePane;
	
	//TODO BE Connection - remove this once we have BE
	private String[] stringTeamList = {"FAA Gu11", "SYJS Bu11"}; //Temporary
	
	
	/**
	 * Returns a string array of teams that can be used in the gui for displaying a team list
	 * TODO - BE Connection - need Team type
	 * 
	 * @param ArrayList<Team>
	 * @return ArrayList<String>
	 */
//	public ArrayList<String> getStringTeamList(ArrayList<Team> teamList){
//		ArrayList<String> stringTeamList = new ArrayList<>();
//		for(Team t:teamList) {
//			stringTeamList.add(t.getName());
//		}
//		return stringTeamList;
//	}

	/**
	 * A GUI Class 
	 * Initializes selectTeamChoiceBox
	 * 
	 * @return void
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selectTeamChoiceBox.getItems().addAll(stringTeamList);		
	}
	
	
	/**
	 * A GUI Class
	 * Displays username to the UserMenuPage.
	 * 
	 * @param username
	 * @return void
	 */
	public void displayName(String username) {
		usernameLabel.setText("Hi " + username);
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
	 * Create a new team and brings user to EditTeamScene
	 * TODO - BE Connection - Make new team object, and use edit team controller to add new team rather than modify. 
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void addTeam(ActionEvent event)throws IOException
	{		
		//TODO - Create new team object and "pass" in that team
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeamScene.fxml"));
		root = loader.load();
		
			
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

	/**
	 * A GUI Class
	 * Brings user to selected Team Menu. 
	 * Displays an alert if no team is selected. 
	 * TODO - BE Connection - "load" up the selected team
	 * 
	 * @param event
	 * @throws IOException
	 * @return void
	 */
	public void visitTeamMenu(ActionEvent event) throws IOException {
			String teamname = selectTeamChoiceBox.getValue();
			boolean teamname_empty = teamname.isBlank();
			if (teamname_empty) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Select Team");
				alert.setHeaderText("Invalid Input");
				alert.setContentText("Please select one of the teams from the the drop down list.");
				
				if (alert.showAndWait().get() == ButtonType.OK) {
				}
			}
			
			else {
				//TODO - Get the team object user.getTeam(teamname);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("TeamMenuScene.fxml"));
				root = loader.load();
				
				TeamMenuController teamMenuController = loader.getController();
				teamMenuController.displayTeamName(teamname);
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
	}



	
}
	