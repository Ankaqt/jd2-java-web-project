package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.News;
import by.htp.controller.command.Command;
import by.htp.controller.security.SecurityLoginationCheck;
import by.htp.service.NewsService;
import by.htp.service.ServiceProvider;
import by.htp.service.exception.NewsException;
import by.htp.service.exception.ServiceException;

import static by.htp.controller.command.impl.CommandConstant.*;

public class SaveEditedNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (SecurityLoginationCheck.checkLogination(request, response)) {
			return;
		}

		String title = request.getParameter(PARAM_TITLE);
		String brief = request.getParameter(PARAM_BRIEF);
		String content = request.getParameter(PARAM_CONTENT);
		int id = Integer.valueOf(request.getParameter(PARAM_ID));

		News news = new News(id, title, brief, content);

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			Boolean update = newsService.editNews(news);
			response.sendRedirect("Controller?command=shownews&id=" + id + "&update=" + update
					+ "&message=Changes saved successfully");

		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=shownews&id=" + id + "&message=Something went wrong. Try again");

		} catch (NewsException e) {
			response.sendRedirect("Controller?command=shownews&id=" + id
					+ "&message=News wasn't saved as incorrect data was entered");
		}
	}
}
