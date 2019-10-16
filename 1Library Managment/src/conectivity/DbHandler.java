package conectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler extends Configs {

	private static DbHandler handler = null;
	Connection dbConnection;

	public static DbHandler getInstance() {
		if (handler == null) {
			handler = new DbHandler();
		}
		return handler;
	}

	public Connection getConnection() {
		String connectionString = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbname
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			dbConnection = DriverManager.getConnection(connectionString, Configs.dbuser, Configs.dbpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dbConnection;
	}
}
