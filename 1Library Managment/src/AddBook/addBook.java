package AddBook;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addBook extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Add Book");
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AddBook.fxml"));
			Scene scene = new Scene(root, 477, 489);
			scene.getStylesheets().add(getClass().getResource("AddBook.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		launch(args);

	}

}
