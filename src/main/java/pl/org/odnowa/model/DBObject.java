package pl.org.odnowa.model;

import java.util.List;

public abstract class DBObject implements Storable {

	@Override
	public String getDBColumnIdentifiersAsString() {
		List<String> columnNames = getDBColumnIdentifiers();

		StringBuilder sb = new StringBuilder();

		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			sb.append(columnNames.get(i));

			if (i < size - 1) {
				sb.append(", ");
			}
		}

		return sb.toString();
	}

	@Override
	public String getDBColumnParametersAsString() {
		List<String> columnNames = getDBColumnIdentifiers();

		StringBuilder sb = new StringBuilder();

		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			sb.append(":" + columnNames.get(i));

			if (i < size - 1) {
				sb.append(", ");
			}
		}

		return sb.toString();
	}

}
