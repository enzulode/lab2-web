package com.enzulode;

import com.enzulode.check.AreaHitChecker;
import com.enzulode.check.AreaHitCheckerImpl;
import com.enzulode.dto.PointCoordinatesCheckDTO;
import com.enzulode.servlet.AreaCheckServlet;
import com.enzulode.servlet.ControllerServlet;
import com.enzulode.validation.PointCoordinatesCheckDTOValidator;
import com.enzulode.validation.Validator;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import java.util.Set;

public class CustomServletContainerInitializer implements ServletContainerInitializer
{
	/**
	 * This method is responsible for application servlet container initialization.
	 *
	 * @param c the Set of application classes that extend, implement, or have been annotated with the class types specified
	 * by the {@link jakarta.servlet.annotation.HandlesTypes HandlesTypes} annotation, or <tt>null</tt> if there are no
	 * matches, or this <tt>ServletContainerInitializer</tt> has not been annotated with <tt>HandlesTypes</tt>
	 *
	 * @param ctx the <tt>ServletContext</tt> of the web application that is being started and in which the classes
	 * contained in <tt>c</tt> were found
	 */
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException
	{
//		Register main (index) page
		ctx.addJspFile("indexJsp", "/WEB-INF/pages/index.jsp")
						.addMapping("/index.jsp");

//		Register result page
		ctx.addJspFile("resultJsp", "/WEB-INF/pages/result.jsp")
				.addMapping("/result.jsp");

//		Register error page
		ctx.addJspFile("errorJsp", "/WEB-INF/pages/error.jsp")
				.addMapping("/error.jsp");

//		Instantiate area check servlet dependencies
		Validator<PointCoordinatesCheckDTO> validator = new PointCoordinatesCheckDTOValidator();
		AreaHitChecker areaHitChecker = new AreaHitCheckerImpl();

//		Instantiate area check servlet and inject dto validator
		AreaCheckServlet areaCheckServlet = new AreaCheckServlet(validator, areaHitChecker);

//		Register area check servlet
		ctx.addServlet("areaCheckServlet", areaCheckServlet)
				.addMapping("/check");

//		Instantiate controller servlet
		ControllerServlet controllerServlet = new ControllerServlet();

//		Register controller servlet
		ctx.addServlet("controllerServlet", controllerServlet)
				.addMapping("/*");
	}
}
