package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Represents a controller to the application without using the Scene creator.
 * Keep all the controllers from the application.
 */
public class MainController extends Application {

	private static final String SPACER = ", ";
	private static final String BLANK = "";

	protected CheckBox cbStudentConcil;
	protected CheckBox cbVolunteerWork;

	protected TextField txtFieldName;
	protected TextField txtFieldAddress;
	protected TextField txtFieldProvince;
	protected TextField txtFieldCity;
	protected TextField txtFieldPostalCode;
	protected TextField txtFieldPhoneNumber;
	protected TextField txtFieldEmail;

	protected ComboBox<String> lbCourses;
	protected ListView<String> listBoxCouses;

	protected RadioButton rbComputerScience;
	protected RadioButton rbBusiness;

	protected TextArea txtAreaDisplay;
	protected Button btnDisplay;

	// Create the controls
	public MainController() {
		cbStudentConcil = new CheckBox("Student Concil");
		cbVolunteerWork = new CheckBox("Volunteer Work	");

		txtFieldName = new TextField();
		txtFieldAddress = new TextField();
		txtFieldProvince = new TextField();
		txtFieldCity = new TextField();
		txtFieldPostalCode = new TextField();
		txtFieldPhoneNumber = new TextField();
		txtFieldEmail = new TextField();

		lbCourses = new ComboBox<String>();
		// lbCourses.setValue(coursesList.get(0));

		listBoxCouses = new ListView<String>();
		listBoxCouses.setEditable(false);

		ToggleGroup radioGroup = new ToggleGroup();
		rbComputerScience = new RadioButton("Computer Science");
		rbComputerScience.setToggleGroup(radioGroup);

		rbBusiness = new RadioButton("Business");
		rbBusiness.setToggleGroup(radioGroup);

		btnDisplay = new Button("Display");
		txtAreaDisplay = new TextArea();
		addEventHandler();

		// update components
		rbComputerScience.setSelected(true);
		executeChangeRadio(true);
	}

	// adding eventHandler
	private void addEventHandler() {
		lbCourses.setOnAction(e -> executeListCoursesOnClick(lbCourses.getItems().indexOf(lbCourses.getValue())));
		btnDisplay.setOnAction(e -> executeDisplayOnClick());
		rbComputerScience.setOnAction(e -> executeChangeRadio(true));
		rbBusiness.setOnAction(e -> executeChangeRadio(false));

	}

	private void executeChangeRadio(boolean ComputerScience) {
		listBoxCouses.setItems(FXCollections.observableArrayList());
		lbCourses.setItems(FXCollections.observableArrayList());
		ObservableList<String> coursesList;
		if (ComputerScience) {
			coursesList = FXCollections.observableArrayList("Java", "ASP.NET", "C#", "Oracle");
		} else {
			coursesList = FXCollections.observableArrayList("Time Management", "Planning", "Error Mitigate",
					"Statistics");
		}
		lbCourses.setItems(coursesList);
	}

	// The event when a item on combo is selected: adding in the list
	private void executeListCoursesOnClick(int index) {
		if (lbCourses.getItems().size() > 0 && !listBoxCouses.getItems().contains(lbCourses.getItems().get(index))) {
			listBoxCouses.getItems().add(lbCourses.getItems().get(index));
		}
	}

	// Action of the click of display button
	private void executeDisplayOnClick() {
		String information = "";
		information += txtFieldName.getText();
		information += txtFieldAddress.getText().isEmpty() ? BLANK : SPACER + txtFieldAddress.getText();
		information += txtFieldCity.getText().isEmpty() ? BLANK : SPACER + txtFieldCity.getText();
		information += txtFieldProvince.getText().isEmpty() ? BLANK : SPACER + txtFieldProvince.getText();
		information += txtFieldPostalCode.getText().isEmpty() ? BLANK : SPACER + txtFieldPostalCode.getText();
		information += txtFieldPhoneNumber.getText().isEmpty() ? BLANK : SPACER + txtFieldPhoneNumber.getText();
		information += txtFieldEmail.getText().isEmpty() ? BLANK : SPACER + txtFieldEmail.getText();
		information += "\n";
		information += cbStudentConcil.isSelected() ? cbStudentConcil.getText() : BLANK;
		information += (cbStudentConcil.isSelected() & cbVolunteerWork.isSelected()) ? SPACER : BLANK;
		information += cbVolunteerWork.isSelected() ? cbVolunteerWork.getText() : BLANK;
		information += "\n";
		information += rbBusiness.isSelected() ? rbBusiness.getText() : rbComputerScience.getText();
		information += "\n";

		String courses = BLANK;
		for (String course : listBoxCouses.getItems()) {
			courses += "\n" + course;
		}
		information += courses.isEmpty() ? BLANK : courses;
		txtAreaDisplay.setText(information);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Nothing to do, the subclass will implement
	}

}
