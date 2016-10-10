package pl.org.odnowa.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.sql2o.Connection;

import pl.org.odnowa.dao.UserDAO;
import pl.org.odnowa.model.User;

@WebServlet(urlPatterns = { "/*" }, loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 841970273993299662L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Connection conn = (Connection) getServletContext().getAttribute("DBConnection");

		try {
			User user = UserDAO.getObject(conn, "1");

			if (user == null) {
				print("User: 1 does not exist", response);
				UserDAO.createUser(conn, new User("1", new Date()));
				print("User 1 has been created.", response);
			}

			user = UserDAO.getObject(conn, "1");

			if (user == null) {
				print("User: 1 does not exist", response);
			} else {
				print("User: 1 exist: " + user.toString(), response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void print(String message, ServletResponse response) throws IOException {
		response.getOutputStream().print(message);
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new HelloWorldServlet()), "/*");
		server.start();
		server.join();
	}
}
