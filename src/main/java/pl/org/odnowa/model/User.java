package pl.org.odnowa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User extends DBObject {

	private static final String TABLE_NAME = "Test";

	private static final String ID_COLUMN = "id";

	private static final List<String> COLUMN_NAMES = Arrays.asList("id");

	private String id;
	private Date date1;

	public User(String id, Date date1) {
		this.id = id;
		this.date1 = date1;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public Date getDate1() {
		return date1;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", date1=" + date1 + "]";
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
	public List<Object> getValues() {
		List<Object> values = new ArrayList<>();

		values.add(getId());

		return values;
	}

	@Override
	public String getIdColumnName() {
		return ID_COLUMN;
	}

}
