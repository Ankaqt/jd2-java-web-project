package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.htp.bean.News;
import by.htp.controller.command.Command;
import by.htp.controller.security.SecurityLoginationCheck;
import by.htp.service.NewsService;
import by.htp.service.ServiceException;
import by.htp.service.ServiceProvider;

import static by.htp.controller.command.impl.CommandConstant.*;

public class DeleteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (SecurityLoginationCheck.checkLogination(request, response)) {
			return;
		}

		int id = Integer.valueOf(request.getParameter(PARAM_ID));

		News news = new News(id);

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			newsService.deleteNews(news);
			response.sendRedirect("Controller?command=gotomainpage&message=Changes saved successfully");
		} catch (ServiceException e) {
			
			response.sendRedirect("Controller?command=gotomainpage&message=Changes didn't save");
		}

	}

}
