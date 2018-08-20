package application;

/** The Science Book in the system. This type of book has 10% discount. */
public class ScienceBook extends Book {

	//The price of a ScienceBook Must be only 90%
	@Override
	protected void setPrice(double price) {
		this.price = (price * 0.9);
	}

	@Override
	protected Gender getGender() {
		return Gender.S;
	}

}
