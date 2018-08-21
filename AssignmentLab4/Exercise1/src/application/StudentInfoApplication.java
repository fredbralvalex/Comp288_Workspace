package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/** The class application for prompting student info */
public class StudentInfoApplication extends MainController {

	// Override the start method in the Application class
	@Override
	public void start(Stage primaryStage) {
		// This is the first level pane
		BorderPane pane = new BorderPane();
		// Place nodes in the pane
		pane.setCenter(createSecondLevelPane());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Student Info");
		// Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Creates a pane for second level pane
	private Pane createSecondLevelPane() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		pane.add(createThirdLevelPane(), 0, 0);
		pane.add(createPaneButton(), 0, 1);
		pane.add(createPaneDisplay(), 0, 2);
		return pane;
	}

	// Creates a pane for third level pane
	private Pane createThirdLevelPane() {
		BorderPane pane = new BorderPane();
		// Place nodes in the pane
		pane.setLeft(createTextInfoPane());
		pane.setRight(createFourthLevelPane());
		return pane;
	}

	// Creates a pane for third level pane
	private Pane createFourthLevelPane() {
		BorderPane pane = new BorderPane();
		// Place nodes in the pane
		pane.setLeft(createCheckBoxInfoPane());
		pane.setRight(createOtherInfoPane());
		return pane;
	}

	// Creates the content of text information
		private Pane createCheckBoxInfoPane() {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(10, 10, 10, 10));
			pane.setHgap(5.5);
			pane.setVgap(5.5);

			// Place nodes in the pane
			// Pane for the major information
			pane.add(cbStudentConcil, 0, 0);
			pane.add(cbVolunteerWork, 0, 1);
			return pane;
		}

	// Creates the content of text information
	private Pane createTextInfoPane() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		// Place nodes in the pane
		pane.add(new Label("Name:"), 0, 0);
		pane.add(txtFieldName, 1, 0);
		pane.add(new Label("Address:"), 0, 1);
		pane.add(txtFieldAddress, 1, 1);
		pane.add(new Label("Province:"), 0, 2);
		pane.add(txtFieldProvince, 1, 2);
		pane.add(new Label("City:"), 0, 3);
		pane.add(txtFieldCity, 1, 3);
		pane.add(new Label("Postal Code:"), 0, 4);
		pane.add(txtFieldPostalCode, 1, 4);
		pane.add(new Label("Phone Number:"), 0, 5);
		pane.add(txtFieldPhoneNumber, 1, 5);
		pane.add(new Label("Email:"), 0, 6);
		pane.add(txtFieldEmail, 1, 6);
		return pane;
	}

	// Creates the content of text information
	private Pane createOtherInfoPane() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);

		pane.setHgap(5.5);
		pane.setVgap(5.5);

		// Place nodes in the pane
		// Pane for the major information
		pane.add(createStudentMajorPane(), 0, 0);
		// List of courses
		pane.add(lbCourses, 0, 1);
		listBoxCouses.setMaxHeight(150);
		pane.add(listBoxCouses, 0, 2);

		return pane;
	}

	// Creates a pane for the student's major
	private Pane createStudentMajorPane() {
		BorderPane pane = new BorderPane();
		// Place nodes in the pane

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setLeft(rbComputerScience);
		pane.setRight(rbBusiness);
		return pane;
	}

	// Creates a pane for the display button
	private Pane createPaneButton() {
		BorderPane pane = new BorderPane();
		// Place nodes in the pane

		pane.setCenter(btnDisplay);
		return pane;
	}

	// Creates a pane for the display
	private Pane createPaneDisplay() {
		BorderPane pane = new BorderPane();
		// Place nodes in the pane
		txtAreaDisplay = new TextArea();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setCenter(txtAreaDisplay);
		return pane;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
