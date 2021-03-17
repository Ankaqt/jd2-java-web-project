package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.controller.command.Command;
import by.htp.service.ServiceProvider;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;
import by.htp.service.exception.UserException;

import static by.htp.controller.command.impl.CommandConstant.*;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter(PARAM_NAME);
		String password = request.getParameter(PARAM_PASSWORD);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;

		try {
			user = userService.authorization(username, password);

			if (user == null) {
				response.sendRedirect(
						"Controller?command=gotosigninpage&message=You entered an incorrect username or password. Try again.");
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute(ATTR_AUTH, true);
			session.setAttribute(ATTR_USER, user);
			response.sendRedirect("Controller?command=gotomainpage");

		} catch (ServiceException e) {
			response.sendRedirect(
					"Controller?command=gotosigninpage&message=Unfortunately, something went wrong. Try later.");

		} catch (UserException e) {
			response.sendRedirect(
					"Controller?command=gotosigninpage&message=You entered incorrect data");
		}

	}
}
