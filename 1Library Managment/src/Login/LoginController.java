package Login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import conectivity.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private JFXButton btnLogin;

	@FXML
	private JFXButton btn;

	private DbHandler handler;
	private Connection connection;
	private PreparedStatement pst;

	@FXML
	private void login(ActionEvent event) {
		connection = handler.getConnection();
		String email = username.getText().toString();
		String password1 = password.getText().toString();

		String sql = "SELECT * FROM login WHERE username1 = ? and password1 = ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password1);
			ResultSet result = pst.executeQuery();
			if (!result.next()) {
				infoBox("Please enter correct Email and Password !", null, "Failed Log in");
			} else {
				closeStage();
				load();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeStage() {
		((Stage) username.getScene().getWindow()).close();

	}

	void load() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/Main/Main.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}

	@FXML
	void Cancelb(ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		handler = new DbHandler();
	}

}
