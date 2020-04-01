package main;

import java.sql.SQLException;

public class Runner {


	public static void main(String[] args) throws SQLException {
		DB db = new DB();
//		db.readActors();
//		db.createActors("Matt", "Berk");
//		db.deleteActor(201);
		db.updateActor("Matt", "BERK", 44);
	}

}
