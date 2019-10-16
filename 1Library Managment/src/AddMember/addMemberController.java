package AddMember;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import conectivity.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addMemberController implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private TextField number;
	@FXML
	private TextField email;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private Connection connection;
	private DbHandler handler;
	private PreparedStatement pst;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		handler = DbHandler.getInstance();
	}

	@FXML
	private void save(ActionEvent event) {
		String insert = "INSERT INTO members(name,id,number,email)" + "VALUES (?,?,?,?)";
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(insert);
		} catch (Exception e) {
		}

		try {
			pst.setString(1, name.getText());
			pst.setString(2, id.getText());
			pst.setString(3, number.getText());
			pst.setString(4, email.getText());

			pst.executeUpdate();

		} catch (Exception e) {
		}
	}

	@FXML
	private void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

}
