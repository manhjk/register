package pl.org.odnowa.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.sql2o.Connection;

@WebListener
public class AppContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();

		// initialize DB Connection
		String dbURL = ctx.getInitParameter("dbURL");
		String user = ctx.getInitParameter("dbUser");
		String pwd = ctx.getInitParameter("dbPassword");

		try {
			DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, pwd);
			ctx.setAttribute("DBConnection", connectionManager.getConnection());
			System.out.println("DB Connection initialized successfully.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Connection conn = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
		try {
			conn.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}