module module {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	requires java.sql;
	requires com.jfoenix;
	requires java.prefs;
	exports AddBook;
	opens AddBook;
	exports conectivity;
	opens conectivity;
	exports AddMember;
	opens AddMember;
	exports Main;
	opens Main;
	exports viewBooks;
	opens viewBooks;
	exports viewMembers;
	opens viewMembers;
	exports Login;
	opens Login;
}