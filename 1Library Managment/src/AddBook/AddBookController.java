package AddBook;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import conectivity.ConnectionClass;
import conectivity.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBookController implements Initializable {

	@FXML
	private TextField title;
	@FXML
	private TextField id;
	@FXML
	private TextField author;
	@FXML
	private TextField description;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private Connection connection;
	private DbHandler handler;
	private PreparedStatement pst;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		handler = DbHandler.getInstance();
	}

	@FXML
	private void addBook(ActionEvent event) throws SQLException {
		String insert = "INSERT INTO books(title,bookid,author,description)" + "VALUES (?,?,?,?)";
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(insert);
		} catch (Exception e) {
		}

		try {
			pst.setString(1, title.getText());
			pst.setString(2, id.getText());
			pst.setString(3, author.getText());
			pst.setString(4, description.getText());

			pst.executeUpdate();

		} catch (Exception e) {
		}

	}

	@FXML
	private void cancelBook(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

}
