package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
* <h1>LoginController</h1>
* LoginController class prompts user for username and password and upon login, brings them to the user menu.
* 
* 
* 
* 
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

		/**
	    * Brings user to UserMenuScene
		* @param event
		* @return void
		*/
		public void login(ActionEvent event) throws IOException {

			
			String username = usernameTextField.getText();
			String password = passwordField.getText();
			
			//Check user credentials
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMenuScene.fxml"));
			root = loader.load();
			
			UserMenuController userMenuController = loader.getController();
			userMenuController.displayName(username);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		public void createAccount(ActionEvent event) throws IOException {

			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccountScene.fxml"));
			root = loader.load();
					
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
}
