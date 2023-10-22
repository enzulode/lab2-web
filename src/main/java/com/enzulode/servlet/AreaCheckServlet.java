package com.enzulode.servlet;

import com.enzulode.check.AreaHitChecker;
import com.enzulode.dto.CheckResultDTO;
import com.enzulode.dto.ErrorDTO;
import com.enzulode.dto.PointCoordinatesCheckDTO;
import com.enzulode.exception.ValidationException;
import com.enzulode.validation.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * This servlet is responsible for point hit area checks.
 *
 */
@RequiredArgsConstructor
public class AreaCheckServlet extends HttpServlet
{

	/**
	 * PointCoordinatesCheckDTO validator instance.
	 *
	 */
	private final Validator<PointCoordinatesCheckDTO> validator;

	/**
	 * AreaHitChecker instance.
	 *
	 */
	private final AreaHitChecker areaHitChecker;

	/**
	 * This method handles GET requests on specific endpoint.
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
//		Check if all required params are present
		if (req.getParameter("x") == null || req.getParameter("y") == null
				|| req.getParameter("r") == null)
		{
			forwardToErrorPage(req, resp, 400, "Not all required params are present");
			return;
		}

//		Check if x coordinate parameter is integer
		Integer x = null;
		try
		{
			x = Integer.parseInt(req.getParameter("x"));
		}
		catch (NumberFormatException e)
		{
			forwardToErrorPage(req, resp, 400, "X parameter should be an integer value");
			return;
		}

		Float y = null;
		try
		{
			y = Float.parseFloat(req.getParameter("y"));
		}
		catch (NumberFormatException e)
		{
			forwardToErrorPage(req, resp, 400, "Y parameter should be a float value");
			return;
		}

		Integer r = null;
		try
		{
			r = Integer.parseInt(req.getParameter("r"));
		}
		catch (NumberFormatException e)
		{
			forwardToErrorPage(req, resp, 400, "R parameter should be an integer value");
			return;
		}

//		Assemble the DTO object from request params
		PointCoordinatesCheckDTO dto = new PointCoordinatesCheckDTO(x, y, r);

		try
		{
//			Then validate assembled DTO
			validator.validate(dto);
		}
		catch (ValidationException e)
		{
			forwardToErrorPage(req, resp, 400, e.getMessage());
			return;
		}

//		Validation succeed - perform area hit check
		boolean checkResult = areaHitChecker.check(dto);

//		Check succeed - forward on result jsp
		req.setAttribute("result", new CheckResultDTO(x, y, r, (checkResult) ? "succeed" : "missed"));
		getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
	}

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
	private void forwardToErrorPage(HttpServletRequest req, HttpServletResponse resp, int status, String message) throws ServletException, IOException
	{
		resp.setStatus(status);
		req.setAttribute("error", new ErrorDTO(message));
		req.getRequestDispatcher("/error.jsp").forward(req, resp);
	}
}
