package com.enzulode.servlet;

import com.enzulode.dto.CheckResultDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This servlet is responsible for the whole application requests dispatching.
 *
 */
public class ControllerServlet extends HttpServlet
{

	/**
	 * This method handles GET requests.
	 *
	 * @param req an {@link HttpServletRequest} object that contains the request the client has made of the servlet
	 *
	 * @param resp an {@link HttpServletResponse} object that contains the response the servlet sends to the client
	 *
	 * @throws ServletException if the request for the GET could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		var results = req.getSession().getAttribute("results");
		if (results == null)
			req.getSession().setAttribute("results", new ArrayList<CheckResultDTO>());

		if (req.getParameter("x") == null || req.getParameter("y") == null
				|| req.getParameter("r") == null)
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		else
			getServletContext().getRequestDispatcher("/check").forward(req, resp);
	}
}
