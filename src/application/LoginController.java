package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

		@FXML
		TextField usernameTextField;
		
		@FXML
		TextField passwordTextField;
		
		private Stage stage;
		private Scene scene;
		private Parent root;

		public void login(ActionEvent event) throws IOException {
			
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMenuScene.fxml"));
			root = loader.load();
			
			UserMenuController userMenuController = loader.getController();
			userMenuController.displayName(username);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
}
