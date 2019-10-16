package viewBooks;

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

public class ViewBooksController implements Initializable {

	@FXML
	private TableView<view> tableBooks;

	@FXML
	private TableColumn<view, String> col_title;

	@FXML
	private TableColumn<view, String> col_id;

	@FXML
	private TableColumn<view, String> col_author;

	@FXML
	private TableColumn<view, String> col_description;

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

	private void load() {
		String select = ("SELECT * FROM books");
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(select);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String title = result.getString("title");
				String id = result.getString("bookid");
				String author = result.getString("author");
				String description = result.getString("description");

				list.add(new view(title, id, author, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tableBooks.getItems().setAll(list);

	}

	private void initcol() {

		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
		col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
	}

	public static class view {
		private final SimpleStringProperty title;
		private final SimpleStringProperty id;
		private final SimpleStringProperty author;
		private final SimpleStringProperty description;

		view(String title, String id, String author, String description) {
			this.title = new SimpleStringProperty(title);
			this.id = new SimpleStringProperty(id);
			this.author = new SimpleStringProperty(author);
			this.description = new SimpleStringProperty(description);
		}

		public String getTitle() {
			return title.get();
		}

		public String getId() {
			return id.get();
		}

		public String getAuthor() {
			return author.get();
		}

		public String getDescription() {
			return description.get();
		}

	}

}
