package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;
	private Statement stmt;

	public DB() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createActors(String fName, String lName) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('" + fName + "', '" + lName + "')");
	}

	public void readActors() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM actor");
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
	}

	public void updateActor(String fName, String lName, int id) throws SQLException {
		stmt.executeUpdate(
				"UPDATE actor SET first_name = '" + fName + "', last_name = '" + lName + "' WHERE actor_id = " + id);
	}

	public void deleteActor(int id) throws SQLException {
		stmt.executeUpdate("DELETE FROM actor WHERE actor_id = " + id);
	}

}
