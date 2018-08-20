package application;

/** A Children Book in the system. This type of book has a fixed price. */
public class ChildrenBook extends Book {

	// A variable to know if the price was set
	public static double uniquePrice = 0;

	// Making sure that the price is unique for Children Books
	@Override
	protected void setPrice(double price) {
		if (uniquePrice == 0) {
			uniquePrice = price;
		}
		this.price = uniquePrice;
	}

	@Override
	protected Gender getGender() {
		return Gender.C;
	}

}
