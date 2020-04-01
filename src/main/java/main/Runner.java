package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
	private static final String DB_URL = "jdbc:mysql://35.241.217.5/sakila";
	private static final String USER = "root";
	private static final String PASS = "pass";

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM actor");
		while (rs.next()) {
			String name = rs.getString("first_name")
					+ " " 
					+ rs.getString("last_name");
			System.out.println(name);
		}
		conn.close();
	}

}
