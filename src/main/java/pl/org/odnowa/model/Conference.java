package pl.org.odnowa.model;

import java.util.Arrays;
import java.util.List;

public enum Conference {

	A("", ""), 
	B("", "");

	private String displayName;

	private String dbName;

	private Conference(String displayName, String dbName) {
		this.displayName = displayName;
		this.dbName = dbName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDbName() {
		return dbName;
	}

	public static Conference getConference(String displayName) {
		for (Conference c : values()) {
			if (c.getDisplayName().equals(displayName)) {
				return c;
			}
		}

		return null;
	}

	public static Conference[] getConferences(String[] displayValues) {
		Conference[] result = new Conference[values().length];

		List<String> valuesList = Arrays.asList(displayValues);

		for (int i = 0; i < values().length; i++) {
			Conference c = values()[i];
			if (valuesList.contains(c.getDisplayName())) {
				result[i] = c;
			}
		}

		return result;
	}
}
