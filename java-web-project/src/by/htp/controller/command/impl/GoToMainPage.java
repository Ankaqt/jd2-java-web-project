package by.htp.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.News;
import by.htp.controller.command.Command;
import by.htp.service.NewsService;
import by.htp.service.ServiceException;
import by.htp.service.ServiceProvider;

public class GoToMainPage implements Command {

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

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			List<News> news = newsService.takeALL();
			request.setAttribute("news", news);
			request.setAttribute("username", session.getAttribute("username"));
			request.setAttribute("role", session.getAttribute("role"));

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);

		} catch (ServiceException e) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("global_error.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
