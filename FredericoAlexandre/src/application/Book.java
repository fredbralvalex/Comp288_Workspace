package application;

/** This class represents a Book in the system. */
public abstract class Book {

	// Fields
	private String title;
	private String iSBN;
	private String publisher;
	protected double price;
	private int year;

	//Getters and Setters
	protected String getTitle() {
		return title;
	}

	protected String getISBN() {
		return iSBN;
	}

	protected String getPublisher() {
		return publisher;
	}

	protected int getYear() {
		return year;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}

	protected void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	protected void setYear(int year) {
		this.year = year;
	}

	//Abstract Methods
	//sets the price of a book
	protected abstract void setPrice(double price);

	//get the gender of a book
	protected abstract Gender getGender();

	// Prints all the variables in the Book
	@Override
	public String toString() {
		return "Gender : " + getGender() + " - Title : " + title + " - ISBN: " + iSBN + " - Publisher: " + publisher + " - Price: " + price
				+ " - Year: " + year;
	}
}
