package pl.org.odnowa.db;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.quirks.PostgresQuirks;

public class DBConnectionManager {

	private Connection connection;

	public DBConnectionManager(String dbURL, String user, String pwd) {
		Sql2o sql2o = new Sql2o(dbURL, user, pwd, new PostgresQuirks());
		this.connection = sql2o.open();
	}

	public Connection getConnection() {
		return this.connection;
	}
}
