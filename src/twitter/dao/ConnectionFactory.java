package twitter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection conectar() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/twitter?useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Marcinho@1998");
	}
}