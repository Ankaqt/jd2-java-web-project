package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;

import static by.htp.controller.command.impl.CommandConstant.*;

public class ChangeLanguage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String local = request.getParameter(PARAM_LOCAL);

		request.setAttribute(PARAM_LOCAL, local);

		if (session != null)
			session.setAttribute(PARAM_LOCAL, local);

		String url = (String) session.getAttribute(ATTR_URL);

		response.sendRedirect(url);

	}

}
