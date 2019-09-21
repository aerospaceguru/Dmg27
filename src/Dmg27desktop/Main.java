package Dmg27desktop;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
				
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Application.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);		
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("DMG 27 Pavement Calculation Programme");
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
