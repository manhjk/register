package pl.org.odnowa.model;

import java.util.List;

public interface Storable {

	public String getDBTableName();

	public List<String> getDBColumnIdentifiers();

	public String getDBColumnIdentifiersAsString();

	public String getDBColumnParametersAsString();

	public List<String> getValues();

	public String getIdColumnName();

}
