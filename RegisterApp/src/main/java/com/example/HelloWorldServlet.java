package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.IOException;

@WebServlet(urlPatterns = { "/*" }, loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 841970273993299662L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getOutputStream().print("Hello World");
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
