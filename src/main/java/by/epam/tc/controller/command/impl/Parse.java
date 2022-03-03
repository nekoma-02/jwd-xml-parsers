package by.epam.tc.controller.command.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.epam.tc.controller.command.Command;
import by.epam.tc.entity.Application;
import by.epam.tc.service.ApplicationServiceImp;
import by.epam.tc.service.ServiceException;

public class Parse implements Command {

	private static final String RESULT_PAGE = "WEB-INF/jsp/resultPage.jsp";
	private static final String ERROR_PAGE = "error.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Application> appList = new ArrayList<Application>();
		String typeParser = request.getParameter("type_parser");
		
		ApplicationServiceImp service = new ApplicationServiceImp();
		
		Part part = request.getPart("file");
		InputStream inputStream = part.getInputStream();
		
		try {
			appList = service.getApplications(typeParser, inputStream);
			
			if (appList != null) {
				request.setAttribute("application", appList);
			}
			else {
				request.setAttribute("error_message", "Invalid input file!");
			}
			
			request.setAttribute("application", appList);
		} catch (ServiceException e) {
			response.sendRedirect(ERROR_PAGE);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(RESULT_PAGE);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(ERROR_PAGE);
		}
		
	}

}
