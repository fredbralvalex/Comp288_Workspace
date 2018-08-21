package application;

//Represents the items in the questions
public enum AnswerItem {
	A(1), B(2), C(3), D(4);

	int order;

	//A simple constructor
	private AnswerItem(int order) {
		this.order = order;
	}

	//getter
	public int getOrder() {
		return order;
	}
}
