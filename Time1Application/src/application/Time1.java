package application;

public class Time1 {

	private int _hour;
	private int _minute;
	private int _second;

	//this is the default construtor
	public Time1() {
		this(24, 0, 0);
	}

	// constructor using set
	public Time1(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	// set a new time value using universal time; throw an
	// exception if the hour, minute or second is invalid
	public void setTime(int hour, int minute, int second) {
		// validate hour, minute and second
		if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
			throw new IllegalArgumentException("hour, minute and/or second was out of range");
		} else {
			this._hour = hour;
			this._minute = minute;
			this._second = second;
		}
	}

	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", _hour, _minute, _second);
	}

	// convert to String in standard-time format (H:MM:SS AM or PM)
	@Override
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((_hour == 0 || _hour == 12) ? 12 : _hour % 12), _minute, _second,
				(_hour < 12 ? "AM" : "PM"));
	}
}
