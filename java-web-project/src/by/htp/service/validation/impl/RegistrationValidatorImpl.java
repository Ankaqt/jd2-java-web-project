package by.htp.service.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.bean.RegistrationInfo;
import by.htp.service.validation.RegistrationValidator;

public class RegistrationValidatorImpl implements RegistrationValidator {

	private Pattern patternUsername = Pattern.compile("[a-z0-9]{4,12}");
	private Pattern patternPassword = Pattern.compile("[a-z0-9]{6,12}");
	private Pattern patternEmail = Pattern.compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$");
	private Pattern patternPhone = Pattern.compile("^\\d{7}$");

	@Override
	public boolean checkRegistration(RegistrationInfo registrationInfo) {

		String username = registrationInfo.getName();
		String password = registrationInfo.getPassword();
		String email = registrationInfo.getEmail();
		String phone = registrationInfo.getPhone();

		Matcher matcherUsername = patternUsername.matcher(username);
		Matcher matcherPassword = patternPassword.matcher(password);
		Matcher matcherEmail = patternEmail.matcher(email);
		Matcher matcherPhone = patternPhone.matcher(phone);

		boolean isAnyParamEqNull = username == null || "".equals(username) || password == null || "".equals(password)
				|| email == null || "".equals(email) || phone == null || "".equals(phone);

		if (isAnyParamEqNull) {
			return false;
		}

		boolean check = matcherUsername.find() && matcherPassword.find() && matcherEmail.find() && matcherPhone.find();

		return check;
	}

}
