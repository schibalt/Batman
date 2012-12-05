package com.batman.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendlyUrl extends HttpServlet {
	private final static Logger log = Logger.getLogger(FriendlyUrl.class.getName(), null);

	private static final long serialVersionUID = 8641049249826262967L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		log.severe("/WEB-INF" + request.getServletPath() + ".jsp");
		request.getRequestDispatcher("/WEB-INF" + request.getServletPath() + ".jsp").forward(request, response);		
	}
}
