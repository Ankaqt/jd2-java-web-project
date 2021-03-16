package by.htp.controller.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class SecurityLoginationCheck {

	public static boolean checkLogination(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean result = false;

		HttpSession session = request.getSession();

		if (session == null) {
			response.sendRedirect("Controller?command=gotosigninpage&message=Please sign in.");

			result = false;

		} else {

			Boolean isAuth = (Boolean) session.getAttribute("auth");
			if (isAuth == null || !isAuth) {
				response.sendRedirect("Controller?command=gotosigninpage&message=Please sign in.");

				result = true;
			}

		}
		return result;

	}

}
