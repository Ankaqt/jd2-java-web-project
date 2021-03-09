package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;

public class ChangeLanguage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String local = request.getParameter("local");

		request.setAttribute("local", local);

		if (session != null)
			session.setAttribute("local", local);

		String url = (String) session.getAttribute("url");

		response.sendRedirect(url);

	}

}
