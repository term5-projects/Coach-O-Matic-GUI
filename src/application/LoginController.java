package application;

import java.io.IOException;

import coach_o_matic_be.src.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
* <h1>LoginController</h1>
* LoginController class prompts user for username and password and upon login, brings them to the user menu.
* User can also create a new account. 
* TODO - BE Connection
* 
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class LoginController {

		@FXML Button createAccountButton;		
		@FXML TextField usernameTextField;		
		@FXML PasswordField passwordField;
		
		private Stage stage;
		private Scene scene;
		private Parent root;
		private Player michael;

		/**
	    * Brings user to UserMenuScene
	    * TODO - BE Connection
	    * 
		* @param event
		* @throws IOException
		* @return void
		*/
		public void login(ActionEvent event) throws IOException {
			
			
			String username = usernameTextField.getText();
			String password = passwordField.getText();
			
			//Check if user credentials missing
			if (username.isBlank() == true || password.isBlank() == true) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Login");
				alert.setHeaderText("Invalid User Credentials");
				alert.setContentText("Please try again.");
				
				if (alert.showAndWait().get() == ButtonType.OK) {
				}
			}
			else {
				//BE Connection - TODO
				//bool validUser = findUser(username, password)
				boolean validUser = true; //TEMPORARY 
				if (validUser == true) {
					
					//load User Menu Scene add get the correct user
					//TODO - get the correct user object - how do we "pass" the user into the UserMenuController?
					FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMenuScene.fxml"));
					root = loader.load();
					
					UserMenuController userMenuController = loader.getController();
					userMenuController.displayName(username);
					
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();		
				}
				else {
					
					//Alert User of invalid credentials
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Login");
					alert.setHeaderText("Invalid User Credentials");
					alert.setContentText("Please try again.");
					
					if (alert.showAndWait().get() == ButtonType.OK) {
					}					
				}				
			}
		}
		
		/**
	    * Brings user to CreateAccount Scene.
	    * 
		* @param event
		* @throws IOException
		* @return void
		*/
		public void createAccount(ActionEvent event) throws IOException {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccountScene.fxml"));
			root = loader.load();
					
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
}
