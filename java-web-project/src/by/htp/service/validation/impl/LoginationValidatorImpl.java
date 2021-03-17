package by.htp.service.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.service.validation.LoginationValidator;

public class LoginationValidatorImpl implements LoginationValidator {

	private Pattern patternUsername = Pattern.compile("[a-z0-9]{6,12}");
	private Pattern patternPassword = Pattern.compile("[a-z0-9]{6,12}");

	@Override
	public boolean checkLogination(String username, String password) {

		Matcher matcherUsername = patternUsername.matcher(username);
		Matcher matcherPassword = patternPassword.matcher(password);

		boolean isAnyParamEqNull = username == null || "".equals(username) || password == null || "".equals(password);

		if (isAnyParamEqNull) {
			return false;
		}

		boolean check = matcherUsername.find() && matcherPassword.find();

		return check;

	}
}
