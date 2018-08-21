package application;

/**
 * A interface for keep the constants. short-term (one year), medium-term (three
 * years) and long-term (5 years)
 */
public interface MortgageConstants {
	// constants
	public static final int YEARS_FOR_SHORT_TERM = 1;
	public static final int YEARS_FOR_MEDIUM_TERM = 3;
	public static final int YEARS_FOR_LONG_TERM = 5;
	public static final double MAX_MORTAGE_AMOUNT = 300000;
	public static final String BANK_NAME = "CityToronto Bank";

	String getMortgageInfo();
}
