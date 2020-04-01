package main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		try {
			String action = "";
			action = getAction();
			do {
				switch (action) {
				case "create":
					System.out.println("Enter first name:");
					String fName = scan.nextLine();
					System.out.println("Enter last name: ");
					String lname = scan.nextLine();
					db.createActors(fName, lname);
					break;
				case "print":
					db.readActors();
					break;
				case "delete":
					System.out.println("Enter the id:");
					int id = Integer.parseInt(scan.nextLine());
					db.deleteActor(id);
					break;
				default:
					System.out.println("No matching case");
				}
				action = getAction();
			} while (!action.equals("quit"));
			System.out.println("bye");
		} finally {
			scan.close();
			db.close();
		}
	}

	private static String getAction() {
		System.out.println("Type 'create' to create, 'print' to print, 'delete' to delete or 'quit' to quit.");
		return scan.nextLine().toLowerCase();
	}
}
