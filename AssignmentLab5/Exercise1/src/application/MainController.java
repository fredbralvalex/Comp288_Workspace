package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import javax.sql.rowset.JdbcRowSet;
import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Lab5 Assignment
 *
 * @author Hyojin Kim (300950009), Frederico Alexandre (300974435)
 * @since  2018.04.11
 */
public class MainController implements Initializable {

	// Declaration & Initialization
	@FXML private TableView<PlayedGame> _tableView;
	@FXML private TableColumn<PlayedGame, Integer> _pgId;
	@FXML private TableColumn<PlayedGame, Integer> _gameId;
	@FXML private TableColumn<PlayedGame, Integer> _playerId;
	@FXML private TableColumn<PlayedGame, String> _gameTitle;
	@FXML private TableColumn<PlayedGame, String> _playerFirstName;
	@FXML private TableColumn<PlayedGame, String> _playerLastName;
	@FXML private TableColumn<PlayedGame, String> _playingDate;
	@FXML private TableColumn<PlayedGame, Integer> _score;

	@FXML private TextField _txtPlayerId;
	@FXML private TextField _txtGame;
	@FXML private TextField _txtFirstName;
	@FXML private TextField _txtLastName;
	@FXML private TextField _txtAddress;
	@FXML private TextField _txtPostalCode;
	@FXML private TextField _txtProvince;
	@FXML private TextField _txtPhoneNumber;
	@FXML private TextField _txtScore;
	@FXML private ComboBox<String> _comboBoxPlayerList;
	@FXML private ComboBox<HashMap<Integer, String>> _comboBoxPlayerDetail;
	@FXML private ComboBox<HashMap<Integer, String>> _comboBoxGameDetail;
	@FXML private DatePicker _datePicker;

	@FXML private Button _btnAddGame;
	@FXML private Button _btnAddPlayer;
	@FXML private Button _btnUpdatePlayer;
	@FXML private Button _btnClearFields;
	@FXML private Button _btnAddPlayedGame;

	private ObservableList<PlayedGame> _playedGamelist;
	private ObservableList<String> _playerList;
	private ObservableList<HashMap<Integer, String>> _playerDetail;
	private ObservableList<HashMap<Integer, String>> _gameDetail;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// call methods
		getTableViewInfo();				// display reports with player and played games information
		getPlayerList();				// existing player information for updating
		getGameListDetail();			// existing game list
		getPlayerListDetail();			// existing player list

