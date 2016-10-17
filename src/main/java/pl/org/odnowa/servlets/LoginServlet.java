package pl.org.odnowa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sql2o.Connection;

import pl.org.odnowa.dao.UserDAO;
import pl.org.odnowa.db.DBConnectionManager;
import pl.org.odnowa.model.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4701617571765552981L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// do some processing here...

		// get response writer
		PrintWriter writer = response.getWriter();

		User user = new User();
		user.setId(request.getParameter(""));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setStreet(request.getParameter("street"));
		user.setHouseNumber(request.getParameter("houseNumber"));
		user.setFlatNumber(request.getParameter("flatNumber"));
		user.setPostCode(request.getParameter("postCode"));
		user.setTown(request.getParameter("town"));
		user.setPesel(request.getParameter("pesel"));
		user.setTelephone(request.getParameter("telephone"));
		user.setExpectations(request.getParameter("expectations"));
		user.setCommunity(request.getParameter("community"));
		user.setConferences(request.getParameterValues("conferences"));
		user.setSource1(request.getParameterValues("source1"));
		user.setSource2(request.getParameter("source2"));
		user.setNotes(request.getParameter("notes"));
		user.setDate(new Date());

		Connection connection = (Connection) request.getServletContext()
				.getAttribute("DBConnection");
		UserDAO.createUser(connection, user);

		// build HTML code
		String htmlRespone = "<html><h2>";
		htmlRespone += user.toString();
		htmlRespone += "</html>";

		// return response
		writer.println(htmlRespone);
	}

}