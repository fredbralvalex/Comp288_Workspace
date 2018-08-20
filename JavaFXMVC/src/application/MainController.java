package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML
	private Button btnOk;// represents the OK button
	@FXML
	private Button btnCancel; // represents the Cancel button

	@FXML
	private void initialize() {
		btnOk.setOnAction(new OKHandlerClass());
		btnCancel.setOnAction(new CancelHandlerClass());
	}

	class OKHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onOkClicked();
		}
	}

	class CancelHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onCancelClicked();
		}
	}

	public void onOkClicked() {
		System.out.println("OK button clicked");
	}

	public void onCancelClicked() {
		System.out.println("Cancel button clicked");
	}
}
