package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.News;
import by.htp.controller.command.Command;
import by.htp.controller.security.SecurityLoginationCheck;
import by.htp.service.NewsService;
import by.htp.service.ServiceException;
import by.htp.service.ServiceProvider;

public class GoToEditNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (SecurityLoginationCheck.checkLogination(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			Integer id = Integer.valueOf(request.getParameter("id"));

			News news = newsService.takeById(id);
			
			String url = request.getRequestURL() + "?" + request.getQueryString();
			
			if (news == null) {
				request.setAttribute("error", "Unfortunately the news is not available at the moment");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
				requestDispatcher.forward(request, response);
			}

			session.setAttribute("url", url);

			request.setAttribute("username", session.getAttribute("username"));
			request.setAttribute("news", news);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/news_edit_form.jsp");
			requestDispatcher.forward(request, response);

		} catch (ServiceException e) {
			request.setAttribute("globalerror","Unfortunately the news is not available at the moment");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
