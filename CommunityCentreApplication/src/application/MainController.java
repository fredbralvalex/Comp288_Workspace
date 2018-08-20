package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

//This class represents the controller for the FX Scene Creator
public class MainController {
	//The controlls in the program
	@FXML
	private Button btnDisplay;
	@FXML
	private Button btnExit;
	@FXML
	private TextField txtFee;
	@FXML
	private TextField txtAge;
	@FXML
	private RadioButton rdBtnMember;
	@FXML
	private RadioButton rdBtnNonMember;

	@FXML
	private void onExitClicked() {
		// ends the application
		System.exit(0);
	}

	//this is the event of Display button, on click
	@FXML
	private void onDisplayFeeClicked() {
		// calculate Fee

		// non member pay 20
		// member from 65 pay 5
		// otherwise 10
		String ageStr = txtAge.getText();
		int fee = 20;
		boolean member = rdBtnMember.isSelected();
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (NumberFormatException nfe) {
			// error
		}

		//The core of the program to decide what to do
		if (member) {
			if (age >= 65) {
				fee = 5;
			} else {
				fee = 10;
			}
		}
		txtFee.setText(String.valueOf(fee));
	}

}
