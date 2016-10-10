package pl.org.odnowa.dao;

import org.sql2o.Connection;
import org.sql2o.Query;

import pl.org.odnowa.model.Storable;

public abstract class ObjectDAO {

	public static void createObject(Connection conn, Storable object) {
		String insert = String.format("INSERT INTO %s (%s) " + "VALUES (%s)", object.getDBTableName(),
				object.getDBColumnIdentifiersAsString(), object.getDBColumnParametersAsString());

		Query query = conn.createQuery(insert);

		int size = object.getDBColumnIdentifiers().size();
		for (int i = 0; i < size; i++) {
			query.addParameter(object.getDBColumnIdentifiers().get(i), object.getValues().get(i));
		}

		query.executeUpdate();
	}

}
