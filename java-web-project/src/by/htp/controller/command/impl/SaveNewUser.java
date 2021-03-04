package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.RegistrationInfo;
import by.htp.controller.command.Command;
import by.htp.service.ServiceException;
import by.htp.service.ServiceProvider;
import by.htp.service.UserService;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		RegistrationInfo registrationInfo = new RegistrationInfo(username, email, password, phone);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		try {
			userService.registrate(registrationInfo);
			response.sendRedirect(
					"Controller?command=gotosigninpage&message=Registration completed successfully. Please sign in");
			System.out.println("New user saved successfully");
			
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=registration&message=Data entered incorrectly. Try again.");
			System.out.println("Error in registration");
		}

	}

}
