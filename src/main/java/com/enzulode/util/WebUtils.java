package com.enzulode.util;

import com.enzulode.dto.ErrorDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * This utility class contains enhancements for better developer experience.
 *
 */
public class WebUtils
{

	/**
	 * This method forwards request to an error JSP.
	 *
	 * @param req http servlet request instance
	 * @param resp http servlet response instance
	 * @param status http status code
	 * @param message error message
	 * @throws ServletException if the request for the GET could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
	public static void forwardErrorPage(HttpServletRequest req, HttpServletResponse resp, int status, String message) throws ServletException, IOException
	{
		resp.setStatus(status);
		req.setAttribute("error", new ErrorDTO(message));
		req.getRequestDispatcher("/error.jsp").forward(req, resp);
	}
}
