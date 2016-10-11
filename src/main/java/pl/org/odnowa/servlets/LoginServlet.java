package pl.org.odnowa.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4701617571765552981L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// do some processing here...
		
		// get response writer
		PrintWriter writer = response.getWriter();
		
		// build HTML code
		String htmlRespone = "<html><h2>";
		htmlRespone += request.getParameter("your-name") + "<br/>";
		htmlRespone += request.getParameter("your-email") + "<br/>";
		htmlRespone += request.getParameter("your-address") + "<br/>";
		htmlRespone += request.getParameter("your-pesel") + "<br/>";
		htmlRespone += request.getParameter("your-phone") + "<br/>";
		htmlRespone += request.getParameter("your-expectations") + "<br/>";
		htmlRespone += request.getParameter("your-community") + "<br/>";
		htmlRespone += request.getParameter("warsztaty[]") + "<br/>";
		htmlRespone += request.getParameter("skad1[]") + "<br/>";
		htmlRespone += "</html>";
		
		// return response
		writer.println(htmlRespone);
		
	}

}