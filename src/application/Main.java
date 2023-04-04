package application;
	
import coach_o_matic_be.src.coach_o_matic_be.SoccerTeam;
import coach_o_matic_be.src.coach_o_matic_be.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

/**
* <h1>Main</h1>
* Main class is the top level class for the Coach-O-Matic GUI.
* Starts at the login scene, and has a logout method that prompts for user to save changes before exiting.  
*
* @author  Grace Pearcey
* @version 1.0
* @since   2023-03-29 
*/
public class Main extends Application {
	public static User user;
	
	@Override
	public void start(Stage stage) {
		try {
			

			Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
//			stage.setOnCloseRequest(event -> { TODO - For adding alert
//				event.consume();
//				logout(stage);
//			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
//	public void logout(Stage stage) TODO - for adding alert
//	{
//		
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Logout");
//		alert.setHeaderText("You're about to exit the logout!");
//		alert.setContentText("Do you want to save before exiting?");
//		
//		if (alert.showAndWait().get() == ButtonType.OK) {
//			System.out.println("You successfully logged out!");
//			stage.close();
//		}
//			
//		
//	}
}
