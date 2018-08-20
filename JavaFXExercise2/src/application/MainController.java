package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

	@FXML
	private Button btnShow;
	@FXML
	private Button btnClear;
	@FXML
	private TextArea txtArea;

	@FXML
	private void initialize() {
		btnShow.setOnAction(e -> onShowClicked());
		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				onClearClicked();
			}
		});
	}

	class ShowHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onShowClicked();
		}
	}

	public void onShowClicked() {
		txtArea.setText("This is the COMP228 Class!!!");
	}

	public void onClearClicked() {
		txtArea.clear();
	}

}
