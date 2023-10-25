package com.enzulode.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * This filter restricts direct access for internal application components.
 *
 */
@WebFilter("/*")
public class InternalsRestrictedFilter implements Filter
{
	/**
	 *
	 * This method performs internal components requests filtering.
	 *
	 * @param request  the <code>ServletRequest</code> object contains the client's request
	 * @param response the <code>ServletResponse</code> object contains the filter's response
	 * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
	 * @throws IOException      if an I/O related error has occurred during the processing
	 * @throws ServletException if an exception occurs that interferes with the filter's normal operation
	 * @see UnavailableException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (checkRequestPathAllowed(req.getRequestURI()))
		{
			chain.doFilter(request, response);
		}
		else
		{
			resp.setStatus(404);
			resp.sendRedirect(req.getContextPath());
		}
	}

	/**
	 * This method checks if requested component is available from the outside.
	 *
	 * @param requestPath requested path
	 * @return true if allowed, false otherwise
	 */
	private boolean checkRequestPathAllowed(String requestPath)
	{
		return !requestPath.endsWith(".jsp") && !requestPath.endsWith("/check");
	}
}
