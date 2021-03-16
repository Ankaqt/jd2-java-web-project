package by.htp.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.controller.command.Command;

import static by.htp.controller.command.impl.CommandConstant.*;

public class Logout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session != null) {
			session.removeAttribute(ATTR_AUTH);
			session.removeAttribute(ATTR_USER);
			System.out.println("User logged out");
		}

		response.sendRedirect("Controller?command=gotoindexpage");
	}
}
