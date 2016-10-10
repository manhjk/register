package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.quirks.PostgresQuirks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = { "/*" }, loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 841970273993299662L;

	private static String DB_URL = "jdbc:postgres://gmtrsxcockozea:IhMkxrbr1QKtSssCqmDY5i8-lb@ec2-50-19-236-35.compute-1.amazonaws.com:5432/daonm67ig19ntt";
	private static String DB_NAME = "daonm67ig19ntt";
	private static String USER = "gmtrsxcockozea";
	private static String PASS = "IhMkxrbr1QKtSssCqmDY5i8-lb";
	private static String SERVER = "ec2-50-19-236-35.compute-1.amazonaws.com";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MyConnection myConn = new MyConnection(DB_URL, 5432, DB_NAME, USER, PASS, SERVER, "herokuDB");

		Sql2o sql2o = new Sql2o("jdbc:postgresql://" + SERVER + ":" + 5432 + "/" + DB_NAME, USER, PASS, new PostgresQuirks());

		try (Connection conn = sql2o.open()) {
			String select = "SELECT id, date1 FROM test WHERE id = :id";
			List<Test> testResult = conn.createQuery(select).addParameter("id", "pierwszy").executeAndFetch(Test.class);

			if (testResult.isEmpty()) {
				Test test1 = new Test("pierwszy", new Date());

				String insert = "INSERT INTO test (id, date1) " + "VALUES (:id, :date1)";
				conn.createQuery(insert).addParameter("id", test1.getId()).addParameter("date1", test1.getDate1())
						.executeUpdate();
			}

			Test testReturned = conn.createQuery(select).executeAndFetchFirst(Test.class);
			response.getOutputStream().print(testReturned.toString());
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new HelloWorldServlet()), "/*");
		server.start();
		server.join();

		MyConnection myConn = new MyConnection(DB_URL, 5432, DB_NAME, USER, PASS, SERVER, "herokuDB");
		Sql2o sql2o = new Sql2o(myConn);

		try (Connection con = sql2o.open()) {
			con.createQuery("CREATE TABLE IF NOT EXISTS test (id char(20), date1 date);").executeUpdate();
		}
	}

	public static class Test {
		private String id;
		private Date date1;

		public Test(String id, Date date1) {
			this.id = id;
			this.date1 = date1;
		}

		public String getId() {
			return id;
		}

		public Date getDate1() {
			return date1;
		}

		@Override
		public String toString() {
			return "Test [id=" + id + ", date1=" + date1 + "]";
		}
	}

	public static class MyConnection implements DataSource {

		protected boolean usingThinDriver;

		protected String url;

		protected int portNumber;

		protected String databaseName;

		protected String user;

		protected String password;

		protected String description;

		protected String serverName;

		public MyConnection(String url, int portNumber, String databaseName, String user, String password,
				String serverName, String description) {

			this.url = url;
			this.portNumber = portNumber;
			this.databaseName = databaseName;
			this.user = user;
			this.password = password;
			this.serverName = serverName;
			this.description = description;
			this.usingThinDriver = false;
		}

		public boolean isUsingThinDriver() {
			return usingThinDriver;
		}

		public void setUsingThinDriver(boolean thin) {
			usingThinDriver = thin;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String desc) {
			description = desc;
		}

		public String getServerName() {
			return serverName;
		}

		public void setServerName(String name) {
			serverName = name;
		}

		public int getPortNumber() {
			return portNumber;
		}

		public void setPortNumber(int port) {
			portNumber = port;
		}

		public String getDatabaseName() {
			return databaseName;
		}

		public void setDatabaseName(String name) {
			databaseName = name;
		}

		public java.sql.Connection getConnection() throws SQLException {
			return getConnection(null, null);
		}

		public java.sql.Connection getConnection(String userid, String password) throws SQLException {
			return DriverManager.getConnection(url, userid, password);
		}

		protected String getSubname() {
			return (isUsingThinDriver() ? "thin:@" + getServerName() + ":" + getPortNumber() + ":" + getDatabaseName()
					: "oci8:@" + getDatabaseName());
		}

		public int getLoginTimeout() throws SQLException {
			return DriverManager.getLoginTimeout();
		}

		public PrintWriter getLogWriter() throws SQLException {
			return DriverManager.getLogWriter();
		}

		public void setLoginTimeout(int timeout) throws SQLException {
			DriverManager.setLoginTimeout(timeout);
		}

		public void setLogWriter(PrintWriter writer) throws SQLException {
			DriverManager.setLogWriter(writer);
		}

		@Override
		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			return null;
		}

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return null;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return false;
		}

	}
}
