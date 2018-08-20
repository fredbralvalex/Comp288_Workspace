package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		String user = "COMP214_W18_004_8";
		String password = "password";
		try {
			// this loads the driver in memory
			Class.forName("oracle.jdbc.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", user,
					password);
			System.out.println("Connection is sucessful");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
}