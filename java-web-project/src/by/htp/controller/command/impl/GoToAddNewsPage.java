package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;

public class GoToAddNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session == null) {
			response.sendRedirect("Controller?command=gotosigninpage&message=Please sign in.");
			return;
		}

		Boolean isAuth = (Boolean) session.getAttribute("auth");

		if (isAuth == null || !isAuth) {
			response.sendRedirect("Controller?command=gotosigninpage&message=Please sign in.");
			return;
		}
		
		String url = request.getRequestURL() + "?" + request.getQueryString();

		session.setAttribute("url", url);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/news_add_form.jsp");
		requestDispatcher.forward(request, response);

	}

}
