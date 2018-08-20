package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

	@FXML Button _btnShow;
    @FXML TextArea _txtArea;



	@FXML private void onClickedShow()
	{


		//this loads the driver in memory
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_W18_004_8","password");
			System.out.println("Successfull connection");

			Statement retrieveStatement = connection.createStatement();
			ResultSet resultSet = retrieveStatement.executeQuery("select * from person");

			// fetch all rows from the Person table
			// get ResultSet's meta data

			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.printf("Person Table:%n%n");

			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++){

				_txtArea.appendText(String.format("%-14s\t",metaData.getColumnName(i)));


			}
			  _txtArea.appendText("\n");

			// display query results
			while (resultSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
				{
					_txtArea.appendText(String.format("%-14s\t", resultSet.getObject(i)));
				}
				_txtArea.appendText("\n");

			}

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
