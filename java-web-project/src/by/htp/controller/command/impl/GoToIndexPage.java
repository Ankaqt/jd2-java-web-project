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
import by.htp.service.ServiceProvider;
import by.htp.service.exception.ServiceException;

import static by.htp.controller.command.impl.CommandConstant.*;

public class GoToIndexPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {

			List<News> news = newsService.takeALL();
			
			String url = request.getRequestURL() + "?" + request.getQueryString();
			
			if (news == null) {
				request.setAttribute(ATTR_ERROR, "Unfortunately the news is not available at the moment");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
				requestDispatcher.forward(request, response);
			}
			
			session.setAttribute(ATTR_URL, url);
			request.setAttribute(ATTR_NEWS, news);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);

		} catch (ServiceException e) {
			request.setAttribute(ATTR_GLOBALERROR,"Unfortunately the news is not available at the moment");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
