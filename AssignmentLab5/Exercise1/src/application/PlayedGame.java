package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Lab5 Assignment
 *
 * @author Hyojin Kim (300950009), Frederico Alexandre (300974435)
 * @since  2018.04.11
 */
public class PlayedGame {

	// Declaration & Initialization
	private SimpleIntegerProperty pgId;
	private SimpleIntegerProperty gameId;
	private SimpleIntegerProperty playerId;
	private SimpleStringProperty gameTitle;
	private SimpleStringProperty playerFirstName;
	private SimpleStringProperty playerLastName;
	private SimpleStringProperty playingDate;
	private SimpleIntegerProperty score;

	public Integer getPgId() {
		return pgId.get();
	}

	public void setPgId(Integer pgId) {
		this.pgId = new SimpleIntegerProperty(pgId);
	}

	public Integer getGameId() {
		return gameId.get();
	}

	public void setGameId(Integer gameId) {
		this.gameId = new SimpleIntegerProperty(gameId);
	}

	public Integer getPlayerId() {
		return playerId.get();
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = new SimpleIntegerProperty(playerId);
	}

	public String getGameTitle() {
		return gameTitle.get();
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = new SimpleStringProperty(gameTitle);
	}

	public String getPlayerFirstName() {
		return playerFirstName.get();
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = new SimpleStringProperty(playerFirstName);
	}

	public String getPlayerLastName() {
		return playerLastName.get();
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = new SimpleStringProperty(playerLastName);
	}

	public String getPlayingDate() {
		return playingDate.get();
	}

	public void setPlayingDate(String playingDate) {
		this.playingDate = new SimpleStringProperty(playingDate);
	}
	public Integer getScore() {
		return score.get();
	}

	public void setScore(Integer score) {
		this.score = new SimpleIntegerProperty(score);
	}
}
