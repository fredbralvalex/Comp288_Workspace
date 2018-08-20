package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * This class represents a student in the system.
 */
public class Student {

	// Fields from Student table
	private SimpleStringProperty studentid;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty address;
	private SimpleStringProperty city;
	private SimpleStringProperty province;
	private SimpleStringProperty postalCode;

	// only one constructor with all the fields
	public Student(String studentid, String firstName, String lastName, String address, String city, String province,
			String postalCode) {
		this.studentid = new SimpleStringProperty(studentid);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.address = new SimpleStringProperty(address);
		this.city = new SimpleStringProperty(city);
		this.province = new SimpleStringProperty(province);
		this.postalCode = new SimpleStringProperty(postalCode);
	}

	// Getters and Setters
	protected String getStudentId() {
		return studentid.get();
	}

	protected String getFirstName() {
		return firstName.get();
	}

	protected String getLastName() {
		return lastName.get();
	}

	protected String getAddress() {
		return address.get();
	}

	protected String getCity() {
		return city.get();
	}

	protected String getProvince() {
		return province.get();
	}

	protected String getPostalCode() {
		return postalCode.get();
	}

	protected void setStudentId(String studentid) {
		this.studentid = new SimpleStringProperty(studentid);
	}

	protected void setFirstName(String firstName) {
		this.firstName = new SimpleStringProperty(firstName);
	}

	protected void setLastName(String lastName) {
		this.lastName = new SimpleStringProperty(lastName);
	}

	protected void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}

	protected void setCity(String city) {
		this.city = new SimpleStringProperty(city);
	}

	protected void setProvince(String province) {
		this.province = new SimpleStringProperty(province);
	}

	protected void setPostalCode(String postalCode) {
		this.postalCode = new SimpleStringProperty(postalCode);
	}

	@Override
	public String toString() {
		return getStudentId() + "\t" + getFirstName() + "\t" + getLastName() + "\t" + getAddress() + "\t" + getCity()
				+ "\t" + getProvince() + "\t" + getPostalCode();
	}
}
