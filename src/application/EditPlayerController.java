package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
* <h1>EditPlayerController</h1>
* EditPlayerController class is used to edit player name and positions.
* TODO - need to change so class uses a checklistview so that we can dynamically change available positions
*
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class EditPlayerController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Button returnButton;
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
	
	//private Positions[] playerPositions = Positions.values(); TODO
	//private ArrayList<String> playerPositions = new ArrayList<String>();
	
	
	
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
		//TODO


		
		return;

	}
	
	
	
	
	
}
