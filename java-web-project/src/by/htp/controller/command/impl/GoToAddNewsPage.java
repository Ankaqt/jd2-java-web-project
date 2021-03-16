package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;
import by.htp.controller.security.SecurityLoginationCheck;

import static by.htp.controller.command.impl.CommandConstant.*;

public class GoToAddNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (SecurityLoginationCheck.checkLogination(request, response)) {
			return;
		}
		
		String url = request.getRequestURL() + "?" + request.getQueryString();

		session.setAttribute(ATTR_URL, url);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/news_add_form.jsp");
		requestDispatcher.forward(request, response);

	}

}
