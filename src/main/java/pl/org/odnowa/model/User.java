package pl.org.odnowa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User extends DBObject {
	
	private static final int CURRENT_VERSION = 1;

	private static final String TABLE_NAME = "users";

	private static final String ID_COLUMN = "id";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String E_MAIL = "email";
	private static final String STREET = "street";
	private static final String HOUSE_NUMBER = "houseNumber";
	private static final String FLAT_NUMBER = "flatNumber";
	private static final String POST_CODE = "postCode";
	private static final String TOWN = "town";
	private static final String PESEL = "pesel";
	private static final String TELEPHONE = "telephone";
	private static final String EXPECTATIONS = "expectations";
	private static final String COMMUNITY = "community";
	private static final String CONFERENCES = "conferences";
	private static final String SOURCE1 = "source1";
	private static final String SOURCE2 = "source2";
	private static final String NOTES = "notes";
	private static final String DATE = "date";
	private static final String VERSION_COLUMN = "version";

	private static final List<String> COLUMN_NAMES = Arrays.asList(ID_COLUMN, FIRST_NAME, LAST_NAME, E_MAIL, STREET,
			HOUSE_NUMBER, FLAT_NUMBER, POST_CODE, TOWN, PESEL, TELEPHONE, EXPECTATIONS, COMMUNITY, CONFERENCES, SOURCE1,
			SOURCE2, NOTES, DATE, VERSION_COLUMN);

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String houseNumber;
	private String flatNumber;
	private String postCode;
	private String town;
	private String pesel;
	private String telephone;
	private String expectations;
	private String community;
	private String[] conferences;
	private String[] source1;
	private String source2;
	private String notes;
	private Date date;
	private int version = CURRENT_VERSION;

	public User() {
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", street=" + street + ", houseNumber=" + houseNumber + ", flatNumber=" + flatNumber + ", postCode="
				+ postCode + ", town=" + town + ", pesel=" + pesel + ", telephone=" + telephone + ", expectations="
				+ expectations + ", community=" + community + ", conferences=" + Arrays.toString(conferences)
				+ ", source1=" + Arrays.toString(source1) + ", source2=" + source2 + ", notes=" + notes + ", date="
				+ date + ", version=" + version + "]";
	}



	@Override
	public String getDBTableName() {
		return TABLE_NAME;
	}

	@Override
	public List<String> getDBColumnIdentifiers() {
		return COLUMN_NAMES;
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();

		values.add(id);
		values.add(firstName);
		values.add(lastName);
		values.add(email);
		values.add(street);
		values.add(houseNumber);
		values.add(flatNumber);
		values.add(postCode);
		values.add(town);
		values.add(pesel);
		values.add(telephone);
		values.add(expectations);
		values.add(community);
		values.add(String.valueOf(conferences));
		values.add(String.valueOf(source1));
		values.add(source2);
		values.add(notes);
		values.add(String.valueOf(date));
		values.add(String.valueOf(version));

		return values;
	}

	@Override
	public String getIdColumnName() {
		return ID_COLUMN;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setExpectations(String expectations) {
		this.expectations = expectations;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public void setConferences(String[] conferences) {
		this.conferences = conferences;
	}

	public void setSource1(String[] source1) {
		this.source1 = source1;
	}

	public void setSource2(String source2) {
		this.source2 = source2;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
