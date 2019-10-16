package Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import conectivity.DbHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

	@FXML
	private Button btnOpen1;
	@FXML
	private Button btnOpen2;
	@FXML
	private Button btnView1;
	@FXML
	private Button btnView2;
	@FXML
	private Button btnSettings;
	@FXML
	private HBox infoBook;
	@FXML
	private TextField eBook;
	@FXML
	private Text titleB;
	@FXML
	private Text authorB;
	@FXML
	private HBox infoMember;
	@FXML
	private TextField eMember;
	@FXML
	private Text nameM;
	@FXML
	private Text mailM;
	@FXML
	private JFXButton issue;
	@FXML
	private TableView<viewBooks> issuedBooksTable;
	@FXML
	private TableColumn<viewBooks, String> col_book_id;
	@FXML
	private TableColumn<viewBooks, String> col_book_title;
	@FXML
	private TableColumn<viewBooks, String> col_member_name;

	private DbHandler handler;
	private Connection connection;
	private PreparedStatement pst;
	ObservableList<viewBooks> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		handler = DbHandler.getInstance();
		initcol();
		loadTable();
	}

	@FXML
	private void openAddMember(ActionEvent event) {
		load("/AddMember/AddMember.fxml", "Add New Member");
	}

	@FXML
	private void openAddBook(ActionEvent event) {
		load("/AddBook/AddBook.fxml", "Add New Book");
	}

	@FXML
	private void openViewMembers(ActionEvent event) {
		load("/viewMembers/ViewMembers.fxml", "All Members");
	}

	@FXML
	private void openViewBooks(ActionEvent event) {
		load("/viewBooks/ViewBooks.fxml", "All Books");
	}

	@FXML
	void loadBookInfo(ActionEvent event) {
		connection = handler.getConnection();
		String bookID = eBook.getText().toString();
		String select = "SELECT * FROM books WHERE bookid = '" + bookID + "'";

		try {
			pst = connection.prepareStatement(select);
			// pst.setString(1, bookID);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String title = result.getString("title");
				String author = result.getString("author");

				titleB.setText(title);
				authorB.setText(author);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void loadMemberInfo(ActionEvent event) {
		connection = handler.getConnection();
		String memberID = eMember.getText().toString();
		String select = "SELECT * FROM members WHERE id = '" + memberID + "'";

		try {
			pst = connection.prepareStatement(select);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				String name = result.getString("name");
				String mail = result.getString("email");

				nameM.setText(name);
				mailM.setText(mail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void issueBook(ActionEvent event) {

		connection = handler.getConnection();
		String insert = "INSERT INTO books_issued(bookid,title,name)" + "VALUES (?,?,?)";

		try {
			pst = connection.prepareStatement(insert);
		} catch (Exception e) {

		}
		try {
			pst.setString(1, eBook.getText());
			pst.setString(2, titleB.getText());
			pst.setString(3, nameM.getText());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void load(String location, String title) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(location));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setTitle(title);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);

		}

	}

	public void loadTable() {
		String select = ("SELECT * FROM books_issued");
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(select);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				String id = result.getString("bookid");
				String title = result.getString("title");
				String name = result.getString("name");

				list.add(new viewBooks(id, title, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		issuedBooksTable.getItems().setAll(list);

	}

	private void initcol() {
		col_book_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_book_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_member_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	}

	public static class viewBooks {
		private final SimpleStringProperty id;
		private final SimpleStringProperty title;
		private final SimpleStringProperty name;

		public String getId() {
			return id.get();
		}

		public String getTitle() {
			return title.get();
		}

		public String getName() {
			return name.get();
		}

		public viewBooks(String id, String title, String name) {
			this.id = new SimpleStringProperty(id);
			this.title = new SimpleStringProperty(title);
			this.name = new SimpleStringProperty(name);
		}

	}
}
