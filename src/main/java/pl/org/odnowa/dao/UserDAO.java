package pl.org.odnowa.dao;

import org.sql2o.Connection;

import pl.org.odnowa.model.User;

public class UserDAO extends ObjectDAO {

	public static void createUser(Connection conn, User user) {
		createObject(conn, user);
	}

	public static User getObject(Connection conn, String id) {
		User user = new User();

		String select = String.format("SELECT %s FROM %s WHERE %s = :%s", "*", user.getDBTableName(),
				user.getIdColumnName(), user.getIdColumnName());

		return conn.createQuery(select).addParameter(user.getIdColumnName(), id).executeAndFetchFirst(User.class);
	}
}
