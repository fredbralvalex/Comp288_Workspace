package application;

import java.util.Locale;

public class HelloWorldApplication2 {

	static {
		Locale.setDefault(Locale.CANADA);
		//System.setProperty("user.language", "en_CA");
		//System.setProperty("user.country", "CA");
	}

	public static void main(String[] args) {
		System.out.println("This is my second application");
		System.out.println("This is the second line.");
		System.out.println(System.getProperty("user.language"));
		System.out.println(System.getProperty("user.country"));
	}
}