		_tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PlayedGame>(){
			@Override
			public void changed(ObservableValue<? extends PlayedGame> arg0, PlayedGame arg1, PlayedGame arg2) {
				//PlayedGame _playedGame = _tableView.getSelectionModel().getSelectedItem();
			}
		});
	}

	// display reports with player and played games information
	@FXML private void getTableViewInfo()
	{
		_playedGamelist = FXCollections.observableArrayList();

		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			StringBuffer myCommand = new StringBuffer();
			myCommand.append("SELECT pag.player_game_id as pgId, p.player_id, p.first_name, p.last_name,");
			myCommand.append("		 g.game_id, g.game_title, pag.score,");
			myCommand.append("		 TO_CHAR(pag.playing_date, 'YYYY-MM-DD') as playing_date");
			myCommand.append("  FROM playerAndGame pag");
			myCommand.append(" INNER JOIN game g ON pag.game_id = g.game_id");
			myCommand.append(" INNER JOIN player p ON pag.player_id = p.player_id");

			_rowSet.setCommand(myCommand.toString());
			_rowSet.execute();

			while(_rowSet.next())
			{
				PlayedGame _playedGame = new PlayedGame();
				_playedGame.setPgId(Integer.parseInt(_rowSet.getString("pgId")));
				_playedGame.setPlayerId(Integer.parseInt(_rowSet.getString("player_id")));
				_playedGame.setPlayerFirstName(_rowSet.getString("first_name"));
				_playedGame.setPlayerLastName(_rowSet.getString("last_name"));
				_playedGame.setGameId(Integer.parseInt(_rowSet.getString("game_id")));
				_playedGame.setGameTitle(_rowSet.getString("game_title"));
				_playedGame.setPlayingDate(_rowSet.getString("playing_date"));
				_playedGame.setScore(Integer.parseInt(_rowSet.getString("score")));

				_playedGamelist.add(_playedGame);
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		_pgId.setCellValueFactory(new PropertyValueFactory<PlayedGame, Integer>("pgId"));
		_playerId.setCellValueFactory(new PropertyValueFactory<PlayedGame, Integer>("playerId"));
		_playerFirstName.setCellValueFactory(new PropertyValueFactory<PlayedGame, String>("playerFirstName"));
		_playerLastName.setCellValueFactory(new PropertyValueFactory<PlayedGame, String>("playerLastName"));
		_gameId.setCellValueFactory(new PropertyValueFactory<PlayedGame, Integer>("gameId"));
		_gameTitle.setCellValueFactory(new PropertyValueFactory<PlayedGame, String>("gameTitle"));
		_playingDate.setCellValueFactory(new PropertyValueFactory<PlayedGame, String>("playingDate"));
		_score.setCellValueFactory(new PropertyValueFactory<PlayedGame, Integer>("score"));

		_tableView.setItems(_playedGamelist);
	}
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	// existing player information for updating
	@FXML private void getPlayerList()
	{
		_playerList = FXCollections.observableArrayList();

		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			_rowSet.setCommand("SELECT player_id, first_name FROM Player");
			_rowSet.execute();

			while(_rowSet.next())
			{
				_playerList.add(_rowSet.getString("first_name"));
			}
			_comboBoxPlayerList.setItems(_playerList);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// existing player information for updating - comboBox changed event
	@FXML private void comboBoxChanged()
	{
		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			StringBuffer myCommand = new StringBuffer();
			myCommand.append("SELECT * FROM Player WHERE first_name = \'");
			myCommand.append(_comboBoxPlayerList.getValue().toString());
			myCommand.append("\'");

			_rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			_rowSet.setCommand(myCommand.toString());
			_rowSet.execute();

			while(_rowSet.next())
			{
				_txtPlayerId.setText(_rowSet.getString("player_id"));
				_txtFirstName.setText(_rowSet.getString("first_name"));
				_txtLastName.setText(_rowSet.getString("last_name"));
				_txtAddress.setText(_rowSet.getString("address"));
				_txtPostalCode.setText(_rowSet.getString("postal_code"));
				_txtProvince.setText(_rowSet.getString("province"));
				_txtPhoneNumber.setText(_rowSet.getString("phone_number"));
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// clear player fields
	@FXML private void btnClearFieldsClicked()
	{
		_txtPlayerId.clear();
		_txtFirstName.clear();
		_txtLastName.clear();
		_txtAddress.clear();
		_txtPostalCode.clear();
		_txtProvince.clear();
		_txtPhoneNumber.clear();
	}

	// Insert new game information
	@FXML private void btnAddGameClicked()
	{
		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			_rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			_rowSet.setCommand("SELECT game_id, game_title FROM Game");
			_rowSet.execute();

			_rowSet.last();
			_rowSet.moveToInsertRow();
			_rowSet.updateInt("game_id", _rowSet.getRow()+1);
			_rowSet.updateString("game_title", _txtGame.getText());
			_rowSet.insertRow();

			JOptionPane.showMessageDialog(null, "Successful insert!");

			// refresh - These are related to this insert event
			getGameListDetail();
			_txtGame.clear();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// Insert new player information
	@FXML private void btnAddPlayerClicked()
	{
		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			StringBuffer myCommand = new StringBuffer();
			myCommand.append("SELECT player_id, first_name, last_name, ");
			myCommand.append("address, postal_code, province, phone_number FROM Player");

			_rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			_rowSet.setCommand(myCommand.toString());
			_rowSet.execute();

			_rowSet.last();
			_rowSet.moveToInsertRow();
			_rowSet.updateInt("player_id", _rowSet.getRow()+1);
			_rowSet.updateString("first_name", _txtFirstName.getText());
			_rowSet.updateString("last_name", _txtLastName.getText());
			_rowSet.updateString("address", _txtAddress.getText());
			_rowSet.updateString("postal_code", _txtPostalCode.getText());
			_rowSet.updateString("province", _txtProvince.getText());
			_rowSet.updateString("phone_number", _txtPhoneNumber.getText());
			_rowSet.insertRow();

			JOptionPane.showMessageDialog(null, "Successful insert!");

			// refresh - These are related to this insert event
			getPlayerList();
			getPlayerListDetail();
			btnClearFieldsClicked();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// Update existing player information
	@FXML private void btnUpdatePlayerClicked()
	{
		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			int idx = Integer.parseInt(_txtPlayerId.getText());
			StringBuffer myCommand = new StringBuffer();
			myCommand.append("SELECT first_name, last_name, address, postal_code, province, phone_number ");
			myCommand.append("FROM Player WHERE player_id = ");
			myCommand.append(idx);

			_rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			_rowSet.setCommand(myCommand.toString());
			_rowSet.execute();

			_rowSet.first();
			_rowSet.updateString("first_name", _txtFirstName.getText());
			_rowSet.updateString("last_name", _txtLastName.getText());
			_rowSet.updateString("address", _txtAddress.getText());
			_rowSet.updateString("postal_code", _txtPostalCode.getText());
			_rowSet.updateString("province", _txtProvince.getText());
			_rowSet.updateString("phone_number", _txtPhoneNumber.getText());
			_rowSet.updateRow();

			JOptionPane.showMessageDialog(null, "Successful update!");
			btnClearFieldsClicked();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// existing game list (ComboBox)
	@FXML private void getGameListDetail()
	{
		_gameDetail = FXCollections.observableArrayList();

		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			_rowSet.setCommand("SELECT game_id, game_title FROM Game");
			_rowSet.execute();

			while(_rowSet.next())
			{
				int id = Integer.parseInt(_rowSet.getString("game_id"));
				String name = _rowSet.getString("game_title");

				HashMap map = new HashMap<Integer, String>();
				map.put(id, name);

				_gameDetail.add(map);
			}
			_comboBoxGameDetail.setItems(_gameDetail);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// existing player list (ComboBox)
	@FXML private void getPlayerListDetail()
	{
		_playerDetail = FXCollections.observableArrayList();

		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			_rowSet.setCommand("SELECT player_id, first_name FROM Player");
			_rowSet.execute();

			while(_rowSet.next())
			{
				int id = Integer.parseInt(_rowSet.getString("player_id"));
				String name = _rowSet.getString("first_name");

				HashMap map = new HashMap<Integer, String>();
				map.put(id, name);

				_playerDetail.add(map);
			}
			_comboBoxPlayerDetail.setItems(_playerDetail);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// Insert new match information that player and played games
	@FXML private void btnAddPlayedGameClicked()
	{
		try (JdbcRowSet _rowSet = RowSetUtil.getInstance().getRowSet())
		{
			_rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			_rowSet.setCommand("SELECT player_game_id, game_id, player_id, playing_date, score FROM PlayerAndGame");
			_rowSet.execute();

			Integer gameId = getHashMapKey(_comboBoxGameDetail.getValue());
			Integer playerId = getHashMapKey(_comboBoxPlayerDetail.getValue());

			_rowSet.last();
			_rowSet.moveToInsertRow();
			_rowSet.updateInt("player_game_id", _rowSet.getRow()+1);
			_rowSet.updateInt("game_id", gameId);
			_rowSet.updateInt("player_id", playerId);
			_rowSet.updateString("playing_date", _datePicker.getValue().toString());
			_rowSet.updateInt("score", Integer.parseInt(_txtScore.getText()));
			_rowSet.insertRow();

			JOptionPane.showMessageDialog(null, "Successful insert!");

			// refresh - These are related to this insert event
			getTableViewInfo();
			_tableView.refresh();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// get hashMap key
	private Integer getHashMapKey(HashMap<Integer, String> map)
	{
		Set set = map.keySet();
		Iterator iterator = set.iterator();

		Integer id = null;
		String value = null;

		while(iterator.hasNext())
		{
			id = (Integer) iterator.next();
			value = (String) map.get(id);
		}
		return id;
	}
}
