package application;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

/** This class represents the application in the system. */
public class BookApplication {

	// Main method starts the application
	public static void main(String[] args) {
		// Declaration and initialization of the application
		BookApplication application = new BookApplication();
		// Interact with the user as many as desired
		Book[] books = new Book[0];

		while (true) {
			// Prompts a Gender of book to the user
			Book book = application.promptUserForGender();
			// Prompt all information
			// title
			book.setTitle(application.promptUserForStringInfo("Title"));
			// ISBN
			book.setISBN(application.promptUserForStringInfo("ISBN"));
			// publisher
			book.setPublisher(application.promptUserForStringInfo("Publisher"));
			// year
			book.setYear((int) application.promptUserForNumericInfo(true));
			if (Gender.S == book.getGender() || (Gender.C == book.getGender() && ChildrenBook.uniquePrice == 0)) {
				// price
				book.setPrice(application.promptUserForNumericInfo(false));
			} else {
				//doesnt matter the price is already set as static in the subclass
				book.setPrice(0);
			}

			// creates a new array to support the new quantity
			books = application.createAndFillArray(books);
			// fill the last book entered
			books[books.length - 1] = book;
			application.printBooks(books);
		}

	}

	private void printBooks(Book[] books) {
		String booksStr = "";

		for (int index = 0; index < books.length; index++) {
			booksStr = booksStr + "\n" + (index + 1) + " " + books[index];
		}

		JOptionPane.showMessageDialog(null, booksStr);
	}

	// Prompts the user for the gender of the book
	private Book promptUserForGender() {
		String typeString = JOptionPane
				.showInputDialog("Please enter the Gender.\n(S) Science\n(C) Children\n(E) Exit");
		// Exiting
		if (typeString == null) {
			System.exit(0);
		}
		Gender gender;
		try {
			// get the value of enum
			gender = Gender.valueOf(StringUtils.capitalize(typeString));
			if (Gender.S == gender) {
				return new ScienceBook();
			} else if (Gender.C == gender) {
				return new ChildrenBook();
			}
		} catch (IllegalArgumentException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			if ("E".equals(StringUtils.capitalize(typeString))) {
				System.exit(0);
			} else {
				return promptUserForGender();
			}
		}
		throw new IllegalArgumentException();
	}

	// Prompts the user for the price or year of the book
	private double promptUserForNumericInfo(boolean year) {
		String prompting;

		if (year) {
			// for year
			prompting = "Please enter a valid Year.";
		} else {
			// for Price
			prompting = "Please enter a valid Price.";
		}

		String numericString = JOptionPane.showInputDialog(prompting);
		// Exiting is not allowed now
		if (numericString == null) {
			return promptUserForNumericInfo(year);
		}
		try {
			if (year) {
				int yearValue = Integer.parseInt(numericString);
				int maxYear = 2018; // Needs to be improved to get the year.
				if (yearValue < 0 || yearValue > maxYear) {
					promptUserForNumericInfo(year);
				}
				return yearValue;
			} else {
				return Double.parseDouble(numericString);
			}
		} catch (NumberFormatException e) {
			// when it is not a valid number, prompt one more time.
			return promptUserForNumericInfo(year);
		}
	}

	// Prompts the user for the title, the ISBN, the publisher of the book
	private String promptUserForStringInfo(String info) {
		String infoStr = JOptionPane.showInputDialog("Please enter a " + info + ".");
		// Exiting is not allowed now
		if (infoStr == null || infoStr.equals("")) {
			// when it is not a valid number, prompt one more time.
			return promptUserForStringInfo(info);
		} else {
			// get the value
			return infoStr;
		}
	}

	// Builds a new array with one more element capacity
	public Book[] createAndFillArray(Book[] initialArray) {
		Book[] books;
		books = new Book[initialArray.length + 1];
		for (int index = 0; index < initialArray.length; index++) {
			books[index] = initialArray[index];
		}
		return books;
	}

}
