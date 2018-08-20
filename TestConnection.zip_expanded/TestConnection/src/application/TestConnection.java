package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestConnection {
	public static void main(String[] args)  {


		try{

			//this loads the driver in memory
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_W18_004_8","password");
			System.out.println("Successfull connection");

			// create a table named Person
			String sqlCreate = "Create Table Person(" +
					"id char(9) NOT NULL," +
					"firstName varchar (20) NOT NULL," +
					"lastName varchar (20) NOT NULL," +
					" PRIMARY KEY ( id ))";

			Statement createStatement = connection.createStatement();
			createStatement.executeUpdate(sqlCreate);
			System.out.println("Created Person table in the database...");

			// insert rows into person
			String sqlInsert = "INSERT INTO Person " +
					"VALUES (1005, 'Meryl', 'Streep')";


			Statement insertStatement = connection.createStatement();
			insertStatement.executeUpdate(sqlInsert);
			System.out.println("Values have been inserted");

			Statement retrieveStatement = connection.createStatement();
			ResultSet resultSet = retrieveStatement.executeQuery("select * from Person");

			// fetch all rows from the Person table
			// get ResultSet's meta data

			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.printf("Person Table:%n%n");

			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++){

				System.out.printf("%-14s\t",metaData.getColumnName(i) );
			}
			System.out.println();

			// display query results
			while (resultSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-14s\t", resultSet.getObject(i));
				System.out.println();
			}

/*
			// DROP the table

			String sqlDrop = "drop table Person ";


			Statement dropStatement = connection.createStatement();
			dropStatement.executeUpdate(sqlDrop);
			System.out.println("The table has been deleted");


*/

		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}



	}
}

