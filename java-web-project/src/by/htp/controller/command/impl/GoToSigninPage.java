package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;

public class GoToSigninPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String url = request.getRequestURL() + "?" + request.getQueryString();

		session.setAttribute("url", url);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sign_in_form.jsp");
		requestDispatcher.forward(request, response);

	}

}
