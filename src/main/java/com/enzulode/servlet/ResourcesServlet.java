package com.enzulode.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * This servlet is responsible for static resources access.
 *
 */
@WebServlet("/resources/*")
public class ResourcesServlet extends HttpServlet
{

	/**
	 * This method handles get requests for static resources.
	 *
	 * @param req an {@link HttpServletRequest} object that contains the request the client has made of the servlet
	 *
	 * @param resp an {@link HttpServletResponse} object that contains the response the servlet sends to the client
	 *
	 * @throws IOException if resource as stream fetch failed or writer access failed
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String[] res = req.getRequestURI().split("/resources");
		if (res.length < 2)
		{
			resp.setStatus(404);
			resp.getWriter().println("Resource not found");
			return;
		}

		String resource = res[res.length - 1];

		if (resource.endsWith(".css"))
			resp.setContentType("text/css");
		else if (resource.endsWith(".js"))
			resp.setContentType("text/javascript");

		try(var asset = getClass().getClassLoader().getResourceAsStream(resource))
		{
			if (asset != null)
				asset.transferTo(resp.getOutputStream());
		}
	}
}
