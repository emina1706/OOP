package viewMembers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import conectivity.DbHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewMembersController implements Initializable {
	@FXML
	private TableView<view> ViewMembersTable;

	@FXML
	private TableColumn<view, String> col_name;

	@FXML
	private TableColumn<view, String> col_id;

	@FXML
	private TableColumn<view, String> col_phone;

	@FXML
	private TableColumn<view, String> col_mail;

	DbHandler handler;
	private Connection connection;
	private PreparedStatement pst;
	ObservableList<view> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initcol();
		handler = new DbHandler();
		load();
	}

	public void load() {
		String select = ("SELECT name,id,number,email FROM members");
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(select);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				String name = result.getString("name");
				String id = result.getString("id");
				String mail = result.getString("email");
				String phone = result.getString("number");

				list.add(new view(name, id, phone, mail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ViewMembersTable.getItems().setAll(list);

	}

	private void initcol() {
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));

	}

	public static class view {
		private final SimpleStringProperty name;
		private final SimpleStringProperty id;
		private final SimpleStringProperty phone;
		private final SimpleStringProperty mail;

		view(String name, String id, String phone, String mail) {

			this.name = new SimpleStringProperty(name);
			this.id = new SimpleStringProperty(id);
			this.phone = new SimpleStringProperty(phone);
			this.mail = new SimpleStringProperty(mail);
		}

		public String getName() {
			return name.get();
		}

		public String getId() {
			return id.get();
		}

		public String getPhone() {
			return phone.get();
		}

		public String getMail() {
			return mail.get();
		}
	}
}
