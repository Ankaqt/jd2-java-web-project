package by.htp.controller.command.impl;

import java.io.IOException;

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

public class ShowNews implements Command {

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
			Integer id = Integer.valueOf(request.getParameter("id"));

			News news = newsService.takeById(id);

			request.setAttribute("username", session.getAttribute("username"));
			request.setAttribute("news", news);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/news_view.jsp");
			requestDispatcher.forward(request, response);

		} catch (ServiceException e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("global_error.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
