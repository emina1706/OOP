package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root, 530, 420);
			scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Library");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
