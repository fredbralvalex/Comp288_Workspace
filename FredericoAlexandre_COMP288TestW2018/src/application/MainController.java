package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.JdbcRowSet;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * This class represents the controller for the application
 */
public class MainController implements Initializable {

	// Fields
	@FXML
	private TextField cityTextField;

	@FXML
	private TextArea studentsTextArea;

	@FXML
	private Button displayBtn;

	// The list to be shown
	private ObservableList<Student> studentsList;

	private static DBManager dbManager = new DBManager();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		displayBtn.setOnAction(e -> onDisplayClicked());
	}

	private void onDisplayClicked() {
		String city = cityTextField.getText();
		doQueryTextAreaViewInfo(city);
	}

	// display reports
	private void doQueryTextAreaViewInfo(String p_city) {
		studentsList = FXCollections.observableArrayList();

		try (JdbcRowSet rowSet = dbManager.getRowSet()) {
			StringBuffer myCommand = new StringBuffer();

			// Accepting any entry
			myCommand
					.append("select studentid, firstname, lastname, address, city, province, postalcode from students");
			if (p_city != null && !p_city.equals("")) {
				myCommand.append(" where city like '%" + p_city + "%'");
			}

			rowSet.setCommand(myCommand.toString());
			rowSet.execute();

			while (rowSet.next()) {
				// Creates students from select table
				Student student = new Student(rowSet.getString("studentid"), rowSet.getString("firstname"),
						rowSet.getString("lastname"), rowSet.getString("address"), rowSet.getString("city"),
						rowSet.getString("province"), rowSet.getString("postalcode"));
				studentsList.add(student);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		String studentInfo = "";
		for (Student student : studentsList) {
			studentInfo += "\n" + student.toString();
		}
		studentsTextArea.setText(studentInfo);
	}

}
