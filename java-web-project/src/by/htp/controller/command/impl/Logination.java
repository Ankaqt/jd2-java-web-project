package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.controller.command.Command;
import by.htp.service.ServiceException;
import by.htp.service.ServiceProvider;
import by.htp.service.UserService;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");
		String password = request.getParameter("password");

		System.out.println("Username:" + username);
		System.out.println("Password:" + password);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;

		try {
			user = userService.authorization(username, password);

			if (user == null) {
				response.sendRedirect(
						"Controller?command=gotosigninpage&message=You entered an incorrect username or password. Try again.");
				System.out.println("Error");
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			session.setAttribute("user", user);
			response.sendRedirect("Controller?command=gotomainpage&message=Welcome");

		} catch (ServiceException e) {
			response.sendRedirect(
					"Controller?command=gotosigninpage&message=You entered an incorrect username or password. Try again.");
			System.out.println("Error1");

		}

	}
}
